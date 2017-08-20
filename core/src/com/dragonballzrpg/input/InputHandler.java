package com.dragonballzrpg.input;

import com.dragonballzrpg.actions.ActionManager;
import com.dragonballzrpg.enums.KeyName;
import com.dragonballzrpg.enums.StateName;
import com.dragonballzrpg.gameobjects.characters.Player;
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
    private KeyStateManager keyStateManager;
    private Map<StateName, State> states;
    private State currentState;
    private Player player;
    //private ActionManager actionManager;

    public InputHandler(Map<KeyName, Integer> inputKeyMap, ActionManager actionManager)
    {
        keyStateManager = new KeyStateManager(inputKeyMap);
        states = new HashMap<StateName, State>();
        //this.actionManager = actionManager;

        initialiseStates();
    }

    public InputHandler(Map<KeyName, Integer> inputKeyMap, Player player)
    {
        keyStateManager = new KeyStateManager(inputKeyMap);
        states = new HashMap<StateName, State>();
        this.player = player;

        initialiseStates();
    }

    public void update()
    {
        keyStateManager.update();
        currentState = currentState.update();
    }

    public void setKeyState(int keyCode, boolean isPressed)
    {
        keyStateManager.setKeyState(keyCode, isPressed);
    }

    private void initialiseStates()
    {
        // Put States in HashMap
        //states.put(StateName.NOT_HANDLING_INPUT, new NotHandlingInputState(actionManager));
        //states.put(StateName.HANDLING_UP_KEY_PRESSED, new HandlingUpKeyPressedState(actionManager));
        states.put(StateName.NOT_HANDLING_INPUT, new NotHandlingInputState(player));
        states.put(StateName.HANDLING_UP_KEY_PRESSED, new HandlingUpKeyPressedState(player));
        states.put(StateName.HANDLING_DOWN_KEY_PRESSED, new HandlingDownKeyPressedState());
        states.put(StateName.HANDLING_LEFT_KEY_PRESSED, new HandlingLeftKeyPressedState());
        states.put(StateName.HANDLING_RIGHT_KEY_PRESSED, new HandlingRightKeyPressedState());

        currentState = states.get(StateName.NOT_HANDLING_INPUT);

        // Set State Transitions
        states.get(StateName.NOT_HANDLING_INPUT).setTransitions(new NotHandlingInputStateTransitionSet(keyStateManager, states));
        states.get(StateName.HANDLING_UP_KEY_PRESSED).setTransitions(new HandlingUpKeyPressedStateTransitionSet(keyStateManager, states));
    }
}
