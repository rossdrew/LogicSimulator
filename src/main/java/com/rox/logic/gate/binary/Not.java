package com.rox.logic.gate.binary;

import com.rox.LogicGate;
import com.rox.LogicValue;

/**
 * @Author rossdrew
 * @Created 02/05/16.
 */
public class Not implements LogicGate {
    private LogicValue[] inputs;

    public void setInput(LogicValue... inputs) {
        this.inputs = inputs;
    }

    public boolean getValue() {

        boolean inputA = (inputs == null || inputs[0] == null) ? true : inputs[0].getValue();

        return !inputA;
    }
}
