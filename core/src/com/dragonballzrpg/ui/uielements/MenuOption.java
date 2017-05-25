package com.dragonballzrpg.ui.uielements;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dragonballzrpg.input.InputHandler;

/**
 * Created by Carl on 25/05/2017.
 */
public class MenuOption extends UIElement implements InputHandler
{
    public boolean isSelected;
    private Text text;

    public MenuOption(Vector2 position, Text text, boolean isSelected)
    {
        this.position = position;
        this.text = text;
        this.isSelected = isSelected;
    }

    @Override
    public void update()
    {

    }

    @Override
    public void render(SpriteBatch batch)
    {

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
