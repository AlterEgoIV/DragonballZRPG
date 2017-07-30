package com.dragonballzrpg.states.controllerstates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragonballzrpg.controllers.Controller;
import com.dragonballzrpg.controllers.PlayerController;
import com.dragonballzrpg.gameobjects.GameObject;
import com.dragonballzrpg.gameobjects.characters.Player;
import com.dragonballzrpg.states.State;

/**
 * Created by Carl on 15/07/2017.
 */
public class MovePlayerUpState extends ControllerState
{
    public MovePlayerUpState(Controller controller)
    {
        super(controller);
    }

    @Override
    public void enter()
    {

    }

    @Override
    public void exit()
    {

    }

    @Override
    public State update()
    {
        return this;
    }

    @Override
    public void render(SpriteBatch batch)
    {

    }
}
