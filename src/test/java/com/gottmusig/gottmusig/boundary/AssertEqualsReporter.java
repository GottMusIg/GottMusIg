package com.gottmusig.gottmusig.boundary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.io.File;
import java.util.Arrays;
import com.github.approval.Reporter;

public class AssertEqualsReporter implements Reporter {

    @Override
    public void notTheSame(byte[] oldValue, File fileForVerification, byte[] newValue, File fileForApproval) {
        if (!Arrays.equals(oldValue, newValue)) {
            assertEquals(new String(oldValue), new String(newValue));
        }
    }

    @Override
    public void approveNew(byte[] value, File fileForApproval, File fileForVerification) {
        fileForApproval.delete();
        fileForVerification.delete();
        fail("no approval file found: " + fileForVerification);
    }

    @Override
    public boolean canApprove(File fileForApproval) {
        return true;
    }
}
