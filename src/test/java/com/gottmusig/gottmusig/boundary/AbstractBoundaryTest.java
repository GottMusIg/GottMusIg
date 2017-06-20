package com.gottmusig.gottmusig.boundary;

import java.nio.file.Paths;
import com.github.approval.Approval;
import com.github.approval.Reporter;
import com.github.approval.reporters.ExecutableDifferenceReporter;
import com.github.approval.reporters.Reporters;
import com.github.approval.reporters.WindowsReporters;

public class AbstractBoundaryTest {

    protected void approve(String value, String fileName) {
        Approval<String> approver = Approval.of(String.class) //
                .withReporter(createReporter())//
                .build();

        approver.verify(value, Paths.get("src", "test", "resources", "approval", fileName));
    }

    private Reporter createReporter() {
        if (isInfinitest() || isMaven()) {
        	
        	
            return new AssertEqualsReporter();
        }
        return Reporters.firstWorking( //
                // SystemPropertyReporter.getInstance("test.approvals.reporter"), // TODO: version 0.4
                new ExecutableDifferenceReporter("meld", "meld", "meld"), WindowsReporters.tortoiseText(), //
                Reporters.console());
    }


    private boolean isInfinitest() {
        return System.getProperty("infinitest") != null;
    }

    private boolean isMaven() {
        return System.getenv("MAVEN_CMD_LINE_ARGS") != null;
    }
}
