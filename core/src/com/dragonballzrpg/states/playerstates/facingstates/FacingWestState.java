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

public class FacingWestState extends State
{
    @Override
    public void initialiseTransitions(Player p)
    {
        transitions.add(new Transition(p.getPlayerStates().get("walkingNorth"), new String[]{"walkingUp"},
        new TransitionCondition[]
        {
        new TransitionCondition(p.getUpKeyPressed(), true)
        }));

        transitions.add(new Transition(p.getPlayerStates().get("walkingSouth"), new String[]{"walkingDown"},
        new TransitionCondition[]
        {
        new TransitionCondition(p.getDownKeyPressed(), true)
        }));

        transitions.add(new Transition(p.getPlayerStates().get("walkingWest"), new String[]{"walkingLeft"},
        new TransitionCondition[]
        {
        new TransitionCondition(p.getLeftKeyPressed(), true)
        }));

        transitions.add(new Transition(p.getPlayerStates().get("walkingEast"), new String[]{"walkingRight"},
        new TransitionCondition[]
        {
        new TransitionCondition(p.getRightKeyPressed(), true)
        }));

        transitions.add(new Transition(p.getPlayerStates().get("runningWest"), new String[]{"runningLeft"},
        new TransitionCondition[]
        {
        new TransitionCondition(p.getLeftKeyPressed(), true),
        new TransitionCondition(p.getReadyToRunLeft(), true)
        }));

        transitions.add(new Transition(p.getPlayerStates().get("meleeingWest"), new String[]{"punch1Left", "punch2Left", "kickLeft"},
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
        batch.draw(((Player)entity).currentAnimation.getCurrentFrame(), (int)entity.position.x, (int)entity.position.y);
        //batch.draw(((Player)entity).currentAnimation.getCurrentFrame(), (int)entity.position.x, (int)entity.position.y);
        //batch.draw(((Player)entity).currentAnimation.getCurrentFrame(),
        //((Player)entity).position.x - ((Player)entity).currentAnimation.getCurrentFrame().getRegionWidth() / 2,
        //(int)((Player)entity).position.y);
        //batch.draw(((Player)entity).currentAnimation.getCurrentFrame(),
        //(int)((Player)entity).position.x - ((Player)entity).currentAnimation.getCurrentFrame().getRegionWidth() / 2,
        //((Player)entity).position.y - ((Player)entity).currentAnimation.getCurrentFrame().getRegionHeight() / 2.0f);
    }
}
