package com.dragonballzrpg.actions;

import com.dragonballzrpg.utilities.Animation;

/**
 * Created by Carl on 03/08/2017.
 */
public abstract class Action
{
    protected Animation animation;

    public void setAnimation(Animation animation)
    {
        this.animation = animation;
    }

    public abstract void update();
}
