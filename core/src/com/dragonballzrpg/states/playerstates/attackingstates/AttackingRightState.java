package com.dragonballzrpg.states.playerstates.attackingstates;

import com.badlogic.gdx.Gdx;
import com.dragonballzrpg.entities.Entity;
import com.dragonballzrpg.entities.animatedentities.players.Player;
import com.dragonballzrpg.states.State;
import com.dragonballzrpg.states.Transition;

import java.util.Map;

/**
 * Created by Carl on 06/09/2016.
 */
public class AttackingRightState extends State
{
    @Override
    public void initialiseTransitions(Map<String, State> playerStates)
    {
        //transitions.add(new Transition(playerStates.get("standing"), "facingRight", false, false, false, false, false, false));
        //transitions.add(new Transition(playerStates.get("standing"), "facingRight", false, false, false, false, true, false));
        //transitions.add(new Transition(playerStates.get("walkingEast"), "walkingRight", false, false, false, true, false, true));
        //transitions.add(new Transition(playerStates.get("walkingEast"), "walkingRight", false, false, false, true, true, true));

        transitions.add(new Transition(playerStates.get("standing"), "facingRight", false, false, false, false));
        //transitions.add(new Transition(playerStates.get("walkingEast"), "walkingRight", false, false, false, true, false));
        //transitions.add(new Transition(playerStates.get("walkingEast"), "walkingRight", false, false, false, true, true));
    }

    @Override
    public void update(Entity entity)
    {
        currentStateDuration += Gdx.graphics.getDeltaTime();

        if(currentStateDuration >= ((Player)entity).currentAnimation.getDuration())
        {
            currentStateDuration = 0.0d;
            ((Player)entity).currentAnimation.reset();

            if(((Player)entity).isRightKeyPressed())
            {
                ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("walkingRight"));
                ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("walkingEast"));
            }

            for(Transition transition : transitions)
            {
                transition.update((Player)entity);
            }
        }
    }
}
