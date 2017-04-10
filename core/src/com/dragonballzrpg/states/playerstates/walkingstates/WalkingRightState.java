package com.dragonballzrpg.states.playerstates.walkingstates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragonballzrpg.entities.Entity;
import com.dragonballzrpg.entities.animatedentities.players.Player;
import com.dragonballzrpg.states.State;
import com.dragonballzrpg.states.Transition;
import com.dragonballzrpg.states.TransitionCondition;

/**
 * Created by Carl on 24/08/2016.
 */
public class WalkingRightState extends State
{
    @Override
    public void initialiseTransitions(Player p)
    {
        transitions.add(new Transition(p.getPlayerStates().get("facingEast"), new String[]{"facingRight"},
        new TransitionCondition[]
        {
            new TransitionCondition(p.getRightKeyPressed(), false)
        }));

        transitions.add(new Transition(p.getPlayerStates().get("walkingWest"), new String[]{"walkingLeft"},
        new TransitionCondition[]
        {
        new TransitionCondition(p.getLeftKeyPressed(), true),
        new TransitionCondition(p.getRightKeyPressed(), false)
        }));

        transitions.add(new Transition(p.getPlayerStates().get("walkingEastNorth"), new String[]{"walkingRight"},
        new TransitionCondition[]
        {
        new TransitionCondition(p.getUpKeyPressed(), true),
        new TransitionCondition(p.getRightKeyPressed(), true)
        }));

        transitions.add(new Transition(p.getPlayerStates().get("walkingEastSouth"), new String[]{"walkingRight"},
        new TransitionCondition[]
        {
        new TransitionCondition(p.getDownKeyPressed(), true),
        new TransitionCondition(p.getRightKeyPressed(), true)
        }));

        transitions.add(new Transition(p.getPlayerStates().get("meleeingEast"), new String[]{"punch1Right", "punch2Right", "kickRight"},
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

        ((Player)entity).position.x += entity.getSpeed() * Gdx.graphics.getDeltaTime();
    }

    @Override
    public void render(Entity entity, SpriteBatch batch)
    {
        //batch.draw(((Player)entity).currentAnimation.getCurrentFrame(), (int)entity.position.x, (int)entity.position.y);
        batch.draw(((Player)entity).currentAnimation.getCurrentFrame(),
        (int)((Player)entity).position.x - ((Player)entity).currentAnimation.getCurrentFrame().getRegionWidth() / 2,
        ((Player)entity).position.y - ((Player)entity).currentAnimation.getCurrentFrame().getRegionHeight() / 2.0f);
    }
}
