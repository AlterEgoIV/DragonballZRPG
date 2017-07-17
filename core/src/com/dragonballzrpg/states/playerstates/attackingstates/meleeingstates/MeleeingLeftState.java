package com.dragonballzrpg.states.playerstates.attackingstates.meleeingstates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragonballzrpg.gameobjects.GameObject;
import com.dragonballzrpg.gameobjects.characters.Player;
import com.dragonballzrpg.states.State;
import com.dragonballzrpg.states.Transition;

/**
 * Created by Carl on 06/09/2016.
 */
//public class MeleeingLeftState extends State
//{
//    @Override
//    public void initialiseTransitions(Player p)
//    {
////        transitions.add(new Transition(p.getPlayerStates().get("facingWest"), new String[]{"facingLeft"},
////        new TransitionCondition[]
////        {
////        new TransitionCondition(p.isRightKeyPressed(), false)
////        }));
////
////        transitions.add(new Transition(p.getPlayerStates().get("walkingNorth"), new String[]{"walkingUp"},
////        new TransitionCondition[]
////        {
////        new TransitionCondition(p.isUpKeyPressed(), true)
////        }));
////
////        transitions.add(new Transition(p.getPlayerStates().get("walkingSouth"), new String[]{"walkingDown"},
////        new TransitionCondition[]
////        {
////        new TransitionCondition(p.isDownKeyPressed(), true)
////        }));
////
////        transitions.add(new Transition(p.getPlayerStates().get("walkingWest"), new String[]{"walkingLeft"},
////        new TransitionCondition[]
////        {
////        new TransitionCondition(p.isLeftKeyPressed(), true)
////        }));
////
////        transitions.add(new Transition(p.getPlayerStates().get("walkingEast"), new String[]{"walkingRight"},
////        new TransitionCondition[]
////        {
////        new TransitionCondition(p.isRightKeyPressed(), true)
////        }));
////
////        transitions.add(new Transition(p.getPlayerStates().get("walkingWestNorth"), new String[]{"walkingLeft"},
////        new TransitionCondition[]
////        {
////        new TransitionCondition(p.isUpKeyPressed(), true),
////        new TransitionCondition(p.isLeftKeyPressed(), true)
////        }));
////
////        transitions.add(new Transition(p.getPlayerStates().get("walkingEastNorth"), new String[]{"walkingRight"},
////        new TransitionCondition[]
////        {
////        new TransitionCondition(p.isUpKeyPressed(), true),
////        new TransitionCondition(p.isRightKeyPressed(), true)
////        }));
////
////        transitions.add(new Transition(p.getPlayerStates().get("walkingWestSouth"), new String[]{"walkingLeft"},
////        new TransitionCondition[]
////        {
////        new TransitionCondition(p.isDownKeyPressed(), true),
////        new TransitionCondition(p.isLeftKeyPressed(), true)
////        }));
////
////        transitions.add(new Transition(p.getPlayerStates().get("walkingEastSouth"), new String[]{"walkingRight"},
////        new TransitionCondition[]
////        {
////        new TransitionCondition(p.isDownKeyPressed(), true),
////        new TransitionCondition(p.isRightKeyPressed(), true)
////        }));
//    }
//
//    @Override
//    public void enter(GameObject gameObject)
//    {
//        Player p = (Player) gameObject;
//
//        //p.canAttack().set(false);
//        //p.setCanAttack(false);
//        //p.getSounds().get(getRandomValue(new String[]{"melee1", "melee2"})).play();
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
//        currentDuration += Gdx.graphics.getDeltaTime();
//
//        if(currentDuration >= ((Player) gameObject).currentAnimation.getDuration())
//        {
//            currentDuration = 0.0d;
//            ((Player) gameObject).currentAnimation.reset();
//
//            for(Transition transition : transitions)
//            {
//                transition.update((Player) gameObject);
//            }
//        }
//
//        /*Player p = (Player)gameObject;
//
//        if(!p.isMeleeKeyPressed())
//        {
//            //p.setCurrentAttackState(p.getPlayerStates().getAnimation("notAttacking"));
//            //p.setCurrentMovementState(p.getPlayerStates().getAnimation("standing"));
//            p.setCurrentAnimation(p.getStringAnimations().getAnimation("facingLeft"));
//        }*/
//    }
//
//    @Override
//    public void render(GameObject gameObject, SpriteBatch batch)
//    {
//        int offsetx = (int) gameObject.position.x / 2;
//        int offsety = (int) gameObject.position.y / 2;
//
//
//        //batch.draw(((Player)gameObject).currentAnimation.getCurrentFrame(), (int)gameObject.position.x + offsetx, (int)gameObject.position.y);
//        //batch.draw(((Player)gameObject).currentAnimation.getCurrentFrame(),
//        //((Player)gameObject).position.x - ((Player)gameObject).currentAnimation.getCurrentFrame().getRegionWidth() / 2,
//        //(int)((Player)gameObject).position.y);
//        //batch.draw(((Player)gameObject).currentAnimation.getCurrentFrame(), (int)gameObject.position.x, (int)gameObject.position.y);
//        //batch.draw(((Player)gameObject).currentAnimation.getCurrentFrame(),
//        //(int)((Player)gameObject).position.x - ((Player)gameObject).currentAnimation.getCurrentFrame().getRegionWidth(),
//        //(int)((Player)gameObject).position.y - ((Player)gameObject).currentAnimation.getCurrentFrame().getRegionHeight() / 2);
//    }
//}
