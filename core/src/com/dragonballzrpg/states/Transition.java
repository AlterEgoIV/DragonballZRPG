package com.dragonballzrpg.states;

import com.dragonballzrpg.entities.animatedentities.players.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Carl on 07/09/2016.
 */
public class Transition
{
    private State state;
    private String[] animationNames;
    private List<TransitionCondition> transitionConditions;

    public Transition(State state, String[] animationNames, TransitionCondition[] transitionConditions)
    {
        this.state = state;
        this.animationNames = animationNames;
        this.transitionConditions = new ArrayList<TransitionCondition>();

        for(TransitionCondition transitionCondition : transitionConditions)
        {
            this.transitionConditions.add(transitionCondition);
        }
    }

    public void update(Player p)
    {
        for(TransitionCondition transitionCondition : transitionConditions)
        {
            if(!transitionCondition.isValid()) return;
        }

        p.setCurrentAnimation(p.getAnimations().get(getRandomAnimationName(animationNames)));
        p.setCurrentState(state);
        p.getCurrentState().enter(p);
    }

    private String getRandomAnimationName(String[] animationNames)
    {
        Random random = new Random();

        return animationNames[random.nextInt(animationNames.length)];
    }
}
