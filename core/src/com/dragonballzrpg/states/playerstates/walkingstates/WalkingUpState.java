package com.dragonballzrpg.states.playerstates.walkingstates;

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
public class WalkingUpState extends State
{
    @Override
    public void initialiseTransitions(Player p)
    {
        transitions.add(new Transition(p.getPlayerStates().get("facingNorth"), new String[]{"facingUp"},
        new TransitionCondition[]
        {
            new TransitionCondition(p.getUpKeyPressed(), false)
        }));

        transitions.add(new Transition(p.getPlayerStates().get("walkingSouth"), new String[]{"walkingDown"},
        new TransitionCondition[]
        {
        new TransitionCondition(p.getUpKeyPressed(), false),
        new TransitionCondition(p.getDownKeyPressed(), true)
        }));

        transitions.add(new Transition(p.getPlayerStates().get("walkingNorthEast"), new String[]{"walkingUp"},
        new TransitionCondition[]
        {
        new TransitionCondition(p.getUpKeyPressed(), true),
        new TransitionCondition(p.getRightKeyPressed(), true)
        }));

        transitions.add(new Transition(p.getPlayerStates().get("walkingNorthWest"), new String[]{"walkingUp"},
        new TransitionCondition[]
        {
        new TransitionCondition(p.getUpKeyPressed(), true),
        new TransitionCondition(p.getLeftKeyPressed(), true)
        }));

        transitions.add(new Transition(p.getPlayerStates().get("meleeingNorth"), new String[]{"punch1Up", "punch2Up", "kickUp"},
        new TransitionCondition[]
        {
        new TransitionCondition(p.getMKeyPressed(), true),
        new TransitionCondition(p.getCanAttack(), true)
        }));
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

        // Up && Left
        /*if(((Player)entity).isUpKeyPressed() && !((Player)entity).isDownKeyPressed() &&
           ((Player)entity).isLeftKeyPressed() && !((Player)entity).isRightKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("walkingUp"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("walkingNorthWest"));
        }

        // Up && Right
        if(((Player)entity).isUpKeyPressed() && !((Player)entity).isDownKeyPressed() &&
           !((Player)entity).isLeftKeyPressed() && ((Player)entity).isRightKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("walkingUp"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("walkingNorthEast"));
        }

        if(!((Player)entity).isUpKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("facingUp"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("standing"));
        }*/

        ((Player)entity).position.y += entity.getSpeed() * Gdx.graphics.getDeltaTime();
    }

    @Override
    public void render(Entity entity, SpriteBatch batch)
    {
        //batch.draw(((Player)entity).currentAnimation.getCurrentFrame(), (int)entity.position.x, (int)entity.position.y);
        batch.draw(((Player)entity).currentAnimation.getCurrentFrame(),
        (int)((Player)entity).position.x - ((Player)entity).currentAnimation.getCurrentFrame().getRegionWidth() / 2,
        (int)((Player)entity).position.y - ((Player)entity).currentAnimation.getCurrentFrame().getRegionHeight() / 2);
    }
}