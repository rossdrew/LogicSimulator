package com.rox.logic.gate.compound;

import com.rox.logic.gate.binary.And;

/**
 * @Author rossdrew
 *
 * There is obviously a simpler way to do this but I am testing simple compound gates here, for now
 */
public class NAnd extends And {
    @Override
    protected boolean performTransformation(boolean... values) {
        return !super.performTransformation(values);
    }

    public String getStringIdentifier() {
        return "NAND";
    }
}
