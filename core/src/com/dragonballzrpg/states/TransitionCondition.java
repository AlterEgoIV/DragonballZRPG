package com.dragonballzrpg.states;

import com.dragonballzrpg.wrappers.Bool;

/**
 * Created by Carl on 15/09/2016.
 */
public class TransitionCondition
{
    //private Boolean condition;
    private Bool condition;
    private boolean requiredValue;

    public TransitionCondition(Bool condition, boolean requiredValue)
    {
        this.condition = condition;
        this.requiredValue = requiredValue;
    }

    public boolean isValid()
    {
        return condition.equals(requiredValue);
    }
}
