package com.dragonballzrpg.states.deprecated.transitions_deprecated_;

import com.dragonballzrpg.gameobjects.GameObject;
import com.dragonballzrpg.enums.AnimationName;
import com.dragonballzrpg.states.State;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Carl on 07/09/2016.
 */
public class Transition_deprecated_
{
    private State state;
    private AnimationName[] animationNames;
    private List<TransitionConditionDep> transitionConditionDeps;

    public Transition_deprecated_(State state, AnimationName[] animationNames, TransitionConditionDep[] transitionConditionDeps)
    {
        this.state = state;
        this.animationNames = animationNames;
        this.transitionConditionDeps = new ArrayList<TransitionConditionDep>();

        for(TransitionConditionDep transitionConditionDep : transitionConditionDeps)
        {
            this.transitionConditionDeps.add(transitionConditionDep);
        }
    }

    public void update(GameObject gameObject)
    {
        for(TransitionConditionDep transitionConditionDep : transitionConditionDeps)
        {
            if(!transitionConditionDep.isValid()) return;
        }

        gameObject.currentAnimation = gameObject.animations.get(getRandomAnimationName(animationNames));
        gameObject.currentState.exit(gameObject);
        gameObject.currentState = state;
        gameObject.currentState.enter(gameObject);
    }

    private AnimationName getRandomAnimationName(AnimationName[] animationNames)
    {
        Random random = new Random();

        return animationNames[random.nextInt(animationNames.length)];
    }
}
