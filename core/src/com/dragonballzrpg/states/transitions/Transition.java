package com.dragonballzrpg.states.transitions;

import com.dragonballzrpg.states.State;

import java.util.List;

/**
 * Created by Carl on 25/07/2017.
 */
public class Transition
{
    private State newState;
    private List<TransitionCondition> transitionConditions;

    public Transition(State newState, List<TransitionCondition> transitionConditions)
    {
        this.newState = newState;
        this.transitionConditions = transitionConditions;
    }

    public State update(State state)
    {
        for(TransitionCondition transitionCondition : transitionConditions)
        {
            if(!transitionCondition.isMet()) return state;
        }

        state.exit();
        state = newState;
        state.enter();

        return state;
    }
}
