package com.dragonballzrpg.states;

/**
 * Created by Carl on 15/09/2016.
 */
public class TransitionCondition
{
    private Boolean condition;
    private boolean requiredValue;

    public TransitionCondition(Boolean condition, boolean requiredValue)
    {
        this.condition = condition;
        this.requiredValue = requiredValue;
    }

    public boolean isValid()
    {
        return condition.equals(requiredValue);
    }
}
