package com.rox.logic.gate.compound;

import com.rox.LogicGate;
import com.rox.LogicValue;
import com.rox.logic.gate.binary.And;
import com.rox.logic.gate.binary.Not;

/**
 * @Author rossdrew
 * @Created 02/05/16.
 */
public class Mux implements LogicGate{
    private LogicValue[] inputs;

    private And endAND = new And();
    private And middleAND1 = new And();
    private And middleAND2 = new And();
    private Not inverter = new Not();

    public void setInput(LogicValue... inputs) {
        endAND.setInput(middleAND1, middleAND2);

        middleAND1.setInput(inputs[0], inverter);
        middleAND2.setInput(inputs[1], inputs[2]);
        
        inverter.setInput(inputs[2]);
    }

    public boolean getValue() {
        return endAND.getValue();
    }
}
