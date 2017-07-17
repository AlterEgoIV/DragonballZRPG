package com.dragonballzrpg.gameobjects.characters;

import com.badlogic.gdx.math.Vector2;
import com.dragonballzrpg.gameobjects.GameObject;
import com.dragonballzrpg.enums.AnimationName;
import com.dragonballzrpg.utilities.Animation;

import java.util.Map;

/**
 * Created by Carl on 09/08/2016.
 */
public abstract class Player extends GameObject
{
//    public Bool isUpKeyPressed;
//    public Bool isDownKeyPressed;
//    public Bool isLeftKeyPressed;
//    public Bool isRightKeyPressed;
//    public Bool isMeleeKeyPressed;
//    public Bool isReadyToRunUp;
//    public Bool isReadyToRunDown;
//    public Bool isReadyToRunLeft;
//    public Bool isReadyToRunRight;
//    public Bool runWindowOpen;
//    public Bool canAttack;
//    private double elapsedRunWindowTime;
//    private double runWindowDuration;
    private double runSpeed;
//    private int up, down, left, right, melee;

    public Player(Vector2 position, float speed, Map<AnimationName, Animation> animations, Animation currentAnimation)
    {
        super(position, speed, animations, currentAnimation);
        runSpeed = speed * 2;

//        isUpKeyPressed = new Bool();
//        isDownKeyPressed = new Bool();
//        isLeftKeyPressed = new Bool();
//        isRightKeyPressed = new Bool();
//        isMeleeKeyPressed = new Bool();
//        isReadyToRunUp = new Bool();
//        isReadyToRunDown = new Bool();
//        isReadyToRunLeft = new Bool();
//        isReadyToRunRight = new Bool();
//        runWindowOpen = new Bool();
//        canAttack = new Bool(true);
//
//        this.up = up;
//        this.down = down;
//        this.left = left;
//        this.right = right;
//        this.melee = melee;
//
//        initialiseStates();
//
//        elapsedRunWindowTime = 0.0d;
//        runWindowDuration = .3d;
    }

    private void initialiseStates()
    {
//        states.put(StateName.STANDING, new StandingState());
//        states.put(StateName.WALKING_UP, new WalkingUpState());
//        states.put(StateName.WALKING_DOWN, new WalkingDownState());
//        states.put(StateName.WALKING_LEFT, new WalkingLeftState());
//        states.put(StateName.WALKING_RIGHT, new WalkingRightState());
//        states.put(StateName.WALKING_UP_LEFT, new WalkingUpLeftState());
//        states.put(StateName.WALKING_UP_RIGHT, new WalkingUpRightState());
//        states.put(StateName.WALKING_DOWN_LEFT, new WalkingDownLeftState());
//        states.put(StateName.WALKING_DOWN_RIGHT, new WalkingDownRightState());
//        states.put(StateName.RUNNING_UP, new RunningUpState());
//        states.put(StateName.RUNNING_DOWN, new RunningDownState());
//        states.put(StateName.RUNNING_LEFT, new RunningLeftState());
//        states.put(StateName.RUNNING_RIGHT, new RunningRightState());
//        states.put(StateName.RUNNING_UP_LEFT, new RunningUpLeftState());
//        states.put(StateName.RUNNING_UP_RIGHT, new RunningUpRightState());
//        states.put(StateName.RUNNING_DOWN_LEFT, new RunningDownLeftState());
//        states.put(StateName.RUNNING_DOWN_RIGHT, new RunningDownRightState());
//        states.put(StateName.MELEEING_UP, new MeleeingUpState());
//        states.put(StateName.MELEEING_DOWN, new MeleeingDownState());
//        states.put(StateName.MELEEING_LEFT, new MeleeingLeftState());
//        states.put(StateName.MELEEING_RIGHT, new MeleeingRightState());
//
//        for(State state : states.values())
//        {
//            state.initialiseTransitions(this);
//        }
//
//        currentState = states.get(StateName.STANDING);
    }

//    protected void setKeys(int keyCode)
//    {
//        if(keyCode == up)
//        {
//            isUpKeyPressed.set(true);
//        }
//        else if(keyCode == down)
//        {
//            isDownKeyPressed.set(true);
//        }
//        else if(keyCode == left)
//        {
//            isLeftKeyPressed.set(true);
//        }
//        else if(keyCode == right)
//        {
//            isRightKeyPressed.set(true);
//        }
//        else if(keyCode == melee)
//        {
//            isMeleeKeyPressed.set(true);
//        }
//        else
//        {
//            return;
//        }
//
////        switch(keyCode)
////        {
////            case Input.Keys.UP: isUpKeyPressed.set(true); break;
////            case Input.Keys.DOWN: isDownKeyPressed.set(true); break;
////            case Input.Keys.LEFT: isLeftKeyPressed.set(true); break;
////            case Input.Keys.RIGHT: isRightKeyPressed.set(true); break;
////            case Input.Keys.M: isMeleeKeyPressed.set(true); break;
////
////            default: return;
////        }
//
//        if(!runWindowOpen.value()) runWindowOpen.set(true);
//    }
//
//    protected void unsetKeys(int keyCode)
//    {
//        if(keyCode == up)
//        {
//            isUpKeyPressed.set(false);
//            if(runWindowOpen.value()) isReadyToRunUp.set(true);
//        }
//        else if(keyCode == down)
//        {
//            isDownKeyPressed.set(false);
//            if(runWindowOpen.value()) isReadyToRunDown.set(true);
//        }
//        else if(keyCode == left)
//        {
//            isLeftKeyPressed.set(false);
//            if(runWindowOpen.value()) isReadyToRunLeft.set(true);
//        }
//        else if(keyCode == right)
//        {
//            isRightKeyPressed.set(false);
//            if(runWindowOpen.value()) isReadyToRunRight.set(true);
//        }
//        else if(keyCode == melee)
//        {
//            isMeleeKeyPressed.set(false);
//            canAttack.set(true);
//        }
//
////        switch(keyCode)
////        {
////            case Input.Keys.UP: isUpKeyPressed.set(false); if(runWindowOpen.value()) isReadyToRunUp.set(true); break;
////            case Input.Keys.DOWN: isDownKeyPressed.set(false); if(runWindowOpen.value()) isReadyToRunDown.set(true); break;
////            case Input.Keys.LEFT: isLeftKeyPressed.set(false); if(runWindowOpen.value()) isReadyToRunLeft.set(true); break;
////            case Input.Keys.RIGHT: isRightKeyPressed.set(false); if(runWindowOpen.value()) isReadyToRunRight.set(true); break;
////            case Input.Keys.M: isMeleeKeyPressed.set(false); canAttack.set(true); break;
////
////            default: break;
////        }
//    }
//
//    protected void checkRunWindow()
//    {
//        if(runWindowOpen.value())
//        {
//            elapsedRunWindowTime += Gdx.graphics.getDeltaTime();
//
//            if(elapsedRunWindowTime >= runWindowDuration)
//            {
//                elapsedRunWindowTime = 0.0d;
//                runWindowOpen.set(false);
//                isReadyToRunUp.set(false);
//                isReadyToRunDown.set(false);
//                isReadyToRunLeft.set(false);
//                isReadyToRunRight.set(false);
//            }
//        }
//    }

    public double getRunSpeed()
    {
        return runSpeed;
    }
}
