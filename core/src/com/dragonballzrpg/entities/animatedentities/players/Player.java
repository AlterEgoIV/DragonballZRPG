package com.dragonballzrpg.entities.animatedentities.players;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.dragonballzrpg.entities.animatedentities.AnimatedEntity;
import com.dragonballzrpg.input.GameInputProcessor;
import com.dragonballzrpg.input.InputHandler;
import com.dragonballzrpg.states.State;
import com.dragonballzrpg.states.playerstates.attackingstates.meleeingstates.MeleeingEastState;
import com.dragonballzrpg.states.playerstates.attackingstates.meleeingstates.MeleeingNorthState;
import com.dragonballzrpg.states.playerstates.attackingstates.meleeingstates.MeleeingSouthState;
import com.dragonballzrpg.states.playerstates.attackingstates.meleeingstates.MeleeingWestState;
import com.dragonballzrpg.states.playerstates.facingstates.FacingEastState;
import com.dragonballzrpg.states.playerstates.facingstates.FacingNorthState;
import com.dragonballzrpg.states.playerstates.facingstates.FacingSouthState;
import com.dragonballzrpg.states.playerstates.facingstates.FacingWestState;
import com.dragonballzrpg.states.playerstates.runningstates.RunningEastNorthState;
import com.dragonballzrpg.states.playerstates.runningstates.RunningEastSouthState;
import com.dragonballzrpg.states.playerstates.runningstates.RunningEastState;
import com.dragonballzrpg.states.playerstates.runningstates.RunningNorthEastState;
import com.dragonballzrpg.states.playerstates.runningstates.RunningNorthState;
import com.dragonballzrpg.states.playerstates.runningstates.RunningNorthWestState;
import com.dragonballzrpg.states.playerstates.runningstates.RunningSouthEastState;
import com.dragonballzrpg.states.playerstates.runningstates.RunningSouthState;
import com.dragonballzrpg.states.playerstates.runningstates.RunningSouthWestState;
import com.dragonballzrpg.states.playerstates.runningstates.RunningWestNorthState;
import com.dragonballzrpg.states.playerstates.runningstates.RunningWestSouthState;
import com.dragonballzrpg.states.playerstates.runningstates.RunningWestState;
import com.dragonballzrpg.states.playerstates.walkingstates.WalkingEastNorthState;
import com.dragonballzrpg.states.playerstates.walkingstates.WalkingEastSouthState;
import com.dragonballzrpg.states.playerstates.walkingstates.WalkingEastState;
import com.dragonballzrpg.states.playerstates.walkingstates.WalkingNorthEastState;
import com.dragonballzrpg.states.playerstates.walkingstates.WalkingNorthState;
import com.dragonballzrpg.states.playerstates.walkingstates.WalkingNorthWestState;
import com.dragonballzrpg.states.playerstates.walkingstates.WalkingSouthEastState;
import com.dragonballzrpg.states.playerstates.walkingstates.WalkingSouthState;
import com.dragonballzrpg.states.playerstates.walkingstates.WalkingSouthWestState;
import com.dragonballzrpg.states.playerstates.walkingstates.WalkingWestNorthState;
import com.dragonballzrpg.states.playerstates.walkingstates.WalkingWestSouthState;
import com.dragonballzrpg.states.playerstates.walkingstates.WalkingWestState;
import com.dragonballzrpg.wrappers.Bool;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Carl on 09/08/2016.
 */
public abstract class Player extends AnimatedEntity implements InputHandler
{
    public Map<String, State> playerStates;
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

        playerStates = new HashMap<String, State>();
        initialiseStates();
        initialiseSounds();

        elapsedRunWindowTime = 0.0d;
        runWindowDuration = .3d;
    }

    private void initialiseStates()
    {
        playerStates.put("facingNorth", new FacingNorthState());
        playerStates.put("facingSouth", new FacingSouthState());
        playerStates.put("facingEast", new FacingEastState());
        playerStates.put("facingWest", new FacingWestState());
        playerStates.put("walkingNorth", new WalkingNorthState());
        playerStates.put("walkingSouth", new WalkingSouthState());
        playerStates.put("walkingEast", new WalkingEastState());
        playerStates.put("walkingWest", new WalkingWestState());
        playerStates.put("walkingNorthEast", new WalkingNorthEastState());
        playerStates.put("walkingNorthWest", new WalkingNorthWestState());
        playerStates.put("walkingSouthEast", new WalkingSouthEastState());
        playerStates.put("walkingSouthWest", new WalkingSouthWestState());
        playerStates.put("walkingEastNorth", new WalkingEastNorthState());
        playerStates.put("walkingWestNorth", new WalkingWestNorthState());
        playerStates.put("walkingEastSouth", new WalkingEastSouthState());
        playerStates.put("walkingWestSouth", new WalkingWestSouthState());
        playerStates.put("runningNorth", new RunningNorthState());
        playerStates.put("runningSouth", new RunningSouthState());
        playerStates.put("runningEast", new RunningEastState());
        playerStates.put("runningWest", new RunningWestState());
        playerStates.put("runningNorthEast", new RunningNorthEastState());
        playerStates.put("runningNorthWest", new RunningNorthWestState());
        playerStates.put("runningSouthEast", new RunningSouthEastState());
        playerStates.put("runningSouthWest", new RunningSouthWestState());
        playerStates.put("runningEastNorth", new RunningEastNorthState());
        playerStates.put("runningWestNorth", new RunningWestNorthState());
        playerStates.put("runningEastSouth", new RunningEastSouthState());
        playerStates.put("runningWestSouth", new RunningWestSouthState());
        playerStates.put("meleeingNorth", new MeleeingNorthState());
        playerStates.put("meleeingSouth", new MeleeingSouthState());
        playerStates.put("meleeingEast", new MeleeingEastState());
        playerStates.put("meleeingWest", new MeleeingWestState());

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

    public Map<String, State> getPlayerStates()
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
