package com.dragonballzrpg.ui.uielements;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Carl on 21/05/2017.
 */
public abstract class UIElement
{
    protected Vector2 position;
    protected int width, height;
    protected Pixmap pixmap;
    protected Texture texture;

    public abstract void update();
    public abstract void render(SpriteBatch batch);
}
