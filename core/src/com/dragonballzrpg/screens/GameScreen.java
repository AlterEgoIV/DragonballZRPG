package com.dragonballzrpg.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragonballzrpg.DragonballZRPG;
import com.dragonballzrpg.ui.UI;

/**
 * Created by Carl on 10/08/2016.
 */
public abstract class GameScreen implements Screen
{
    protected DragonballZRPG game;
    protected UI ui;
    protected SpriteBatch batch;

    protected GameScreen(DragonballZRPG game)
    {
        this.game = game;
        this.ui = null;
        batch = new SpriteBatch();
    }

    protected GameScreen(DragonballZRPG game, UI ui)
    {
        this.game = game;
        this.ui = ui;
        batch = new SpriteBatch();
    }

    @Override
    public void dispose()
    {
        batch.dispose();
    }
}
