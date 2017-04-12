package com.dragonballzrpg.states.playerstates.runningstates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragonballzrpg.entities.Entity;
import com.dragonballzrpg.entities.animatedentities.players.Player;
import com.dragonballzrpg.states.State;
import com.dragonballzrpg.states.Transition;
import com.dragonballzrpg.states.TransitionCondition;

/**
 * Created by Carl on 24/08/2016.
 */
public class RunningRightState extends State
{
    @Override
    public void initialiseTransitions(Player p)
    {
        transitions.add(new Transition(p.getPlayerStates().get("facingEast"), new String[]{"facingRight"},
        new TransitionCondition[]
        {
            new TransitionCondition(p.getRightKeyPressed(), false)
        }));
    }

    @Override
    public void enter(Entity entity)
    {
        entity.getSounds().get("running").loop();
    }

    @Override
    public void exit(Entity entity)
    {
        entity.getSounds().get("running").stop();
    }

    @Override
    public void update(Entity entity)
    {
        for(Transition transition : transitions)
        {
            transition.update((Player)entity);
        }

        // Up && Right
        /*if(((Player)entity).isUpKeyPressed() && !((Player)entity).isDownKeyPressed() &&
           !((Player)entity).isLeftKeyPressed() && ((Player)entity).isRightKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getStringAnimations().getAnimation("runningRight"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().getAnimation("runningEastNorth"));
        }

        // Down && Right
        if(!((Player)entity).isUpKeyPressed() && ((Player)entity).isDownKeyPressed() &&
           !((Player)entity).isLeftKeyPressed() && ((Player)entity).isRightKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getStringAnimations().getAnimation("runningRight"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().getAnimation("runningEastSouth"));
        }

        if(!((Player)entity).isRightKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getStringAnimations().getAnimation("facingRight"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().getAnimation("standing"));
        }*/

        ((Player)entity).position.x += ((Player)entity).getRunSpeed() * Gdx.graphics.getDeltaTime();
    }

    @Override
    public void render(Entity entity, SpriteBatch batch)
    {

    }
}