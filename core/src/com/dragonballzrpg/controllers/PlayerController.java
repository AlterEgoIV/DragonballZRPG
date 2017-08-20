package com.dragonballzrpg.controllers;

import com.dragonballzrpg.gameobjects.characters.Player;
import com.dragonballzrpg.input.KeyStateViewer;

/**
 * Created by Carl on 14/07/2017.
 */
public class PlayerController extends InputController
{
    private Player player;

    public PlayerController(Player player, KeyStateViewer keyStateViewer)
    {
        super(keyStateViewer);

        this.player = player;
    }

    public void update()
    {
        //currentState = currentState.update();
    }
}
