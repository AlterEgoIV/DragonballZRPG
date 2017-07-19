package com.dragonballzrpg.input;

import com.badlogic.gdx.Gdx;

/**
 * Created by Carl on 17/07/2017.
 */
public class Key
{
    private boolean isPressed, isDoublePressed, isDoublePressWindowOpen, isReadyToBeDoublePressed;
    private double currentTimeDoublePressWindowOpen, doublePressWindowDuration;

    public Key()
    {
        isPressed = false;
        isDoublePressed = false;
        isDoublePressWindowOpen = false;
        isReadyToBeDoublePressed = false;
        currentTimeDoublePressWindowOpen = 0.0d;
        doublePressWindowDuration = 0.3d;
    }

    public void update()
    {
        if(isDoublePressWindowOpen)
        {
            currentTimeDoublePressWindowOpen += Gdx.graphics.getDeltaTime();

            if(currentTimeDoublePressWindowOpen >= doublePressWindowDuration)
            {
                currentTimeDoublePressWindowOpen = 0.0d;
                isDoublePressWindowOpen = false;
                isReadyToBeDoublePressed = false;
            }
        }
    }

    public void setPressed(boolean isPressed)
    {
        if(isPressed)
        {
            this.isPressed = true;

            if(isReadyToBeDoublePressed)
            {
                isDoublePressed = true;
            }

            if(!isDoublePressWindowOpen)
            {
                isDoublePressWindowOpen = true;
            }
        }
        else
        {
            this.isPressed = false;

            if(isDoublePressWindowOpen)
            {
                isReadyToBeDoublePressed = true;
            }

            if(isDoublePressed)
            {
                isDoublePressed = false;
            }
        }
    }

    public boolean isPressed()
    {
        return isPressed;
    }

    public boolean isDoublePressed()
    {
        return isDoublePressed;
    }
}
