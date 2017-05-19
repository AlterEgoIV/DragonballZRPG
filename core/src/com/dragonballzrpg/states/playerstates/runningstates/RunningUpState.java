package com.dragonballzrpg.states.playerstates.runningstates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragonballzrpg.gameobjects.GameObject;
import com.dragonballzrpg.gameobjects.players.Player;
import com.dragonballzrpg.states.State;
import com.dragonballzrpg.states.Transition;

/**
 * Created by Carl on 24/08/2016.
 */
public class RunningUpState extends State
{
    @Override
    public void initialiseTransitions(Player p)
    {

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

        // Up && Left
        /*if(((Player)gameObject).isUpKeyPressed() && !((Player)gameObject).isDownKeyPressed() &&
           ((Player)gameObject).isLeftKeyPressed() && !((Player)gameObject).isRightKeyPressed())
        {
            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("runningUp"));
            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("runningNorthWest"));
        }

        // Up && Right
        if(((Player)gameObject).isUpKeyPressed() && !((Player)gameObject).isDownKeyPressed() &&
           !((Player)gameObject).isLeftKeyPressed() && ((Player)gameObject).isRightKeyPressed())
        {
            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("runningUp"));
            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("runningNorthEast"));
        }

        if(!((Player)gameObject).isUpKeyPressed())
        {
            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("facingUp"));
            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("standing"));
        }*/

        ((Player) gameObject).position.y += ((Player) gameObject).getRunSpeed() * Gdx.graphics.getDeltaTime();
    }

    @Override
    public void render(GameObject gameObject, SpriteBatch batch)
    {

    }
}