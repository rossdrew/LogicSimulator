package com.rox.logic.gate.compound;

import com.rox.logic.gate.binary.XOr;

/**
 * @Author rossdrew
 */
public class XNOr extends XOr {
    @Override
    protected boolean performTransformation(boolean... values) {
        return !super.performTransformation(values);
    }

    public String getStringIdentifier() {
        return "XNOR";
    }
}
