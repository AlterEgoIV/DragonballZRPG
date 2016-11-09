package com.dragonballzrpg.states.playerstates.runningstates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragonballzrpg.entities.Entity;
import com.dragonballzrpg.entities.animatedentities.players.Player;
import com.dragonballzrpg.states.State;
import com.dragonballzrpg.states.Transition;

/**
 * Created by Carl on 30/08/2016.
 */
public class RunningEastNorthState extends State
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
    public void exit(Entity entity)
    {

    }

    @Override
    public void update(Entity entity)
    {
        for(Transition transition : transitions)
        {
            transition.update((Player)entity);
        }

        // Up
        /*if(((Player)entity).isUpKeyPressed() && !((Player)entity).isDownKeyPressed() &&
           !((Player)entity).isLeftKeyPressed() && !((Player)entity).isRightKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("walkingUp"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("walkingNorth"));
        }

        // Right
        if(!((Player)entity).isUpKeyPressed() && !((Player)entity).isDownKeyPressed() &&
           !((Player)entity).isLeftKeyPressed() && ((Player)entity).isRightKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("runningRight"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("runningEast"));
        }

        // Down && Right
        if(!((Player)entity).isUpKeyPressed() && ((Player)entity).isDownKeyPressed() &&
           !((Player)entity).isLeftKeyPressed() && ((Player)entity).isRightKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("runningRight"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("runningEastSouth"));
        }

        if(!((Player)entity).isRightKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("facingRight"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("standing"));
        }*/

        ((Player)entity).position.x += ((Player)entity).getRunSpeed() * Gdx.graphics.getDeltaTime();
        ((Player)entity).position.y += (((Player)entity).getRunSpeed() / 2) * Gdx.graphics.getDeltaTime();
    }

    @Override
    public void render(Entity entity, SpriteBatch batch)
    {

    }
}
