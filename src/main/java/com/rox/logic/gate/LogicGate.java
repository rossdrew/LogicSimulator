package com.rox.logic.gate;

import com.rox.logic.LogicValueProducer;

/**
 * @Author rossdrew
 * @Created 02/05/16.
 */
public interface LogicGate extends LogicValueProducer {
    void setInput(LogicValueProducer...inputs);
    LogicValueProducer[] getInput();
    String getStringIdentifier();
}
