package com.dragonballzrpg.states.transitions.transitionsets;

import com.dragonballzrpg.enums.KeyName;
import com.dragonballzrpg.enums.StateName;
import com.dragonballzrpg.input.KeyHandler;
import com.dragonballzrpg.states.State;
import com.dragonballzrpg.states.transitions.InputTransitionCondition;
import com.dragonballzrpg.states.transitions.Transition;

import java.util.Map;

/**
 * Created by Carl on 29/07/2017.
 */

public class NotHandlingInputStateTransitionSet extends InputHandlingStateTransitionSet
{
    public NotHandlingInputStateTransitionSet(KeyHandler keyHandler, Map<StateName, State> states, State currentState)
    {
        super(keyHandler, states);

        transitionConditions.add(new InputTransitionCondition(keyHandler.getKey(KeyName.UP_KEY).getKeyCode(), true));
        transitions.add(new Transition(currentState, states.get(StateName.HANDLING_UP_KEY_PRESSED), transitionConditions));
        //transitions.add(new Transition(states.get(StateName.NOT_HANDLING_INPUT), states.get(StateName.HANDLING_UP_KEY_PRESSED), transitionConditions));
    }
}
