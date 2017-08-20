package com.dragonballzrpg.states.transitions.transitionsets;

import com.dragonballzrpg.enums.StateName;
import com.dragonballzrpg.input.KeyStateManager;
import com.dragonballzrpg.states.State;

import java.util.Map;

/**
 * Created by Carl on 29/07/2017.
 */

public class InputHandlingStateTransitionSet extends StateTransitionSet
{
    protected KeyStateManager keyStateManager;
    protected Map<StateName, State> states;

    public InputHandlingStateTransitionSet(KeyStateManager keyStateManager, Map<StateName, State> states)
    {
        this.keyStateManager = keyStateManager;
        this.states = states;
    }
}
