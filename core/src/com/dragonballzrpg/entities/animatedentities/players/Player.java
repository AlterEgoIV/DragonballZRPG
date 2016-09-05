package com.dragonballzrpg.entities.animatedentities.players;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.dragonballzrpg.entities.animatedentities.AnimatedEntity;
import com.dragonballzrpg.input.GameInputProcessor;
import com.dragonballzrpg.input.InputHandler;
import com.dragonballzrpg.states.State;
import com.dragonballzrpg.states.playerstates.Standing;
import com.dragonballzrpg.states.playerstates.runningstates.RunningEast;
import com.dragonballzrpg.states.playerstates.runningstates.RunningEastNorth;
import com.dragonballzrpg.states.playerstates.runningstates.RunningEastSouth;
import com.dragonballzrpg.states.playerstates.runningstates.RunningNorth;
import com.dragonballzrpg.states.playerstates.runningstates.RunningNorthEast;
import com.dragonballzrpg.states.playerstates.runningstates.RunningNorthWest;
import com.dragonballzrpg.states.playerstates.runningstates.RunningSouth;
import com.dragonballzrpg.states.playerstates.runningstates.RunningSouthEast;
import com.dragonballzrpg.states.playerstates.runningstates.RunningSouthWest;
import com.dragonballzrpg.states.playerstates.runningstates.RunningWest;
import com.dragonballzrpg.states.playerstates.runningstates.RunningWestNorth;
import com.dragonballzrpg.states.playerstates.runningstates.RunningWestSouth;
import com.dragonballzrpg.states.playerstates.walkingstates.WalkingEast;
import com.dragonballzrpg.states.playerstates.walkingstates.WalkingEastNorth;
import com.dragonballzrpg.states.playerstates.walkingstates.WalkingEastSouth;
import com.dragonballzrpg.states.playerstates.walkingstates.WalkingNorth;
import com.dragonballzrpg.states.playerstates.walkingstates.WalkingNorthEast;
import com.dragonballzrpg.states.playerstates.walkingstates.WalkingNorthWest;
import com.dragonballzrpg.states.playerstates.walkingstates.WalkingSouth;
import com.dragonballzrpg.states.playerstates.walkingstates.WalkingSouthEast;
import com.dragonballzrpg.states.playerstates.walkingstates.WalkingSouthWest;
import com.dragonballzrpg.states.playerstates.walkingstates.WalkingWest;
import com.dragonballzrpg.states.playerstates.walkingstates.WalkingWestNorth;
import com.dragonballzrpg.states.playerstates.walkingstates.WalkingWestSouth;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Carl on 09/08/2016.
 */
public abstract class Player extends AnimatedEntity implements InputHandler
{
    private Map<String, State> playerStates;
    protected State currentState;
    protected GameInputProcessor inputProcessor;
    protected OrthographicCamera camera;
    private boolean upKeyPressed;
    private boolean downKeyPressed;
    private boolean leftKeyPressed;
    private boolean rightKeyPressed;
    private boolean readyToRunUp;
    private boolean readyToRunDown;
    private boolean readyToRunLeft;
    private boolean readyToRunRight;
    private boolean runWindowOpen;
    private double elapsedRunWindowTime;
    private double runWindowDuration;
    private double runSpeed;

