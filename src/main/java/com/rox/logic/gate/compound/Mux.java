package com.rox.logic.gate.compound;

import com.rox.logic.LogicGate;
import com.rox.logic.LogicValueProducer;
import com.rox.logic.gate.binary.And;
import com.rox.logic.gate.binary.Not;
import com.rox.logic.gate.type.AuditableLogicGate;

/**
 * 2-Input Multiplexer<br/>
 * <br/>
 * Let input 3 choose to get value from input 1 (3=false) or 2 (3=true)
 * <br/>
 * More for testing gate chaining than anything else.
 *
 * @Author rossdrew
 * @Created 02/05/16.
 */
public class Mux extends AuditableLogicGate {
    private NAnd endNAND = new NAnd();
    private NAnd middleNAND1 = new NAnd();
    private NAnd middleNAND2 = new NAnd();
    private Not inverter = new Not();

    @Override
    protected boolean performTransformation(boolean... values) {
        return endNAND.getValue();
    }

    @Override
    public void performSetInputPostOpertations() {
        LogicValueProducer[] inputs = getInput();

        endNAND.setInput(middleNAND1, middleNAND2);

        middleNAND1.setInput(inputs[0], inverter);
        middleNAND2.setInput(inputs[1], inputs[2]);

        inverter.setInput(inputs[2]);
    }

    public String getStringIdentifier() {
        return "MUX";
    }
}
