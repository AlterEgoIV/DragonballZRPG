package com.dragonballzrpg.states.inputhandlerstates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragonballzrpg.gameobjects.GameObject;
import com.dragonballzrpg.states.State;

/**
 * Created by Carl on 28/07/2017.
 */
public class NotHandlingInputState extends State
{
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

        System.out.println("Updating NotHandlingInputState");
    }

    @Override
    public void render(SpriteBatch batch)
    {

    }
}
