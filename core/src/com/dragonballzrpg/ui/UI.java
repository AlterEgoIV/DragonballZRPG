package com.dragonballzrpg.ui;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dragonballzrpg.DragonballZRPG;
import com.dragonballzrpg.enums.ActionName;
import com.dragonballzrpg.ui.uielements.UIElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Carl on 25/05/2017.
 */
public abstract class UI
{
    protected AssetManager assetManager;
    protected Viewport viewport;
    protected List<UIElement> uiElements;

    public UI(AssetManager assetManager, Viewport viewport)
    {
        this.assetManager = assetManager;
        this.viewport = viewport;

        uiElements = new ArrayList<UIElement>();
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
}
