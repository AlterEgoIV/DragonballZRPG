package com.dragonballzrpg.states.playerstates.attackingstates.meleeingstates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragonballzrpg.gameobjects.GameObject;
import com.dragonballzrpg.gameobjects.players.Player;
import com.dragonballzrpg.states.State;
import com.dragonballzrpg.states.Transition;

/**
 * Created by Carl on 06/09/2016.
 */
public class MeleeingUpState extends State
{
    @Override
    public void initialiseTransitions(Player p)
    {
//        transitions.add(new Transition(p.getPlayerStates().get("facingNorth"), new String[]{"facingUp"},
//        new TransitionCondition[]
//        {
//        new TransitionCondition(p.isUpKeyPressed(), false)
//        }));
//
//        transitions.add(new Transition(p.getPlayerStates().get("walkingNorth"), new String[]{"walkingUp"},
//        new TransitionCondition[]
//        {
//        new TransitionCondition(p.isUpKeyPressed(), true)
//        }));
//
//        transitions.add(new Transition(p.getPlayerStates().get("walkingSouth"), new String[]{"walkingDown"},
//        new TransitionCondition[]
//        {
//        new TransitionCondition(p.isDownKeyPressed(), true)
//        }));
//
//        transitions.add(new Transition(p.getPlayerStates().get("walkingWest"), new String[]{"walkingLeft"},
//        new TransitionCondition[]
//        {
//        new TransitionCondition(p.isLeftKeyPressed(), true)
//        }));
//
//        transitions.add(new Transition(p.getPlayerStates().get("walkingEast"), new String[]{"walkingRight"},
//        new TransitionCondition[]
//        {
//        new TransitionCondition(p.isRightKeyPressed(), true)
//        }));
//
//        transitions.add(new Transition(p.getPlayerStates().get("walkingWestNorth"), new String[]{"walkingLeft"},
//        new TransitionCondition[]
//        {
//        new TransitionCondition(p.isUpKeyPressed(), true),
//        new TransitionCondition(p.isLeftKeyPressed(), true)
//        }));
//
//        transitions.add(new Transition(p.getPlayerStates().get("walkingEastNorth"), new String[]{"walkingRight"},
//        new TransitionCondition[]
//        {
//        new TransitionCondition(p.isUpKeyPressed(), true),
//        new TransitionCondition(p.isRightKeyPressed(), true)
//        }));
//
//        transitions.add(new Transition(p.getPlayerStates().get("walkingWestSouth"), new String[]{"walkingLeft"},
//        new TransitionCondition[]
//        {
//        new TransitionCondition(p.isDownKeyPressed(), true),
//        new TransitionCondition(p.isLeftKeyPressed(), true)
//        }));
//
//        transitions.add(new Transition(p.getPlayerStates().get("walkingEastSouth"), new String[]{"walkingRight"},
//        new TransitionCondition[]
//        {
//        new TransitionCondition(p.isDownKeyPressed(), true),
//        new TransitionCondition(p.isRightKeyPressed(), true)
//        }));
    }

    @Override
    public void enter(GameObject gameObject)
    {
        Player p = (Player) gameObject;

        //p.canAttack().set(false);
        //p.setCanAttack(false);
        //p.getSounds().get(getRandomValue(new String[]{"melee1", "melee2"})).play();
    }

    @Override
    public void exit(GameObject gameObject)
    {

    }

    @Override
    public void update(GameObject gameObject)
    {
        currentStateDuration += Gdx.graphics.getDeltaTime();

        if(currentStateDuration >= ((Player) gameObject).currentAnimation.getDuration())
        {
            currentStateDuration = 0.0d;
            ((Player) gameObject).currentAnimation.reset();

            for(Transition transition : transitions)
            {
                transition.update((Player) gameObject);
            }
        }

        /*Player p = (Player)gameObject;

        if(!p.isMeleeKeyPressed())
        {
            //p.setCurrentAttackState(p.getPlayerStates().getAnimation("notAttacking"));
            //p.setCurrentMovementState(p.getPlayerStates().getAnimation("standing"));
            p.setCurrentAnimation(p.getStringAnimations().getAnimation("facingUp"));
        }*/
    }

    @Override
    public void render(GameObject gameObject, SpriteBatch batch)
    {
        //batch.draw(((Player)gameObject).currentAnimation.getCurrentFrame(), (int)gameObject.position.x, (int)gameObject.position.y);
    }
}
