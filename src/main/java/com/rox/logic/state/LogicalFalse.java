package com.rox.logic.state;

import com.rox.logic.LogicValueProducer;

/**
 * @Author rossdrew
 * @Created 02/05/16.
 */
public class LogicalFalse implements LogicValueProducer {
    public static final LogicalFalse INSTANCE = new LogicalFalse();

    public boolean getValue() {
        return false;
    }
}
