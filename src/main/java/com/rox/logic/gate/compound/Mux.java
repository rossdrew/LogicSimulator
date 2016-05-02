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

    And endAND = new And();
    And middleAND1 = new And();
    And middleAND2 = new And();
    Not inverter = new Not();

    public void multipleInput(LogicValue... inputs) {
        endAND.multipleInput(middleAND1, middleAND2);
        middleAND1.multipleInput(inputs[0], inverter);
        middleAND2.multipleInput(inputs[1], inputs[2]);
        inverter.multipleInput(inputs[2]);
    }

    public boolean getValue() {
        return endAND.getValue();
    }
}
