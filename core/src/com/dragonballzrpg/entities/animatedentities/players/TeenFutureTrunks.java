package com.dragonballzrpg.entities.animatedentities.players;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragonballzrpg.utilities.Animation;
import com.dragonballzrpg.utilities.AnimationLoader;

/**
 * Created by Carl on 09/08/2016.
 */
public class TeenFutureTrunks extends Player
{
    public TeenFutureTrunks(AssetManager assetManager)
    {
        animationLoader = new AnimationLoader(assetManager.get("spritesheets/futuretrunks/teenFutureTrunks.png", Texture.class), "spritesheetproperties/teenFutureTrunks.csv");
        initialiseAnimations();
    }

    @Override
    public void update()
    {
        currentAnimation.update();
    }

    @Override
    public void render(SpriteBatch batch)
    {
        batch.draw(currentAnimation.getCurrentFrame(), position.x, position.y);
    }

    @Override
    protected void initialiseAnimations()
    {
        Animation animation = new Animation();

        animations.put("walkingUp", new Animation(animationLoader.load("walkingUp"), .25d, true));
        animations.put("walkingDown", new Animation(animationLoader.load("walkingDown"), .25d, true));
        animations.put("walkingLeft", new Animation(animationLoader.load("walkingLeft"), .25d, true));
        animations.put("walkingRight", new Animation(animationLoader.load("walkingRight"), .25d, true));
        animations.put("runningUp", new Animation(animationLoader.load("runningUp"), .25d, true));
        animations.put("runningDown", new Animation(animationLoader.load("runningDown"), .25d, true));
        animations.put("runningLeft", new Animation(animationLoader.load("runningLeft"), .25d, true));
        animations.put("runningRight", new Animation(animationLoader.load("runningRight"), .25d, true));
        animations.put("facingUp", new Animation(animationLoader.load("facingUp"), 1));

        animation.setLoops(true);
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
        animations.put("facingRight", animation);

        currentAnimation = animations.get("facingDown");
    }
}
