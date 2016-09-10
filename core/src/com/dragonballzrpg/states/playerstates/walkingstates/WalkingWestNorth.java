package com.dragonballzrpg.states.playerstates.walkingstates;

import com.badlogic.gdx.Gdx;
import com.dragonballzrpg.entities.Entity;
import com.dragonballzrpg.entities.animatedentities.players.Player;
import com.dragonballzrpg.states.State;

import java.util.Map;

/**
 * Created by Carl on 30/08/2016.
 */
public class WalkingWestNorth extends State
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
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("walkingUp"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("walkingNorth"));
        }

        // Left
        if(!((Player)entity).isUpKeyPressed() && !((Player)entity).isDownKeyPressed() &&
           ((Player)entity).isLeftKeyPressed() && !((Player)entity).isRightKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("walkingLeft"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("walkingWest"));
        }

        // Down && Left
        if(!((Player)entity).isUpKeyPressed() && ((Player)entity).isDownKeyPressed() &&
           ((Player)entity).isLeftKeyPressed() && !((Player)entity).isRightKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("walkingLeft"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("walkingWestSouth"));
        }

        if(!((Player)entity).isLeftKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("facingLeft"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("standing"));
        }

        ((Player)entity).position.x -= entity.getSpeed() * Gdx.graphics.getDeltaTime();
        ((Player)entity).position.y += entity.getSpeed() * Gdx.graphics.getDeltaTime();
    }
}
