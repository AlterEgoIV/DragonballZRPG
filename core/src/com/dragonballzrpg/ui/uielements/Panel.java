package com.dragonballzrpg.ui.uielements;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Carl on 26/05/2017.
 */
public class Panel extends UIElement
{
    private float r, g, b, a;
    private Color outlineColour;

    public Panel(Vector2 position, int width, int height, float r, float g, float b, float a, Color outlineColour)
    {
        super(position, width, height);

        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
        this.outlineColour = outlineColour;

        pixmap.setColor(r, g, b, a);
        pixmap.fillRectangle(0, 0, width, height);
        pixmap.setColor(outlineColour);
        pixmap.drawRectangle(0, 0, width, height);
        texture = new Texture(pixmap);
        pixmap.dispose();
    }

    @Override
    public void update()
    {

    }

    @Override
    public void render(SpriteBatch batch)
    {
        batch.draw(texture, position.x, position.y);
    }

    public void setRGBA(float r, float g, float b, float a)
    {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(r, g, b, a);
        pixmap.fillRectangle(0, 0, width, height);
        pixmap.setColor(outlineColour);
        pixmap.drawRectangle(0, 0, width, height);
        texture = new Texture(pixmap);
        pixmap.dispose();
    }
}
