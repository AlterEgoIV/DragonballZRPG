package com.dragonballzrpg.input;

import com.badlogic.gdx.Gdx;

/**
 * Created by Carl on 17/07/2017.
 */
public class Key
{
    private boolean isPressed, isJustPressed, isDoublePressed;
    private double currentTimeBetweenPresses, allowedTimeBetweenPresses;

    public Key()
    {
        isPressed = false;
        isJustPressed = false;
        isDoublePressed = false;
        currentTimeBetweenPresses = 0.0d;
        allowedTimeBetweenPresses = 0.3d;
    }

    public void update()
    {
        if(isJustPressed)
        {
            currentTimeBetweenPresses += Gdx.graphics.getDeltaTime();

            if(currentTimeBetweenPresses >= allowedTimeBetweenPresses)
            {
                isJustPressed = false;
                currentTimeBetweenPresses = 0.0d;
            }
        }
    }

    public void setPressed(boolean isPressed)
    {
        if(isPressed)
        {
            this.isPressed = true;

            if(isJustPressed)
            {
                isDoublePressed = true;
            }
        }
        else
        {
            this.isPressed = false;
            isJustPressed = true;
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
