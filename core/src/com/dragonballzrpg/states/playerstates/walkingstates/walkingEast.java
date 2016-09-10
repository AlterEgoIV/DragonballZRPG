package com.dragonballzrpg.states.playerstates.walkingstates;

import com.badlogic.gdx.Gdx;
import com.dragonballzrpg.entities.Entity;
import com.dragonballzrpg.entities.animatedentities.players.Player;
import com.dragonballzrpg.states.State;
import com.dragonballzrpg.states.Transition;

import java.util.Map;

/**
 * Created by Carl on 24/08/2016.
 */
public class WalkingEast extends State
{
    @Override
    public void initialiseTransitions(Map<String, State> playerStates)
    {
        /*transitions.add(new Transition(playerStates.get("walkingEastNorth"), "walkingRight", true, false, false, true, false, false));
        transitions.add(new Transition(playerStates.get("walkingEastSouth"), "walkingRight", false, true, false, true, false, false));
        transitions.add(new Transition(playerStates.get("walkingWest"), "walkingLeft", false, false, true, false, false, false));
        transitions.add(new Transition(playerStates.get("standing"), "facingRight", false, false, false, false, false, false));
        transitions.add(new Transition(playerStates.get("attackingRight"), getRandomValue(new String[]{"punch1Right", "punch2Right", "kickRight"}),
        false, false, false, true, true, true));*/

        transitions.add(new Transition(playerStates.get("walkingEastNorth"), "walkingRight", true, false, false, true));
        transitions.add(new Transition(playerStates.get("walkingEastSouth"), "walkingRight", false, true, false, true));
        transitions.add(new Transition(playerStates.get("walkingWest"), "walkingLeft", false, false, true, false));
        transitions.add(new Transition(playerStates.get("standing"), "facingRight", false, false, false, false));
        //transitions.add(new Transition(playerStates.get("attackingRight"), getRandomValue(new String[]{"punch1Right", "punch2Right", "kickRight"}),
           //false, false, false, true, true));
    }

    @Override
    public void update(Entity entity)
    {
        //transitions.remove(transitions.size() - 1);
        //transitions.get(transitions.size() - 1).setAnimation(getRandomValue(new String[]{"punch1Right", "punch2Right", "kickRight"}));

        //Player p = (Player)entity;

        /*transitions.clear();
        transitions.add(new Transition(p.playerStates.get("walkingEastNorth"), "walkingRight", true, false, false, true, false));
        transitions.add(new Transition(p.playerStates.get("walkingEastSouth"), "walkingRight", false, true, false, true, false));
        transitions.add(new Transition(p.playerStates.get("walkingWest"), "walkingLeft", false, false, true, false, false));
        transitions.add(new Transition(p.playerStates.get("standing"), "facingRight", false, false, false, false, false));
        transitions.add(new Transition(p.playerStates.get("attackingRight"), getRandomValue(new String[]{"punch1Right", "punch2Right", "kickRight"}),
        false, false, false, true, true));*/

        if(((Player)entity).isRightKeyPressed() && ((Player)entity).isMKeyPressed() && ((Player)entity).canAttack)
        {
            ((Player)entity).canAttack = false;
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get(getRandomValue(new String[]{"punch1Right", "punch2Right", "kickRight"})));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("attackingRight"));
        }

        /*for(Transition transition : transitions)
        {
            if(transition.getState() == ((Player)entity).getPlayerStates().get("attackingRight"))
            {
                transition.setAnimation(getRandomValue(new String[]{"punch1Right", "punch2Right", "kickRight"}));
            }

            transition.update((Player)entity);
        }*/

        for(Transition transition : transitions)
        {
            transition.update((Player)entity);
        }

        ((Player)entity).position.x += entity.getSpeed() * Gdx.graphics.getDeltaTime();
    }
}
