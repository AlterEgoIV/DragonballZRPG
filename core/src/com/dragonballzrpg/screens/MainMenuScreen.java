package com.dragonballzrpg.screens;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
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

        ui = new MainMenuUI();
    }

    @Override
    public void show()
    {

    }

    @Override
    public void render(float delta)
    {
        batch.setProjectionMatrix(game.camera.combined);
        batch.begin();
        ui.render(batch);
        //font.draw(batch, layout,
        //game.viewport.getWorldWidth() / 2 - (layout.width / 2),
        //game.viewport.getWorldHeight() / 2 + (layout.height / 2));
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
