package com.dragonballzrpg.input;

import com.badlogic.gdx.InputAdapter;
import com.dragonballzrpg.controllers.Controller;
import com.dragonballzrpg.controllers.InputController;
import com.dragonballzrpg.enums.KeyName;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Carl on 19/08/2017.
 */
public class PlayInputProcessor extends InputAdapter
{
    private KeyHandler keyHandler;
    public KeyStateViewer keyStateViewer;
    //private List<InputController> inputControllers;

    public PlayInputProcessor(Map<KeyName, Integer> inputKeyMap)
    {
        keyHandler = new KeyHandler(inputKeyMap);
        keyStateViewer = keyHandler.getKeyStateViewer();
        //inputControllers = new ArrayList<InputController>();
    }

    public void addInputController(InputController inputController)
    {
        //inputControllers.add(inputController);
    }

//    private void setKeyState(int keyCode, boolean isPressed)
//    {
//        for(InputController inputController : inputControllers)
//        {
//            inputController.setKeyState(keyCode, isPressed);
//        }
//    }

    public void update()
    {
        keyHandler.update();
    }

    @Override
    public boolean keyDown(int keyCode)
    {
        //System.out.println("Key Down");

        keyHandler.setKeyState(keyCode, true);
        //setKeyState(keyCode, true);

        return false;
    }

    @Override
    public boolean keyUp(int keyCode)
    {
        //System.out.println("Key Up");

        keyHandler.setKeyState(keyCode, false);
        //setKeyState(keyCode, false);

        return false;
    }
}
