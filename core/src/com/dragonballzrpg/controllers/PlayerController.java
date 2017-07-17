package com.dragonballzrpg.controllers;

import com.dragonballzrpg.gameobjects.characters.Player;
import com.dragonballzrpg.states.controllerstates.IdleState;
import com.dragonballzrpg.states.controllerstates.MovePlayerUpState;

/**
 * Created by Carl on 14/07/2017.
 */
public class PlayerController extends Controller
{
    public boolean moveUp, moveDown, moveLeft, moveRight, melee;

    public PlayerController(Player player)
    {
        super(player);

        moveUp = false;
        moveDown = false;
        moveLeft = false;
        moveRight = false;
        melee = false;

        states.add(new IdleState(this));
        states.add(new MovePlayerUpState(this));

        currentState = states.get(0);
    }
}
