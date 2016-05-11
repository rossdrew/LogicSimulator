package com.rox.logic.gate.compound;

import com.rox.logic.LogicGate;
import com.rox.logic.LogicValueProducer;
import com.rox.logic.state.LogicalFalse;
import com.rox.logic.state.LogicalTrue;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertArrayEquals;

/**
 * @Author rossdrew
 * @Created 02/05/16.
 */
public class TestNOr {
    private LogicGate testGate;

    @Before
    public void setup(){
        testGate = new NOr();
    }

    @Test
    public void testGetInput(){
        LogicValueProducer[] inputs = new LogicValueProducer[] {LogicalTrue.instance(), LogicalFalse.instance(), LogicalTrue.instance()};
        testGate.setInput(inputs);
        assertArrayEquals(inputs, testGate.getInput());
    }

    @Test
    public void testTwoTrueInputs(){
        testGate.setInput(LogicalTrue.instance(), LogicalTrue.instance());
        assertFalse(testGate.getValue());
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
    public void testNullATrueBInput(){
        testGate.setInput(null, LogicalTrue.instance());
        assertFalse(testGate.getValue());
    }

    @Test
    public void testNullBTrueAInput(){
        testGate.setInput(LogicalTrue.instance(), null);
        assertFalse(testGate.getValue());
    }

    //Test for too many inputs?
}
