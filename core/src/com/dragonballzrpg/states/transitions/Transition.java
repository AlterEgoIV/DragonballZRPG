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
            System.out.println("In Transition update()");
            if(!transitionCondition.isMet()) return state;
        }

        System.out.println("Transition succeeded");

        // If everything is correct
        state.exit();
        state = newState;
        state.enter();

        return state;
    }
}
