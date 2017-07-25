package com.dragonballzrpg.states.deprecated.transitions_deprecated_;

import com.dragonballzrpg.wrappers.Bool;

/**
 * Created by Carl on 15/09/2016.
 */
public class TransitionConditionDep
{
    private Bool condition;
    private boolean requiredValue;

    public TransitionConditionDep(Bool condition, boolean requiredValue)
    {
        this.condition = condition;
        this.requiredValue = requiredValue;
    }

    public boolean isValid()
    {
        return condition.equals(requiredValue);
    }
}
