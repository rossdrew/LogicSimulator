package com.rox.logic.gate.binary;

import com.rox.logic.gate.type.AuditableLogicGate;

/**
 * @Author rossdrew
 * @Created 02/05/16.
 */
public class Not extends AuditableLogicGate {
    @Override
    protected boolean performTransformation(boolean... values) {
        return !(values == null || values.length < 1 ? false : values[0]);
    }

    @Override
    protected void performSetInputPostOperations() {

    }

    public String getStringIdentifier() {
        return "NOT";
    }
}
