package com.rox.logic.gate.binary;

import com.rox.logic.LogicGate;
import com.rox.logic.LogicValueProducer;
import com.rox.logic.state.LogicalFalse;
import com.rox.logic.state.LogicalTrue;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

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
        LogicValueProducer[] inputs = new LogicValueProducer[] {LogicalTrue.instance(), LogicalFalse.instance(), LogicalTrue.instance()};
        testGate.setInput(inputs);
        assertArrayEquals(inputs, testGate.getInput());
    }

    @Test
    public void testTrueInput(){
        testGate.setInput(LogicalTrue.instance());
        assertFalse(testGate.getValue());
    }

    @Test
    public void testFalseInput(){
        testGate.setInput(LogicalFalse.instance());
        assertTrue(testGate.getValue());
    }

    @Test
    public void testNullInput(){
        testGate.setInput(null);
        //XXX What SHOULD be the output from a NOT with a null input,
        //    I'm assuming a null input == false so the output is true
        assertTrue(testGate.getValue());
    }
}
