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
    public Vector2 position;
    protected int width, height;
    protected Pixmap pixmap;
    protected Texture texture;

    public UIElement(float x, float y)
    {
        this.position = new Vector2(x, y);
        this.width = 0;
        this.height = 0;

        pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
    }

    public UIElement(Vector2 position)
    {
        this.position = position;
        this.width = 0;
        this.height = 0;

        pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
    }

    public UIElement(Vector2 position, int width, int height)
    {
        this.position = position;
        this.width = width;
        this.height = height;

        pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
    }

    public abstract void update();
    public abstract void render(SpriteBatch batch);
}
