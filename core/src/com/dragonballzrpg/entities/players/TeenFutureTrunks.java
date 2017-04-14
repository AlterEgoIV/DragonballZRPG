package com.dragonballzrpg.entities.players;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dragonballzrpg.enums.AnimationName;
import com.dragonballzrpg.enums.SoundName;
import com.dragonballzrpg.utilities.Animation;

import java.util.Map;

/**
 * Created by Carl on 09/08/2016.
 */
public class TeenFutureTrunks extends Player
{
//    public TeenFutureTrunks(AssetManager assetManager, OrthographicCamera camera, GameInputProcessor inputProcessor)
//    {
//        //super(assetManager);
//        this.camera = camera;
//        this.inputProcessor = inputProcessor;
//        //spriteSheetAnimationsExtractor = new SpriteSheetAnimationsExtractor(assetManager.get("spritesheets/futuretrunks/teenFutureTrunks.png", Texture.class), "spritesheetproperties/teenFutureTrunks.csv");
//        //initialiseAnimations();
//        //width = stringAnimations.get("facingDown").getCurrentFrame().getRegionWidth();
//        //height = stringAnimations.get("facingDown").getCurrentFrame().getRegionHeight();
//    }

    public TeenFutureTrunks(OrthographicCamera camera, Vector2 position, double speed,
                            Map<AnimationName, Animation> animations, Animation currentAnimation,
                            Map<SoundName, Sound> sounds)
    {
        super(position, speed, animations, currentAnimation, sounds);
        this.camera = camera;
        //this.animations = animations;
        //this.sounds = sounds;
        //currentAnimation = animations.get(AnimationName.FACE_DOWN);
        //width = stringAnimations.get("facingDown").getCurrentFrame().getRegionWidth();
        //height = stringAnimations.get("facingDown").getCurrentFrame().getRegionHeight();
    }

    @Override
    public void update()
    {
        currentState.update(this);
        currentAnimation.update();
        checkRunWindow();

        camera.position.x = (int)position.x + width / 2.0f;
        camera.position.y = (int)position.y + height / 2.0f;
    }

    @Override
    public void render(SpriteBatch batch)
    {
        batch.draw(currentAnimation.getCurrentFrame(), (int)position.x, (int)position.y);
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
