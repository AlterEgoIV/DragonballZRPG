package com.dragonballzrpg.states.deprecated.transitions_deprecated_.playerstates_deprecated_.walkingstates;

/**
 * Created by Carl on 24/08/2016.
 */
//public class WalkingUpRightState extends State
//{
//    @Override
//    public void initialiseTransitions(Player p)
//    {
////        transitionDeprecateds.add(new Transition_deprecated_(p.getPlayerStates().get("walkingNorth"), new String[]{"walkingUp"},
////        new TransitionConditionDep[]
////        {
////            new TransitionConditionDep(p.isUpKeyPressed(), true),
////            new TransitionConditionDep(p.isRightKeyPressed(), false)
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
//        for(Transition_deprecated_ transition : transitionDeprecateds)
//        {
//            transition.update((Player) gameObject);
//        }
//
//        // Up
//        /*if(((Player)gameObject).isUpKeyPressed() && !((Player)gameObject).isDownKeyPressed() &&
//           !((Player)gameObject).isLeftKeyPressed() && !((Player)gameObject).isRightKeyPressed())
//        {
//            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("walkingUp"));
//            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("walkingNorth"));
//        }
//
//        // Right
//        if(!((Player)gameObject).isUpKeyPressed() && !((Player)gameObject).isDownKeyPressed() &&
//           !((Player)gameObject).isLeftKeyPressed() && ((Player)gameObject).isRightKeyPressed())
//        {
//            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("walkingRight"));
//            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("walkingEast"));
//        }
//
//        // Up && Left
//        if(((Player)gameObject).isUpKeyPressed() && !((Player)gameObject).isDownKeyPressed() &&
//           ((Player)gameObject).isLeftKeyPressed() && !((Player)gameObject).isRightKeyPressed())
//        {
//            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("walkingUp"));
//            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("walkingNorthWest"));
//        }
//
//        if(!((Player)gameObject).isUpKeyPressed())
//        {
//            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("facingUp"));
//            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("standing"));
//        }*/
//
//        ((Player) gameObject).position.x += gameObject.getSpeed() * Gdx.graphics.getDeltaTime();
//        ((Player) gameObject).position.y += gameObject.getSpeed() * Gdx.graphics.getDeltaTime();
//    }
//
//    @Override
//    public void render(GameObject gameObject, SpriteBatch batch)
//    {
//
//    }
//}