package com.dragonballzrpg.actions;

import com.dragonballzrpg.gameobjects.characters.Player;

/**
 * Created by Carl on 03/08/2017.
 */
public class PlayerActionProcessor extends ActionProcessor
{
    private Player player;

    public PlayerActionProcessor(Player player)
    {
        this.player = player;
    }

    @Override
    public void update()
    {
        for(Action action : actions)
        {
            action.update();
        }
    }
}
