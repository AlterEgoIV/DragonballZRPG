package com.dragonballzrpg.input;

import com.dragonballzrpg.enums.KeyName;
import com.dragonballzrpg.enums.StateName;
import com.dragonballzrpg.states.State;
import com.dragonballzrpg.states.inputhandlerstates.HandlingDownKeyPressedState;
import com.dragonballzrpg.states.inputhandlerstates.HandlingLeftKeyPressedState;
import com.dragonballzrpg.states.inputhandlerstates.HandlingRightKeyPressedState;
import com.dragonballzrpg.states.inputhandlerstates.HandlingUpKeyPressedState;
import com.dragonballzrpg.states.inputhandlerstates.NotHandlingInputState;
import com.dragonballzrpg.states.transitions.transitionsets.HandlingUpKeyPressedStateTransitionSet;
import com.dragonballzrpg.states.transitions.transitionsets.NotHandlingInputStateTransitionSet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Carl on 25/07/2017.
 */
public class InputHandler
{
    private KeyHandler keyHandler;
    private Map<StateName, State> states;
    private State currentState;

    public InputHandler(Map<KeyName, Integer> inputKeyMap)
    {
        keyHandler = new KeyHandler(inputKeyMap);
        states = new HashMap<StateName, State>();

        initialiseStates();

        currentState = states.get(StateName.NOT_HANDLING_INPUT);
    }

    public void update()
    {
        keyHandler.update();
        currentState.update();
    }

    public void setKeyState(int keyCode, boolean isPressed)
    {
        keyHandler.setKeyState(keyCode, isPressed);
    }

    private void initialiseStates()
    {
        // Put States in HashMap
        states.put(StateName.NOT_HANDLING_INPUT, new NotHandlingInputState());
        states.put(StateName.HANDLING_UP_KEY_PRESSED, new HandlingUpKeyPressedState());
        states.put(StateName.HANDLING_DOWN_KEY_PRESSED, new HandlingDownKeyPressedState());
        states.put(StateName.HANDLING_LEFT_KEY_PRESSED, new HandlingLeftKeyPressedState());
        states.put(StateName.HANDLING_RIGHT_KEY_PRESSED, new HandlingRightKeyPressedState());

        // Set State Transitions
        states.get(StateName.NOT_HANDLING_INPUT).setTransitions(new NotHandlingInputStateTransitionSet(keyHandler, states));
        states.get(StateName.HANDLING_UP_KEY_PRESSED).setTransitions(new HandlingUpKeyPressedStateTransitionSet(keyHandler, states));
    }
}
