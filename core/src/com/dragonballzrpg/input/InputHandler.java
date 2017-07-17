package com.dragonballzrpg.input;

import com.dragonballzrpg.enums.ActionName;
import com.dragonballzrpg.enums.KeyName;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Carl on 16/07/2017.
 */
public class InputHandler
{
    private Map<ActionName, Integer> inputToActionMap;
    private Map<KeyName, Key> keys;

    public InputHandler(Map<ActionName, Integer> inputToActionMap)
    {
        this.inputToActionMap = inputToActionMap;

        keys = new HashMap<KeyName, Key>();
        keys.put(KeyName.UP_KEY, new Key());
        keys.put(KeyName.DOWN_KEY, new Key());
        keys.put(KeyName.LEFT_KEY, new Key());
        keys.put(KeyName.RIGHT_KEY, new Key());
        keys.put(KeyName.INTERACT_OR_MELEE_KEY, new Key());
        keys.put(KeyName.CANCEL_OR_ENERGY_ATTACK_KEY, new Key());
        keys.put(KeyName.SWITCH_ENERGY_ATTACK_KEY, new Key());
    }

    public void handleKeyDown(int keyCode)
    {
        setKey(keyCode, true);
    }

    public void handleKeyUp(int keyCode)
    {
        setKey(keyCode, false);
    }

    private void setKey(int keyCode, boolean isPressed)
    {
        if(keyCode == inputToActionMap.get(ActionName.UP))
        {
            keys.get(KeyName.UP_KEY).setPressed(isPressed);
        }
        else if(keyCode == inputToActionMap.get(ActionName.DOWN))
        {
            keys.get(KeyName.DOWN_KEY).setPressed(isPressed);
        }
        else if(keyCode == inputToActionMap.get(ActionName.LEFT))
        {
            keys.get(KeyName.LEFT_KEY).setPressed(isPressed);
        }
        else if(keyCode == inputToActionMap.get(ActionName.RIGHT))
        {
            keys.get(KeyName.RIGHT_KEY).setPressed(isPressed);
        }
        else if(keyCode == inputToActionMap.get(ActionName.INTERACT_OR_MELEE))
        {
            keys.get(KeyName.INTERACT_OR_MELEE_KEY).setPressed(isPressed);
        }
        else if(keyCode == inputToActionMap.get(ActionName.CANCEL_OR_ENERGY_ATTACK))
        {
            keys.get(KeyName.CANCEL_OR_ENERGY_ATTACK_KEY).setPressed(isPressed);
        }
        else if(keyCode == inputToActionMap.get(ActionName.SWITCH_ENERGY_ATTACK))
        {
            keys.get(KeyName.SWITCH_ENERGY_ATTACK_KEY).setPressed(isPressed);
        }
    }
}
