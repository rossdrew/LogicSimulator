package com.rox.logic.gate.dec;

import com.rox.logic.LogicGate;
import com.rox.logic.LogicValueProducer;
import com.rox.logic.gate.dec.watch.GateWatchListener;
import com.rox.logic.gate.type.AuditableLogicGate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author rossdrew
 * @Created 05/05/16.
 */
public class GateWatcher implements LogicGate {
    private AuditableLogicGate internalGate;

    private List<GateWatchListener> listeners = new ArrayList<GateWatchListener>();

    public GateWatcher(AuditableLogicGate gate){
        internalGate = gate;
    }

    public void addGateWatchListener(GateWatchListener listener){
        listeners.add(listener);
    }

    public void removeGateWatchListener(GateWatchListener listener){
        listeners.remove(listener);
    }

    public void setInput(LogicValueProducer... inputs) {
        internalGate.setInput(inputs);
    }

    public LogicValueProducer[] getInput() {
        return internalGate.getInput();
    }

    public String getStringIdentifier() {
        return internalGate.getStringIdentifier();
    }

    public boolean getValue() {
        boolean returnValue = internalGate.getValue();

        String inputs = inputsToString(internalGate.getLastEvaluatedInputs());
        String gateName = internalGate.getStringIdentifier();

        reportStatusString(inputs + "-("+ gateName + ")-> " + (returnValue ? "1" : "0"));

        return returnValue;
    }

    private String inputsToString(boolean[] inputs){
        String inputsString = "";
        for (boolean i : inputs){
            inputsString += (i ? "1":"0") + " ";
        }

        return inputsString;
    }

    private void reportStatusString(String statusString){
        for (GateWatchListener listener : listeners){
            listener.reportStatus(statusString);
        }
    }
}
