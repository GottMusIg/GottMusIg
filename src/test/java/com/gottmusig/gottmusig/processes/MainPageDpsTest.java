package com.gottmusig.gottmusig.processes;

import javax.annotation.PostConstruct;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.camunda.bpm.extension.process_test_coverage.junit.rules.TestCoverageProcessEngineRuleBuilder;
import org.junit.After;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.gottmusig.gottmusig.facade.adapter.processengine.BpeAdapter;
import com.gottmusig.gottmusig.utils.ProcessTestBase;

@Deployment(resources= {"processes/autodeploy/simulateMainPageDpsProcess.bpmn"})
@Transactional
public class MainPageDpsTest extends ProcessTestBase {

    @Autowired
    private BpeAdapter bpeAdapter;

    @Rule
    @ClassRule
    public static ProcessEngineRule rule;

    @PostConstruct
    void initRule() {
        rule = TestCoverageProcessEngineRuleBuilder.create(processEngine).withDetailedCoverageLogging().build();
    }

    @Test
    public void mainPageDpsSimulationProcessShouldRun(){

        String id = bpeAdapter.startMainPageDpsSimulation("123");
        executeAsyncJobsLoop();
        ProcessInstance processInstance = getProcessInstanceBy(id); //Nur 1 ProcessInstance kann ausgeführt worden sein

        assertProcessFinished(processInstance);


    }

    @Test
    public void shouldNotExecuteSimulationProcessTwiceWhenIdIsEqual(){

        String simcVersion = "123";

        String id = bpeAdapter.startMainPageDpsSimulation(simcVersion);
        executeAsyncJobsLoop();

        ProcessInstance processInstance = getProcessInstanceBy(id); //Nur 1 ProcessInstance kann ausgeführt worden sein

        assertStepsTakenFor(processInstance, "startMainPageDpsProcess", "checkVersionStep", "checkSimcVersionGateway", "simulateClassesStep", "returnDpsDataStep", "finalGateway", "processFinished");
        assertProcessFinished(processInstance);


        String id2 = bpeAdapter.startMainPageDpsSimulation(simcVersion);
        executeAsyncJobsLoop();
        ProcessInstance processInstance2 = getProcessInstanceBy(id2); //Nur 1 ProcessInstance kann ausgeführt worden sein

        assertStepsTakenFor(processInstance2, "startMainPageDpsProcess", "checkVersionStep", "checkSimcVersionGateway","finalGateway", "processFinished");

    }

}
