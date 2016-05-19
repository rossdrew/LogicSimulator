package com.rox.logic.gate.compound;

import com.rox.logic.gate.LogicGate;
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
        LogicValueProducer[] inputs = new LogicValueProducer[] {LogicalTrue.INSTANCE, LogicalFalse.INSTANCE, LogicalTrue.INSTANCE};
        testGate.setInput(inputs);
        assertArrayEquals(inputs, testGate.getInput());
    }

    @Test
    public void testTrueInput(){
        testGate.setInput(LogicalTrue.INSTANCE, LogicalTrue.INSTANCE, LogicalTrue.INSTANCE);
        assertTrue("Selector (input 3) is true so output should be that of input 2", testGate.getValue());
    }

    @Test
    public void testFalseInput(){
        testGate.setInput(LogicalFalse.INSTANCE, LogicalFalse.INSTANCE, LogicalFalse.INSTANCE);
        assertFalse("Selector (input 3) is false so output should be that of input 1", testGate.getValue());
    }

    @Test
    public void testOneIsTrueAndSelected(){
        testGate.setInput(LogicalTrue.INSTANCE, LogicalFalse.INSTANCE, LogicalFalse.INSTANCE);
        assertTrue("Selector (input 3) is false so output should be that of input 1", testGate.getValue());
    }

    @Test
    public void testOneIsFalseAndSelected(){
        testGate.setInput(LogicalFalse.INSTANCE, LogicalTrue.INSTANCE, LogicalFalse.INSTANCE);
        assertFalse("Selector (input 3) is false so output should be that of input 1", testGate.getValue());
    }

    @Test
    public void testTwoIsTrueAndSelected(){
        testGate.setInput(LogicalFalse.INSTANCE, LogicalTrue.INSTANCE, LogicalTrue.INSTANCE);
        assertTrue("Selector (input 3) is false so output should be that of input 1", testGate.getValue());
    }

    @Test
    public void testTwoIsFalseAndSelected(){
        testGate.setInput(LogicalFalse.INSTANCE, LogicalFalse.INSTANCE, LogicalTrue.INSTANCE);
        assertFalse("Selector (input 3) is true so output should be that of input 2", testGate.getValue());
    }

    /**
     * XXX pitest caught this edge case, perhaps I should start testing based on a
     *     truith table instead to avoid this and make tests more readable.
     */
    @Test
    public void testFalseOutputFrom2ndInputWhile1stIsTrue(){
        testGate.setInput(LogicalTrue.INSTANCE, LogicalFalse.INSTANCE, LogicalTrue.INSTANCE);
        assertFalse("Selector (input 3) is true so output should be that of input 2", testGate.getValue());
    }


    @Test
    public void testName(){
        assertEquals("MUX", testGate.getStringIdentifier());
    }
}
