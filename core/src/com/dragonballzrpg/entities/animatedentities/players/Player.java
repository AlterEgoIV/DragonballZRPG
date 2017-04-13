package com.dragonballzrpg.entities.animatedentities.players;

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

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Carl on 09/08/2016.
 */
public abstract class Player extends Entity implements InputHandler
{
    public Map<StateName, State> playerStates;
    protected State currentState;
    protected OrthographicCamera camera;
    private Boolean upKeyPressed;
    private Boolean downKeyPressed;
    private Boolean leftKeyPressed;
    private Boolean rightKeyPressed;
    private Boolean mKeyPressed;
    private Boolean readyToRunUp;
    private Boolean readyToRunDown;
    private Boolean readyToRunLeft;
    private Boolean readyToRunRight;
    private Boolean runWindowOpen;
    private Boolean canAttack;
    private double elapsedRunWindowTime;
    private double runWindowDuration;
    private double runSpeed;

    public Player(Vector2 position, double speed, Map<AnimationName, Animation> animations, Animation currentAnimation,
                  Map<SoundName, Sound> sounds)
    {
        super(position, speed, animations, currentAnimation, sounds);
        speed = 100.0d;
        runSpeed = speed * 2;

        upKeyPressed = false;
        downKeyPressed = false;
        leftKeyPressed = false;
        rightKeyPressed = false;
        mKeyPressed = false;
        readyToRunUp = false;
        readyToRunDown = false;
        readyToRunLeft = false;
        readyToRunRight = false;
        runWindowOpen = false;
        canAttack = true;

        playerStates = new HashMap<StateName, State>();
        initialiseStates();
        //initialiseSounds();

        elapsedRunWindowTime = 0.0d;
        runWindowDuration = .3d;
    }

    private void initialiseStates()
    {
        playerStates.put(StateName.STANDING, new StandingState());
        //playerStates.put(StateName.FACING_UP, new FacingUpState());
        //playerStates.put(StateName.FACING_DOWN, new FacingDownState());
        //playerStates.put(StateName.FACING_LEFT, new FacingLeftState());
        //playerStates.put(StateName.FACING_RIGHT, new FacingRightState());
        playerStates.put(StateName.WALKING_UP, new WalkingUpState());
        playerStates.put(StateName.WALKING_DOWN, new WalkingDownState());
        playerStates.put(StateName.WALKING_LEFT, new WalkingLeftState());
        playerStates.put(StateName.WALKING_RIGHT, new WalkingRightState());
        playerStates.put(StateName.WALKING_UP_LEFT, new WalkingUpLeftState());
        playerStates.put(StateName.WALKING_UP_RIGHT, new WalkingUpRightState());
        playerStates.put(StateName.WALKING_DOWN_LEFT, new WalkingDownLeftState());
        playerStates.put(StateName.WALKING_DOWN_RIGHT, new WalkingDownRightState());
        //playerStates.put("walkingEastNorth", new WalkingEastNorthState());
        //playerStates.put("walkingWestNorth", new WalkingWestNorthState());
        //playerStates.put("walkingEastSouth", new WalkingEastSouthState());
        //playerStates.put("walkingWestSouth", new WalkingWestSouthState());
        playerStates.put(StateName.RUNNING_UP, new RunningUpState());
        playerStates.put(StateName.RUNNING_DOWN, new RunningDownState());
        playerStates.put(StateName.RUNNING_LEFT, new RunningLeftState());
        playerStates.put(StateName.RUNNING_RIGHT, new RunningRightState());
        playerStates.put(StateName.RUNNING_UP_LEFT, new RunningUpLeftState());
        playerStates.put(StateName.RUNNING_UP_RIGHT, new RunningUpRightState());
        playerStates.put(StateName.RUNNING_DOWN_LEFT, new RunningDownLeftState());
        playerStates.put(StateName.RUNNING_DOWN_RIGHT, new RunningDownRightState());
        //playerStates.put("runningEastNorth", new RunningEastNorthState());
        //playerStates.put("runningWestNorth", new RunningWestNorthState());
        //playerStates.put("runningEastSouth", new RunningEastSouthState());
        //playerStates.put("runningWestSouth", new RunningWestSouthState());
        playerStates.put(StateName.MELEEING_UP, new MeleeingUpState());
        playerStates.put(StateName.MELEEING_DOWN, new MeleeingDownState());
        playerStates.put(StateName.MELEEING_LEFT, new MeleeingLeftState());
        playerStates.put(StateName.MELEEING_RIGHT, new MeleeingRightState());

        for(State state : playerStates.values())
        {
            state.initialiseTransitions(this);
        }

        currentState = playerStates.get(StateName.STANDING);
    }

//    private void initialiseSounds()
//    {
//        sounds.put(SoundName.MELEE_1, (Sound)assetManager.get("sounds/melee1.wav"));
//        sounds.put(SoundName.MELEE_2, (Sound)assetManager.get("sounds/melee2.wav"));
//        sounds.put(SoundName.RUNNING, (Sound)assetManager.get("sounds/running.wav"));
//    }

