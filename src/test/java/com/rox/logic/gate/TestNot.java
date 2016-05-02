package com.rox.logic.gate;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;

/**
 * @Author rossdrew
 * @Created 02/05/16.
 */
public class TestNot {
    @Test
    public void testTrueInput(){
        Not testGate = new Not();
        testGate.multipleInput(LogicalTrue.instance());
        assertFalse(testGate.getValue());
    }

    @Test
    public void testFalseInput(){
        Not testGate = new Not();
        testGate.multipleInput(LogicalFalse.instance());
        assertFalse(testGate.getValue());
    }

    @Test
    public void testNullInput(){
        Not testGate = new Not();
        testGate.multipleInput(null);
        assertFalse(testGate.getValue());
    }
}
