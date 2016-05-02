package com.rox.logic.gate;

import com.rox.LogicValue;

/**
 * @Author rossdrew
 * @Created 02/05/16.
 */
public class LogicalFalse implements LogicValue {
    private static LogicalFalse me = new LogicalFalse();

    public static LogicalFalse instance(){
        return me;
    }

    public boolean getValue() {
        return false;
    }
}
