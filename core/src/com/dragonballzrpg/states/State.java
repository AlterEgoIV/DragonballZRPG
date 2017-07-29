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
    //protected List<Transition> transitions;
    protected StateTransitionSet stateTransitionSet;
    protected double currentDuration;

    public State()
    {
        //transitions = new ArrayList<Transition>();
        currentDuration = 0.0d;
    }

    public State(List<Transition> transitions)
    {
        //this.transitions = transitions;
        currentDuration = 0.0d;
    }

    public abstract void enter();
    public abstract void exit();
    public abstract void update();
    public abstract void render(SpriteBatch batch);

    public void setTransitions(List<Transition> transitions)
    {
        //this.transitions = transitions;
    }

    public void setTransitions(StateTransitionSet stateTransitionSet)
    {
        this.stateTransitionSet = stateTransitionSet;
    }

    protected void checkTransitions()
    {
        stateTransitionSet.checkTransitions();
    }
}
