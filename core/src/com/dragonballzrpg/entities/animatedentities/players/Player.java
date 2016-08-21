package com.dragonballzrpg.entities.animatedentities.players;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.dragonballzrpg.directions.Direction;
import com.dragonballzrpg.directions.East;
import com.dragonballzrpg.directions.NoDirection;
import com.dragonballzrpg.directions.North;
import com.dragonballzrpg.directions.NorthEast;
import com.dragonballzrpg.directions.NorthWest;
import com.dragonballzrpg.directions.South;
import com.dragonballzrpg.directions.SouthEast;
import com.dragonballzrpg.directions.SouthWest;
import com.dragonballzrpg.directions.West;
import com.dragonballzrpg.entities.animatedentities.AnimatedEntity;
import com.dragonballzrpg.input.GameInputProcessor;
import com.dragonballzrpg.input.InputHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Carl on 09/08/2016.
 */
public abstract class Player extends AnimatedEntity implements InputHandler
{
    protected Map<String, Direction> directions;
    protected Direction currentDirection;
    protected GameInputProcessor inputProcessor;
    protected OrthographicCamera camera;

    public Player()
    {
        speed = 100.0d;
        directions = new HashMap<String, Direction>();
        directions.put("north", new North());
        directions.put("south", new South());
        directions.put("east", new East());
        directions.put("west", new West());
        directions.put("northeast", new NorthEast());
        directions.put("northwest", new NorthWest());
        directions.put("southeast", new SouthEast());
        directions.put("southwest", new SouthWest());
        directions.put("nodirection", new NoDirection());
        currentDirection = directions.get("nodirection");
    }

    public Map<String, Direction> getDirections()
    {
        return directions;
    }

    public void setDirections(Map<String, Direction> directions)
    {
        this.directions = directions;
    }

    public void setCurrentDirection(Direction currentDirection)
    {
        this.currentDirection = currentDirection;
    }
}
