package com.dragonballzrpg.states.playerstates.attackingstates.meleeingstates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragonballzrpg.entities.Entity;
import com.dragonballzrpg.entities.players.Player;
import com.dragonballzrpg.enums.AnimationName;
import com.dragonballzrpg.enums.SoundName;
import com.dragonballzrpg.enums.StateName;
import com.dragonballzrpg.states.State;
import com.dragonballzrpg.states.Transition;
import com.dragonballzrpg.states.TransitionCondition;

/**
 * Created by Carl on 06/09/2016.
 */
public class MeleeingDownState extends State
{
    @Override
    public void initialiseTransitions(Player player)
    {
        transitions.add(new Transition(player.states.get(StateName.STANDING), new AnimationName[]{AnimationName.FACE_DOWN},
        new TransitionCondition[]
        {
            new TransitionCondition(player.isMeleeKeyPressed, false)
        }));

//        transitions.add(new Transition(p.getPlayerStates().value(StateName.STANDING), new String[]{"facingDown"},
//        new TransitionCondition[]
//        {
//        new TransitionCondition(p.isDownKeyPressed(), false)
//        }));
//
//        transitions.add(new Transition(p.getPlayerStates().value("walkingNorth"), new String[]{"walkingUp"},
//        new TransitionCondition[]
//        {
//        new TransitionCondition(p.isUpKeyPressed(), true)
//        }));
//
//        transitions.add(new Transition(p.getPlayerStates().value("walkingSouth"), new String[]{"walkingDown"},
//        new TransitionCondition[]
//        {
//        new TransitionCondition(p.isDownKeyPressed(), true)
//        }));
//
//        transitions.add(new Transition(p.getPlayerStates().value("walkingWest"), new String[]{"walkingLeft"},
//        new TransitionCondition[]
//        {
//        new TransitionCondition(p.isLeftKeyPressed(), true)
//        }));
//
//        transitions.add(new Transition(p.getPlayerStates().value("walkingEast"), new String[]{"walkingRight"},
//        new TransitionCondition[]
//        {
//        new TransitionCondition(p.isRightKeyPressed(), true)
//        }));
//
//        transitions.add(new Transition(p.getPlayerStates().value("walkingWestNorth"), new String[]{"walkingLeft"},
//        new TransitionCondition[]
//        {
//        new TransitionCondition(p.isUpKeyPressed(), true),
//        new TransitionCondition(p.isLeftKeyPressed(), true)
//        }));
//
//        transitions.add(new Transition(p.getPlayerStates().value("walkingEastNorth"), new String[]{"walkingRight"},
//        new TransitionCondition[]
//        {
//        new TransitionCondition(p.isUpKeyPressed(), true),
//        new TransitionCondition(p.isRightKeyPressed(), true)
//        }));
//
//        transitions.add(new Transition(p.getPlayerStates().value("walkingWestSouth"), new String[]{"walkingLeft"},
//        new TransitionCondition[]
//        {
//        new TransitionCondition(p.isDownKeyPressed(), true),
//        new TransitionCondition(p.isLeftKeyPressed(), true)
//        }));
//
//        transitions.add(new Transition(p.getPlayerStates().value("walkingEastSouth"), new String[]{"walkingRight"},
//        new TransitionCondition[]
//        {
//        new TransitionCondition(p.isDownKeyPressed(), true),
//        new TransitionCondition(p.isRightKeyPressed(), true)
//        }));
    }

    @Override
    public void enter(Entity entity)
    {
        Player player = (Player)entity;

        player.canAttack.set(false);
        player.sounds.get(getRandomValue(new SoundName[]{SoundName.MELEE_1, SoundName.MELEE_2})).play();

        //p.canAttack().set(false);
        //p.setCanAttack(false);
        //p.getSounds().value(getRandomValue(new String[]{"melee1", "melee2"})).play();
    }

    @Override
    public void exit(Entity entity)
    {
        Player player = (Player)entity;
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

        if(!p.isMeleeKeyPressed())
        {
            //p.setCurrentAttackState(p.getPlayerStates().getAnimation("notAttacking"));
            //p.setCurrentMovementState(p.getPlayerStates().getAnimation("standing"));
            p.setCurrentAnimation(p.getStringAnimations().getAnimation("facingDown"));
        }*/
    }

    @Override
    public void render(Entity entity, SpriteBatch batch)
    {
        batch.draw(((Player)entity).currentAnimation.getCurrentFrame(), (int)entity.position.x, (int)entity.position.y);
    }
}
