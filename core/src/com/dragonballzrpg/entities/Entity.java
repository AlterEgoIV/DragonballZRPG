package com.dragonballzrpg.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Carl on 09/08/2016.
 */
public abstract class Entity
{
    protected Vector2 position;
    protected double speed;
    protected double width;
    protected double height;

    public Entity()
    {
        position = new Vector2(0, 0);
        speed = 0.0d;
        width = 0.0d;
        height = 0.0d;
    }

    public abstract void update();
    public abstract void render(SpriteBatch batch);
}