    public Player()
    {
        animationNames.add("facingUp");
        animationNames.add("facingDown");
        animationNames.add("facingLeft");
        animationNames.add("facingRight");
        animationNames.add("walkingUp");
        animationNames.add("walkingDown");
        animationNames.add("walkingLeft");
        animationNames.add("walkingRight");
        animationNames.add("runningUp");
        animationNames.add("runningDown");
        animationNames.add("runningLeft");
        animationNames.add("runningRight");

        speed = 100.0d;
        runSpeed = speed * 2;

        playerStates = new HashMap<String, State>();
        playerStates.put("standing", new Standing());
        playerStates.put("walkingNorth", new WalkingNorth());
        playerStates.put("walkingSouth", new WalkingSouth());
        playerStates.put("walkingEast", new WalkingEast());
        playerStates.put("walkingWest", new WalkingWest());
        playerStates.put("walkingNorthEast", new WalkingNorthEast());
        playerStates.put("walkingNorthWest", new WalkingNorthWest());
        playerStates.put("walkingSouthEast", new WalkingSouthEast());
        playerStates.put("walkingSouthWest", new WalkingSouthWest());
        playerStates.put("walkingEastNorth", new WalkingEastNorth());
        playerStates.put("walkingWestNorth", new WalkingWestNorth());
        playerStates.put("walkingEastSouth", new WalkingEastSouth());
        playerStates.put("walkingWestSouth", new WalkingWestSouth());
        playerStates.put("runningNorth", new RunningNorth());
        playerStates.put("runningSouth", new RunningSouth());
        playerStates.put("runningEast", new RunningEast());
        playerStates.put("runningWest", new RunningWest());
        playerStates.put("runningNorthEast", new RunningNorthEast());
        playerStates.put("runningNorthWest", new RunningNorthWest());
        playerStates.put("runningSouthEast", new RunningSouthEast());
        playerStates.put("runningSouthWest", new RunningSouthWest());
        playerStates.put("runningEastNorth", new RunningEastNorth());
        playerStates.put("runningWestNorth", new RunningWestNorth());
        playerStates.put("runningEastSouth", new RunningEastSouth());
        playerStates.put("runningWestSouth", new RunningWestSouth());
        currentState = playerStates.get("standing");

        upKeyPressed = false;
        downKeyPressed = false;
        leftKeyPressed = false;
        rightKeyPressed = false;
        readyToRunUp = false;
        readyToRunDown = false;
        readyToRunLeft = false;
        readyToRunRight = false;
        runWindowOpen = false;
        elapsedRunWindowTime = 0.0d;
        runWindowDuration = .4d;
    }

    protected void setKeys(int keyCode)
    {
        switch(keyCode)
        {
            case Input.Keys.UP: upKeyPressed = true; if(!runWindowOpen) runWindowOpen = true; break;
            case Input.Keys.DOWN: downKeyPressed = true; if(!runWindowOpen) runWindowOpen = true; break;
            case Input.Keys.LEFT: leftKeyPressed = true; if(!runWindowOpen) runWindowOpen = true; break;
            case Input.Keys.RIGHT: rightKeyPressed = true; if(!runWindowOpen) runWindowOpen = true; break;
        }
    }

    protected void unsetKeys(int keyCode)
    {
        switch(keyCode)
        {
            case Input.Keys.UP: upKeyPressed = false; if(runWindowOpen) readyToRunUp = true; break;
            case Input.Keys.DOWN: downKeyPressed = false; if(runWindowOpen) readyToRunDown = true; break;
            case Input.Keys.LEFT: leftKeyPressed = false; if(runWindowOpen) readyToRunLeft = true; break;
            case Input.Keys.RIGHT: rightKeyPressed = false; if(runWindowOpen) readyToRunRight = true; break;
        }
    }

    protected void handleRunWindow()
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

    public void setCurrentState(State currentState)
    {
        this.currentState = currentState;
    }

    public Map<String, State> getPlayerStates()
    {
        return playerStates;
    }

    public boolean isUpKeyPressed()
    {
        return upKeyPressed;
    }

    public boolean isDownKeyPressed()
    {
        return downKeyPressed;
    }

    public boolean isLeftKeyPressed()
    {
        return leftKeyPressed;
    }

    public boolean isRightKeyPressed()
    {
        return rightKeyPressed;
    }

    public boolean isReadyToRunUp()
    {
        return readyToRunUp;
    }

    public boolean isReadyToRunDown()
    {
        return readyToRunDown;
    }

    public boolean isReadyToRunLeft()
    {
        return readyToRunLeft;
    }

    public boolean isReadyToRunRight()
    {
        return readyToRunRight;
    }
}
