package com.dragonballzrpg.controllers;

import com.dragonballzrpg.enums.KeyName;
import com.dragonballzrpg.input.KeyHandler;
import com.dragonballzrpg.input.KeyStateViewer;

import java.util.Map;

/**
 * Created by Carl on 19/08/2017.
 */
public abstract class InputController extends Controller
{
    protected KeyStateViewer keyStateViewer;

    public InputController(KeyStateViewer keyStateViewer)
    {
        this.keyStateViewer = keyStateViewer;
    }

//    public void setKeyState(int keyCode, boolean isPressed)
//    {
//        keyHandler.setKeyState(keyCode, isPressed);
//    }
}
