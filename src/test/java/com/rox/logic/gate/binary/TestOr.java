package com.rox.logic.gate.binary;

import com.rox.logic.gate.binary.Or;
import com.rox.logic.gate.state.LogicalFalse;
import com.rox.logic.gate.state.LogicalTrue;
import org.junit.Test;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @Author rossdrew
 * @Created 02/05/16.
 */
public class TestOr {

    @Test
    public void testTwoTrueInputs(){
        Or testGate = new Or();
        testGate.setInput(LogicalTrue.instance(), LogicalTrue.instance());
        assertTrue(testGate.getValue());
    }

    @Test
    public void testTwoFalseInputs(){
        Or testGate = new Or();
        testGate.setInput(LogicalFalse.instance(), LogicalFalse.instance());
        assertFalse(testGate.getValue());
    }

    @Test
    public void testFalseBInput(){
        Or testGate = new Or();
        testGate.setInput(LogicalTrue.instance(), LogicalFalse.instance());
        assertTrue(testGate.getValue());
    }

    @Test
    public void testFalseAInput(){
        Or testGate = new Or();
        testGate.setInput(LogicalFalse.instance(), LogicalTrue.instance());
        assertTrue(testGate.getValue());
    }

    @Test
    public void testNullATrueBInput(){
        Or testGate = new Or();
        testGate.setInput(null, LogicalTrue.instance());
        assertTrue(testGate.getValue());
    }

    @Test
    public void testNullBTrueAInput(){
        Or testGate = new Or();
        testGate.setInput(LogicalTrue.instance(), null);
        assertTrue(testGate.getValue());
    }

    //Test for too many inputs?
}
