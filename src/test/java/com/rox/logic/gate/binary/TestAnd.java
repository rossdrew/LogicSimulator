package com.rox.logic.gate.binary;

import com.rox.logic.gate.binary.And;
import com.rox.logic.gate.state.LogicalFalse;
import com.rox.logic.gate.state.LogicalTrue;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @Author rossdrew
 * @Created 02/05/16.
 */
public class TestAnd {

    @Test
    public void testTwoTrueInputs(){
        And testGate = new And();
        testGate.multipleInput(LogicalTrue.instance(), LogicalTrue.instance());
        assertTrue(testGate.getValue());
    }

    @Test
    public void testTwoFalseInputs(){
        And testGate = new And();
        testGate.multipleInput(LogicalFalse.instance(), LogicalFalse.instance());
        assertFalse(testGate.getValue());
    }

    @Test
    public void testFalseBInput(){
        And testGate = new And();
        testGate.multipleInput(LogicalTrue.instance(), LogicalFalse.instance());
        assertFalse(testGate.getValue());
    }

    @Test
    public void testFalseAInput(){
        And testGate = new And();
        testGate.multipleInput(LogicalFalse.instance(), LogicalTrue.instance());
        assertFalse(testGate.getValue());
    }

    @Test
    public void testNullAInput(){
        And testGate = new And();
        testGate.multipleInput(null, LogicalTrue.instance());
        assertFalse(testGate.getValue());
    }

    @Test
    public void testNullBInput(){
        And testGate = new And();
        testGate.multipleInput(LogicalTrue.instance(), null);
        assertFalse(testGate.getValue());
    }

    //Test for too many inputs?
}
