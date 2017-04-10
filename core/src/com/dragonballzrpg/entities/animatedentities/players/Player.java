package com.dragonballzrpg.entities.animatedentities.players;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.dragonballzrpg.entities.animatedentities.AnimatedEntity;
import com.dragonballzrpg.enums.StateName;
import com.dragonballzrpg.input.GameInputProcessor;
import com.dragonballzrpg.input.InputHandler;
import com.dragonballzrpg.states.State;
import com.dragonballzrpg.states.playerstates.attackingstates.meleeingstates.MeleeingRightState;
import com.dragonballzrpg.states.playerstates.attackingstates.meleeingstates.MeleeingUpState;
import com.dragonballzrpg.states.playerstates.attackingstates.meleeingstates.MeleeingDownState;
import com.dragonballzrpg.states.playerstates.attackingstates.meleeingstates.MeleeingLeftState;
import com.dragonballzrpg.states.playerstates.facingstates.FacingRightState;
import com.dragonballzrpg.states.playerstates.facingstates.FacingUpState;
import com.dragonballzrpg.states.playerstates.facingstates.FacingDownState;
import com.dragonballzrpg.states.playerstates.facingstates.FacingLeftState;
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
import com.dragonballzrpg.wrappers.Bool;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Carl on 09/08/2016.
 */
public abstract class Player extends AnimatedEntity implements InputHandler
{
    public Map<StateName, State> playerStates;
    protected State currentState;
    protected GameInputProcessor inputProcessor;
    protected OrthographicCamera camera;
    private Bool upKeyPressed;
    private Bool downKeyPressed;
    private Bool leftKeyPressed;
    private Bool rightKeyPressed;
    private Bool mKeyPressed;
    private Bool readyToRunUp;
    private Bool readyToRunDown;
    private Bool readyToRunLeft;
    private Bool readyToRunRight;
    private Bool runWindowOpen;
    private Bool canAttack;
    private double elapsedRunWindowTime;
    private double runWindowDuration;
    private double runSpeed;

    public Player(AssetManager assetManager)
    {
        super(assetManager);
        speed = 100.0d;
        runSpeed = speed * 2;

        upKeyPressed = new Bool();
        downKeyPressed = new Bool();
        leftKeyPressed = new Bool();
        rightKeyPressed = new Bool();
        mKeyPressed = new Bool();
        readyToRunUp = new Bool();
        readyToRunDown = new Bool();
        readyToRunLeft = new Bool();
        readyToRunRight = new Bool();
        runWindowOpen = new Bool();
        canAttack = new Bool(true);

        playerStates = new HashMap<StateName, State>();
        initialiseStates();
        initialiseSounds();

        elapsedRunWindowTime = 0.0d;
        runWindowDuration = .3d;
    }

    private void initialiseStates()
    {
        playerStates.put(StateName.FACING_UP, new FacingUpState());
        playerStates.put(StateName.FACING_DOWN, new FacingDownState());
        playerStates.put(StateName.FACING_LEFT, new FacingLeftState());
        playerStates.put(StateName.FACING_RIGHT, new FacingRightState());
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

        currentState = playerStates.get("facingSouth");
    }

    private void initialiseSounds()
    {
        sounds.put("melee1", (Sound)assetManager.get("sounds/melee1.wav"));
        sounds.put("melee2", (Sound)assetManager.get("sounds/melee2.wav"));
        sounds.put("running", (Sound)assetManager.get("sounds/running.wav"));
    }

    protected void setKeys(int keyCode)
    {
        switch(keyCode)
        {
            case Input.Keys.UP: upKeyPressed.setValue(true); break;
            case Input.Keys.DOWN: downKeyPressed.setValue(true); break;
            case Input.Keys.LEFT: leftKeyPressed.setValue(true); break;
            case Input.Keys.RIGHT: rightKeyPressed.setValue(true); break;
            case Input.Keys.M: mKeyPressed.setValue(true); break;
            default: return;
        }

        if(!runWindowOpen.getValue()) runWindowOpen.setValue(true);
    }

    protected void unsetKeys(int keyCode)
    {
        switch(keyCode)
        {
            case Input.Keys.UP: upKeyPressed.setValue(false); if(runWindowOpen.getValue()) readyToRunUp.setValue(true); break;
            case Input.Keys.DOWN: downKeyPressed.setValue(false); if(runWindowOpen.getValue()) readyToRunDown.setValue(true); break;
            case Input.Keys.LEFT: leftKeyPressed.setValue(false); if(runWindowOpen.getValue()) readyToRunLeft.setValue(true); break;
            case Input.Keys.RIGHT: rightKeyPressed.setValue(false); if(runWindowOpen.getValue()) readyToRunRight.setValue(true); break;
            case Input.Keys.M: mKeyPressed.setValue(false); canAttack.setValue(true); break;
            default: break;
        }
    }

    protected void checkRunWindow()
    {
        if(runWindowOpen.getValue())
        {
            elapsedRunWindowTime += Gdx.graphics.getDeltaTime();

            if(elapsedRunWindowTime >= runWindowDuration)
            {
                elapsedRunWindowTime = 0.0d;
                runWindowOpen.setValue(false);
                readyToRunUp.setValue(false);
                readyToRunDown.setValue(false);
                readyToRunLeft.setValue(false);
                readyToRunRight.setValue(false);
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

    public Bool getUpKeyPressed()
    {
        return upKeyPressed;
    }

    public Bool getDownKeyPressed()
    {
        return downKeyPressed;
    }

    public Bool getLeftKeyPressed()
    {
        return leftKeyPressed;
    }

    public Bool getRightKeyPressed()
    {
        return rightKeyPressed;
    }

    public Bool getMKeyPressed()
    {
        return mKeyPressed;
    }

    public Bool getReadyToRunUp()
    {
        return readyToRunUp;
    }

    public Bool getReadyToRunDown()
    {
        return readyToRunDown;
    }

    public Bool getReadyToRunLeft()
    {
        return readyToRunLeft;
    }

    public Bool getReadyToRunRight()
    {
        return readyToRunRight;
    }

    public Bool getCanAttack()
    {
        return canAttack;
    }
}
