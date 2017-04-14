package com.dragonballzrpg.input;

import com.badlogic.gdx.InputProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carl on 16/08/2016.
 */
public class GameInputProcessor implements InputProcessor
{
    private List<InputHandler> inputHandlers;
    //private InputHandler inputHandler;

    public GameInputProcessor()
    {
        inputHandlers = new ArrayList<InputHandler>();
    }

    public void add(InputHandler inputHandler)
    {
        if(!inputHandlers.contains(inputHandler)) inputHandlers.add(inputHandler);
    }

    public void remove(InputHandler inputHandler)
    {
        if(inputHandlers.contains(inputHandler)) inputHandlers.remove(inputHandler);
    }

//    public void setInputHandler(InputHandler inputHandler)
//    {
//        this.inputHandler = inputHandler;
//    }

    @Override
    public boolean keyDown(int keycode)
    {
        for(InputHandler inputHandler : inputHandlers)
        {
            inputHandler.handleKeyDown(keycode);
        }

        return false;

//        if(inputHandler != null)
//        {
//            inputHandler.handleKeyDown(keycode);
//
//            return true;
//        }
//
//        return false;
    }

    @Override
    public boolean keyUp(int keycode)
    {
        for(InputHandler inputHandler : inputHandlers)
        {
            inputHandler.handleKeyUp(keycode);
        }

        return false;

//        if(inputHandler != null)
//        {
//            inputHandler.handleKeyUp(keycode);
//
//            return true;
//        }
//
//        return false;
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
