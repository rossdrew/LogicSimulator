package com.rox.logic.gate.binary;

import com.rox.logic.LogicGate;
import com.rox.logic.LogicValueProducer;

/**
 * @Author rossdrew
 * @Created 02/05/16.
 */
public class Not implements LogicGate {
    private LogicValueProducer[] inputs;

    public void setInput(LogicValueProducer... inputs) {
        this.inputs = inputs;
    }

    public LogicValueProducer[] getInput() {
        return inputs;
    }

    public boolean getValue() {

        boolean inputA = (inputs == null || inputs[0] == null) ? true : inputs[0].getValue();

        return !inputA;
    }
}
