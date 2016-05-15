package com.rox.logic.gate;

import com.rox.logic.gate.type.AuditableLogicGate;
import com.rox.logic.state.LogicalFalse;
import com.rox.logic.state.LogicalTrue;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;

/**
 * @Author rossdrew
 * @Created 15/05/16.
 */
public class TestAuditableLogicGate {
    AuditableLogicGate testGate;

    @Before
    public void setup(){
        testGate = new AuditableLogicGate(){
            @Override
            protected boolean performTransformation(boolean... values) {
                //Return true if any inputs are true
                boolean r = false;
                for (boolean v : values) {
                    if (v)
                        r = true;
                }

                return r;
            }
        };
    }

    @Test
    public void testExecution(){
        testGate.setInput(LogicalTrue.instance(), LogicalFalse.instance());

        assertTrue("Should get value from implementer of abstract class", testGate.getValue());
        assertFalse("Gate was used, should be marked as such", testGate.isUnused());
        assertTrue(testGate.lastEvaluatedResult());
        assertArrayEquals(new boolean[] {true, false}, testGate.getLastEvaluatedInputs());
    }

    @Test
    public void testWithNoInputs(){
        assertFalse("No inputs should assume all inputs are false", testGate.getValue());
    }
}
