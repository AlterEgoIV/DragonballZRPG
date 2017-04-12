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
public class WalkingDownState extends State
{
    @Override
    public void initialiseTransitions(Player p)
    {
        transitions.add(new Transition(p.getPlayerStates().get("facingSouth"), new String[]{"facingDown"},
        new TransitionCondition[]
        {
            new TransitionCondition(p.getDownKeyPressed(), false)
        }));

        transitions.add(new Transition(p.getPlayerStates().get("walkingNorth"), new String[]{"walkingUp"},
        new TransitionCondition[]
        {
        new TransitionCondition(p.getUpKeyPressed(), true),
        new TransitionCondition(p.getDownKeyPressed(), false)
        }));

        transitions.add(new Transition(p.getPlayerStates().get("walkingSouthEast"), new String[]{"walkingDown"},
        new TransitionCondition[]
        {
        new TransitionCondition(p.getDownKeyPressed(), true),
        new TransitionCondition(p.getRightKeyPressed(), true)
        }));

        transitions.add(new Transition(p.getPlayerStates().get("walkingSouthWest"), new String[]{"walkingDown"},
        new TransitionCondition[]
        {
        new TransitionCondition(p.getDownKeyPressed(), true),
        new TransitionCondition(p.getLeftKeyPressed(), true)
        }));

        transitions.add(new Transition(p.getPlayerStates().get("meleeingSouth"), new String[]{"punch1Down", "punch2Down", "kickDown"},
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

        // Down && Left
        /*if(!((Player)entity).isUpKeyPressed() && ((Player)entity).isDownKeyPressed() &&
           ((Player)entity).isLeftKeyPressed() && !((Player)entity).isRightKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getStringAnimations().getAnimation("walkingDown"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().getAnimation("walkingSouthWest"));
        }

        // Down && Right
        if(!((Player)entity).isUpKeyPressed() && ((Player)entity).isDownKeyPressed() &&
           !((Player)entity).isLeftKeyPressed() && ((Player)entity).isRightKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getStringAnimations().getAnimation("walkingDown"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().getAnimation("walkingSouthEast"));
        }

        if(!((Player)entity).isDownKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getStringAnimations().getAnimation("facingDown"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().getAnimation("standing"));
        }*/

        ((Player)entity).position.y -= entity.getSpeed() * Gdx.graphics.getDeltaTime();
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
