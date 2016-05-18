package com.rox.logic.state;

import com.rox.logic.LogicValueProducer;

/**
 * @Author rossdrew
 * @Created 02/05/16.
 */
public class LogicalTrue implements LogicValueProducer {
    public static final LogicalTrue INSTANCE = new LogicalTrue();

    public boolean getValue() {
        return true;
    }
}
