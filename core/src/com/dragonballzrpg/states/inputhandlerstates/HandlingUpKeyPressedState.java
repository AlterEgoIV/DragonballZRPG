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

        player.position.y += 300;
    }

    @Override
    public void render(SpriteBatch batch)
    {

    }
}
