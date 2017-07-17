package com.dragonballzrpg.states.playerstates.walkingstates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragonballzrpg.gameobjects.GameObject;
import com.dragonballzrpg.gameobjects.characters.Player;
import com.dragonballzrpg.states.State;
import com.dragonballzrpg.states.Transition;

/**
 * Created by Carl on 24/08/2016.
 */
//public class WalkingDownState extends State
//{
//    @Override
//    public void initialiseTransitions(Player p)
//    {
////        transitions.add(new Transition(p.getPlayerStates().get("facingSouth"), new String[]{"facingDown"},
////        new TransitionCondition[]
////        {
////            new TransitionCondition(p.isDownKeyPressed(), false)
////        }));
////
////        transitions.add(new Transition(p.getPlayerStates().get("walkingNorth"), new String[]{"walkingUp"},
////        new TransitionCondition[]
////        {
////        new TransitionCondition(p.isUpKeyPressed(), true),
////        new TransitionCondition(p.isDownKeyPressed(), false)
////        }));
////
////        transitions.add(new Transition(p.getPlayerStates().get("walkingSouthEast"), new String[]{"walkingDown"},
////        new TransitionCondition[]
////        {
////        new TransitionCondition(p.isDownKeyPressed(), true),
////        new TransitionCondition(p.isRightKeyPressed(), true)
////        }));
////
////        transitions.add(new Transition(p.getPlayerStates().get("walkingSouthWest"), new String[]{"walkingDown"},
////        new TransitionCondition[]
////        {
////        new TransitionCondition(p.isDownKeyPressed(), true),
////        new TransitionCondition(p.isLeftKeyPressed(), true)
////        }));
////
////        transitions.add(new Transition(p.getPlayerStates().get("meleeingSouth"), new String[]{"punch1Down", "punch2Down", "kickDown"},
////        new TransitionCondition[]
////        {
////        new TransitionCondition(p.isMeleeKeyPressed(), true),
////        new TransitionCondition(p.canAttack(), true)
////        }));
//    }
//
//    @Override
//    public void enter(GameObject gameObject)
//    {
//
//    }
//
//    @Override
//    public void exit(GameObject gameObject)
//    {
//
//    }
//
//    @Override
//    public void update(GameObject gameObject)
//    {
//        for(Transition transition : transitions)
//        {
//            transition.update((Player) gameObject);
//        }
//
//        // Down && Left
//        /*if(!((Player)gameObject).isUpKeyPressed() && ((Player)gameObject).isDownKeyPressed() &&
//           ((Player)gameObject).isLeftKeyPressed() && !((Player)gameObject).isRightKeyPressed())
//        {
//            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("walkingDown"));
//            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("walkingSouthWest"));
//        }
//
//        // Down && Right
//        if(!((Player)gameObject).isUpKeyPressed() && ((Player)gameObject).isDownKeyPressed() &&
//           !((Player)gameObject).isLeftKeyPressed() && ((Player)gameObject).isRightKeyPressed())
//        {
//            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("walkingDown"));
//            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("walkingSouthEast"));
//        }
//
//        if(!((Player)gameObject).isDownKeyPressed())
//        {
//            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("facingDown"));
//            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("standing"));
//        }*/
//
//        ((Player) gameObject).position.y -= gameObject.getSpeed() * Gdx.graphics.getDeltaTime();
//    }
//
//    @Override
//    public void render(GameObject gameObject, SpriteBatch batch)
//    {
//        //batch.draw(((Player)gameObject).currentAnimation.getCurrentFrame(), (int)gameObject.position.x, (int)gameObject.position.y);
////        batch.draw(((Player)gameObject).currentAnimation.getCurrentFrame(),
////        (int)((Player)gameObject).position.x - ((Player)gameObject).currentAnimation.getCurrentFrame().getRegionWidth() / 2,
////        (int)((Player)gameObject).position.y - ((Player)gameObject).currentAnimation.getCurrentFrame().getRegionHeight() / 2);
//    }
//}
