package com.dragonballzrpg.gameobjects.characters;

import com.badlogic.gdx.math.Vector2;
import com.dragonballzrpg.controllers.Controller;
import com.dragonballzrpg.enums.AnimationName;
import com.dragonballzrpg.gameobjects.GameObject;
import com.dragonballzrpg.utilities.Animation;

import java.util.Map;

/**
 * Created by Carl on 14/07/2017.
 */
public abstract class Character extends GameObject
{
    protected Controller controller;
    protected LifeEssence lifeEssence;

    public Character(Vector2 position, float speed, Map<AnimationName, Animation> animations, Animation currentAnimation)
    {
        super(position, speed, animations, currentAnimation);
    }
}
