package com.dragonballzrpg.states.playerstates.attackingstates.meleeingstates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragonballzrpg.entities.Entity;
import com.dragonballzrpg.entities.animatedentities.players.Player;
import com.dragonballzrpg.states.State;
import com.dragonballzrpg.states.Transition;
import com.dragonballzrpg.states.TransitionCondition;

/**
 * Created by Carl on 06/09/2016.
 */
public class MeleeingDownState extends State
{
    @Override
    public void initialiseTransitions(Player p)
    {
        transitions.add(new Transition(p.getPlayerStates().get("facingSouth"), new String[]{"facingDown"},
        new TransitionCondition[]
        {
        new TransitionCondition(p.getDownKeyPressed(), false)
        }));

        transitions.add(new Transition(p.getPlayerStates().get("walkingNorth"), new String[]{"walkingUp"},
        new TransitionCondition[]
        {
        new TransitionCondition(p.getUpKeyPressed(), true)
        }));

        transitions.add(new Transition(p.getPlayerStates().get("walkingSouth"), new String[]{"walkingDown"},
        new TransitionCondition[]
        {
        new TransitionCondition(p.getDownKeyPressed(), true)
        }));

        transitions.add(new Transition(p.getPlayerStates().get("walkingWest"), new String[]{"walkingLeft"},
        new TransitionCondition[]
        {
        new TransitionCondition(p.getLeftKeyPressed(), true)
        }));

        transitions.add(new Transition(p.getPlayerStates().get("walkingEast"), new String[]{"walkingRight"},
        new TransitionCondition[]
        {
        new TransitionCondition(p.getRightKeyPressed(), true)
        }));

        transitions.add(new Transition(p.getPlayerStates().get("walkingWestNorth"), new String[]{"walkingLeft"},
        new TransitionCondition[]
        {
        new TransitionCondition(p.getUpKeyPressed(), true),
        new TransitionCondition(p.getLeftKeyPressed(), true)
        }));

        transitions.add(new Transition(p.getPlayerStates().get("walkingEastNorth"), new String[]{"walkingRight"},
        new TransitionCondition[]
        {
        new TransitionCondition(p.getUpKeyPressed(), true),
        new TransitionCondition(p.getRightKeyPressed(), true)
        }));

        transitions.add(new Transition(p.getPlayerStates().get("walkingWestSouth"), new String[]{"walkingLeft"},
        new TransitionCondition[]
        {
        new TransitionCondition(p.getDownKeyPressed(), true),
        new TransitionCondition(p.getLeftKeyPressed(), true)
        }));

        transitions.add(new Transition(p.getPlayerStates().get("walkingEastSouth"), new String[]{"walkingRight"},
        new TransitionCondition[]
        {
        new TransitionCondition(p.getDownKeyPressed(), true),
        new TransitionCondition(p.getRightKeyPressed(), true)
        }));
    }

    @Override
    public void enter(Entity entity)
    {
        Player p = (Player)entity;

        p.getCanAttack().setValue(false);
        p.getSounds().get(getRandomValue(new String[]{"melee1", "melee2"})).play();
    }

    @Override
    public void exit(Entity entity)
    {

    }

    @Override
    public void update(Entity entity)
    {
        currentStateDuration += Gdx.graphics.getDeltaTime();

        if(currentStateDuration >= ((Player)entity).currentAnimation.getDuration())
        {
            currentStateDuration = 0.0d;
            ((Player)entity).currentAnimation.reset();

            for(Transition transition : transitions)
            {
                transition.update((Player)entity);
            }
        }

        /*Player p = (Player)entity;

        if(!p.isMKeyPressed())
        {
            //p.setCurrentAttackState(p.getPlayerStates().get("notAttacking"));
            //p.setCurrentMovementState(p.getPlayerStates().get("standing"));
            p.setCurrentAnimation(p.getAnimations().get("facingDown"));
        }*/
    }

    @Override
    public void render(Entity entity, SpriteBatch batch)
    {
        batch.draw(((Player)entity).currentAnimation.getCurrentFrame(), (int)entity.position.x, (int)entity.position.y);
    }
}
