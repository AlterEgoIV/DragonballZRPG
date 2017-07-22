package com.dragonballzrpg.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dragonballzrpg.enums.MenuOption;
import com.dragonballzrpg.ui.uielements.Cursor;
import com.dragonballzrpg.ui.uielements.UIElement;
import com.dragonballzrpg.utilities.ResourceManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carl on 25/05/2017.
 */
public abstract class UI
{
    protected ResourceManager assetManager;
    protected Viewport viewport;
    protected List<UIElement> uiElements;
    protected Cursor cursor;

    public UI(ResourceManager assetManager)
    {
        this.assetManager = assetManager;

        uiElements = new ArrayList<UIElement>();
        cursor = new Cursor();
    }

    public UI(ResourceManager assetManager, Viewport viewport)
    {
        this.assetManager = assetManager;
        this.viewport = viewport;

        uiElements = new ArrayList<UIElement>();
        cursor = new Cursor();
    }

    public void update()
    {
        for(UIElement uiElement : uiElements)
        {
            uiElement.update();
        }
    }

    public void render(SpriteBatch batch)
    {
        for(UIElement uiElement : uiElements)
        {
            uiElement.render(batch);
        }
    }

    public void nextOption()
    {
        cursor.next();
    }

    public void previousOption()
    {
        cursor.previous();
    }

    public MenuOption getCurrentMenuOption()
    {
        return cursor.getCurrentMenuOption();
    }

    public void setCurrentMenuOptionText(String text)
    {
        cursor.setCurrentMenuOptionText(text);
    }

    public void highlightCurrentMenuOption(boolean highlight)
    {
        cursor.getCurrentPanel().isSelected(highlight);
    }

    public void resetText()
    {
        cursor.resetAllPanelText();
    }
}
