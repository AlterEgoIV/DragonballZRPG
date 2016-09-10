package com.dragonballzrpg.states.playerstates.runningstates;

import com.badlogic.gdx.Gdx;
import com.dragonballzrpg.entities.Entity;
import com.dragonballzrpg.entities.animatedentities.players.Player;
import com.dragonballzrpg.states.State;

import java.util.Map;

/**
 * Created by Carl on 24/08/2016.
 */
public class RunningSouth extends State
{
    @Override
    public void initialiseTransitions(Map<String, State> playerStates)
    {

    }

    @Override
    public void update(Entity entity)
    {
        // Down && Left
        if(!((Player)entity).isUpKeyPressed() && ((Player)entity).isDownKeyPressed() &&
           ((Player)entity).isLeftKeyPressed() && !((Player)entity).isRightKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("runningDown"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("runningSouthWest"));
        }

        // Down && Right
        if(!((Player)entity).isUpKeyPressed() && ((Player)entity).isDownKeyPressed() &&
           !((Player)entity).isLeftKeyPressed() && ((Player)entity).isRightKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("runningDown"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("runningSouthEast"));
        }

        if(!((Player)entity).isDownKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("facingDown"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("standing"));
        }

        ((Player)entity).position.y -= ((Player)entity).getRunSpeed() * Gdx.graphics.getDeltaTime();
    }
}
