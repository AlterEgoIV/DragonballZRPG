package com.dragonballzrpg.controllers;

import com.dragonballzrpg.enums.StateName;
import com.dragonballzrpg.gameobjects.GameObject;
import com.dragonballzrpg.states.State;

import java.util.List;
import java.util.Map;

/**
 * Created by Carl on 14/07/2017.
 */
public class AIController extends Controller
{
    public AIController(GameObject gameObject, Map<StateName, State> states)
    {
        super(gameObject, states);
    }

    @Override
    public void update() {

    }
}
