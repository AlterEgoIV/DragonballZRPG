package com.dragonballzrpg.gameobjects.characters;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dragonballzrpg.enums.AnimationName;
import com.dragonballzrpg.utilities.Animation;

import java.util.Map;

/**
 * Created by Carl on 14/07/2017.
 */
public class NPC extends Character
{
    public NPC(Vector2 position, float speed, Map<AnimationName, Animation> animations, Animation currentAnimation)
    {
        super(position, speed, animations, currentAnimation);
    }

    @Override
    public void update()
    {
        
    }

    @Override
    public void render(SpriteBatch batch)
    {

    }
}
