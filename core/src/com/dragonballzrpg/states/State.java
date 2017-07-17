package com.dragonballzrpg.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragonballzrpg.gameobjects.GameObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carl on 24/08/2016.
 */
public abstract class State
{
    protected List<Transition> transitions;
    protected double currentDuration;

    public State()
    {
        transitions = new ArrayList<Transition>();
        currentDuration = 0.0d;
    }

    //public abstract void initialiseTransitions(Player player);
    public abstract void enter(GameObject gameObject);
    public abstract void exit(GameObject gameObject);
    public abstract void update(GameObject gameObject);
    public abstract void render(GameObject gameObject, SpriteBatch batch);
    public abstract void enter();
    public abstract void exit();
    public abstract void update();
    public abstract void render();

    public void setTransitions(List<Transition> transitions)
    {
        this.transitions = transitions;
    }

//    protected <T> T getRandomValue(T[] values)
//    {
//        Random random = new Random();
//        int value = random.nextInt(values.length);
//
//        return values[value];
//    }
}
