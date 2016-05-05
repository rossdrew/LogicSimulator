package com.rox.logic.gate.compound;

import com.rox.LogicGate;
import com.rox.LogicValue;
import com.rox.logic.gate.binary.*;

/**
 * @Author rossdrew
 * @Created 05/05/16.
 *
 * There is obviously a simpler way to do this but I am testing simple compound gates here, for now
 */
public class NAnd implements LogicGate{
    private LogicValue[] inputs;

    private And andGate = new And();
    private Not notGate = new Not();

    public void setInput(LogicValue... inputs) {
        this.inputs = inputs;

        andGate.setInput(inputs);
        notGate.setInput(andGate);
    }

    public boolean getValue() {
        return notGate.getValue();
    }
}
