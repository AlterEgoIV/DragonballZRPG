package com.dragonballzrpg.entities.animatedentities.players;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.dragonballzrpg.entities.animatedentities.AnimatedEntity;
import com.dragonballzrpg.input.GameInputProcessor;
import com.dragonballzrpg.input.InputHandler;
import com.dragonballzrpg.states.State;
import com.dragonballzrpg.states.playerstates.Standing;
import com.dragonballzrpg.states.playerstates.attackingstates.AttackingDownState;
import com.dragonballzrpg.states.playerstates.attackingstates.AttackingLeftState;
import com.dragonballzrpg.states.playerstates.attackingstates.AttackingRightState;
import com.dragonballzrpg.states.playerstates.attackingstates.AttackingUpState;
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
import com.dragonballzrpg.wrappers.Bool;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Carl on 09/08/2016.
 */
public abstract class Player extends AnimatedEntity implements InputHandler
{
    public Map<String, State> playerStates;
    //protected KeyState[] keyStates;
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
    /*private boolean upKeyPressed;
    private boolean downKeyPressed;
    private boolean leftKeyPressed;
    private boolean rightKeyPressed;
    private boolean mKeyPressed;
    private boolean readyToRunUp;
    private boolean readyToRunDown;
    private boolean readyToRunLeft;
    private boolean readyToRunRight;
    private boolean runWindowOpen;
    public boolean canAttack;*/
    private double elapsedRunWindowTime;
    private double runWindowDuration;
    private double runSpeed;

    public Player()
    {
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

        /*upKeyPressed = false;
        downKeyPressed = false;
        leftKeyPressed = false;
        rightKeyPressed = false;
        mKeyPressed = false;
        readyToRunUp = false;
        readyToRunDown = false;
        readyToRunLeft = false;
        readyToRunRight = false;
        runWindowOpen = false;
        canAttack = true;*/
        elapsedRunWindowTime = 0.0d;
        runWindowDuration = .3d;
    }

    private void initialiseStates()
    {
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
        playerStates.put("attackingUp", new AttackingUpState());
        playerStates.put("attackingDown", new AttackingDownState());
        playerStates.put("attackingLeft", new AttackingLeftState());
        playerStates.put("attackingRight", new AttackingRightState());

        for(State state : playerStates.values())
        {
            state.initialiseTransitions(this);
        }

        System.out.println("Player States initialised.");

        /*for(State state : playerStates.values())
        {
            state.initialiseTransitions(playerStates);
        }*/

        currentState = playerStates.get("standing");

        System.out.println("standing");
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

        /*switch(keyCode)
        {
            case Input.Keys.UP: upKeyPressed = true; break;
            case Input.Keys.DOWN: downKeyPressed = true; break;
            case Input.Keys.LEFT: leftKeyPressed = true; break;
            case Input.Keys.RIGHT: rightKeyPressed = true; break;
            case Input.Keys.M: mKeyPressed = true; break;
            default: return;
        }

        if(!runWindowOpen) runWindowOpen = true;*/
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

        /*switch(keyCode)
        {
            case Input.Keys.UP: upKeyPressed = false; if(runWindowOpen) readyToRunUp = true; break;
            case Input.Keys.DOWN: downKeyPressed = false; if(runWindowOpen) readyToRunDown = true; break;
            case Input.Keys.LEFT: leftKeyPressed = false; if(runWindowOpen) readyToRunLeft = true; break;
            case Input.Keys.RIGHT: rightKeyPressed = false; if(runWindowOpen) readyToRunRight = true; break;
            case Input.Keys.M: mKeyPressed = false; canAttack = true; break;
            default: break;
        }*/
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
        System.out.println("Right key returned.");
        return rightKeyPressed;

        //System.out.println("Returned null.");

        //return null;
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

    /*public boolean isUpKeyPressed()
    {
        return upKeyPressed.isTrue();
    }

    public boolean isDownKeyPressed()
    {
        return downKeyPressed.isTrue();
    }

    public boolean isLeftKeyPressed()
    {
        return leftKeyPressed.isTrue();
    }

    public boolean isRightKeyPressed()
    {
        return rightKeyPressed.isTrue();
    }

    public boolean isMKeyPressed()
    {
        return mKeyPressed.isTrue();
    }

    public boolean isReadyToRunUp()
    {
        return readyToRunUp.isTrue();
    }

    public boolean isReadyToRunDown()
    {
        return readyToRunDown.isTrue();
    }

    public boolean isReadyToRunLeft()
    {
        return readyToRunLeft.isTrue();
    }

    public boolean isReadyToRunRight()
    {
        return readyToRunRight.isTrue();
    }*/
}
