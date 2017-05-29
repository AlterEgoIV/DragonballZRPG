package com.dragonballzrpg.ui.uielements;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dragonballzrpg.input.InputHandler;

/**
 * Created by Carl on 25/05/2017.
 */
public class MenuOption extends UIElement implements InputHandler
{
    private Panel panel;
    private Text text;

    public MenuOption(Vector2 position, int width, int height, Panel panel, Text text)
    {
        super(position, width, height);

        this.panel = panel;
        this.text = text;
    }

    @Override
    public void update()
    {

    }

    @Override
    public void render(SpriteBatch batch)
    {
        panel.render(batch);
        text.render(batch);
    }

    public void setPanelRGBA(float r, float g, float b, float a)
    {
        panel.setRGBA(r, g, b, a);
    }

    @Override
    public void handleKeyDown(int keyCode)
    {

    }

    @Override
    public void handleKeyUp(int keyCode)
    {

    }
}
