package com.dragonballzrpg.input;

import com.badlogic.gdx.Gdx;

/**
 * Created by Carl on 17/07/2017.
 */
public class Key
{
    private boolean isPressed, justPressed, isDoublePressed;
    private double currentTimeBetweenPresses, allowedTimeBetweenPresses;

    public Key()
    {
        isPressed = false;
        justPressed = false;
        isDoublePressed = false;
        currentTimeBetweenPresses = 0.0d;
        allowedTimeBetweenPresses = 0.3d;
    }

    public void update()
    {
        if(justPressed)
        {
            currentTimeBetweenPresses += Gdx.graphics.getDeltaTime();

            if(currentTimeBetweenPresses >= allowedTimeBetweenPresses)
            {
                justPressed = false;
                currentTimeBetweenPresses = 0.0d;
            }
        }
    }

    public void setPressed(boolean isPressed)
    {
        if(isPressed)
        {
            this.isPressed = true;

            if(justPressed)
            {
                isDoublePressed = true;
            }
        }
        else
        {
            this.isPressed = false;
            justPressed = true;
        }
    }

    public void press()
    {
        isPressed = true;

        if(justPressed)
        {
            isDoublePressed = true;
        }
    }

    public void release()
    {
        isPressed = false;
        justPressed = true;
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
