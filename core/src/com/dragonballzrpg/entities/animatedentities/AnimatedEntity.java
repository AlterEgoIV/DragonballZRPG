package com.dragonballzrpg.entities.animatedentities;

import com.badlogic.gdx.assets.AssetManager;
import com.dragonballzrpg.entities.Entity;
import com.dragonballzrpg.enums.AnimationName;
import com.dragonballzrpg.utilities.Animation;
import com.dragonballzrpg.utilities.SpriteSheetAnimationsExtractor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Carl on 11/08/2016.
 */
public abstract class AnimatedEntity extends Entity
{
    protected Map<String, Animation> stringAnimations;
    protected Map<AnimationName, Animation> animations;
    public Animation currentAnimation;
    protected SpriteSheetAnimationsExtractor spriteSheetAnimationsExtractor;

    public AnimatedEntity(AssetManager assetManager)
    {
        super(assetManager);
        stringAnimations = new HashMap<String, Animation>();
    }

    protected abstract void initialiseAnimations();

    public Map<String, Animation> getStringAnimations()
    {
        return stringAnimations;
    }

    public void setCurrentAnimation(Animation currentAnimation)
    {
        this.currentAnimation = currentAnimation;
    }
}
