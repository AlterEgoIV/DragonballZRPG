package com.dragonballzrpg.entities.animatedentities.players;

import com.badlogic.gdx.Gdx;
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
        currentDirection.update(this);
        currentAnimation.update();

        position.x += ((currentDirection.getX() * speed) * Gdx.graphics.getDeltaTime());
        position.y += ((currentDirection.getY() * speed) * Gdx.graphics.getDeltaTime());

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

    @Override
    public void handleKeyPress(int keyCode)
    {

    }

    @Override
    public void handleKeyRelease(int keyCode)
    {

    }
}
