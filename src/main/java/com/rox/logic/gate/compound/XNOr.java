package com.rox.logic.gate.compound;

import com.rox.logic.LogicGate;
import com.rox.LogicValue;

/**
 * @Author rossdrew
 * @Created 05/05/16.
 */
public class XNOr implements LogicGate {
    private LogicValue[] inputs;

    public void setInput(LogicValue... inputs) {
        this.inputs = inputs;
    }

    public boolean getValue() {
        boolean inputA = inputs[0] == null ? false : inputs[0].getValue();
        boolean inputB = inputs[1] == null ? false : inputs[1].getValue();

        return !(inputA^inputB);
    }
}
