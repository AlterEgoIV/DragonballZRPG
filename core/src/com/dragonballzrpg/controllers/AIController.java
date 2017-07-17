package com.dragonballzrpg.controllers;

import com.dragonballzrpg.gameobjects.GameObject;
import com.dragonballzrpg.states.State;

import java.util.List;

/**
 * Created by Carl on 14/07/2017.
 */
public class AIController extends Controller
{
    public AIController(GameObject gameObject, List<State> states)
    {
        super(gameObject, states);
    }
}
