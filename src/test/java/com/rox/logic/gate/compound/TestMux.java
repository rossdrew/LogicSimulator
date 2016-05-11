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
public class TestMux {
    private LogicGate testGate;

    @Before
    public void setup(){
        testGate = new Mux();
    }

    @Test
    public void testGetInput(){
        LogicValueProducer[] inputs = new LogicValueProducer[] {LogicalTrue.instance(), LogicalFalse.instance(), LogicalTrue.instance()};
        testGate.setInput(inputs);
        assertArrayEquals(inputs, testGate.getInput());
    }

    @Test
    public void testTrueInput(){
        testGate.setInput(LogicalTrue.instance(), LogicalTrue.instance(), LogicalTrue.instance());
        assertTrue("Selector (input 3) is true so output should be that of input 2", testGate.getValue());
    }

    @Test
    public void testFalseInput(){
        testGate.setInput(LogicalFalse.instance(), LogicalFalse.instance(), LogicalFalse.instance());
        assertFalse("Selector (input 3) is false so output should be that of input 1", testGate.getValue());
    }

    @Test
    public void testOneIsTrueAndSelected(){
        testGate.setInput(LogicalTrue.instance(), LogicalFalse.instance(), LogicalFalse.instance());
        assertTrue("Selector (input 3) is false so output should be that of input 1", testGate.getValue());
    }

    @Test
    public void testOneIsFalseAndSelected(){
        testGate.setInput(LogicalFalse.instance(), LogicalTrue.instance(), LogicalFalse.instance());
        assertFalse("Selector (input 3) is false so output should be that of input 1", testGate.getValue());
    }

    @Test
    public void testTwoIsTrueAndSelected(){
        testGate.setInput(LogicalFalse.instance(), LogicalTrue.instance(), LogicalTrue.instance());
        assertTrue("Selector (input 3) is false so output should be that of input 1", testGate.getValue());
    }

    @Test
    public void testTwoIsFalseAndSelected(){
        testGate.setInput(LogicalFalse.instance(), LogicalFalse.instance(), LogicalTrue.instance());
        assertFalse("Selector (input 3) is true so output should be that of input 2", testGate.getValue());
    }
}
