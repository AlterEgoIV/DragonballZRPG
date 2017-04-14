package com.dragonballzrpg.states;

import com.dragonballzrpg.entities.Entity;
import com.dragonballzrpg.entities.players.Player;
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

    public void update(Entity entity)
    {
        for(TransitionCondition transitionCondition : transitionConditions)
        {
            if(!transitionCondition.isValid()) return;
        }

        entity.currentAnimation = entity.animations.get(getRandomAnimationName(animationNames));
        entity.currentState.exit(entity);
        entity.currentState = state;
        entity.currentState.enter(entity);
    }

    private AnimationName getRandomAnimationName(AnimationName[] animationNames)
    {
        Random random = new Random();

        return animationNames[random.nextInt(animationNames.length)];
    }
}
