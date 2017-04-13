package com.dragonballzrpg.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragonballzrpg.DragonballZRPG;

/**
 * Created by Carl on 10/08/2016.
 */
public abstract class GameScreen implements Screen
{
    protected DragonballZRPG game;
    protected SpriteBatch batch;

    protected GameScreen(DragonballZRPG game)
    {
        this.game = game;
        batch = new SpriteBatch();
    }

    @Override
    public void dispose()
    {
        batch.dispose();
    }
}
