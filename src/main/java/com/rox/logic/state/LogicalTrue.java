package com.rox.logic.state;

import com.rox.logic.LogicValueProducer;

/**
 * @Author rossdrew
 * @Created 02/05/16.
 */
public class LogicalTrue implements LogicValueProducer {
    private static LogicalTrue me = new LogicalTrue();

    public static LogicalTrue instance(){
        return me;
    }


    public boolean getValue() {
        return true;
    }
}
