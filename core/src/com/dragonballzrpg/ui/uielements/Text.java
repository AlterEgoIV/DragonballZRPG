package com.dragonballzrpg.ui.uielements;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Carl on 25/05/2017.
 */
public class Text extends UIElement
{
    private BitmapFont font;
    private GlyphLayout layout;

    public Text(float x, float y, String text, float scaleX, float scaleY)
    {
        super(x, y);

        font = new BitmapFont();
        font.getData().setScale(scaleX, scaleY); // x: .35f, y: .3f
        layout = new GlyphLayout(font, text);
    }

    public Text(Vector2 position, String text, float scaleX, float scaleY)
    {
        super(position);

        font = new BitmapFont();
        font.getData().setScale(scaleX, scaleY); // x: .35f, y: .3f
        layout = new GlyphLayout(font, text);
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
}
