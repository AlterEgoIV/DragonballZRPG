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

    public InputHandler(Map<KeyName, Integer> inputKeyMap)
    {
        this.inputKeyMap = inputKeyMap;
        keys = new HashMap<KeyName, Key>();

        for(Map.Entry<KeyName, Integer> inputKey : inputKeyMap.entrySet())
        {
            keys.put(inputKey.getKey(), new Key());
        }

//        keys.put(KeyName.UP_KEY, new Key());
//        keys.put(KeyName.DOWN_KEY, new Key());
//        keys.put(KeyName.LEFT_KEY, new Key());
//        keys.put(KeyName.RIGHT_KEY, new Key());
//        keys.put(KeyName.INTERACT_OR_MELEE_KEY, new Key());
//        keys.put(KeyName.CANCEL_OR_ENERGY_ATTACK_KEY, new Key());
//        keys.put(KeyName.SWITCH_ENERGY_ATTACK_KEY, new Key());
    }

    public void update()
    {
        for(Key key : keys.values())
        {
            key.update();
        }
    }

//    public void handleKeyDown(int keyCode)
//    {
//        setKey(keyCode, true);
//    }
//
//    public void handleKeyUp(int keyCode)
//    {
//        setKey(keyCode, false);
//    }

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

//        if(keyCode == inputKeyMap.get(KeyName.UP_KEY))
//        {
//            keys.get(KeyName.UP_KEY).setPressed(isPressed);
//        }
//        else if(keyCode == inputKeyMap.get(KeyName.DOWN_KEY))
//        {
//            keys.get(KeyName.DOWN_KEY).setPressed(isPressed);
//        }
//        else if(keyCode == inputKeyMap.get(KeyName.LEFT_KEY))
//        {
//            keys.get(KeyName.LEFT_KEY).setPressed(isPressed);
//        }
//        else if(keyCode == inputKeyMap.get(KeyName.RIGHT_KEY))
//        {
//            keys.get(KeyName.RIGHT_KEY).setPressed(isPressed);
//        }
//        else if(keyCode == inputKeyMap.get(KeyName.INTERACT_OR_MELEE_KEY))
//        {
//            keys.get(KeyName.INTERACT_OR_MELEE_KEY).setPressed(isPressed);
//        }
//        else if(keyCode == inputKeyMap.get(KeyName.CANCEL_OR_ENERGY_ATTACK_KEY))
//        {
//            keys.get(KeyName.CANCEL_OR_ENERGY_ATTACK_KEY).setPressed(isPressed);
//        }
//        else if(keyCode == inputKeyMap.get(KeyName.SWITCH_ENERGY_ATTACK_KEY))
//        {
//            keys.get(KeyName.SWITCH_ENERGY_ATTACK_KEY).setPressed(isPressed);
//        }
    }
}
