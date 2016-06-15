package com.rox.logic.gate.binary;

import com.rox.logic.gate.LogicGate;
import com.rox.logic.LogicValueProducer;
import com.rox.logic.state.LogicalFalse;
import com.rox.logic.state.LogicalTrue;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertArrayEquals;

/**
 * @Author rossdrew
 * @Created 02/05/16.
 */
public class TestNot {
    private LogicGate testGate;

    @Before
    public void setup(){
        testGate = new Not();
    }

    @Test
    public void testGetInput(){
        LogicValueProducer[] inputs = new LogicValueProducer[] {LogicalTrue.INSTANCE, LogicalFalse.INSTANCE, LogicalTrue.INSTANCE};
        testGate.setInput(inputs);
        assertArrayEquals(inputs, testGate.getInput());
    }

    @Test
    public void testTrueInput(){
        testGate.setInput(LogicalTrue.INSTANCE);
        assertFalse(testGate.getValue());
    }

    @Test
    public void testFalseInput(){
        testGate.setInput(LogicalFalse.INSTANCE);
        assertTrue(testGate.getValue());
    }

    @Test
    public void testNullInput(){
        testGate.setInput(null);
        //XXX What SHOULD be the output from a NOT with a null input,
        //    I'm assuming a null input == false so the output is true
        assertTrue(testGate.getValue());
    }

    @Test
    public void testNoInput(){
        testGate.setInput();
        //XXX What SHOULD be the output from a NOT with no input,
        //    I'm assuming no input == false so the output is true
        assertTrue(testGate.getValue());
    }


    @Test
    public void testName(){
        Assert.assertEquals("NOT", testGate.getStringIdentifier());
    }
}
