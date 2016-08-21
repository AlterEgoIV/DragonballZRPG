package com.dragonballzrpg.entities;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Carl on 09/08/2016.
 */
public abstract class Entity
{
    protected Vector2 position;
    protected double speed;
    protected float width;
    protected float height;
    protected AssetManager assetManager;

    public Entity()
    {
        position = new Vector2(0, 0);
        speed = 0.0d;
        width = 0.0f;
        height = 0.0f;
    }

    public abstract void update();
    public abstract void render(SpriteBatch batch);
}
