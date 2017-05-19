package com.dragonballzrpg.states.playerstates;

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
public class StandingState extends State
{
    @Override
    public void initialiseTransitions(Player player)
    {
        transitions.add(new Transition(player.states.get(StateName.WALKING_LEFT), new AnimationName[]{AnimationName.WALK_LEFT},
        new TransitionCondition[]
        {
            new TransitionCondition(player.isLeftKeyPressed, true)
        }));

        transitions.add(new Transition(player.states.get(StateName.WALKING_RIGHT), new AnimationName[]{AnimationName.WALK_RIGHT},
        new TransitionCondition[]
        {
            new TransitionCondition(player.isRightKeyPressed, true)
        }));

        transitions.add(new Transition(player.states.get(StateName.RUNNING_RIGHT), new AnimationName[]{AnimationName.RUN_RIGHT},
        new TransitionCondition[]
        {
            new TransitionCondition(player.isRightKeyPressed, true),
            new TransitionCondition(player.isReadyToRunRight, true)
        }));

//        transitions.add(new Transition(player.states.get(StateName.MELEEING_DOWN),
//                        new AnimationName[]{AnimationName.PUNCH_DOWN_1, AnimationName.PUNCH_DOWN_2, AnimationName.KICK_DOWN},
//        new TransitionCondition[]
//        {
//            new TransitionCondition(player.isMeleeKeyPressed, true),
//            new TransitionCondition(player.canAttack, true)
//        }));

        transitions.add(new Transition(player.states.get(StateName.MELEEING_RIGHT),
                        new AnimationName[]{AnimationName.PUNCH_RIGHT_1, AnimationName.PUNCH_RIGHT_2, AnimationName.KICK_RIGHT},
        new TransitionCondition[]
        {
            new TransitionCondition(player.isMeleeKeyPressed, true),
            new TransitionCondition(player.canAttack, true)
        }));
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

//        if(((Player)gameObject).isRightKeyPressed().value())
//        {
//            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getAnimations().get(AnimationName.WALK_RIGHT));
//            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().get(StateName.WALKING_RIGHT));
//        }

        /*if(((Player)gameObject).isMeleeKeyPressed() && ((Player)gameObject).canAttack) // For testing
        {
            ((Player)gameObject).canAttack = false;
            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation(getRandomValue(new String[]{"punch1Right", "punch2Right", "kickRight"})));
            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("attackingRight"));
        }
        else if(((Player)gameObject).isUpKeyPressed() && ((Player)gameObject).isReadyToRunUp())
        {
            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("runningUp"));
            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("runningNorth"));
        }
        else if(((Player)gameObject).isDownKeyPressed() && ((Player)gameObject).isReadyToRunDown())
        {
            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("runningDown"));
            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("runningSouth"));
        }
        else if(((Player)gameObject).isLeftKeyPressed() && ((Player)gameObject).isReadyToRunLeft())
        {
            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("runningLeft"));
            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("runningWest"));
        }
        else if(((Player)gameObject).isRightKeyPressed() && ((Player)gameObject).isReadyToRunRight())
        {
            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("runningRight"));
            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("runningEast"));
        }
        else if(((Player)gameObject).isUpKeyPressed())
        {
            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("walkingUp"));
            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("walkingNorth"));
        }
        else if(((Player)gameObject).isDownKeyPressed())
        {
            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("walkingDown"));
            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("walkingSouth"));
        }
        else if(((Player)gameObject).isLeftKeyPressed())
        {
            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("walkingLeft"));
            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("walkingWest"));
        }
        else if(((Player)gameObject).isRightKeyPressed())
        {
            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("walkingRight"));
            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("walkingEast"));
        }*/
    }

    @Override
    public void render(GameObject gameObject, SpriteBatch batch)
    {

    }
}
