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
    public State update()
    {
        System.out.println("Updating NotHandlingInputState");

        return checkTransitions(this);
    }

    @Override
    public void render(SpriteBatch batch)
    {

    }
}
