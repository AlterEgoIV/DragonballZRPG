package com.dragonballzrpg.states.playerstates.runningstates;

import com.badlogic.gdx.Gdx;
import com.dragonballzrpg.entities.Entity;
import com.dragonballzrpg.entities.animatedentities.players.Player;
import com.dragonballzrpg.states.State;

import java.util.Map;

/**
 * Created by Carl on 24/08/2016.
 */
public class RunningNorthEast extends State
{
    @Override
    public void initialiseTransitions(Map<String, State> playerStates)
    {

    }

    @Override
    public void update(Entity entity)
    {
        // Up
        if(((Player)entity).isUpKeyPressed() && !((Player)entity).isDownKeyPressed() &&
           !((Player)entity).isLeftKeyPressed() && !((Player)entity).isRightKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("runningUp"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("runningNorth"));
        }

        // Right
        if(!((Player)entity).isUpKeyPressed() && !((Player)entity).isDownKeyPressed() &&
           !((Player)entity).isLeftKeyPressed() && ((Player)entity).isRightKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("walkingRight"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("walkingEast"));
        }

        // Up && Left
        if(((Player)entity).isUpKeyPressed() && !((Player)entity).isDownKeyPressed() &&
           ((Player)entity).isLeftKeyPressed() && !((Player)entity).isRightKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("runningUp"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("runningNorthWest"));
        }

        if(!((Player)entity).isUpKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("facingUp"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("standing"));
        }

        ((Player)entity).position.x += (((Player)entity).getRunSpeed() / 2) * Gdx.graphics.getDeltaTime();
        ((Player)entity).position.y += ((Player)entity).getRunSpeed() * Gdx.graphics.getDeltaTime();
    }
}
