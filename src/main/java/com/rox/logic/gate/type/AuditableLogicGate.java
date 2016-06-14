package com.rox.logic.gate.type;

import com.rox.logic.gate.LogicGate;
import com.rox.logic.LogicValueProducer;

/**
 * @Author rossdrew
 */
public abstract class AuditableLogicGate implements LogicGate {
    protected LogicValueProducer[] inputs = new LogicValueProducer[] {};

    private boolean[] lastEvaluatedInputs;
    private boolean lastEvaluatedResult;
    boolean isUnused = true;

    public void setInput(LogicValueProducer... inputs){
        this.inputs = inputs;
        performSetInputPostOperations();
    }

    public LogicValueProducer[] getInput() {
        return inputs;
    }

    public boolean getValue(){
        boolean[] inputValues = new boolean[]{};

        if (inputs != null) {
            inputValues = new boolean[inputs.length];
            for (int i = 0; i < inputs.length; i++) {
                inputValues[i] = inputs[i] == null ? false : inputs[i].getValue();
            }
        }

        isUnused = false;
        lastEvaluatedInputs = inputValues;
        lastEvaluatedResult =  performTransformation(inputValues);

        return lastEvaluatedResult;
    }

    protected abstract boolean performTransformation(boolean... values);
    protected abstract void performSetInputPostOperations();

    public boolean isUnused() {
        return isUnused;
    }

    public boolean lastEvaluatedResult() {
        return lastEvaluatedResult;
    }

    public boolean[] getLastEvaluatedInputs() {
        return lastEvaluatedInputs;
    }
}
