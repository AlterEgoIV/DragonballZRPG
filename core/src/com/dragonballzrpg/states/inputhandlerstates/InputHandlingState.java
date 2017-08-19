package com.dragonballzrpg.states.inputhandlerstates;

import com.dragonballzrpg.actions.ActionManager;
import com.dragonballzrpg.gameobjects.characters.Player;
import com.dragonballzrpg.states.State;

/**
 * Created by Carl on 03/08/2017.
 */
public abstract class InputHandlingState extends State
{
    protected Player player;

    public InputHandlingState(Player player)
    {
        this.player = player;
    }

//    protected ActionManager actionManager;
//
//    public InputHandlingState(ActionManager actionManager)
//    {
//        this.actionManager = actionManager;
//    }
}
