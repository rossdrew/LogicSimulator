package com.rox.logic.gate.binary;

import com.rox.logic.gate.type.AuditableLogicGate;

/**
 * @Author rossdrew
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
    protected void performSetInputPostOperations() {
    }

    public String getStringIdentifier() {
        return "AND";
    }
}
