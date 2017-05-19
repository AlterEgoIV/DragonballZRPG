package com.dragonballzrpg.states.playerstates.walkingstates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragonballzrpg.gameobjects.GameObject;
import com.dragonballzrpg.gameobjects.players.Player;
import com.dragonballzrpg.enums.AnimationName;
import com.dragonballzrpg.enums.StateName;
import com.dragonballzrpg.states.State;
import com.dragonballzrpg.states.Transition;
import com.dragonballzrpg.states.TransitionCondition;

/**
 * Created by Carl on 24/08/2016.
 */
public class WalkingRightState extends State
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

//        transitions.add(new Transition(p.getPlayerStates().get("walkingWest"), new String[]{"walkingLeft"},
//        new TransitionCondition[]
//        {
//        new TransitionCondition(p.isLeftKeyPressed(), true),
//        new TransitionCondition(p.isRightKeyPressed(), false)
//        }));
//
//        transitions.add(new Transition(p.getPlayerStates().get("walkingEastNorth"), new String[]{"walkingRight"},
//        new TransitionCondition[]
//        {
//        new TransitionCondition(p.isUpKeyPressed(), true),
//        new TransitionCondition(p.isRightKeyPressed(), true)
//        }));
//
//        transitions.add(new Transition(p.getPlayerStates().get("walkingEastSouth"), new String[]{"walkingRight"},
//        new TransitionCondition[]
//        {
//        new TransitionCondition(p.isDownKeyPressed(), true),
//        new TransitionCondition(p.isRightKeyPressed(), true)
//        }));
//
//        transitions.add(new Transition(p.getPlayerStates().get("meleeingEast"), new String[]{"punch1Right", "punch2Right", "kickRight"},
//        new TransitionCondition[]
//        {
//        new TransitionCondition(p.isMeleeKeyPressed(), true),
//        new TransitionCondition(p.canAttack(), true)
//        }));
    }

    @Override
    public void enter(GameObject gameObject)
    {

    }

    @Override
    public void exit(GameObject gameObject)
    {

    }

    @Override
    public void update(GameObject gameObject)
    {
        for(Transition transition : transitions)
        {
            transition.update(gameObject);
        }

        gameObject.position.x += gameObject.getSpeed() * Gdx.graphics.getDeltaTime();
    }

    @Override
    public void render(GameObject gameObject, SpriteBatch batch)
    {

    }
}
