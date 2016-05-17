package com.rox.logic.gate.binary;

import com.rox.logic.LogicGate;
import com.rox.logic.LogicValueProducer;
import com.rox.logic.gate.type.AuditableLogicGate;

/**
 * @Author rossdrew
 * @Created 02/05/16.
 */
public class XOr extends AuditableLogicGate {
    @Override
    protected boolean performTransformation(boolean... values) {
        boolean oneOn = false;

        for (boolean v : values){
            if (v){
                if (oneOn){
                    return false;
                }
                oneOn = true;
            }
        }
        return oneOn;
    }

    public String getStringIdentifier() {
        return "XOR";
    }
}
