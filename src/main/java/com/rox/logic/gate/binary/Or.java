package com.rox.logic.gate.binary;

import com.rox.logic.gate.type.AuditableLogicGate;

/**
 * @Author rossdrew
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
