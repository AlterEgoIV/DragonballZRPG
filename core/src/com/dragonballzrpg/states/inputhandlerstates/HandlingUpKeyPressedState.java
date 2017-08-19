package com.dragonballzrpg.states.inputhandlerstates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragonballzrpg.actions.ActionManager;
import com.dragonballzrpg.enums.ActionName;
import com.dragonballzrpg.enums.AnimationName;
import com.dragonballzrpg.enums.AnimationSet;
import com.dragonballzrpg.gameobjects.characters.Player;
import com.dragonballzrpg.states.State;

/**
 * Created by Carl on 28/07/2017.
 */

public class HandlingUpKeyPressedState extends InputHandlingState
{
//    public HandlingUpKeyPressedState(ActionManager actionManager)
//    {
//        super(actionManager);
//    }

    public HandlingUpKeyPressedState(Player player)
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
        //actionManager.sendAction(ActionName.MOVE_UP, AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS, AnimationName.WALK_UP);

        return checkTransitions(this);
    }

    @Override
    public void render(SpriteBatch batch)
    {

    }
}
