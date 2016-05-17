package com.rox.logic.gate.compound;

import com.rox.logic.LogicGate;
import com.rox.logic.LogicValueProducer;
import com.rox.logic.gate.type.AuditableLogicGate;

/**
 * @Author rossdrew
 * @Created 05/05/16.
 *
 * There is obviously a simpler way to do this but I am testing simple compound gates here, for now
 */
public class NAnd extends AuditableLogicGate {
    @Override
    protected boolean performTransformation(boolean... values) {
        for (boolean v : values){
            if (!v){
                return true;
            }
        }
        return false;
    }
}
