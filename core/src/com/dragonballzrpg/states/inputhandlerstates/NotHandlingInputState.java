package com.dragonballzrpg.states.inputhandlerstates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragonballzrpg.actions.ActionManager;
import com.dragonballzrpg.gameobjects.characters.Player;
import com.dragonballzrpg.states.State;

/**
 * Created by Carl on 28/07/2017.
 */
public class NotHandlingInputState extends InputHandlingState
{
//    public NotHandlingInputState(ActionManager actionManager)
//    {
//        super(actionManager);
//    }

    public NotHandlingInputState(Player player)
    {
        super(player);
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
    public State update()
    {
        return checkTransitions(this);
    }

    @Override
    public void render(SpriteBatch batch)
    {

    }
}
