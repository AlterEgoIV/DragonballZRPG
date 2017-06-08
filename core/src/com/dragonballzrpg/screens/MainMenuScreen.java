package com.dragonballzrpg.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.dragonballzrpg.DragonballZRPG;
import com.dragonballzrpg.enums.ActionName;
import com.dragonballzrpg.enums.ScreenName;
import com.dragonballzrpg.ui.MainMenuUI;

/**
 * Created by Carl on 24/05/2017.
 */
public class MainMenuScreen extends GameScreen implements InputProcessor
{
    public MainMenuScreen(DragonballZRPG game)
    {
        super(game, new MainMenuUI(game.assetManager, game.viewport));
    }

    @Override
    public void show()
    {
        Gdx.input.setInputProcessor(this);
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

    @Override
    public boolean keyDown(int keycode)
    {
        if(keycode == game.actions.get(ActionName.UP))
        {
            ((MainMenuUI)ui).cursor.previous();
        }
        else if(keycode == game.actions.get(ActionName.DOWN))
        {
            ((MainMenuUI)ui).cursor.next();
        }

        return false;
    }

    @Override
    public boolean keyUp(int keycode)
    {
        if(keycode == game.actions.get(ActionName.SELECT))
        {
            switch(((MainMenuUI)ui).cursor.currentMenuOption)
            {
                case START:
                {
                    game.setScreen(game.screens.get(ScreenName.PLAY_SCREEN));
                    break;
                }

                case CONTROLS:
                {
                    game.setScreen(game.screens.get(ScreenName.CONTROLS_SCREEN));
                    break;
                }

                case EXIT:
                {
                    Gdx.app.exit();
                    break;
                }
            }
        }

        return false;
    }

    @Override
    public boolean keyTyped(char character)
    {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button)
    {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button)
    {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer)
    {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY)
    {
        return false;
    }

    @Override
    public boolean scrolled(int amount)
    {
        return false;
    }
}
