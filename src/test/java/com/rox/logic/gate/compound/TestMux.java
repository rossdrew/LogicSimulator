package com.rox.logic.gate.compound;

import com.rox.logic.gate.state.LogicalFalse;
import com.rox.logic.gate.state.LogicalTrue;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @Author rossdrew
 * @Created 02/05/16.
 */
public class TestMux {

    @Test
    public void testTrueInput(){
        Mux testGate = new Mux();
        testGate.setInput(LogicalTrue.instance(), LogicalTrue.instance(), LogicalTrue.instance());
        assertTrue("Selector (input 3) is true so output should be that of input 2", testGate.getValue());
    }

    @Test
    public void testFalseInput(){
        Mux testGate = new Mux();
        testGate.setInput(LogicalFalse.instance(), LogicalFalse.instance(), LogicalFalse.instance());
        assertFalse("Selector (input 3) is false so output should be that of input 1", testGate.getValue());
    }

    @Test
    public void testOneIsTrueAndSelected(){
        Mux testGate = new Mux();
        testGate.setInput(LogicalTrue.instance(), LogicalFalse.instance(), LogicalFalse.instance());
        assertTrue("Selector (input 3) is false so output should be that of input 1", testGate.getValue());
    }

    @Test
    public void testOneIsFalseAndSelected(){
        Mux testGate = new Mux();
        testGate.setInput(LogicalFalse.instance(), LogicalTrue.instance(), LogicalFalse.instance());
        assertFalse("Selector (input 3) is false so output should be that of input 1", testGate.getValue());
    }

    @Test
    public void testTwoIsTrueAndSelected(){
        Mux testGate = new Mux();
        testGate.setInput(LogicalFalse.instance(), LogicalTrue.instance(), LogicalTrue.instance());
        assertTrue("Selector (input 3) is false so output should be that of input 1", testGate.getValue());
    }

    @Test
    public void testTwoIsFalseAndSelected(){
        Mux testGate = new Mux();
        testGate.setInput(LogicalFalse.instance(), LogicalFalse.instance(), LogicalTrue.instance());
        assertFalse("Selector (input 3) is true so output should be that of input 2", testGate.getValue());
    }
}
