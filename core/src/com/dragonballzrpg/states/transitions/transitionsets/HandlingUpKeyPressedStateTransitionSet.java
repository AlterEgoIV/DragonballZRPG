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

public class HandlingUpKeyPressedStateTransitionSet extends InputHandlingStateTransitionSet
{
    public HandlingUpKeyPressedStateTransitionSet(KeyHandler keyHandler, Map<StateName, State> states, State currentState)
    {
        super(keyHandler, states);

        transitionConditions.add(new InputTransitionCondition(keyHandler.getKey(KeyName.UP_KEY).getKeyCode(), false));
        transitions.add(new Transition(currentState, states.get(StateName.NOT_HANDLING_INPUT), transitionConditions));
    }
}
