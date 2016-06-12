package com.rox.logic.gate.compound;

import com.rox.logic.gate.binary.Or;

/**
 * @Author rossdrew
 */
public class NOr extends Or {
    @Override
    protected boolean performTransformation(boolean... values) {
        return !super.performTransformation(values);
    }

    public String getStringIdentifier() {
        return "NOR";
    }
}
