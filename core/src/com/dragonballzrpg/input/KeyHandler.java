package com.dragonballzrpg.input;

import com.dragonballzrpg.enums.KeyName;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Carl on 16/07/2017.
 */
public class KeyHandler
{
    private Map<KeyName, Integer> inputKeyMap;
    private Map<KeyName, Key> keys;

    public KeyHandler(Map<KeyName, Integer> inputKeyMap)
    {
        this.inputKeyMap = inputKeyMap;
        keys = new HashMap<KeyName, Key>();

        for(Map.Entry<KeyName, Integer> inputKey : inputKeyMap.entrySet())
        {
            keys.put(inputKey.getKey(), new Key(inputKey.getValue()));
        }
    }

    public void update()
    {
        for(Key key : keys.values())
        {
            key.update();
        }
    }

    public Key getKey(KeyName keyName)
    {
        return keys.get(keyName);
    }

    public void setKeyState(int keyCode, boolean isPressed)
    {
        for(Map.Entry<KeyName, Integer> inputKey : inputKeyMap.entrySet())
        {
            if(keyCode == inputKey.getValue())
            {
                keys.get(inputKey.getKey()).setPressed(isPressed);
                break;
            }
        }
    }
}
