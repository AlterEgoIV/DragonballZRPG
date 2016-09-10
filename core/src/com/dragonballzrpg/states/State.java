package com.dragonballzrpg.states;

import com.dragonballzrpg.entities.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by Carl on 24/08/2016.
 */
public abstract class State
{
    protected List<Transition> transitions;
    protected double currentStateDuration;

    public State()
    {
        transitions = new ArrayList<Transition>();
        currentStateDuration = 0.0d;
    }

    public abstract void initialiseTransitions(Map<String, State> playerStates);
    public abstract void update(Entity entity);

    public <T> T getRandomValue(T[] values)
    {
        Random random = new Random();
        int value = random.nextInt(values.length);

        return values[value];
    }
}
