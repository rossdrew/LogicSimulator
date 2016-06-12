package com.rox.logic.gate.binary;

import com.rox.logic.gate.type.AuditableLogicGate;

/**
 * @Author rossdrew
 */
public class XOr extends AuditableLogicGate {
    @Override
    protected boolean performTransformation(boolean... values) {
        boolean returnValue = false;

        if (values.length == 0) {
            //No inputs == all implied false inputs
        }else if (values.length == 1) {
            //Single input means there's also an implied null(false) gate
            returnValue = values[0];
        }else{
            boolean lastValue = values[0];
            for (int v = 1; v < values.length; v++) {
                if (values[v] != lastValue) {
                    returnValue = true;
                    break;
                }

                lastValue = values[v];
            }
        }

        return returnValue;
    }

    @Override
    protected void performSetInputPostOperations() {

    }

    public String getStringIdentifier() {
        return "XOR";
    }
}
