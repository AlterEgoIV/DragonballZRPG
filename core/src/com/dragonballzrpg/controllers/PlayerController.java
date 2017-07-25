package com.dragonballzrpg.controllers;

import com.dragonballzrpg.gameobjects.characters.Player;
import com.dragonballzrpg.input.KeyHandler;

/**
 * Created by Carl on 14/07/2017.
 */
public class PlayerController extends Controller
{
    private Player player;
    public KeyHandler keyHandler;

    public PlayerController(KeyHandler keyHandler)
    {
        this.keyHandler = keyHandler;
    }

    public void update()
    {
        keyHandler.update();
    }

    public void setPlayer(Player player)
    {
        this.player = player;
    }
}
