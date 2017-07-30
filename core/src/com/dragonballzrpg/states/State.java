package com.dragonballzrpg.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragonballzrpg.gameobjects.GameObject;
import com.dragonballzrpg.states.transitions.Transition;
import com.dragonballzrpg.states.transitions.transitionsets.StateTransitionSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carl on 24/08/2016.
 */
public abstract class State
{
    protected StateTransitionSet stateTransitionSet;
    protected double currentDuration;

    public State()
    {
        currentDuration = 0.0d;
    }

    public abstract void enter();
    public abstract void exit();
    public abstract State update();
    public abstract void render(SpriteBatch batch);


    public void setTransitions(StateTransitionSet stateTransitionSet)
    {
        this.stateTransitionSet = stateTransitionSet;
    }

    protected State checkTransitions(State state)
    {
        return stateTransitionSet.checkTransitions(state);
    }
}
