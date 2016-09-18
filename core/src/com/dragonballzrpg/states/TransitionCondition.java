package com.dragonballzrpg.states;

import com.dragonballzrpg.wrappers.Bool;

/**
 * Created by Carl on 15/09/2016.
 */
public class TransitionCondition
{
    private Bool value;
    private boolean control;

    public TransitionCondition(Bool value, boolean control)
    {
        this.value = value;
        this.control = control;
    }

    public boolean isValid()
    {
        return value.equals(control);
    }
}
