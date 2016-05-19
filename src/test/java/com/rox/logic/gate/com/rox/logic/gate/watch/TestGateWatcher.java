package com.rox.logic.gate.com.rox.logic.gate.watch;

import com.rox.logic.gate.LogicGate;
import com.rox.logic.LogicValueProducer;
import com.rox.logic.gate.binary.And;
import com.rox.logic.gate.binary.Or;
import com.rox.logic.gate.watch.GateWatcher;
import com.rox.logic.gate.watch.GateWatchListener;
import com.rox.logic.gate.type.AuditableLogicGate;
import com.rox.logic.state.LogicalFalse;
import com.rox.logic.state.LogicalTrue;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;
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
        LogicValueProducer[] inputs = new LogicValueProducer[] {LogicalTrue.INSTANCE, LogicalFalse.INSTANCE, LogicalTrue.INSTANCE};

        GateWatcher gateWatcher = new GateWatcher(new And());
        testGate = gateWatcher;
        testGate.setInput(inputs);
        assertArrayEquals(inputs, testGate.getInput());
    }

    /**
     * (F) ---¬
     * (T) --[AND]---(F)
     */
    @Test
    public void testOneWatchedGate(){
        GateWatcher gateWatcher = new GateWatcher(new And());
        gateWatcher.addGateWatchListener(listener);

        testGate = gateWatcher;
        testGate.setInput(LogicalFalse.INSTANCE, LogicalTrue.INSTANCE);

        boolean result = testGate.getValue();
        gateWatcher.removeGateWatchListener(listener);

        assertFalse(result);
        assertEquals("Report output not as expected: " + Arrays.toString(reportString.toArray()), 1, reportString.size());
        assertEquals("0 1 -(AND)-> 0", reportString.get(0));
    }

    /**
     * (T) ---¬
     * (F) --[OR]----¬
     * (T) ---------[AND]--- (T)
     */
    @Test
    public void testTwoWatchedGates(){
        AuditableLogicGate internalOrGate = new Or();
        internalOrGate.setInput(LogicalTrue.INSTANCE, LogicalFalse.INSTANCE);
        GateWatcher orGateWatcher = new GateWatcher(internalOrGate);
        orGateWatcher.addGateWatchListener(listener);

        AuditableLogicGate internalAndGate = new And();
        internalAndGate.setInput(LogicalTrue.INSTANCE, orGateWatcher);
        GateWatcher andGateWatcher = new GateWatcher(internalAndGate);
        andGateWatcher.addGateWatchListener(listener);

        testGate = andGateWatcher;
        boolean result = testGate.getValue();

        orGateWatcher.removeGateWatchListener(listener);
        andGateWatcher.removeGateWatchListener(listener);

        assertTrue(result);
        assertEquals("Report output not as expected: " + Arrays.toString(reportString.toArray()), 2, reportString.size());
        assertEquals("1 0 -(OR)-> 1", reportString.get(0));
        assertEquals("1 1 -(AND)-> 1", reportString.get(1));
    }

    @Test
    public void testNoListeners(){
        try {
            GateWatcher gateWatcher = new GateWatcher(new And());

            testGate = gateWatcher;
            testGate.setInput(LogicalTrue.INSTANCE, LogicalFalse.INSTANCE, LogicalTrue.INSTANCE);
            testGate.getValue();
            assertTrue(reportString.size() == 0);
        }catch (Exception e){
            fail("The absence of a gate watch listener has caused an exception");
        }
    }


    @Test
    public void testName(){
        AuditableLogicGate internalAndGate = new And();
        internalAndGate.setInput(LogicalTrue.INSTANCE, LogicalFalse.INSTANCE);
        GateWatcher andGateWatcher = new GateWatcher(internalAndGate);
        andGateWatcher.addGateWatchListener(listener);

        testGate = andGateWatcher;

        assertEquals("Name should be the name of the internal gate", "AND", testGate.getStringIdentifier());
    }
}
