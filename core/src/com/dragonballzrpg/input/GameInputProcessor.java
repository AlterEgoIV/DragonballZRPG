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
    private List<KeyHandler> keyHandlers;

    public GameInputProcessor()
    {
        keyHandlers = new ArrayList<KeyHandler>();
    }

    public void addAll(Collection<? extends KeyHandler> inputHandlers)
    {
        this.keyHandlers.addAll(inputHandlers);
    }

    public void add(KeyHandler keyHandler)
    {
        if(!keyHandlers.contains(keyHandler)) keyHandlers.add(keyHandler);
    }

    public void remove(KeyHandler keyHandler)
    {
        if(keyHandlers.contains(keyHandler)) keyHandlers.remove(keyHandler);
    }

    @Override
    public boolean keyDown(int keycode)
    {
//        for(KeyHandler inputHandler : keyHandlers)
//        {
//            inputHandler.handleKeyDown(keycode);
//        }

        return false;
    }

    @Override
    public boolean keyUp(int keycode)
    {
//        for(KeyHandler inputHandler : keyHandlers)
//        {
//            inputHandler.handleKeyUp(keycode);
//        }

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
