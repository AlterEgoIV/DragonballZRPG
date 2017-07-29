package com.dragonballzrpg.states.transitions.transitionsets;

import com.dragonballzrpg.enums.StateName;
import com.dragonballzrpg.input.KeyHandler;
import com.dragonballzrpg.states.State;

import java.util.Map;

/**
 * Created by Carl on 29/07/2017.
 */

public class InputHandlingStateTransitionSet extends StateTransitionSet
{
    protected KeyHandler keyHandler;
    protected Map<StateName, State> states;

    public InputHandlingStateTransitionSet(KeyHandler keyHandler, Map<StateName, State> states)
    {
        this.keyHandler = keyHandler;
        this.states = states;
    }
}
