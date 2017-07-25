package com.dragonballzrpg.input;

import com.dragonballzrpg.enums.KeyName;

import java.util.Map;

/**
 * Created by Carl on 25/07/2017.
 */
public class InputHandler
{
    private KeyHandler keyHandler;

    public InputHandler(Map<KeyName, Integer> inputKeyMap)
    {
        keyHandler = new KeyHandler(inputKeyMap);
    }

    public void update()
    {
        keyHandler.update();

        if(keyHandler.getKey(KeyName.DOWN_KEY).isPressed())
        {

        }
    }

    public void setKeyState(int keyCode, boolean isPressed)
    {
        keyHandler.setKeyState(keyCode, isPressed);
    }
}
