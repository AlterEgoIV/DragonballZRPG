package com.dragonballzrpg.states.playerstates.runningstates;

import com.badlogic.gdx.Gdx;
import com.dragonballzrpg.entities.Entity;
import com.dragonballzrpg.entities.animatedentities.players.Player;
import com.dragonballzrpg.states.State;

/**
 * Created by Carl on 30/08/2016.
 */
public class RunningEastSouth extends State
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
        // Down
        /*if(!((Player)entity).isUpKeyPressed() && ((Player)entity).isDownKeyPressed() &&
           !((Player)entity).isLeftKeyPressed() && !((Player)entity).isRightKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("walkingDown"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("walkingSouth"));
        }

        // Right
        if(!((Player)entity).isUpKeyPressed() && !((Player)entity).isDownKeyPressed() &&
           !((Player)entity).isLeftKeyPressed() && ((Player)entity).isRightKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("runningRight"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("runningEast"));
        }

        // Up && Right
        if(((Player)entity).isUpKeyPressed() && !((Player)entity).isDownKeyPressed() &&
           !((Player)entity).isLeftKeyPressed() && ((Player)entity).isRightKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("runningRight"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("runningEastNorth"));
        }

        if(!((Player)entity).isRightKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("facingRight"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("standing"));
        }*/

        ((Player)entity).position.x += ((Player)entity).getRunSpeed() * Gdx.graphics.getDeltaTime();
        ((Player)entity).position.y -= (((Player)entity).getRunSpeed() / 2) * Gdx.graphics.getDeltaTime();
    }
}
