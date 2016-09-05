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
        handleRunWindow();

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
        Animation animation = new Animation();

        for(String name : animationNames)
        {
            if(name.equals("facingDown") || name.equals("facingLeft") || name.equals("facingRight"))
            {
                animation.setLoops(true);
                animation.addFrame(animationLoader.load(name, 0), 5.0d); // frame 0, duration 5 seconds
                animation.addFrame(animationLoader.load(name, 1), .25d); // frame 1, duration .25 seconds
                animations.put(name, animation);
                animation = new Animation(); // Clear the Animation
            }
            else
            {
                animations.put(name, new Animation(animationLoader.load(name), .125d, true)); // name, duration, looping
            }
        }

        currentAnimation = animations.get("facingDown");

        /*animations.put("walkingUp", new Animation(animationLoader.load("walkingUp"), .125d, true));
        animations.put("walkingDown", new Animation(animationLoader.load("walkingDown"), .125d, true));
        animations.put("walkingLeft", new Animation(animationLoader.load("walkingLeft"), .125d, true));
        animations.put("walkingRight", new Animation(animationLoader.load("walkingRight"), .125d, true));
        animations.put("runningUp", new Animation(animationLoader.load("runningUp"), .125d, true));
        animations.put("runningDown", new Animation(animationLoader.load("runningDown"), .125d, true));
        animations.put("runningLeft", new Animation(animationLoader.load("runningLeft"), .125d, true));
        animations.put("runningRight", new Animation(animationLoader.load("runningRight"), .125d, true));
        animations.put("facingUp", new Animation(animationLoader.load("facingUp"), 1));*/

        /*animation.setLoops(true);
        animation.addFrame(animationLoader.load("facingDown", 0), 5.0d);
        animation.addFrame(animationLoader.load("facingDown", 1), .25d);
        animations.put("facingDown", animation);

        animation = new Animation();
        animation.setLoops(true);
        animation.addFrame(animationLoader.load("facingLeft", 0), 5.0d);
        animation.addFrame(animationLoader.load("facingLeft", 1), .25d);
        animations.put("facingLeft", animation);

        animation = new Animation();
        animation.setLoops(true);
        animation.addFrame(animationLoader.load("facingRight", 0), 5.0d);
        animation.addFrame(animationLoader.load("facingRight", 1), .25d);
        animations.put("facingRight", animation);*/
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
