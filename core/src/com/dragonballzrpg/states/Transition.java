package com.dragonballzrpg.states;

import com.dragonballzrpg.entities.animatedentities.players.Player;
import com.dragonballzrpg.enums.AnimationName;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Carl on 07/09/2016.
 */
public class Transition
{
    private State state;
    private AnimationName[] animationNames;
    private List<TransitionCondition> transitionConditions;

    public Transition(State state, AnimationName[] animationNames, TransitionCondition[] transitionConditions)
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
        //System.out.println("Before transition condition checks");
        for(TransitionCondition transitionCondition : transitionConditions)
        {
            if(!transitionCondition.isValid()) System.out.println("Transition condition failed"); return;
        }
        System.out.println("After transition condition checks");

        p.setCurrentAnimation(p.getAnimations().get(getRandomAnimationName(animationNames)));
        //p.getCurrentState().exit(p);
        p.setCurrentState(state);
        //p.getCurrentState().enter(p);
    }

    private AnimationName getRandomAnimationName(AnimationName[] animationNames)
    {
        Random random = new Random();

        return animationNames[random.nextInt(animationNames.length)];
    }
}
