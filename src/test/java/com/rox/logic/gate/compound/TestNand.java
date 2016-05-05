package com.rox.logic.gate.compound;

import com.rox.logic.gate.state.LogicalFalse;
import com.rox.logic.gate.state.LogicalTrue;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @Author rossdrew
 * @Created 05/05/16.
 */
public class TestNand {
    @Test
    public void testTwoTrueInputs(){
        NAnd testGate = new NAnd();
        testGate.setInput(LogicalTrue.instance(), LogicalTrue.instance());
        assertFalse(testGate.getValue());
    }

    @Test
    public void testTwoFalseInputs(){
        NAnd testGate = new NAnd();
        testGate.setInput(LogicalFalse.instance(), LogicalFalse.instance());
        assertTrue(testGate.getValue());
    }

    @Test
    public void testFalseBInput(){
        NAnd testGate = new NAnd();
        testGate.setInput(LogicalTrue.instance(), LogicalFalse.instance());
        assertTrue(testGate.getValue());
    }

    @Test
    public void testFalseAInput(){
        NAnd testGate = new NAnd();
        testGate.setInput(LogicalFalse.instance(), LogicalTrue.instance());
        assertTrue(testGate.getValue());
    }

    @Test
    public void testNullAInput(){
        NAnd testGate = new NAnd();
        testGate.setInput(null, LogicalTrue.instance());
        assertTrue(testGate.getValue());
    }

    @Test
    public void testNullBInput(){
        NAnd testGate = new NAnd();
        testGate.setInput(LogicalTrue.instance(), null);
        assertTrue(testGate.getValue());
    }
}
