package com.dragonballzrpg.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dragonballzrpg.enums.AnimationName;
import com.dragonballzrpg.enums.StateName;
import com.dragonballzrpg.states.State;
import com.dragonballzrpg.utilities.Animation;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Carl on 09/08/2016.
 */
public abstract class GameObject
{
    public Vector2 position, velocity;
    public Map<StateName, State> states;
    public State currentState;
    public Map<AnimationName, Animation> animations;
    public Animation currentAnimation;
    protected float speed;
    public int width, height;
    public Rectangle boundingBox;

    public GameObject(Vector2 position, float speed, Map<AnimationName, Animation> animations, Animation currentAnimation)
    {
        this.position = position;
        this.speed = speed;
        this.velocity = new Vector2(0, 0);
        //this.velocity = new Vector2(speed, speed);
        this.animations = animations;
        this.currentAnimation = currentAnimation;
        width = currentAnimation.getFrame(0).getTextureRegion().getRegionWidth();
        height = currentAnimation.getFrame(0).getTextureRegion().getRegionHeight();

        //position.x -= width / 2;
        //position.y += height / 2;
        states = new HashMap<StateName, State>();
        currentState = null;
        boundingBox = new Rectangle((int)position.x - width / 2, (int)position.y - height / 2, width, height);
    }

    public abstract void update();
    public abstract void render(SpriteBatch batch);

    public double getSpeed()
    {
        return speed;
    }
}
