package com.rox.logic.gate.dec;

import com.rox.logic.LogicGate;
import com.rox.logic.LogicValueProducer;
import com.rox.logic.gate.dec.watch.GateWatchListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author rossdrew
 * @Created 05/05/16.
 */
public class GateWatcher implements LogicGate {
    private LogicGate internalGate;

    private List<GateWatchListener> listeners = new ArrayList<GateWatchListener>();

    public GateWatcher(LogicGate gate){
        internalGate = gate;
    }

    public void addGateWatchListener(GateWatchListener listener){
        listeners.add(listener);
    }

    public void setInput(LogicValueProducer... inputs) {
        internalGate.setInput(inputs);
    }

    public LogicValueProducer[] getInput() {
        return internalGate.getInput();
    }

    public boolean getValue() {
        String inputs = "";
        for (LogicValueProducer input : internalGate.getInput()){
            inputs += (input.getValue() ? "1 " : "0 ");
        }

        boolean returnValue = internalGate.getValue();

        reportStatusString(inputs + "-> " + (returnValue ? "1" : "0"));

        return returnValue;
    }

    private void reportStatusString(String statusString){
        for (GateWatchListener listener : listeners){
            listener.reportStatus(statusString);
        }
    }
}
