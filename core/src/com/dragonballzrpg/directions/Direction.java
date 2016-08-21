package com.dragonballzrpg.directions;

import com.dragonballzrpg.entities.Entity;

/**
 * Created by Carl on 18/08/2016.
 */
public abstract class Direction
{
    protected int x = 0;
    protected int y = 0;

    public abstract void update(Entity entity);

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }
}
