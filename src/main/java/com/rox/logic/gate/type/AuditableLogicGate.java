package com.rox.logic.gate.type;

import com.rox.logic.LogicGate;
import com.rox.logic.LogicValueProducer;

/**
 * @Author rossdrew
 * @Created 15/05/16.
 */
public abstract class AuditableLogicGate implements LogicGate {
    protected LogicValueProducer[] inputs = new LogicValueProducer[] {};

    private boolean[] lastEvaluatedInputs;
    private boolean lastEvaluatedResult;
    boolean isUnused = true;

    public void setInput(LogicValueProducer... inputs){
        this.inputs = inputs;
        performSetInputPostOpertations();
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

        boolean transformedValue =  performTransformation(inputValues);
        isUnused = false;
        lastEvaluatedInputs = inputValues;
        lastEvaluatedResult = transformedValue;

        return transformedValue;
    }

    protected abstract boolean performTransformation(boolean... values);
    protected abstract void performSetInputPostOpertations();

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
