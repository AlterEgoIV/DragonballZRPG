package com.dragonballzrpg.states.transitions;

import com.dragonballzrpg.states.State;

/**
 * Created by Carl on 25/07/2017.
 */
public class Transition
{
    private State currentState, newState;
    private TransitionCondition[] transitionConditions;

    public Transition(State currentState, State newState, TransitionCondition[] transitionConditions)
    {
        this.currentState = currentState;
        this.newState = newState;
        this.transitionConditions = transitionConditions;
    }

    public void update()
    {
        for(int i = 0; i < transitionConditions.length; ++i)
        {

        }

        // If everything correct
        currentState.exit();
        currentState = newState;
        currentState.enter();
    }
}
