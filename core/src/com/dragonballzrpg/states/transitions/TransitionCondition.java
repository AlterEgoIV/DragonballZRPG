package com.dragonballzrpg.states.transitions;

/**
 * Created by Carl on 25/07/2017.
 */
public class TransitionCondition
{
    private boolean actualValue, requiredValue;

    public TransitionCondition(boolean actualValue, boolean requiredValue)
    {
        this.actualValue = actualValue;
        this.requiredValue = requiredValue;
    }

    public boolean isValid()
    {
        return actualValue == requiredValue;
    }
}
