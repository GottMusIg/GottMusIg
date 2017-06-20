package com.gottmusig.gottmusig.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.ManagementService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.history.HistoricActivityInstance;
import org.camunda.bpm.engine.history.HistoricProcessInstance;
import org.camunda.bpm.engine.history.HistoricVariableInstance;
import org.camunda.bpm.engine.runtime.Execution;
import org.camunda.bpm.engine.runtime.Job;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.junit.After;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.gottmusig.gottmusig.facade.processes.vars.Message;
import jersey.repackaged.com.google.common.base.Function;
import jersey.repackaged.com.google.common.collect.Iterables;
import jersey.repackaged.com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

/**
 * Basic functions for process tests. <br/>
 * <b>ATTENTION:</b> Test is not {@link Transactional} - Camunda based transaction will be used.
 *
 * <b>ATTENTION:</b> TransactionalTestExecutionListener.class has to be declared after CamundaDeploymentTestExecutionListener.class to avoid nullpointerexception
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners( listeners = {DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        CamundaDeploymentTestExecutionListener.class,
        TransactionalTestExecutionListener.class})
@ContextConfiguration(locations = {"classpath:META-INF/spring-config/bpe-integration-context.xml"})
@Slf4j
public abstract class ProcessTestBase {

    private static final String AUTOMATIC_CLEANUP = "Cleaned up after execution test: ";

    @Autowired
    protected ProcessEngine processEngine;

    @Autowired
    protected RuntimeService runtimeService;

    @Autowired
    protected ManagementService managementService;

    @Autowired
    protected TaskService taskService;

    @Autowired
    protected HistoryService historyService;

    protected List<ProcessInstance> processInstances = new ArrayList<>();

    /**
     * Deleting all process instances and their history created by the test class in order to avoid messing up test data.
     */
    @After
    public void cleanUpProcessInstances() {

        List<Execution> runningProcesses = runtimeService.createExecutionQuery().list();

        for (Execution execution : runningProcesses) {
           try{
               runtimeService.deleteProcessInstance(execution.getProcessInstanceId(), AUTOMATIC_CLEANUP + this.getClass().getName());
           }catch (Exception e){

           }
        }

        assertTrue("Couldn't terminate all process instances.", runtimeService.createExecutionQuery().list().isEmpty());
    }

    protected void executeNextStepsFor(ProcessInstance processInstance, int stepCount){
        for(int i=stepCount;i>0;i--){
            log.debug("ExecutedNextStep "+i);
            executeNextStepFor(processInstance);
        }
    }

    protected void executeNextStepFor(ProcessInstance instance){

        Job job = managementService.createJobQuery().processInstanceId(instance.getId()).singleResult();
        assertNotNull("There are no steps left! "+ Iterables.toString(getHistoricActivityIds(instance)), job);
        execute(job);
    }

    protected void executeAsyncJobsLoop() {
        while (executeAsyncJobs()) {}
    }

    /**
     * Execute async jobs.
     *
     * @return true, if at least one job was executed
     */
    protected boolean executeAsyncJobs() {
        List<Job> list = managementService.createJobQuery().executable().list();
        return executeJobs(list);
    }

    /**
     * Execute given jobs.
     *
     * @param jobs
     *            the jobs
     * @return true, if at least one job was executed
     */
    private boolean executeJobs(List<Job> jobs) {
        checkForNewCreatedProcessInstancesToAdd();

        boolean executedJob = false;
        for (Job job : jobs) {
            execute(job);
            executedJob = true;
        }
        return executedJob;
    }

    private void execute(Job job){
        managementService.executeJob(job.getId());
        checkForNewCreatedProcessInstancesToAdd();
    }

    protected ProcessInstance startProcessByMessage(Message message, Map<String, Object> args) {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByMessage(message.name(), args);
        processInstances.add(processInstance);
        return processInstance;
    }

    protected void assertStepsTakenFor(ProcessInstance processInstance, String... activityIds) {

        List<String> historicActivityIds = getHistoricActivityIds(processInstance);
        List<String> stepsThatShouldBeTaken = Arrays.asList(activityIds);

        if(historicActivityIds.size() > stepsThatShouldBeTaken.size()){

            for(String stepThatShouldBeTaken : stepsThatShouldBeTaken){
                for(String executedStep : historicActivityIds){
                    if(executedStep.equals(stepThatShouldBeTaken)){
                        historicActivityIds.remove(stepThatShouldBeTaken);
                        break;
                    }
                }
            }
            fail("There were more steps executed than expected: \nSteps that weren't expected:"+ Iterables.toString(historicActivityIds) + " - probably these steps were executed multiple times (multiinstance)?");
        }

        if (!historicActivityIds.containsAll(stepsThatShouldBeTaken)) {
            List<String> notTaken = new ArrayList<>(stepsThatShouldBeTaken);
            notTaken.removeAll(historicActivityIds);
            fail("Not all required steps where taken: \nMissing: " + Iterables.toString(notTaken) + "\nProcess: "
                    + Iterables.toString(historicActivityIds));
        }
    }

    protected void assertStepsFailedFor(ProcessInstance processInstance, String... activityIds){

        List<String> shouldFailIds = Arrays.asList(activityIds);

        List<Job> failedJobs = managementService.createJobQuery().processInstanceId(processInstance.getId()).withException().list();

        List<String> failedJobsIds = Lists.transform(failedJobs, new Function<Job, String>() {
            @Nullable
            @Override
            public String apply(@Nullable Job job) {

                return job == null ? null : managementService.createJobDefinitionQuery().jobDefinitionId(job.getJobDefinitionId()).singleResult().getActivityId();
            }
        });

        if (!failedJobsIds.containsAll(shouldFailIds)) {
            List<String> notFailed = new ArrayList<>(shouldFailIds);
            notFailed.removeAll(failedJobsIds);
            fail("Following steps didn't fail: \nMissing: " + Iterables.toString(notFailed) + "\nProcess: "
                    + Iterables.toString(failedJobsIds));
        }
    }

    protected void assertRetriesLeftFor(ProcessInstance processInstance, String activityId, int leftRetries){

        Job job = managementService.createJobQuery().processInstanceId(processInstance.getId()).activityId(activityId).singleResult();
        assertEquals(leftRetries, job.getRetries());
    }

    protected void assertProcessFinished(ProcessInstance processInstance) {
        HistoricProcessInstance historicProcessInstance =
                historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstance.getId()).singleResult();
        assertNotNull("Process was not recorded.", historicProcessInstance);
        assertNotNull("Process has not ended.", historicProcessInstance.getEndTime());
    }

    protected void assertProcessIsStillActiv(ProcessInstance processInstance){
        assertEquals("Active Process Instances", 1, runtimeService.createProcessInstanceQuery().processInstanceId(processInstance.getProcessInstanceId()).list().size());
    }

    protected void assertNoProcessActive(ProcessInstance processInstance) {
        assertEquals("No active Process Instances", 0, runtimeService.createProcessInstanceQuery().processInstanceId(processInstance.getProcessInstanceId()).list().size());
    }

    private List<String> getHistoricActivityIds(ProcessInstance processInstance){
        List<HistoricActivityInstance> activities =
                historyService.createHistoricActivityInstanceQuery().processInstanceId(processInstance.getId())
                        .orderByHistoricActivityInstanceEndTime().asc().list();

        return Lists.transform(activities, new Function<HistoricActivityInstance, String>() {
            @Override
            @Nullable
            public String apply(@Nullable HistoricActivityInstance input) {
                return input == null ? null : input.getActivityId();
            }
        });

    }

    protected void assertVarWasCorrectSet(ProcessInstance processInstance, String varName, Object value){

        assertVarWasSet(processInstance, varName);
        Object object = getProcessEngineVariable(processInstance,varName);
        assertTrue(object.equals(value));
    }

    protected void assertVarWasSet(ProcessInstance processInstance, String varName){
        Object object = getProcessEngineVariable(processInstance,varName);
        assertNotNull("Expected "+varName+" in processEngineVars, but it wasn't set", object);
    }

    protected Object getProcessEngineVariable(ProcessInstance processInstance, String varName){
        return runtimeService.getVariable(processInstance.getId(), varName);
    }

    private void checkForNewCreatedProcessInstancesToAdd(){

        boolean contains;
        for(ProcessInstance processInstance : runtimeService.createProcessInstanceQuery().list()){
            contains = wasAlreadyAdded(processInstance);
            if(!contains){
                this.processInstances.add(processInstance);
            }
        }
    }

    private boolean wasAlreadyAdded(ProcessInstance processInstance){
        for(ProcessInstance processInstance1 : this.processInstances){
            if(processInstance.getId().equals(processInstance1.getId())){
                return true;
            }
        }
        return false;
    }

    protected ProcessInstance getProcessInstanceBy(String processInstanceId){

        List<ProcessInstance> processInstances = new ArrayList<>();

        for(ProcessInstance processInstance : this.processInstances){
            String id = processInstance.getProcessInstanceId();
            if(id.equals(processInstanceId)){
                return processInstance;
            }
        }
        Assert.fail("Could not find processInstance with id: "+processInstanceId);
        return null; //will be ignored
    }



    protected int getCountOfInstancesWhichContainedVar(List<ProcessInstance> processInstances, String varName, Object value){

        int count = 0;

        for(ProcessInstance instance : processInstances){
            if(assertInstanceContainedVariable(instance,varName,value)){
                count++;
            }
        }
        if(count == 0){
            fail("Could not find "+varName+" with wanted value: "+value+" in given processInstances");
        }
        return count;
    }

    protected boolean assertInstanceContainedVariable(ProcessInstance processInstance, String varName, Object value){
        List<HistoricVariableInstance> variables = historyService.createHistoricVariableInstanceQuery().processInstanceId(processInstance.getProcessInstanceId()).list();

        for(HistoricVariableInstance var : variables){
            if (var.getName().equals(varName) && var.getValue().equals(value)){
                return true;
            }
        }
        return false;
    }
}
