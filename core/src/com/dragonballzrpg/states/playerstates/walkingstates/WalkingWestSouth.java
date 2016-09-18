package com.dragonballzrpg.states.playerstates.walkingstates;

import com.badlogic.gdx.Gdx;
import com.dragonballzrpg.entities.Entity;
import com.dragonballzrpg.entities.animatedentities.players.Player;
import com.dragonballzrpg.states.State;

/**
 * Created by Carl on 30/08/2016.
 */
public class WalkingWestSouth extends State
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
        // Down
        /*if(!((Player)entity).isUpKeyPressed() && ((Player)entity).isDownKeyPressed() &&
           !((Player)entity).isLeftKeyPressed() && !((Player)entity).isRightKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("walkingDown"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("walkingSouth"));
        }

        // Left
        if(!((Player)entity).isUpKeyPressed() && !((Player)entity).isDownKeyPressed() &&
           ((Player)entity).isLeftKeyPressed() && !((Player)entity).isRightKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("walkingLeft"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("walkingWest"));
        }

        // Up && Left
        if(((Player)entity).isUpKeyPressed() && !((Player)entity).isDownKeyPressed() &&
           ((Player)entity).isLeftKeyPressed() && !((Player)entity).isRightKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("walkingLeft"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("walkingWestNorth"));
        }

        if(!((Player)entity).isLeftKeyPressed())
        {
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("facingLeft"));
            ((Player)entity).setCurrentState(((Player)entity).getPlayerStates().get("standing"));
        }*/

        ((Player)entity).position.x -= entity.getSpeed() * Gdx.graphics.getDeltaTime();
        ((Player)entity).position.y -= entity.getSpeed() * Gdx.graphics.getDeltaTime();
    }
}
