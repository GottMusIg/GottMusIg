package com.gottmusig.gottmusig.processes;

import javax.annotation.PostConstruct;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.camunda.bpm.extension.process_test_coverage.junit.rules.TestCoverageProcessEngineRuleBuilder;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.gottmusig.gottmusig.facade.adapter.processengine.BpeAdapter;
import com.gottmusig.gottmusig.utils.ProcessTestBase;


@Deployment(resources= {"processes/autodeploy/mainItemRankingProcess.bpmn",
"processes/autodeploy/subItemRankingProcess.bpmn"})
@Transactional
public class ItemSimulationTest extends ProcessTestBase {


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
    @Ignore
    public void itemSimulationProcessShouldRun(){

        String id = bpeAdapter.startItemRankingCalculation("123");
        executeAsyncJobsLoop();
        ProcessInstance processInstance = getProcessInstanceBy(id); //Nur 1 ProcessInstance kann ausgeführt worden sein

        assertProcessFinished(processInstance);


    }



}
