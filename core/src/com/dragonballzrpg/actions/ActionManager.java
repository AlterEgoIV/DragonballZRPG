package com.dragonballzrpg.actions;

import com.dragonballzrpg.enums.ActionName;
import com.dragonballzrpg.utilities.Animation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Carl on 25/07/2017.
 */
public class ActionManager
{
    private Map<ActionName, Action> actions;
    private List<ActionProcessor> actionProcessors;

    public ActionManager()
    {
        actions = new HashMap<ActionName, Action>();
        actionProcessors = new ArrayList<ActionProcessor>();

        initialiseActions();
    }

    public void addActionProcessor(ActionProcessor actionProcessor)
    {
        actionProcessors.add(actionProcessor);
    }

    public void sendAction(ActionName actionName, Animation animation)
    {
        for(ActionProcessor actionProcessor : actionProcessors)
        {
            actionProcessor.addAction(actions.get(actionName), animation);
        }
    }

    private void initialiseActions()
    {
        actions.put(ActionName.MOVE_UP, new MoveUpAction());
    }
}
