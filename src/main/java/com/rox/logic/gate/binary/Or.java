package com.rox.logic.gate.binary;

import com.rox.logic.LogicGate;
import com.rox.logic.LogicValueProducer;
import com.rox.logic.gate.type.AuditableLogicGate;

/**
 * @Author rossdrew
 * @Created 02/05/16.
 */
public class Or extends AuditableLogicGate {
    @Override
    protected boolean performTransformation(boolean... values) {
        for (boolean v : values){
            if (v){
                return true;
            }
        }
        return false;
    }

    @Override
    protected void performSetInputPostOperations() {

    }

    public String getStringIdentifier() {
        return "OR";
    }
}
