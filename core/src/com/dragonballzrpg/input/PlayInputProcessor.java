package com.dragonballzrpg.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerListener;
import com.badlogic.gdx.controllers.PovDirection;
import com.badlogic.gdx.math.Vector3;
import com.dragonballzrpg.enums.KeyName;
import com.dragonballzrpg.utilities.PS3DS3Pad;

import java.util.Map;

/**
 * Created by Carl on 19/08/2017.
 */
public class PlayInputProcessor extends InputAdapter implements ControllerListener
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

    @Override
    public void connected(Controller controller)
    {
        System.out.printf("%s controller connected.\n", controller.getName());
    }

    @Override
    public void disconnected(Controller controller)
    {
        System.out.printf("%s controller disconnected.\n", controller.getName());
    }

    @Override
    public boolean buttonDown(Controller controller, int buttonCode)
    {
        if(buttonCode == PS3DS3Pad.BUTTON_CROSS)
        {
            System.out.println("Button down");
        }

        return false;
    }

    @Override
    public boolean buttonUp(Controller controller, int buttonCode)
    {
        return false;
    }

    @Override
    public boolean axisMoved(Controller controller, int axisCode, float value)
    {
        return false;
    }

    @Override
    public boolean povMoved(Controller controller, int povCode, PovDirection value)
    {
        return false;
    }

    @Override
    public boolean xSliderMoved(Controller controller, int sliderCode, boolean value)
    {
        return false;
    }

    @Override
    public boolean ySliderMoved(Controller controller, int sliderCode, boolean value)
    {
        return false;
    }

    @Override
    public boolean accelerometerMoved(Controller controller, int accelerometerCode, Vector3 value)
    {
        return false;
    }
}
