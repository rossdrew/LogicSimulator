package com.rox.logic.gate.binary;

import com.rox.logic.LogicGate;
import com.rox.logic.LogicValueProducer;
import com.rox.logic.gate.type.AuditableLogicGate;

/**
 * @Author rossdrew
 * @Created 02/05/16.
 */
public class And extends AuditableLogicGate {
    @Override
    protected boolean performTransformation(boolean... values) {
        for (boolean v : values){
            if (!v){
                return false;
            }
        }
        return true;
    }

    @Override
    protected void performSetInputPostOpertations() {
    }

    public String getStringIdentifier() {
        return "AND";
    }
}
