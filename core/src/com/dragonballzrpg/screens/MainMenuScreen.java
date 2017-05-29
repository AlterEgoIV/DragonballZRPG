package com.dragonballzrpg.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.dragonballzrpg.DragonballZRPG;
import com.dragonballzrpg.ui.MainMenuUI;
import com.dragonballzrpg.ui.UI;

/**
 * Created by Carl on 24/05/2017.
 */
public class MainMenuScreen extends GameScreen
{
    private UI ui;

    public MainMenuScreen(DragonballZRPG game)
    {
        super(game);

        ui = new MainMenuUI(game);
    }

    @Override
    public void show()
    {
        Gdx.input.setInputProcessor((InputProcessor)ui);
    }

    @Override
    public void render(float delta)
    {
        batch.setProjectionMatrix(game.camera.combined);
        batch.begin();
        ui.render(batch);
        batch.end();
    }

    @Override
    public void resize(int width, int height)
    {

    }

    @Override
    public void pause()
    {

    }

    @Override
    public void resume()
    {

    }

    @Override
    public void hide()
    {

    }
}
