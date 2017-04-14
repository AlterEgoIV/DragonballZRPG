package com.dragonballzrpg.entities.players;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.dragonballzrpg.entities.Entity;
import com.dragonballzrpg.enums.AnimationName;
import com.dragonballzrpg.enums.SoundName;
import com.dragonballzrpg.enums.StateName;
import com.dragonballzrpg.input.InputHandler;
import com.dragonballzrpg.states.State;
import com.dragonballzrpg.states.playerstates.StandingState;
import com.dragonballzrpg.states.playerstates.attackingstates.meleeingstates.MeleeingRightState;
import com.dragonballzrpg.states.playerstates.attackingstates.meleeingstates.MeleeingUpState;
import com.dragonballzrpg.states.playerstates.attackingstates.meleeingstates.MeleeingDownState;
import com.dragonballzrpg.states.playerstates.attackingstates.meleeingstates.MeleeingLeftState;
import com.dragonballzrpg.states.playerstates.runningstates.RunningRightState;
import com.dragonballzrpg.states.playerstates.runningstates.RunningUpRightState;
import com.dragonballzrpg.states.playerstates.runningstates.RunningUpState;
import com.dragonballzrpg.states.playerstates.runningstates.RunningUpLeftState;
import com.dragonballzrpg.states.playerstates.runningstates.RunningDownRightState;
import com.dragonballzrpg.states.playerstates.runningstates.RunningDownState;
import com.dragonballzrpg.states.playerstates.runningstates.RunningDownLeftState;
import com.dragonballzrpg.states.playerstates.runningstates.RunningLeftState;
import com.dragonballzrpg.states.playerstates.walkingstates.WalkingRightState;
import com.dragonballzrpg.states.playerstates.walkingstates.WalkingUpRightState;
import com.dragonballzrpg.states.playerstates.walkingstates.WalkingUpState;
import com.dragonballzrpg.states.playerstates.walkingstates.WalkingUpLeftState;
import com.dragonballzrpg.states.playerstates.walkingstates.WalkingDownRightState;
import com.dragonballzrpg.states.playerstates.walkingstates.WalkingDownState;
import com.dragonballzrpg.states.playerstates.walkingstates.WalkingDownLeftState;
import com.dragonballzrpg.states.playerstates.walkingstates.WalkingLeftState;
import com.dragonballzrpg.utilities.Animation;
import com.dragonballzrpg.wrappers.Bool;

import java.util.Map;

/**
 * Created by Carl on 09/08/2016.
 */
public abstract class Player extends Entity implements InputHandler
{
    protected OrthographicCamera camera;
    public Bool isUpKeyPressed;
    public Bool isDownKeyPressed;
    public Bool isLeftKeyPressed;
    public Bool isRightKeyPressed;
    public Bool isMeleeKeyPressed;
    public Bool isReadyToRunUp;
    public Bool isReadyToRunDown;
    public Bool isReadyToRunLeft;
    public Bool isReadyToRunRight;
    public Bool runWindowOpen;
    public Bool canAttack;
    private double elapsedRunWindowTime;
    private double runWindowDuration;
    private double runSpeed;
    private int up, down, left, right, melee;

    public Player(Vector2 position, double speed, Map<AnimationName, Animation> animations, Animation currentAnimation,
                  Map<SoundName, Sound> sounds, int up, int down, int left, int right, int melee)
    {
        super(position, speed, animations, currentAnimation, sounds);
        runSpeed = speed * 2;

        isUpKeyPressed = new Bool();
        isDownKeyPressed = new Bool();
        isLeftKeyPressed = new Bool();
        isRightKeyPressed = new Bool();
        isMeleeKeyPressed = new Bool();
        isReadyToRunUp = new Bool();
        isReadyToRunDown = new Bool();
        isReadyToRunLeft = new Bool();
        isReadyToRunRight = new Bool();
        runWindowOpen = new Bool();
        canAttack = new Bool(true);

        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        this.melee = melee;

        initialiseStates();

        elapsedRunWindowTime = 0.0d;
        runWindowDuration = .3d;
    }

