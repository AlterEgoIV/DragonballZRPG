package com.dragonballzrpg.states.transitions;

import com.badlogic.gdx.Gdx;

/**
 * Created by Carl on 28/07/2017.
 */

public class InputTransitionCondition implements TransitionCondition
{
    private int keyCode;
    private boolean isPressed;

    public InputTransitionCondition(int keyCode, boolean isPressed)
    {
        this.keyCode = keyCode;
        this.isPressed = isPressed;
    }

    @Override
    public boolean isMet()
    {
        return Gdx.input.isKeyPressed(keyCode) == isPressed;
    }
}
