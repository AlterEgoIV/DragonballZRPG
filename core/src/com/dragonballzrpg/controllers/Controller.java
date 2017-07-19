package com.dragonballzrpg.controllers;

import com.dragonballzrpg.gameobjects.GameObject;
import com.dragonballzrpg.states.State;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carl on 14/07/2017.
 */
public abstract class Controller
{
    protected GameObject gameObject;
    public List<State> states;
    public State currentState;

    public Controller()
    {
        states = new ArrayList<State>();
    }

    public Controller(GameObject gameObject)
    {
        this.gameObject = gameObject;
        states = new ArrayList<State>();
    }

    public Controller(GameObject gameObject, List<State> states)
    {
        this.gameObject = gameObject;
        this.states = states;
    }

    public void update()
    {
        currentState.update(gameObject);
    }
}
