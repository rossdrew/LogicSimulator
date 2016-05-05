package com.rox.logic.gate.binary;

import com.rox.logic.gate.binary.Not;
import com.rox.logic.gate.state.LogicalFalse;
import com.rox.logic.gate.state.LogicalTrue;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @Author rossdrew
 * @Created 02/05/16.
 */
public class TestNot {
    @Test
    public void testTrueInput(){
        Not testGate = new Not();
        testGate.setInput(LogicalTrue.instance());
        assertFalse(testGate.getValue());
    }

    @Test
    public void testFalseInput(){
        Not testGate = new Not();
        testGate.setInput(LogicalFalse.instance());
        assertTrue(testGate.getValue());
    }

    @Test
    public void testNullInput(){
        Not testGate = new Not();
        testGate.setInput(null);
        assertFalse(testGate.getValue());//What SHOULD be the output from a NOT with a null input
    }
}
