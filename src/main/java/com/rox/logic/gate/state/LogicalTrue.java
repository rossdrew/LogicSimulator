package com.rox.logic.gate.state;

import com.rox.LogicValue;

/**
 * @Author rossdrew
 * @Created 02/05/16.
 */
public class LogicalTrue implements LogicValue{
    private static LogicalTrue me = new LogicalTrue();

    public static LogicalTrue instance(){
        return me;
    }


    public boolean getValue() {
        return true;
    }
}
