package com.dragonballzrpg.input;

import com.badlogic.gdx.Gdx;

/**
 * Created by Carl on 17/07/2017.
 */
public class Key
{
    private boolean isPressed, isJustPressed, isDoublePressed, doublePressWindowOpen, readyToBeDoublePressed;
    private double durationPressed, currentTimeBetweenPresses, allowedTimeBetweenPresses, allowedTimeToPress, doublePressTimer,
    doublePressWindowTimeElapsed, doublePressWindowDuration;

    public Key()
    {
        isPressed = false;
        isJustPressed = false;
        isDoublePressed = false;
        doublePressWindowOpen = false;
        readyToBeDoublePressed = false;
        durationPressed = 0.0d;
        currentTimeBetweenPresses = 0.0d;
        allowedTimeBetweenPresses = 0.3d;
        allowedTimeToPress = 0.3d;
        doublePressTimer = 0.5d;
        doublePressWindowTimeElapsed = 0.0d;
        doublePressWindowDuration = 0.3d;
    }

    public void update()
    {
        if(doublePressWindowOpen)
        {
            doublePressWindowTimeElapsed += Gdx.graphics.getDeltaTime();

            if(doublePressWindowTimeElapsed >= doublePressWindowDuration)
            {
                doublePressWindowTimeElapsed = 0.0d;
                doublePressWindowOpen = false;
                readyToBeDoublePressed = false;
            }
        }

//        if(isJustPressed)
//        {
//            currentTimeBetweenPresses += Gdx.graphics.getDeltaTime();
//
//            if(currentTimeBetweenPresses >= allowedTimeBetweenPresses)
//            {
//                isJustPressed = false;
//                currentTimeBetweenPresses = 0.0d;
//            }
//        }
    }

    public void setPressed(boolean isPressed)
    {
        if(isPressed)
        {
            this.isPressed = true;

            if(readyToBeDoublePressed)
            {
                isDoublePressed = true;
            }

            if(!doublePressWindowOpen)
            {
                doublePressWindowOpen = true;
            }

//            if(doublePressWindowOpen && isJustPressed)
//            {
//                isDoublePressed = true;
//                isJustPressed = false;
//                doublePressWindowOpen = false;
//            }
        }
        else
        {
            this.isPressed = false;

            if(doublePressWindowOpen)
            {
                readyToBeDoublePressed = true;
            }

            if(isDoublePressed)
            {
                isDoublePressed = false;
            }

//            isJustPressed = true;
//            isDoublePressed = false;
        }

//        if(isPressed)
//        {
//            this.isPressed = true;
//
//            if(isJustPressed)
//            {
//                this.isPressed = false;
//                isDoublePressed = true;
//            }
//        }
//        else
//        {
//            this.isPressed = false;
//            isJustPressed = true;
//            isDoublePressed = false;
//        }
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
