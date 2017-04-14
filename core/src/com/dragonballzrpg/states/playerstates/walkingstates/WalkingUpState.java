package com.dragonballzrpg.states.playerstates.walkingstates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragonballzrpg.entities.Entity;
import com.dragonballzrpg.entities.players.Player;
import com.dragonballzrpg.states.State;
import com.dragonballzrpg.states.Transition;

/**
 * Created by Carl on 24/08/2016.
 */
public class WalkingUpState extends State
{
    @Override
    public void initialiseTransitions(Player p)
    {
//        transitions.add(new Transition(p.getPlayerStates().get("facingNorth"), new String[]{"facingUp"},
//        new TransitionCondition[]
//        {
//            new TransitionCondition(p.isUpKeyPressed(), false)
//        }));
//
//        transitions.add(new Transition(p.getPlayerStates().get("walkingSouth"), new String[]{"walkingDown"},
//        new TransitionCondition[]
//        {
//        new TransitionCondition(p.isUpKeyPressed(), false),
//        new TransitionCondition(p.isDownKeyPressed(), true)
//        }));
//
//        transitions.add(new Transition(p.getPlayerStates().get("walkingNorthEast"), new String[]{"walkingUp"},
//        new TransitionCondition[]
//        {
//        new TransitionCondition(p.isUpKeyPressed(), true),
//        new TransitionCondition(p.isRightKeyPressed(), true)
//        }));
//
//        transitions.add(new Transition(p.getPlayerStates().get("walkingNorthWest"), new String[]{"walkingUp"},
//        new TransitionCondition[]
//        {
//        new TransitionCondition(p.isUpKeyPressed(), true),
//        new TransitionCondition(p.isLeftKeyPressed(), true)
//        }));
//
//        transitions.add(new Transition(p.getPlayerStates().get("meleeingNorth"), new String[]{"punch1Up", "punch2Up", "kickUp"},
//        new TransitionCondition[]
//        {
//        new TransitionCondition(p.isMeleeKeyPressed(), true),
//        new TransitionCondition(p.canAttack(), true)
//        }));
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
            ((Player)entity).setCurrentAnimation(((Player)entity).getStringAnimations().getAnimation("walkingUp"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().getAnimation("walkingNorthWest"));
        }

        // Up && Right
        if(((Player)entity).isUpKeyPressed() && !((Player)entity).isDownKeyPressed() &&
           !((Player)entity).isLeftKeyPressed() && ((Player)entity).isRightKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getStringAnimations().getAnimation("walkingUp"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().getAnimation("walkingNorthEast"));
        }

        if(!((Player)entity).isUpKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getStringAnimations().getAnimation("facingUp"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().getAnimation("standing"));
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