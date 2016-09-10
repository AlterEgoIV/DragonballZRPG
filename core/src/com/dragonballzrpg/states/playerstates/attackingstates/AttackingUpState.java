package com.dragonballzrpg.states.playerstates.attackingstates;

import com.dragonballzrpg.entities.Entity;
import com.dragonballzrpg.states.State;

import java.util.Map;

/**
 * Created by Carl on 06/09/2016.
 */
public class AttackingUpState extends State
{
    @Override
    public void initialiseTransitions(Map<String, State> playerStates)
    {

    }

    @Override
    public void update(Entity entity)
    {
        /*Player p = (Player)entity;

        if(!p.isMKeyPressed())
        {
            //p.setCurrentAttackState(p.getPlayerStates().get("notAttacking"));
            //p.setCurrentMovementState(p.getPlayerStates().get("standing"));
            p.setCurrentAnimation(p.getAnimations().get("facingUp"));
        }*/
    }
}
