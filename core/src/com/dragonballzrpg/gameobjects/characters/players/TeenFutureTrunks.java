package com.dragonballzrpg.gameobjects.characters.players;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dragonballzrpg.enums.AnimationName;
import com.dragonballzrpg.gameobjects.characters.Player;
import com.dragonballzrpg.utilities.Animation;

import java.util.Map;

/**
 * Created by Carl on 09/08/2016.
 */
public class TeenFutureTrunks extends Player
{
    public TeenFutureTrunks(Vector2 position, float speed,
                            Map<AnimationName, Animation> animations, Animation currentAnimation)
    {
        super(position, speed, animations, currentAnimation);

        //animations.get(AnimationName.PUNCH_LEFT_1).getFrame(1).offset.x = -3;
        //animations.get(AnimationName.PUNCH_LEFT_1).getFrame(2).offset.x = -13;
        //animations.get(AnimationName.PUNCH_LEFT_1).getFrame(3).offset.x = -6;
    }

    @Override
    public void update()
    {
        //currentState.update(this);
        currentAnimation.update();
        //checkRunWindow();

        //System.out.println("Position.x: " + position.x);
        //System.out.println("Position.y: " + position.y);
        velocity.x = 0;
        velocity.y = 0;

        if(Gdx.input.isKeyPressed(Input.Keys.UP))
        {
            //position.y += speed * Gdx.graphics.getDeltaTime();
            velocity.y += speed;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
        {
            //position.y -= speed * Gdx.graphics.getDeltaTime();
            velocity.y -= speed;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
        {
            //position.x -= speed * Gdx.graphics.getDeltaTime();
            velocity.x -= speed;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
        {
            //position.x += speed * Gdx.graphics.getDeltaTime();
            velocity.x += speed;
        }
    }

    @Override
    public void render(SpriteBatch batch)
    {
        batch.draw(currentAnimation.getCurrentFrame().getTextureRegion(),
        ((int)position.x + currentAnimation.getCurrentFrame().getXOffset()) - width / 2,
        ((int)position.y + currentAnimation.getCurrentFrame().getYOffset()) - height / 2);
        //batch.draw(currentAnimation.getCurrentFrame(), (int)position.x - width / 2, (int)position.y - height / 2);
    }

//    @Override
//    public void handleKeyDown(int keyCode)
//    {
//        setKeys(keyCode);
//    }
//
//    @Override
//    public void handleKeyUp(int keyCode)
//    {
//        unsetKeys(keyCode);
//    }
}
