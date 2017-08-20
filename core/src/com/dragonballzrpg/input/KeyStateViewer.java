package com.dragonballzrpg.input;

import com.dragonballzrpg.enums.KeyName;

import java.util.Map;

/**
 * Created by Carl on 20/08/2017.
 */
public class KeyStateViewer
{
    private Map<KeyName, Key> keys;

    public KeyStateViewer(Map<KeyName, Key> keys)
    {
        this.keys = keys;
    }

    public Integer getKeyCode(KeyName keyName)
    {
        return keys.get(keyName).getKeyCode();
    }

    public boolean isKeyPressed(KeyName keyName)
    {
        return keys.get(keyName).isPressed();
    }

    public boolean isKeyDoublePressed(KeyName keyName)
    {
        return keys.get(keyName).isDoublePressed();
    }
}
