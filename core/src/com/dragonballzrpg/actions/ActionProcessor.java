package com.dragonballzrpg.actions;

import com.dragonballzrpg.utilities.Animation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carl on 03/08/2017.
 */
public abstract class ActionProcessor
{
    protected List<Action> actions;

    public ActionProcessor()
    {
        actions = new ArrayList<Action>();
    }

    public abstract void update();

    public void receiveAction(Action action, Animation animation)
    {
        action.setAnimation(animation);
        actions.add(action);
    }
}
