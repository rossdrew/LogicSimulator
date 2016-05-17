package com.rox.logic;

/**
 * @Author rossdrew
 * @Created 02/05/16.
 */
public interface LogicGate extends LogicValueProducer {
    void setInput(LogicValueProducer...inputs);
    LogicValueProducer[] getInput();
    String getStringIdentifier();
}
