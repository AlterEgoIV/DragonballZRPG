package com.dragonballzrpg.states.playerstates.runningstates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragonballzrpg.gameobjects.GameObject;
import com.dragonballzrpg.gameobjects.players.Player;
import com.dragonballzrpg.enums.AnimationName;
import com.dragonballzrpg.enums.SoundName;
import com.dragonballzrpg.enums.StateName;
import com.dragonballzrpg.states.State;
import com.dragonballzrpg.states.Transition;
import com.dragonballzrpg.states.TransitionCondition;

/**
 * Created by Carl on 24/08/2016.
 */
public class RunningRightState extends State
{
    @Override
    public void initialiseTransitions(Player player)
    {
        transitions.add(new Transition(player.states.get(StateName.STANDING), new AnimationName[]{AnimationName.FACE_RIGHT},
        new TransitionCondition[]
        {
            new TransitionCondition(player.isRightKeyPressed, false)
        }));

        transitions.add(new Transition(player.states.get(StateName.MELEEING_RIGHT),
                        new AnimationName[]{AnimationName.PUNCH_RIGHT_1, AnimationName.PUNCH_RIGHT_2, AnimationName.KICK_RIGHT},
        new TransitionCondition[]
        {
            new TransitionCondition(player.isMeleeKeyPressed, true),
            new TransitionCondition(player.canAttack, true)
        }));
    }

    @Override
    public void enter(GameObject gameObject)
    {
        //gameObject.sounds.get(SoundName.RUNNING).loop();
    }

    @Override
    public void exit(GameObject gameObject)
    {
        //gameObject.sounds.get(SoundName.RUNNING).stop();
    }

    @Override
    public void update(GameObject gameObject)
    {
        for(Transition transition : transitions)
        {
            transition.update(gameObject);
        }

        // Up && Right
        /*if(((Player)gameObject).isUpKeyPressed() && !((Player)gameObject).isDownKeyPressed() &&
           !((Player)gameObject).isLeftKeyPressed() && ((Player)gameObject).isRightKeyPressed())
        {
            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("runningRight"));
            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("runningEastNorth"));
        }

        // Down && Right
        if(!((Player)gameObject).isUpKeyPressed() && ((Player)gameObject).isDownKeyPressed() &&
           !((Player)gameObject).isLeftKeyPressed() && ((Player)gameObject).isRightKeyPressed())
        {
            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("runningRight"));
            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("runningEastSouth"));
        }

        if(!((Player)gameObject).isRightKeyPressed())
        {
            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("facingRight"));
            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("standing"));
        }*/

        ((Player) gameObject).position.x += ((Player) gameObject).getRunSpeed() * Gdx.graphics.getDeltaTime();
    }

    @Override
    public void render(GameObject gameObject, SpriteBatch batch)
    {

    }
}