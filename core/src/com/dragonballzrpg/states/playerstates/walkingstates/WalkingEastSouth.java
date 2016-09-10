package com.dragonballzrpg.states.playerstates.walkingstates;

import com.badlogic.gdx.Gdx;
import com.dragonballzrpg.entities.Entity;
import com.dragonballzrpg.entities.animatedentities.players.Player;
import com.dragonballzrpg.states.State;
import com.dragonballzrpg.states.Transition;

import java.util.Map;

/**
 * Created by Carl on 30/08/2016.
 */
public class WalkingEastSouth extends State
{
    @Override
    public void initialiseTransitions(Map<String, State> playerStates)
    {
        //transitions.add(new Transition(playerStates.get("walkingSouth"), "walkingDown", false, true, false, false, false, false));
        //transitions.add(new Transition(playerStates.get("walkingEast"), "walkingRight", false, false, false, true, false, false));
        //transitions.add(new Transition(playerStates.get("walkingEastNorth"), "walkingRight", true, false, false, true, false, false));
        //transitions.add(new Transition(playerStates.get("standing"), "facingRight", false, false, false, false, false, false));
        //transitions.add(new Transition(playerStates.get("walkingSouth"), "walkingDown", true, true, false, false, false, false));

        transitions.add(new Transition(playerStates.get("walkingSouth"), "walkingDown", false, true, false, false));
        transitions.add(new Transition(playerStates.get("walkingEast"), "walkingRight", false, false, false, true));
        transitions.add(new Transition(playerStates.get("walkingEastNorth"), "walkingRight", true, false, false, true));
        transitions.add(new Transition(playerStates.get("standing"), "facingRight", false, false, false, false));
        transitions.add(new Transition(playerStates.get("walkingSouth"), "walkingDown", true, true, false, false));
    }

    @Override
    public void update(Entity entity)
    {
        for(Transition transition : transitions)
        {
            transition.update((Player)entity);
        }

        ((Player)entity).position.x += entity.getSpeed() * Gdx.graphics.getDeltaTime();
        ((Player)entity).position.y -= entity.getSpeed() * Gdx.graphics.getDeltaTime();
    }
}
