package com.dragonballzrpg.states.playerstates;

import com.dragonballzrpg.entities.Entity;
import com.dragonballzrpg.entities.animatedentities.players.Player;
import com.dragonballzrpg.states.State;
import com.dragonballzrpg.states.Transition;
import com.dragonballzrpg.states.TransitionCondition;

/**
 * Created by Carl on 24/08/2016.
 */
public class Standing extends State
{
    @Override
    public void initialiseTransitions(Player p)
    {
        transitions.add(new Transition(p.getPlayerStates().get("walkingEast"), new String[]{"walkingRight"},
        new TransitionCondition[]
        {
            new TransitionCondition(p.getRightKeyPressed(), true)
        }));

        transitions.add(new Transition(p.getPlayerStates().get("runningEast"), new String[]{"runningRight"},
        new TransitionCondition[]
        {
            new TransitionCondition(p.getRightKeyPressed(), true),
            new TransitionCondition(p.getReadyToRunRight(), true)
        }));

        transitions.add(new Transition(p.getPlayerStates().get("attackingRight"), new String[]{"punch1Right", "punch2Right", "kickRight"},
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
    public void update(Entity entity)
    {
        for(Transition transition : transitions)
        {
            transition.update((Player)entity);
        }

        /*if(((Player)entity).isMKeyPressed() && ((Player)entity).canAttack) // For testing
        {
            ((Player)entity).canAttack = false;
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get(getRandomValue(new String[]{"punch1Right", "punch2Right", "kickRight"})));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("attackingRight"));
        }
        else if(((Player)entity).isUpKeyPressed() && ((Player)entity).isReadyToRunUp())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("runningUp"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("runningNorth"));
        }
        else if(((Player)entity).isDownKeyPressed() && ((Player)entity).isReadyToRunDown())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("runningDown"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("runningSouth"));
        }
        else if(((Player)entity).isLeftKeyPressed() && ((Player)entity).isReadyToRunLeft())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("runningLeft"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("runningWest"));
        }
        else if(((Player)entity).isRightKeyPressed() && ((Player)entity).isReadyToRunRight())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("runningRight"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("runningEast"));
        }
        else if(((Player)entity).isUpKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("walkingUp"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("walkingNorth"));
        }
        else if(((Player)entity).isDownKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("walkingDown"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("walkingSouth"));
        }
        else if(((Player)entity).isLeftKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("walkingLeft"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("walkingWest"));
        }
        else if(((Player)entity).isRightKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("walkingRight"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("walkingEast"));
        }*/
    }
}
