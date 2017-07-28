package com.dragonballzrpg.actions;

import com.dragonballzrpg.gameobjects.characters.Player;

/**
 * Created by Carl on 28/07/2017.
 */
public abstract class PlayerAction
{
    protected Player player;

    public PlayerAction(Player player)
    {
        this.player = player;
    }

    public abstract void update();
}
