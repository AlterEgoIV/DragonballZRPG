package com.dragonballzrpg.ui.uielements;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dragonballzrpg.enums.TextAlignment;

/**
 * Created by Carl on 25/05/2017.
 */
public class Text extends UIElement
{
    private String text;
    private BitmapFont font;
    private GlyphLayout layout;

    public Text(String text, float x, float y, float scaleX, float scaleY)
    {
        super(x, y);

        this.text = text;
        this.font = new BitmapFont();
        this.font.getData().setScale(scaleX, scaleY); // x: .35f, y: .3f
        layout = new GlyphLayout(this.font, text);
    }

    public Text(String text, BitmapFont font, float x, float y, TextAlignment textAlignment)
    {
        super(x, y);

        this.text = text;
        this.font = font;
        layout = new GlyphLayout(font, text);

        switch(textAlignment)
        {
            case CENTER:
            {
                position.x -= layout.width / 2;
                position.y += layout.height / 2;

                break;
            }

            case RIGHT:
            {
                position.x += layout.width;
                break;
            }

            default:
            {
                break;
            }
        }
    }

    @Override
    public void update()
    {

    }

    @Override
    public void render(SpriteBatch batch)
    {
        font.draw(batch, layout, position.x, position.y);
    }

    public float getWidth()
    {
        return layout.width;
    }

    public float getHeight()
    {
        return layout.height;
    }

    public void setText(String text)
    {
        this.text = text;
        layout.setText(font, text);
    }

    public void setScale(float scaleX, float scaleY)
    {
        font.getData().setScale(scaleX, scaleY);
        layout.setText(font, text);
    }

    public void setColour(Color colour)
    {
        font.setColor(colour);
        layout.setText(font, text);
    }

    public void setColour(float r, float g, float b, float a)
    {
        font.setColor(r, g, b, a);
        layout.setText(font, text);
    }
}
