package com.dragonballzrpg.states.playerstates.attackingstates;

import com.dragonballzrpg.entities.Entity;
import com.dragonballzrpg.entities.animatedentities.players.Player;
import com.dragonballzrpg.states.State;

/**
 * Created by Carl on 06/09/2016.
 */
public class AttackingDownState extends State
{
    @Override
    public void initialiseTransitions(Player p)
    {

    }

    @Override
    public void enter(Entity entity)
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
            p.setCurrentAnimation(p.getAnimations().get("facingDown"));
        }*/
    }
}
