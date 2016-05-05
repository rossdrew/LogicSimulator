package com.rox.logic.gate.compound;

import com.rox.LogicGate;
import com.rox.LogicValue;

/**
 * @Author rossdrew
 * @Created 05/05/16.
 *
 * There is obviously a simpler way to do this but I am testing simple compound gates here, for now
 */
public class NAnd implements LogicGate{
    private LogicValue[] inputs;

    public void setInput(LogicValue... inputs) {
        this.inputs = inputs;
    }

    public boolean getValue() {
        boolean inputA = inputs[0] == null ? false : inputs[0].getValue();
        boolean inputB = inputs[1] == null ? false : inputs[1].getValue();

        return !(inputA && inputB);
    }
}
