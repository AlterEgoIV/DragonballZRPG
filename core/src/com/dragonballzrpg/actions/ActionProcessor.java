package com.dragonballzrpg.actions;

import com.dragonballzrpg.utilities.Animation;

/**
 * Created by Carl on 25/07/2017.
 */
public interface ActionProcessor
{
    void addAction(Action action, Animation animation);
    void clearActions();
}
