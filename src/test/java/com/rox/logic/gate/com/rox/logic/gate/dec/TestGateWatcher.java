package com.rox.logic.gate.com.rox.logic.gate.dec;

import com.rox.logic.LogicGate;
import com.rox.logic.LogicValueProducer;
import com.rox.logic.gate.binary.And;
import com.rox.logic.gate.dec.GateWatcher;
import com.rox.logic.gate.dec.watch.GateWatchListener;
import com.rox.logic.state.LogicalFalse;
import com.rox.logic.state.LogicalTrue;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author rossdrew
 * @Created 06/05/16.
 */
public class TestGateWatcher {
    private LogicGate testGate;
    private List<String> reportString;
    private GateWatchListener listener;

    @Before
    public void setup(){
        reportString = new ArrayList<String>();
        listener = new GateWatchListener() {
            public void reportStatus(String statusString) {
                reportString.add(statusString);
            }
        };
    }

    @Test
    public void testGetInput(){
        LogicValueProducer[] inputs = new LogicValueProducer[] {LogicalTrue.instance(), LogicalFalse.instance(), LogicalTrue.instance()};

        GateWatcher gateWatcher = new GateWatcher(new And());
        testGate = gateWatcher;
        testGate.setInput(inputs);
        assertArrayEquals(inputs, testGate.getInput());
    }

    @Test
    public void testOneWatchedGate(){
        GateWatcher gateWatcher = new GateWatcher(new And());
        gateWatcher.addGateWatchListener(listener);

        testGate = gateWatcher;
        testGate.setInput(LogicalTrue.instance(), LogicalFalse.instance(), LogicalTrue.instance());
        testGate.getValue();

        assertEquals("1 0 1 -> 0", reportString.get(0));
        assertFalse(testGate.getValue());
    }

    @Test
    public void testNoListeners(){
        try {
            GateWatcher gateWatcher = new GateWatcher(new And());

            testGate = gateWatcher;
            testGate.setInput(LogicalTrue.instance(), LogicalFalse.instance(), LogicalTrue.instance());
            testGate.getValue();
            assertTrue(reportString.size() == 0);
        }catch (Exception e){
            fail("The absence of a gate watch listener has caused an exception");
        }
    }
}
