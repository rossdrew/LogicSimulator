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
        boolean returnValue = false;

        //No inputs == all false inputs so output will be true
        if (values.length > 0) {
            //A single gate means there's also an implied null(false) gate
            if (values.length == 1) {
                returnValue = !values[0];
            } else {
                boolean lastValue = values[0];
                for (int v = 1; v < values.length; v++) {
                    if (values[v] != lastValue) {
                        returnValue = true;
                        break;
                    }

                    lastValue = values[v];
                }
            }
        }

        return returnValue;
    }

    public String getStringIdentifier() {
        return "XOR";
    }
}
