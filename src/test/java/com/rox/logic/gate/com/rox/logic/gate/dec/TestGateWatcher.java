package com.rox.logic.gate.com.rox.logic.gate.dec;

import com.rox.logic.LogicGate;
import com.rox.logic.gate.binary.And;
import com.rox.logic.gate.dec.GateWatcher;
import com.rox.logic.gate.dec.watch.GateWatchListener;
import com.rox.logic.state.LogicalFalse;
import com.rox.logic.state.LogicalTrue;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @Author rossdrew
 * @Created 06/05/16.
 */
public class TestGateWatcher {
    private LogicGate testGate;
    private String reportString;

    @Test
    public void testOneWatchedGate(){
        GateWatcher gateWatcher = new GateWatcher(new And());
        gateWatcher.addGateWatchListener(new GateWatchListener() {
            public void reportStatus(String statusString) {
                reportString = statusString;
            }
        });

        testGate = gateWatcher;
        testGate.setInput(LogicalTrue.instance(), LogicalFalse.instance(), LogicalTrue.instance());
        testGate.getValue();

        assertEquals(reportString, "1 0 1 -> 0");
    }
}
