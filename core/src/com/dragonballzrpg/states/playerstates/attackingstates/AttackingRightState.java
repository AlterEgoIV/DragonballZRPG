package com.dragonballzrpg.states.playerstates.attackingstates;

import com.badlogic.gdx.Gdx;
import com.dragonballzrpg.entities.Entity;
import com.dragonballzrpg.entities.animatedentities.players.Player;
import com.dragonballzrpg.states.State;
import com.dragonballzrpg.states.Transition;
import com.dragonballzrpg.states.TransitionCondition;

/**
 * Created by Carl on 06/09/2016.
 */
public class AttackingRightState extends State
{
    @Override
    public void initialiseTransitions(Player p)
    {
        transitions.add(new Transition(p.getPlayerStates().get("standing"), new String[]{"facingRight"},
        new TransitionCondition[]
        {
            new TransitionCondition(p.getRightKeyPressed(), false)
        }));

        transitions.add(new Transition(p.getPlayerStates().get("walkingEast"), new String[]{"walkingRight"},
        new TransitionCondition[]
        {
            new TransitionCondition(p.getRightKeyPressed(), true)
        }));
    }

    @Override
    public void enter(Entity entity)
    {
        ((Player)entity).getCanAttack().setValue(false);
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
    }
}
