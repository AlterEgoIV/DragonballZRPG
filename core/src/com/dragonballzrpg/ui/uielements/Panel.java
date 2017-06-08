package com.dragonballzrpg.ui.uielements;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Carl on 26/05/2017.
 */
public class Panel extends UIElement
{
    private Texture primary, secondary;
    private Color colour, primaryColour, secondaryColour, primaryOutlineColour, secondaryOutlineColour;
    private float primaryAlpha, secondaryAlpha, primaryOutlineAlpha, secondaryOutlineAlpha;
    private float r, g, b, a;
    private Text text;

    public Panel(float x, float y, int width, int height, Color colour, float alpha)
    {
        super(x, y, width, height);

        this.colour = colour;
        this.colour.a = alpha;
        pixmap.setColor(colour);
        pixmap.fillRectangle(0, 0, width, height);
        texture = new Texture(pixmap);
        pixmap.dispose();

        text = new Text("", position.x, position.y, 1, 1);
    }

    public Panel(float x, float y, int width, int height, Color colour, float alpha, Text text)
    {
        super(x, y, width, height);

        this.text = text;
        this.colour = colour;
        this.colour.a = alpha;
        pixmap.setColor(colour);
        pixmap.fillRectangle(0, 0, width, height);
        texture = new Texture(pixmap);
        pixmap.dispose();
    }

    public Panel(float x, float y, int width, int height,
                 Color primaryColour, Color secondaryColour, Color primaryOutlineColour, Color secondaryOutlineColour,
                 float primaryAlpha, float secondaryAlpha, float primaryOutlineAlpha, float secondaryOutlineAlpha)
    {
        super(x, y, width, height);

        this.primaryColour = primaryColour;
        this.secondaryColour = secondaryColour;
        this.primaryOutlineColour = primaryOutlineColour;
        this.secondaryOutlineColour = secondaryOutlineColour;
        this.primaryAlpha = primaryAlpha;
        this.secondaryAlpha = secondaryAlpha;
        this.primaryOutlineAlpha = primaryOutlineAlpha;
        this.secondaryOutlineAlpha = secondaryOutlineAlpha;
        text = new Text("", position.x, position.y, 1, 1);
    }

    public Panel(float x, float y, int width, int height,
                 Color primaryColour, Color secondaryColour, Color primaryOutlineColour, Color secondaryOutlineColour,
                 float primaryAlpha, float secondaryAlpha, float primaryOutlineAlpha, float secondaryOutlineAlpha,
                 Text text)
    {
        super(x, y, width, height);

        this.primaryColour = primaryColour;
        this.secondaryColour = secondaryColour;
        this.primaryOutlineColour = primaryOutlineColour;
        this.secondaryOutlineColour = secondaryOutlineColour;
        this.primaryAlpha = primaryAlpha;
        this.secondaryAlpha = secondaryAlpha;
        this.primaryOutlineAlpha = primaryOutlineAlpha;
        this.secondaryOutlineAlpha = secondaryOutlineAlpha;
        this.text = text;
    }

    public Panel(float x, float y, int width, int height, float r, float g, float b, float a, Color outline)
    {
        super(x, y, width, height);

        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
        //this.outline = outline;

        pixmap.setColor(r, g, b, a);
        pixmap.fillRectangle(0, 0, width, height);
        pixmap.setColor(outline);
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
        batch.draw(texture, position.x - width / 2, position.y - height / 2);
        text.render(batch);
    }
}
