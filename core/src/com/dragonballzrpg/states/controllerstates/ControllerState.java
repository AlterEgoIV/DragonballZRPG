package com.dragonballzrpg.states.controllerstates;

import com.dragonballzrpg.controllers.Controller;
import com.dragonballzrpg.states.State;

/**
 * Created by Carl on 15/07/2017.
 */
public abstract class ControllerState extends State
{
    protected Controller controller;

    public ControllerState(Controller controller)
    {
        this.controller = controller;
    }
}
