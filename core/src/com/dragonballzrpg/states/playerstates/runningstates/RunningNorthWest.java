package com.dragonballzrpg.states.playerstates.runningstates;

import com.badlogic.gdx.Gdx;
import com.dragonballzrpg.entities.Entity;
import com.dragonballzrpg.entities.animatedentities.players.Player;
import com.dragonballzrpg.states.State;

/**
 * Created by Carl on 24/08/2016.
 */
public class RunningNorthWest extends State
{
    @Override
    public void initialiseTransitions(Player p)
    {

    }

    @Override
    public void enter(Entity entity)
    {

    }

    @Override
    public void update(Entity entity)
    {
        // Up
        /*if(((Player)entity).isUpKeyPressed() && !((Player)entity).isDownKeyPressed() &&
           !((Player)entity).isLeftKeyPressed() && !((Player)entity).isRightKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("runningUp"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("runningNorth"));
        }

        // Left
        if(!((Player)entity).isUpKeyPressed() && !((Player)entity).isDownKeyPressed() &&
           ((Player)entity).isLeftKeyPressed() && !((Player)entity).isRightKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("walkingLeft"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("walkingWest"));
        }

        // Up && Right
        if(((Player)entity).isUpKeyPressed() && !((Player)entity).isDownKeyPressed() &&
           !((Player)entity).isLeftKeyPressed() && ((Player)entity).isRightKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("runningUp"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("runningNorthEast"));
        }

        if(!((Player)entity).isUpKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("facingUp"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("standing"));
        }*/

        ((Player)entity).position.x -= (((Player)entity).getRunSpeed() / 2) * Gdx.graphics.getDeltaTime();
        ((Player)entity).position.y += ((Player)entity).getRunSpeed() * Gdx.graphics.getDeltaTime();
    }
}