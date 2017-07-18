package com.dragonballzrpg.input;

import com.dragonballzrpg.enums.KeyName;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Carl on 16/07/2017.
 */
public class InputHandler
{
    private Map<KeyName, Integer> inputKeyMap;
    private Map<KeyName, Key> keys;
    private InputControllable inputControllable;

    public InputHandler(Map<KeyName, Integer> inputKeyMap)
    {
        this.inputKeyMap = inputKeyMap;
        keys = new HashMap<KeyName, Key>();

        for(Map.Entry<KeyName, Integer> inputKey : inputKeyMap.entrySet())
        {
            keys.put(inputKey.getKey(), new Key());
        }
    }

    public void setInputControllable(InputControllable inputControllable)
    {
        this.inputControllable = inputControllable;
    }

    public void update()
    {
        for(Key key : keys.values())
        {
            key.update();
        }

        if(keys.get(KeyName.UP_KEY).isDoublePressed())
        {
            inputControllable.moveUpFast();
        }
//        else if(keys.get(KeyName.UP_KEY).isPressed())
//        {
//            inputControllable.moveUp();
//        }

        if(keys.get(KeyName.DOWN_KEY).isPressed())
        {
            inputControllable.moveDown();
        }

        if(keys.get(KeyName.LEFT_KEY).isPressed())
        {
            inputControllable.moveLeft();
        }

        if(keys.get(KeyName.RIGHT_KEY).isPressed())
        {
            inputControllable.moveRight();
        }
    }

    public void setKey(int keyCode, boolean isPressed)
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
