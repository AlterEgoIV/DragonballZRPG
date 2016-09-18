package com.dragonballzrpg.states.playerstates.walkingstates;

import com.badlogic.gdx.Gdx;
import com.dragonballzrpg.entities.Entity;
import com.dragonballzrpg.entities.animatedentities.players.Player;
import com.dragonballzrpg.states.State;
import com.dragonballzrpg.states.Transition;
import com.dragonballzrpg.states.TransitionCondition;

/**
 * Created by Carl on 24/08/2016.
 */
public class WalkingEast extends State
{
    @Override
    public void initialiseTransitions(Player p)
    {
        transitions.add(new Transition(p.getPlayerStates().get("standing"), new String[]{"facingRight"},
        new TransitionCondition[]
        {
            new TransitionCondition(p.getRightKeyPressed(), false)
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

        ((Player)entity).position.x += entity.getSpeed() * Gdx.graphics.getDeltaTime();
    }
}
