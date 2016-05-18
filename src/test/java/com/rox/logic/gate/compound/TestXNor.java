package com.rox.logic.gate.compound;

import com.rox.logic.LogicGate;
import com.rox.logic.LogicValueProducer;
import com.rox.logic.state.LogicalFalse;
import com.rox.logic.state.LogicalTrue;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertArrayEquals;

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
    public void testGetInput(){
        LogicValueProducer[] inputs = new LogicValueProducer[] {LogicalTrue.INSTANCE, LogicalFalse.INSTANCE, LogicalTrue.INSTANCE};
        testGate.setInput(inputs);
        assertArrayEquals(inputs, testGate.getInput());
    }

    @Test
    public void testTwoTrueInputs(){
        testGate.setInput(LogicalTrue.INSTANCE, LogicalTrue.INSTANCE);
        assertTrue(testGate.getValue());
    }

    @Test
    public void testTwoFalseInputs(){
        testGate.setInput(LogicalFalse.INSTANCE, LogicalFalse.INSTANCE);
        assertTrue(testGate.getValue());
    }

    @Test
    public void testFalseBInput(){
        testGate.setInput(LogicalTrue.INSTANCE, LogicalFalse.INSTANCE);
        assertFalse(testGate.getValue());
    }

    @Test
    public void testFalseAInput(){
        testGate.setInput(LogicalFalse.INSTANCE, LogicalTrue.INSTANCE);
        assertFalse(testGate.getValue());
    }

    @Test
    public void testNullAInput(){
        testGate.setInput(null, LogicalTrue.INSTANCE);
        assertFalse(testGate.getValue());
    }

    @Test
    public void testNullBInput(){
        testGate.setInput(LogicalTrue.INSTANCE, null);
        assertFalse(testGate.getValue());
    }


    @Test
    public void testName(){
        assertEquals("XNOR", testGate.getStringIdentifier());
    }

    //Test for too many inputs?
}
