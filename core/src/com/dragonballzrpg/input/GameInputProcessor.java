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
    private List<KeyStateManager> keyStateManagers;

    public GameInputProcessor()
    {
        keyStateManagers = new ArrayList<KeyStateManager>();
    }

    public void addAll(Collection<? extends KeyStateManager> inputHandlers)
    {
        this.keyStateManagers.addAll(inputHandlers);
    }

    public void add(KeyStateManager keyStateManager)
    {
        if(!keyStateManagers.contains(keyStateManager)) keyStateManagers.add(keyStateManager);
    }

    public void remove(KeyStateManager keyStateManager)
    {
        if(keyStateManagers.contains(keyStateManager)) keyStateManagers.remove(keyStateManager);
    }

    @Override
    public boolean keyDown(int keycode)
    {
//        for(KeyStateManager inputHandler : keyStateManagers)
//        {
//            inputHandler.handleKeyDown(keycode);
//        }

        return false;
    }

    @Override
    public boolean keyUp(int keycode)
    {
//        for(KeyStateManager inputHandler : keyStateManagers)
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
