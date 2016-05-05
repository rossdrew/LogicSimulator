package com.rox.logic;

import com.rox.LogicValue;

/**
 * @Author rossdrew
 * @Created 02/05/16.
 */
public interface LogicGate extends LogicValue {
    void setInput(LogicValue ...inputs);
}
