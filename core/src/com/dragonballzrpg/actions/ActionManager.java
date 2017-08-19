package com.dragonballzrpg.actions;

import com.dragonballzrpg.enums.ActionName;
import com.dragonballzrpg.enums.AnimationName;
import com.dragonballzrpg.enums.AnimationSet;
import com.dragonballzrpg.utilities.ResourceManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Carl on 25/07/2017.
 */
public class ActionManager
{
    private ResourceManager resourceManager;
    private Map<ActionName, Action> actions;
    private List<ActionProcessor> actionProcessors;

    public ActionManager(ResourceManager resourceManager)
    {
        this.resourceManager = resourceManager;
        actions = new HashMap<ActionName, Action>();
        actionProcessors = new ArrayList<ActionProcessor>();

        initialiseActions();
    }

    public void addActionProcessor(ActionProcessor actionProcessor)
    {
        actionProcessors.add(actionProcessor);
    }

    public void sendAction(ActionName actionName, AnimationSet animationSet, AnimationName animationName)
    {
        for(ActionProcessor actionProcessor : actionProcessors)
        {
            actionProcessor.receiveAction(actions.get(actionName), resourceManager.getAnimationSet(animationSet).get(animationName));
        }
    }

    private void initialiseActions()
    {
        actions.put(ActionName.MOVE_UP, new MoveUpAction());
    }
}
