package com.rox.logic.gate.compound;

import com.rox.logic.LogicGate;
import com.rox.logic.state.LogicalFalse;
import com.rox.logic.state.LogicalTrue;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @Author rossdrew
 * @Created 05/05/16.
 */
public class TestXNor {
    private LogicGate testGate;

    @Before
    public void setup(){
        testGate = new XNOr();
    }

    @Test
    public void testTwoTrueInputs(){
        testGate.setInput(LogicalTrue.instance(), LogicalTrue.instance());
        assertTrue(testGate.getValue());
    }

    @Test
    public void testTwoFalseInputs(){
        testGate.setInput(LogicalFalse.instance(), LogicalFalse.instance());
        assertTrue(testGate.getValue());
    }

    @Test
    public void testFalseBInput(){
        testGate.setInput(LogicalTrue.instance(), LogicalFalse.instance());
        assertFalse(testGate.getValue());
    }

    @Test
    public void testFalseAInput(){
        testGate.setInput(LogicalFalse.instance(), LogicalTrue.instance());
        assertFalse(testGate.getValue());
    }

    @Test
    public void testNullAInput(){
        testGate.setInput(null, LogicalTrue.instance());
        assertFalse(testGate.getValue());
    }

    @Test
    public void testNullBInput(){
        testGate.setInput(LogicalTrue.instance(), null);
        assertFalse(testGate.getValue());
    }

    //Test for too many inputs?
}