    private void initialiseStates()
    {
        states.put(StateName.STANDING, new StandingState());
        states.put(StateName.WALKING_UP, new WalkingUpState());
        states.put(StateName.WALKING_DOWN, new WalkingDownState());
        states.put(StateName.WALKING_LEFT, new WalkingLeftState());
        states.put(StateName.WALKING_RIGHT, new WalkingRightState());
        states.put(StateName.WALKING_UP_LEFT, new WalkingUpLeftState());
        states.put(StateName.WALKING_UP_RIGHT, new WalkingUpRightState());
        states.put(StateName.WALKING_DOWN_LEFT, new WalkingDownLeftState());
        states.put(StateName.WALKING_DOWN_RIGHT, new WalkingDownRightState());
        states.put(StateName.RUNNING_UP, new RunningUpState());
        states.put(StateName.RUNNING_DOWN, new RunningDownState());
        states.put(StateName.RUNNING_LEFT, new RunningLeftState());
        states.put(StateName.RUNNING_RIGHT, new RunningRightState());
        states.put(StateName.RUNNING_UP_LEFT, new RunningUpLeftState());
        states.put(StateName.RUNNING_UP_RIGHT, new RunningUpRightState());
        states.put(StateName.RUNNING_DOWN_LEFT, new RunningDownLeftState());
        states.put(StateName.RUNNING_DOWN_RIGHT, new RunningDownRightState());
        states.put(StateName.MELEEING_UP, new MeleeingUpState());
        states.put(StateName.MELEEING_DOWN, new MeleeingDownState());
        states.put(StateName.MELEEING_LEFT, new MeleeingLeftState());
        states.put(StateName.MELEEING_RIGHT, new MeleeingRightState());

        for(State state : states.values())
        {
            state.initialiseTransitions(this);
        }

        currentState = states.get(StateName.STANDING);
    }

    protected void setKeys(int keyCode)
    {
        if(keyCode == up)
        {
            isUpKeyPressed.set(true);
        }
        else if(keyCode == down)
        {
            isDownKeyPressed.set(true);
        }
        else if(keyCode == left)
        {
            isLeftKeyPressed.set(true);
        }
        else if(keyCode == right)
        {
            isRightKeyPressed.set(true);
        }
        else if(keyCode == melee)
        {
            isMeleeKeyPressed.set(true);
        }
        else
        {
            return;
        }

//        switch(keyCode)
//        {
//            case Input.Keys.UP: isUpKeyPressed.set(true); break;
//            case Input.Keys.DOWN: isDownKeyPressed.set(true); break;
//            case Input.Keys.LEFT: isLeftKeyPressed.set(true); break;
//            case Input.Keys.RIGHT: isRightKeyPressed.set(true); break;
//            case Input.Keys.M: isMeleeKeyPressed.set(true); break;
//
//            default: return;
//        }

        if(!runWindowOpen.value()) runWindowOpen.set(true);
    }

    protected void unsetKeys(int keyCode)
    {
        if(keyCode == up)
        {
            isUpKeyPressed.set(false);
            if(runWindowOpen.value()) isReadyToRunUp.set(true);
        }
        else if(keyCode == down)
        {
            isDownKeyPressed.set(false);
            if(runWindowOpen.value()) isReadyToRunDown.set(true);
        }
        else if(keyCode == left)
        {
            isLeftKeyPressed.set(false);
            if(runWindowOpen.value()) isReadyToRunLeft.set(true);
        }
        else if(keyCode == right)
        {
            isRightKeyPressed.set(false);
            if(runWindowOpen.value()) isReadyToRunRight.set(true);
        }
        else if(keyCode == melee)
        {
            isMeleeKeyPressed.set(false);
            canAttack.set(true);
        }

//        switch(keyCode)
//        {
//            case Input.Keys.UP: isUpKeyPressed.set(false); if(runWindowOpen.value()) isReadyToRunUp.set(true); break;
//            case Input.Keys.DOWN: isDownKeyPressed.set(false); if(runWindowOpen.value()) isReadyToRunDown.set(true); break;
//            case Input.Keys.LEFT: isLeftKeyPressed.set(false); if(runWindowOpen.value()) isReadyToRunLeft.set(true); break;
//            case Input.Keys.RIGHT: isRightKeyPressed.set(false); if(runWindowOpen.value()) isReadyToRunRight.set(true); break;
//            case Input.Keys.M: isMeleeKeyPressed.set(false); canAttack.set(true); break;
//
//            default: break;
//        }
    }

    protected void checkRunWindow()
    {
        if(runWindowOpen.value())
        {
            elapsedRunWindowTime += Gdx.graphics.getDeltaTime();

            if(elapsedRunWindowTime >= runWindowDuration)
            {
                elapsedRunWindowTime = 0.0d;
                runWindowOpen.set(false);
                isReadyToRunUp.set(false);
                isReadyToRunDown.set(false);
                isReadyToRunLeft.set(false);
                isReadyToRunRight.set(false);
            }
        }
    }

    public double getRunSpeed()
    {
        return runSpeed;
    }
}
