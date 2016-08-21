package com.dragonballzrpg.directions;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.dragonballzrpg.entities.Entity;
import com.dragonballzrpg.entities.animatedentities.players.Player;

/**
 * Created by Carl on 18/08/2016.
 */
public class South extends Direction
{
    public South()
    {
        x = 0;
        y = -1;
    }

    @Override
    public void update(Entity entity)
    {
        if(!Gdx.input.isKeyPressed(Input.Keys.UP) &&
           Gdx.input.isKeyPressed(Input.Keys.DOWN) &&
           Gdx.input.isKeyPressed(Input.Keys.LEFT) &&
           !Gdx.input.isKeyPressed(Input.Keys.RIGHT))
        {
            ((Player)entity).setCurrentDirection(((Player)entity).getDirections().get("southwest"));
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("walkingDown"));
        }

        if(!Gdx.input.isKeyPressed(Input.Keys.UP) &&
           Gdx.input.isKeyPressed(Input.Keys.DOWN) &&
           !Gdx.input.isKeyPressed(Input.Keys.LEFT) &&
           Gdx.input.isKeyPressed(Input.Keys.RIGHT))
        {
            ((Player)entity).setCurrentDirection(((Player)entity).getDirections().get("southeast"));
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("walkingDown"));
        }

        if(!Gdx.input.isKeyPressed(Input.Keys.DOWN))
        {
            ((Player)entity).setCurrentDirection(((Player)entity).getDirections().get("nodirection"));
            ((Player)entity).setCurrentAnimation(((Player)entity).getAnimations().get("facingDown"));
        }
    }
}
