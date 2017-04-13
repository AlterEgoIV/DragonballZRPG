package com.dragonballzrpg.states.playerstates.facingstates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragonballzrpg.entities.Entity;
import com.dragonballzrpg.entities.animatedentities.players.Player;
import com.dragonballzrpg.states.State;
import com.dragonballzrpg.states.Transition;
import com.dragonballzrpg.states.TransitionCondition;

/**
 * Created by Carl on 21/09/2016.
 */

public class FacingUpState extends State
{
    @Override
    public void initialiseTransitions(Player p)
    {
//        transitions.add(new Transition(p.getPlayerStates().get("walkingNorth"), new String[]{"walkingUp"},
//        new TransitionCondition[]
//        {
//            new TransitionCondition(p.isUpKeyPressed(), true)
//        }));
//
//        transitions.add(new Transition(p.getPlayerStates().get("walkingSouth"), new String[]{"walkingDown"},
//        new TransitionCondition[]
//        {
//            new TransitionCondition(p.isDownKeyPressed(), true)
//        }));
//
//        transitions.add(new Transition(p.getPlayerStates().get("walkingWest"), new String[]{"walkingLeft"},
//        new TransitionCondition[]
//        {
//            new TransitionCondition(p.isLeftKeyPressed(), true)
//        }));
//
//        transitions.add(new Transition(p.getPlayerStates().get("walkingEast"), new String[]{"walkingRight"},
//        new TransitionCondition[]
//        {
//            new TransitionCondition(p.isRightKeyPressed(), true)
//        }));
//
//        transitions.add(new Transition(p.getPlayerStates().get("runningNorth"), new String[]{"runningUp"},
//        new TransitionCondition[]
//        {
//            new TransitionCondition(p.isUpKeyPressed(), true),
//            new TransitionCondition(p.getReadyToRunUp(), true)
//        }));
//
//        transitions.add(new Transition(p.getPlayerStates().get("meleeingNorth"), new String[]{"punch1Up", "punch2Up", "kickUp"},
//        new TransitionCondition[]
//        {
//            new TransitionCondition(p.getMKeyPressed(), true),
//            new TransitionCondition(p.getCanAttack(), true)
//        }));
    }

    @Override
    public void enter(Entity entity)
    {

    }

    @Override
    public void exit(Entity entity)
    {

    }

    @Override
    public void update(Entity entity)
    {
        for(Transition transition : transitions)
        {
            transition.update((Player)entity);
        }
    }

    @Override
    public void render(Entity entity, SpriteBatch batch)
    {
        //batch.draw(((Player)entity).currentAnimation.getCurrentFrame(), (int)entity.position.x, (int)entity.position.y);
        batch.draw(((Player)entity).currentAnimation.getCurrentFrame(),
        (int)((Player)entity).position.x - ((Player)entity).currentAnimation.getCurrentFrame().getRegionWidth() / 2,
        (int)((Player)entity).position.y - ((Player)entity).currentAnimation.getCurrentFrame().getRegionHeight() / 2);
    }
}
