package com.dragonballzrpg.entities.animatedentities;

import com.dragonballzrpg.entities.Entity;
import com.dragonballzrpg.utilities.Animation;
import com.dragonballzrpg.utilities.AnimationLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Carl on 11/08/2016.
 */
public abstract class AnimatedEntity extends Entity
{
    protected Map<String, Animation> animations;
    protected Animation currentAnimation;
    protected AnimationLoader animationLoader;
    protected List<String> animationNames;

    public AnimatedEntity()
    {
        animations = new HashMap<String, Animation>();
        animationNames = new ArrayList<String>();
    }

    protected abstract void initialiseAnimations();

    public Map<String, Animation> getAnimations()
    {
        return animations;
    }

    public void setCurrentAnimation(Animation currentAnimation)
    {
        this.currentAnimation = currentAnimation;
    }
}
