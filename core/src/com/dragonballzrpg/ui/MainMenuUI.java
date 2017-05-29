package com.dragonballzrpg.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.dragonballzrpg.DragonballZRPG;
import com.dragonballzrpg.enums.ActionName;
import com.dragonballzrpg.enums.ScreenName;
import com.dragonballzrpg.ui.uielements.MenuOption;
import com.dragonballzrpg.ui.uielements.Panel;
import com.dragonballzrpg.ui.uielements.Text;

/**
 * Created by Carl on 25/05/2017.
 */
public class MainMenuUI extends UI implements InputProcessor
{
    private int currentOption;

    public MainMenuUI(DragonballZRPG game)
    {
        super(game);

        currentOption = 0;

        createUIElements();

        ((MenuOption)uiElements.get(currentOption)).setPanelRGBA(.65f, .8f, .75f, 1f);
    }

    private void createUIElements()
    {
        int numElements = 3;
        String[] strings = {"Start", "Controls", "Exit"};
        Vector2 position = new Vector2(0, 0);
        int width = (int)game.viewport.getWorldWidth() / 7;
        int height = (int)game.viewport.getWorldHeight() / 7;
        int ySpacing = height / 5;

        for(int i = 0; i < numElements; ++i)
        {
            position.x = game.viewport.getWorldWidth() / 2;
            position.y = game.viewport.getWorldHeight() - (game.viewport.getWorldHeight() / numElements) + (height / 2) - ((height * i) + (ySpacing * i));
            Text text = new Text(position.cpy(), strings[i], .6f, .8f);
            text.position.x -= text.getWidth() / 2;
            text.position.y += text.getHeight() / 2;
            position.x -= width / 2;
            position.y -= height / 2;
            Panel panel = new Panel(position.cpy(), width, height, .15f, .3f, .35f, 1f, Color.CHARTREUSE);

            uiElements.add(new MenuOption(position, width, height, panel, text));
        }
    }

    @Override
    public boolean keyDown(int keycode)
    {
        if(keycode == game.inputActions.get(ActionName.UP))
        {
            ((MenuOption)uiElements.get(currentOption)).setPanelRGBA(.15f, .3f, .35f, 1f);

            --currentOption;

            if(currentOption < 0)
            {
                currentOption = uiElements.size() - 1;
            }

            ((MenuOption)uiElements.get(currentOption)).setPanelRGBA(.65f, .8f, .75f, 1f);
        }
        else if(keycode == game.inputActions.get(ActionName.DOWN))
        {
            ((MenuOption)uiElements.get(currentOption)).setPanelRGBA(.15f, .3f, .35f, 1f);

            ++currentOption;

            if(currentOption > uiElements.size() - 1)
            {
                currentOption = 0;
            }

            ((MenuOption)uiElements.get(currentOption)).setPanelRGBA(.65f, .8f, .75f, 1f);
        }

        return false;
    }

    @Override
    public boolean keyUp(int keycode)
    {
        if(keycode == game.inputActions.get(ActionName.SELECT))
        {
            if(currentOption == 0)
            {
                game.setScreen(game.screens.get(ScreenName.PLAY_SCREEN));
            }
            if(currentOption == 1)
            {
                game.setScreen(game.screens.get(ScreenName.CONTROLS_SCREEN));
            }
            if(currentOption == 2)
            {
                Gdx.app.exit();
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
