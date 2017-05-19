package com.dragonballzrpg.states.playerstates.walkingstates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragonballzrpg.gameobjects.GameObject;
import com.dragonballzrpg.gameobjects.players.Player;
import com.dragonballzrpg.enums.AnimationName;
import com.dragonballzrpg.enums.StateName;
import com.dragonballzrpg.states.State;
import com.dragonballzrpg.states.Transition;
import com.dragonballzrpg.states.TransitionCondition;

/**
 * Created by Carl on 24/08/2016.
 */
public class WalkingLeftState extends State
{
    @Override
    public void initialiseTransitions(Player player)
    {
        transitions.add(new Transition(player.states.get(StateName.STANDING), new AnimationName[]{AnimationName.FACE_LEFT},
        new TransitionCondition[]
        {
        new TransitionCondition(player.isLeftKeyPressed, false)
        }));

        transitions.add(new Transition(player.states.get(StateName.MELEEING_RIGHT),
        new AnimationName[]{AnimationName.PUNCH_RIGHT_1, AnimationName.PUNCH_RIGHT_2, AnimationName.KICK_RIGHT},
        new TransitionCondition[]
        {
        new TransitionCondition(player.isMeleeKeyPressed, true),
        new TransitionCondition(player.canAttack, true)
        }));

//        transitions.add(new Transition(p.getPlayerStates().get("facingWest"), new String[]{"facingLeft"},
//        new TransitionCondition[]
//        {
//            new TransitionCondition(p.isLeftKeyPressed(), false)
//        }));
//
//        transitions.add(new Transition(p.getPlayerStates().get("walkingEast"), new String[]{"walkingRight"},
//        new TransitionCondition[]
//        {
//        new TransitionCondition(p.isLeftKeyPressed(), false),
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
//        transitions.add(new Transition(p.getPlayerStates().get("walkingWestSouth"), new String[]{"walkingLeft"},
//        new TransitionCondition[]
//        {
//        new TransitionCondition(p.isDownKeyPressed(), true),
//        new TransitionCondition(p.isLeftKeyPressed(), true)
//        }));
//
//        transitions.add(new Transition(p.getPlayerStates().get("meleeingWest"), new String[]{"punch1Left", "punch2Left", "kickLeft"},
//        new TransitionCondition[]
//        {
//        new TransitionCondition(p.isMeleeKeyPressed(), true),
//        new TransitionCondition(p.canAttack(), true)
//        }));
    }

    @Override
    public void enter(GameObject gameObject)
    {

    }

    @Override
    public void exit(GameObject gameObject)
    {

    }

    @Override
    public void update(GameObject gameObject)
    {
        for(Transition transition : transitions)
        {
            transition.update((Player) gameObject);
        }

        // Up && Left
        /*if(((Player)gameObject).isUpKeyPressed() && !((Player)gameObject).isDownKeyPressed() &&
           ((Player)gameObject).isLeftKeyPressed() && !((Player)gameObject).isRightKeyPressed())
        {
            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("walkingLeft"));
            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("walkingWestNorth"));
        }

        // Down && Left
        if(!((Player)gameObject).isUpKeyPressed() && ((Player)gameObject).isDownKeyPressed() &&
           ((Player)gameObject).isLeftKeyPressed() && !((Player)gameObject).isRightKeyPressed())
        {
            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("walkingLeft"));
            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("walkingWestSouth"));
        }

        if(!((Player)gameObject).isLeftKeyPressed())
        {
            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("facingLeft"));
            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("standing"));
        }*/

        ((Player) gameObject).position.x -= gameObject.getSpeed() * Gdx.graphics.getDeltaTime();
    }

    @Override
    public void render(GameObject gameObject, SpriteBatch batch)
    {
        //batch.draw(((Player)gameObject).currentAnimation.getCurrentFrame(), (int)gameObject.position.x, (int)gameObject.position.y);
        //batch.draw(((Player)gameObject).currentAnimation.getCurrentFrame(),
        //(int)((Player)gameObject).position.x - ((Player)gameObject).currentAnimation.getCurrentFrame().getRegionWidth() / 2,
        //(int)((Player)gameObject).position.y );
//        batch.draw(((Player)gameObject).currentAnimation.getCurrentFrame(),
//        (int)((Player)gameObject).position.x - ((Player)gameObject).currentAnimation.getCurrentFrame().getRegionWidth() / 2,
//        ((Player)gameObject).position.y - ((Player)gameObject).currentAnimation.getCurrentFrame().getRegionHeight() / 2.0f);
    }
}
