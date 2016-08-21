package com.dragonballzrpg.input;

import com.badlogic.gdx.InputProcessor;

/**
 * Created by Carl on 16/08/2016.
 */
public class GameInputProcessor implements InputProcessor
{
    private InputHandler inputHandler;

    public void setInputHandler(InputHandler inputHandler)
    {
        this.inputHandler = inputHandler;
    }

    @Override
    public boolean keyDown(int keycode)
    {
        if(inputHandler != null)
        {
            inputHandler.handleKeyPress(keycode);

            return true;
        }

        return false;
    }

    @Override
    public boolean keyUp(int keycode)
    {
        if(inputHandler != null)
        {
            inputHandler.handleKeyRelease(keycode);

            return true;
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
