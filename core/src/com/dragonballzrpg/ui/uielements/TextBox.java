package com.dragonballzrpg.ui.uielements;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carl on 21/05/2017.
 */
public class TextBox extends UIElement
{
    private BitmapFont bitmapFont;
    private GlyphLayout glyphLayout;
    private List<String> strings;
    private String currentString;

    public TextBox(Vector2 position, int width, int height)
    {
        super(position, width, height);
    }

//    public TextBox()
//    {
//        bitmapFont = new BitmapFont();
//        glyphLayout = new GlyphLayout();
//        strings = new ArrayList<String>();
//    }

    @Override
    public void update()
    {

    }

    @Override
    public void render(SpriteBatch batch)
    {

    }

    public void addString(String string)
    {
        strings.add(string);
    }
}
