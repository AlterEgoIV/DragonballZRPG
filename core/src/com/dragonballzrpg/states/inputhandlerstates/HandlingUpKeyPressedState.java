package com.dragonballzrpg.states.inputhandlerstates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragonballzrpg.gameobjects.GameObject;
import com.dragonballzrpg.gameobjects.characters.Player;
import com.dragonballzrpg.states.State;

/**
 * Created by Carl on 28/07/2017.
 */

public class HandlingUpKeyPressedState extends State
{
    Player player;

    public HandlingUpKeyPressedState()
    {

    }

    public HandlingUpKeyPressedState(Player player)
    {
        this.player = player;
    }

    @Override
    public void enter()
    {

    }

    @Override
    public void exit()
    {

    }

    @Override
    public void update()
    {
        checkTransitions();

        player.velocity.y = 30;

        System.out.println("Updating HandlingUpKeyPressedState");
    }

    @Override
    public void render(SpriteBatch batch)
    {

    }
}
