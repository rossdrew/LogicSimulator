package com.rox.logic.gate.binary;

import com.rox.logic.gate.state.LogicalFalse;
import com.rox.logic.gate.state.LogicalTrue;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @Author rossdrew
 * @Created 02/05/16.
 */
public class TestXOr {

    @Test
    public void testTwoTrueInputs(){
        XOr testGate = new XOr();
        testGate.multipleInput(LogicalTrue.instance(), LogicalTrue.instance());
        assertFalse(testGate.getValue());
    }

    @Test
    public void testTwoFalseInputs(){
        XOr testGate = new XOr();
        testGate.multipleInput(LogicalFalse.instance(), LogicalFalse.instance());
        assertFalse(testGate.getValue());
    }

    @Test
    public void testFalseBInput(){
        XOr testGate = new XOr();
        testGate.multipleInput(LogicalTrue.instance(), LogicalFalse.instance());
        assertTrue(testGate.getValue());
    }

    @Test
    public void testFalseAInput(){
        XOr testGate = new XOr();
        testGate.multipleInput(LogicalFalse.instance(), LogicalTrue.instance());
        assertTrue(testGate.getValue());
    }

    @Test
    public void testNullAInput(){
        XOr testGate = new XOr();
        testGate.multipleInput(null, LogicalTrue.instance());
        assertTrue(testGate.getValue());
    }

    @Test
    public void testNullBInput(){
        XOr testGate = new XOr();
        testGate.multipleInput(LogicalTrue.instance(), null);
        assertTrue(testGate.getValue());
    }

    //Test for too many inputs?
}
