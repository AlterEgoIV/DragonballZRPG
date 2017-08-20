package com.dragonballzrpg.controllers;

import com.dragonballzrpg.enums.StateName;
import com.dragonballzrpg.gameobjects.GameObject;
import com.dragonballzrpg.states.State;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Carl on 14/07/2017.
 */
public abstract class Controller
{
    //protected GameObject gameObject;
    //public List<State> states;
    public Map<StateName, State> states;
    public State currentState;

    public Controller()
    {
        //states = new ArrayList<State>();
        states = new HashMap<StateName, State>();
    }

    public Controller(GameObject gameObject)
    {
        //this.gameObject = gameObject;
        //states = new ArrayList<State>();
        states = new HashMap<StateName, State>();
    }

    public Controller(GameObject gameObject, Map<StateName, State> states)
    {
        //this.gameObject = gameObject;
        this.states = states;
    }

    public abstract void update();
}
