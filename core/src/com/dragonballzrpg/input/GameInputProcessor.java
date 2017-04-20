package com.dragonballzrpg.input;

import com.badlogic.gdx.InputProcessor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Carl on 16/08/2016.
 */
public class GameInputProcessor implements InputProcessor
{
    private List<InputHandler> inputHandlers;
    //private InputController inputController;

    public GameInputProcessor()
    {
        //this.inputController = inputController;
        inputHandlers = new ArrayList<InputHandler>();
    }

    public void addAll(Collection<? extends InputHandler> inputHandlers)
    {
        this.inputHandlers.addAll(inputHandlers);
    }

    public void add(InputHandler inputHandler)
    {
        if(!inputHandlers.contains(inputHandler)) inputHandlers.add(inputHandler);
    }

    public void remove(InputHandler inputHandler)
    {
        if(inputHandlers.contains(inputHandler)) inputHandlers.remove(inputHandler);
    }

    @Override
    public boolean keyDown(int keycode)
    {
        for(InputHandler inputHandler : inputHandlers)
        {
            inputHandler.handleKeyDown(keycode);
        }

        return false;
    }

    @Override
    public boolean keyUp(int keycode)
    {
        for(InputHandler inputHandler : inputHandlers)
        {
            inputHandler.handleKeyUp(keycode);
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
