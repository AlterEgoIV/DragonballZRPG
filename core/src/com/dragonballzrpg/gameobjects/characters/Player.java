package com.dragonballzrpg.gameobjects.characters;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dragonballzrpg.actions.Action;
import com.dragonballzrpg.actions.ActionProcessor;
import com.dragonballzrpg.actions.PlayerActionProcessor;
import com.dragonballzrpg.controllers.PlayerController;
import com.dragonballzrpg.enums.KeyName;
import com.dragonballzrpg.gameobjects.GameObject;
import com.dragonballzrpg.enums.AnimationName;
import com.dragonballzrpg.utilities.Animation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Carl on 09/08/2016.
 */
public class Player extends Character
{
    private double runSpeed;
    //private List<Action> playerActions;
    //public ActionProcessor actionProcessor;
    //public PlayerController playerController;

    public Player(Vector2 position, float speed, Map<AnimationName, Animation> animations, Animation currentAnimation)
    {
        super(position, speed, animations, currentAnimation);

        runSpeed = speed * 2;
        //playerActions = new ArrayList<Action>();
        //actionProcessor = new PlayerActionProcessor(this);
        //playerController = new PlayerController(this, inputKeyMap);
    }

    @Override
    public void update()
    {
        controller.update();
        currentAnimation.update();
    }

    @Override
    public void render(SpriteBatch batch)
    {
        batch.draw(currentAnimation.getCurrentFrame().getTextureRegion(),
        ((int)position.x + currentAnimation.getCurrentFrame().getXOffset()) - width / 2,
        ((int)position.y + currentAnimation.getCurrentFrame().getYOffset()) - height / 2);
    }

//    public void addAction(PlayerAction playerAction, Animation animation)
//    {
//        playerActions.add(playerAction);
//    }

    public double getRunSpeed()
    {
        return runSpeed;
    }
}
