package com.dragonballzrpg.gameobjects.players;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dragonballzrpg.enums.AnimationName;
import com.dragonballzrpg.utilities.Animation;

import java.util.Map;

/**
 * Created by Carl on 09/08/2016.
 */
public class TeenFutureTrunks extends Player
{
    public TeenFutureTrunks(Vector2 position, float speed,
                            Map<AnimationName, Animation> animations, Animation currentAnimation,
                            int up, int down, int left, int right, int melee)
    {
        super(position, speed, animations, currentAnimation, up, down, left, right, melee);

        //animations.get(AnimationName.PUNCH_LEFT_1).getFrame(1).offset.x = -3;
        //animations.get(AnimationName.PUNCH_LEFT_1).getFrame(2).offset.x = -13;
        //animations.get(AnimationName.PUNCH_LEFT_1).getFrame(3).offset.x = -6;
    }

    @Override
    public void update()
    {
        //currentState.update(this);
        currentAnimation.update();
        checkRunWindow();

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
//    protected void initialiseAnimations()
//    {
//        // Animation name sets are grouped by their stringAnimations frame durations
//
//        String[] animationNameSet1 =
//        {
//            "facingDown", "facingLeft", "facingRight"
//        };
//
//        String[] animationNameSet2 =
//        {
//            "walkingUp", "walkingDown", "walkingLeft", "walkingRight",
//            "runningUp", "runningDown", "runningLeft", "runningRight",
//        };
//
//        String[] animationNameSet3 =
//        {
//            "punch1Up", "punch1Down", "punch1Left", "punch1Right",
//            "punch2Up", "punch2Down", "punch2Left", "punch2Right",
//            "kickUp", "kickDown", "kickLeft", "kickRight"
//        };
//
//        String[] animationNameSet4 =
//        {
//            "knockedBackUp", "knockedBackDown", "knockedBackLeft", "knockedBackRight",
//            "kiBlastUp", "kiBlastDown", "kiBlastLeft", "kiBlastRight",
//            "continuousKiBlastUp", "continuousKiBlastDown", "continuousKiBlastLeft", "continuousKiBlastRight",
//            "flyingUp", "transforming"
//        };
//
//        String[] animationNameSet5 =
//        {
//            "facingUp", "dying"
//        };
//
//        for(String animationName : animationNameSet1)
//        {
//            Animation animation = new Animation();
//            animation.loops(true);
//            animation.addFrame(spriteSheetAnimationsExtractor.getAnimationFrame(animationName, 0), 5.0d); // frame 0, duration 5 seconds
//            animation.addFrame(spriteSheetAnimationsExtractor.getAnimationFrame(animationName, 1), .25d); // frame 1, duration .25 seconds
//            stringAnimations.put(animationName, animation);
//        }
//
//        for(String animationName : animationNameSet2)
//        {
//            stringAnimations.put(animationName, new Animation(spriteSheetAnimationsExtractor.getAnimation(animationName), .125d, true)); // name, duration, looping
//        }
//
//        for(String animationName : animationNameSet3)
//        {
//            stringAnimations.put(animationName, new Animation(spriteSheetAnimationsExtractor.getAnimation(animationName), .0675d/*.07d*/)); // name, duration, looping
//        }
//
//        for(String animationName : animationNameSet4)
//        {
//            stringAnimations.put(animationName, new Animation(spriteSheetAnimationsExtractor.getAnimation(animationName), .25d, true));
//        }
//
//        for(String animationName : animationNameSet5)
//        {
//            stringAnimations.put(animationName, new Animation(spriteSheetAnimationsExtractor.getAnimation(animationName), 1, true));
//        }
//
//        currentAnimation = stringAnimations.get("facingDown");
//    }

    @Override
    public void handleKeyDown(int keyCode)
    {
        setKeys(keyCode);
    }

    @Override
    public void handleKeyUp(int keyCode)
    {
        unsetKeys(keyCode);
    }
}
