package com.dragonballzrpg.states.playerstates.walkingstates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragonballzrpg.gameobjects.GameObject;
import com.dragonballzrpg.gameobjects.players.Player;
import com.dragonballzrpg.states.State;
import com.dragonballzrpg.states.Transition;

/**
 * Created by Carl on 24/08/2016.
 */
public class WalkingUpRightState extends State
{
    @Override
    public void initialiseTransitions(Player p)
    {
//        transitions.add(new Transition(p.getPlayerStates().get("walkingNorth"), new String[]{"walkingUp"},
//        new TransitionCondition[]
//        {
//            new TransitionCondition(p.isUpKeyPressed(), true),
//            new TransitionCondition(p.isRightKeyPressed(), false)
//        }));
    }

    @Override
    public void enter(GameObject gameObject)
    {

    }

    @Override
    public void exit(GameObject gameObject)
    {

    }

    @Override
    public void update(GameObject gameObject)
    {
        for(Transition transition : transitions)
        {
            transition.update((Player) gameObject);
        }

        // Up
        /*if(((Player)gameObject).isUpKeyPressed() && !((Player)gameObject).isDownKeyPressed() &&
           !((Player)gameObject).isLeftKeyPressed() && !((Player)gameObject).isRightKeyPressed())
        {
            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("walkingUp"));
            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("walkingNorth"));
        }

        // Right
        if(!((Player)gameObject).isUpKeyPressed() && !((Player)gameObject).isDownKeyPressed() &&
           !((Player)gameObject).isLeftKeyPressed() && ((Player)gameObject).isRightKeyPressed())
        {
            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("walkingRight"));
            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("walkingEast"));
        }

        // Up && Left
        if(((Player)gameObject).isUpKeyPressed() && !((Player)gameObject).isDownKeyPressed() &&
           ((Player)gameObject).isLeftKeyPressed() && !((Player)gameObject).isRightKeyPressed())
        {
            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("walkingUp"));
            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("walkingNorthWest"));
        }

        if(!((Player)gameObject).isUpKeyPressed())
        {
            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("facingUp"));
            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("standing"));
        }*/

        ((Player) gameObject).position.x += gameObject.getSpeed() * Gdx.graphics.getDeltaTime();
        ((Player) gameObject).position.y += gameObject.getSpeed() * Gdx.graphics.getDeltaTime();
    }

    @Override
    public void render(GameObject gameObject, SpriteBatch batch)
    {

    }
}