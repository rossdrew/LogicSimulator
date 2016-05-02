package com.rox;

/**
 * @Author rossdrew
 * @Created 02/05/16.
 */
public interface LogicGate extends LogicValue{
    void multipleInput(LogicValue ...inputs);
}