    protected void setKeys(int keyCode)
    {
        switch(keyCode)
        {
            case Input.Keys.UP: upKeyPressed = true; break;
            case Input.Keys.DOWN: downKeyPressed = true; break;
            case Input.Keys.LEFT: leftKeyPressed = true; break;
            case Input.Keys.RIGHT: rightKeyPressed = true; break;
            case Input.Keys.M: mKeyPressed = true; break;
            default: return;
        }

        if(!runWindowOpen) runWindowOpen = true;
    }

    protected void unsetKeys(int keyCode)
    {
        switch(keyCode)
        {
            case Input.Keys.UP: upKeyPressed = false; if(runWindowOpen) readyToRunUp = true; break;
            case Input.Keys.DOWN: downKeyPressed = false; if(runWindowOpen) readyToRunDown = true; break;
            case Input.Keys.LEFT: leftKeyPressed = false; if(runWindowOpen) readyToRunLeft = true; break;
            case Input.Keys.RIGHT: rightKeyPressed = false; if(runWindowOpen) readyToRunRight = true; break;
            case Input.Keys.M: mKeyPressed = false; canAttack = true; break;
            default: break;
        }
    }

    protected void checkRunWindow()
    {
        if(runWindowOpen)
        {
            elapsedRunWindowTime += Gdx.graphics.getDeltaTime();

            if(elapsedRunWindowTime >= runWindowDuration)
            {
                elapsedRunWindowTime = 0.0d;
                runWindowOpen = false;
                readyToRunUp = false;
                readyToRunDown = false;
                readyToRunLeft = false;
                readyToRunRight = false;
            }
        }
    }

    public double getRunSpeed()
    {
        return runSpeed;
    }

    public State getCurrentState()
    {
        return currentState;
    }

    public void setCurrentState(State currentState)
    {
        this.currentState = currentState;
    }

    public Map<StateName, State> getPlayerStates()
    {
        return playerStates;
    }

    public Boolean isUpKeyPressed()
    {
        return upKeyPressed;
    }

    public Boolean isDownKeyPressed()
    {
        return downKeyPressed;
    }

    public Boolean isLeftKeyPressed()
    {
        return leftKeyPressed;
    }

    public Boolean isRightKeyPressed()
    {
        return rightKeyPressed;
    }

    public Boolean isMKeyPressed()
    {
        return mKeyPressed;
    }

    public Boolean isReadyToRunUp()
    {
        return readyToRunUp;
    }

    public Boolean isReadyToRunDown()
    {
        return readyToRunDown;
    }

    public Boolean isReadyToRunLeft()
    {
        return readyToRunLeft;
    }

    public Boolean isReadyToRunRight()
    {
        return readyToRunRight;
    }

    public Boolean canAttack()
    {
        return canAttack;
    }

    public void setCanAttack(boolean canAttack)
    {
        this.canAttack = canAttack;
    }

    public Map<AnimationName, Animation> getAnimations()
    {
        return animations;
    }
}
