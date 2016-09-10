package com.dragonballzrpg.states;

import com.dragonballzrpg.entities.animatedentities.players.Player;

/**
 * Created by Carl on 07/09/2016.
 */
public class Transition
{
    private State state;
    private String animation;
    private boolean up, down, left, right /*m, canAttack*/;

    public Transition(State state, String animation, boolean up, boolean down, boolean left, boolean right/*boolean m, boolean canAttack*/)
    {
        this.state = state;
        this.animation = animation;
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        //this.m = m;
        //this.canAttack = canAttack;
    }

    public void update(Player p)
    {
        if(p.isUpKeyPressed() == up && p.isDownKeyPressed() == down &&
           p.isLeftKeyPressed() == left && p.isRightKeyPressed() == right /*&&
           p.isMKeyPressed() == m && p.canAttack = canAttack*/)
        {
            //if(p.canAttack) p.canAttack = false;
            p.setCurrentAnimation(p.getAnimations().get(animation));
            p.setCurrentState(state);
        }
    }

    public State getState()
    {
        return state;
    }

    public void setAnimation(String animation)
    {
        this.animation = animation;
    }
}
