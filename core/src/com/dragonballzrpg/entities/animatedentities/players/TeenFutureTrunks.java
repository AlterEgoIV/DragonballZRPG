package com.dragonballzrpg.entities.animatedentities.players;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragonballzrpg.input.GameInputProcessor;
import com.dragonballzrpg.utilities.Animation;
import com.dragonballzrpg.utilities.AnimationLoader;

/**
 * Created by Carl on 09/08/2016.
 */
public class TeenFutureTrunks extends Player
{
    public TeenFutureTrunks(AssetManager assetManager, OrthographicCamera camera, GameInputProcessor inputProcessor)
    {
        this.assetManager = assetManager;
        this.camera = camera;
        this.inputProcessor = inputProcessor;
        animationLoader = new AnimationLoader(assetManager.get("spritesheets/futuretrunks/teenFutureTrunks.png", Texture.class), "spritesheetproperties/teenFutureTrunks.csv");
        initialiseAnimations();
        width = animations.get("facingDown").getCurrentFrame().getRegionWidth();
        height = animations.get("facingDown").getCurrentFrame().getRegionHeight();
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

    @Override
    protected void initialiseAnimations()
    {
        // Animation name sets are grouped by their animations frame durations

        String[] animationNameSet1 =
        {
            "facingDown", "facingLeft", "facingRight"
        };

        String[] animationNameSet2 =
        {
            "walkingUp", "walkingDown", "walkingLeft", "walkingRight",
            "runningUp", "runningDown", "runningLeft", "runningRight",
        };

        String[] animationNameSet3 =
        {
            "punch1Up", "punch1Down", "punch1Left", "punch1Right",
            "punch2Up", "punch2Down", "punch2Left", "punch2Right",
            "kickUp", "kickDown", "kickLeft", "kickRight"
        };

        String[] animationNameSet4 =
        {
            "knockedBackUp", "knockedBackDown", "knockedBackLeft", "knockedBackRight",
            "kiBlastUp", "kiBlastDown", "kiBlastLeft", "kiBlastRight",
            "continuousKiBlastUp", "continuousKiBlastDown", "continuousKiBlastLeft", "continuousKiBlastRight",
            "flyingUp", "transforming"
        };

        String[] animationNameSet5 =
        {
            "facingUp", "dying"
        };

        for(String name : animationNameSet1)
        {
            Animation animation = new Animation();
            animation.setLoops(true);
            animation.addFrame(animationLoader.load(name, 0), 5.0d); // frame 0, duration 5 seconds
            animation.addFrame(animationLoader.load(name, 1), .25d); // frame 1, duration .25 seconds
            animations.put(name, animation);
        }

        for(String name : animationNameSet2)
        {
            animations.put(name, new Animation(animationLoader.load(name), .125d, true)); // name, duration, looping
        }

        for(String name : animationNameSet3)
        {
            animations.put(name, new Animation(animationLoader.load(name), .07d)); // name, duration, looping
        }

        for(String name : animationNameSet4)
        {
            animations.put(name, new Animation(animationLoader.load(name), .25d, true));
        }

        for(String name : animationNameSet5)
        {
            animations.put(name, new Animation(animationLoader.load(name), 1, true));
        }

        currentAnimation = animations.get("facingDown");
    }

    @Override
    public void handleKeyPress(int keyCode)
    {
        setKeys(keyCode);
    }

    @Override
    public void handleKeyRelease(int keyCode)
    {
        unsetKeys(keyCode);
    }
}
