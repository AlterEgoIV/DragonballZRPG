package com.dragonballzrpg.entities;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dragonballzrpg.enums.AnimationName;
import com.dragonballzrpg.enums.SoundName;
import com.dragonballzrpg.enums.StateName;
import com.dragonballzrpg.states.State;
import com.dragonballzrpg.utilities.Animation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Carl on 09/08/2016.
 */
public abstract class Entity
{
    public Vector2 position;
    public Map<StateName, State> states;
    public State currentState;
    public Map<AnimationName, Animation> animations;
    public Animation currentAnimation;
    public Map<SoundName, Sound> sounds;
    protected double speed;
    protected int width;
    protected int height;

    public Entity(Vector2 position, double speed, Map<AnimationName, Animation> animations, Animation currentAnimation,
                  Map<SoundName, Sound> sounds)
    {
        this.position = position;
        this.speed = speed;
        this.animations = animations;
        this.currentAnimation = currentAnimation;
        this.sounds = sounds;
        width = currentAnimation.getFrame(0).getRegionWidth();
        height = currentAnimation.getFrame(0).getRegionHeight();
        states = new HashMap<StateName, State>();
        currentState = null;
    }

    public abstract void update();
    public abstract void render(SpriteBatch batch);

    public double getSpeed()
    {
        return speed;
    }
}
