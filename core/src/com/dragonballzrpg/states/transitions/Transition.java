package com.dragonballzrpg.states.transitions;

import com.dragonballzrpg.states.State;

import java.util.List;

/**
 * Created by Carl on 25/07/2017.
 */
public class Transition
{
    private State currentState, newState;
    private List<TransitionCondition> transitionConditions;

    public Transition(State currentState, State newState, List<TransitionCondition> transitionConditions)
    {
        this.currentState = currentState;
        this.newState = newState;
        this.transitionConditions = transitionConditions;
    }

    public void update()
    {
        for(TransitionCondition transitionCondition : transitionConditions)
        {
            System.out.println("In Transition update()");
            if(!transitionCondition.isMet()) return;
        }

        System.out.println("Transition succeeded");

        // If everything is correct
        currentState.exit();
        currentState = newState; // This should re-assign InputHandler.currentState but does not seem to
        currentState.enter();
        System.out.println(currentState.toString());
    }
}
