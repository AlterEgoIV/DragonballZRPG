package com.dragonballzrpg.input;

import com.badlogic.gdx.InputAdapter;
import com.dragonballzrpg.enums.KeyName;

import java.util.Map;

/**
 * Created by Carl on 19/08/2017.
 */
public class PlayInputProcessor extends InputAdapter
{
    private KeyStateManager keyStateManager;

    public PlayInputProcessor(Map<KeyName, Integer> inputKeyMap)
    {
        keyStateManager = new KeyStateManager(inputKeyMap);
    }

    public void update()
    {
        keyStateManager.update();
    }

    public KeyStateViewer getKeyStateViewer()
    {
        return keyStateManager.getKeyStateViewer();
    }

    @Override
    public boolean keyDown(int keyCode)
    {
        keyStateManager.setKeyState(keyCode, true);

        return false;
    }

    @Override
    public boolean keyUp(int keyCode)
    {
        keyStateManager.setKeyState(keyCode, false);

        return false;
    }
}
