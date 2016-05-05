package com.rox.logic.gate.compound;

import com.rox.logic.gate.binary.And;
import com.rox.logic.gate.binary.Not;
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
        assertTrue(testGate.getValue());
    }

    @Test
    public void testFalseInput(){
        Mux testGate = new Mux();
        testGate.setInput(LogicalFalse.instance(), LogicalFalse.instance(), LogicalFalse.instance());
        assertFalse(testGate.getValue());
    }

    @Test
    public void testSelectAInputAsTrue(){
        Mux testGate = new Mux();
        testGate.setInput(LogicalTrue.instance(), LogicalFalse.instance(), LogicalTrue.instance());
        assertTrue(testGate.getValue());
    }

    @Test
    public void testSelectAInputAsFalse(){
        Mux testGate = new Mux();
        testGate.setInput(LogicalFalse.instance(), LogicalFalse.instance(), LogicalTrue.instance());
        assertFalse(testGate.getValue());
    }

    //TODO B input as true
    //TODO B input as false
}
