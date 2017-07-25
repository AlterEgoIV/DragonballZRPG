package com.dragonballzrpg.states.deprecated.transitions_deprecated_.playerstates_deprecated_.walkingstates;

/**
 * Created by Carl on 24/08/2016.
 */
//public class WalkingLeftState extends State
//{
//    @Override
//    public void initialiseTransitions(Player player)
//    {
//        transitionDeprecateds.add(new Transition_deprecated_(player.states.get(StateName.STANDING), new AnimationName[]{AnimationName.FACE_LEFT},
//        new TransitionConditionDep[]
//        {
//        new TransitionConditionDep(player.isLeftKeyPressed, false)
//        }));
//
//        transitionDeprecateds.add(new Transition_deprecated_(player.states.get(StateName.MELEEING_RIGHT),
//        new AnimationName[]{AnimationName.PUNCH_RIGHT_1, AnimationName.PUNCH_RIGHT_2, AnimationName.KICK_RIGHT},
//        new TransitionConditionDep[]
//        {
//        new TransitionConditionDep(player.isMeleeKeyPressed, true),
//        new TransitionConditionDep(player.canAttack, true)
//        }));
//
////        transitionDeprecateds.add(new Transition_deprecated_(p.getPlayerStates().get("facingWest"), new String[]{"facingLeft"},
////        new TransitionConditionDep[]
////        {
////            new TransitionConditionDep(p.isLeftKeyPressed(), false)
////        }));
////
////        transitionDeprecateds.add(new Transition_deprecated_(p.getPlayerStates().get("walkingEast"), new String[]{"walkingRight"},
////        new TransitionConditionDep[]
////        {
////        new TransitionConditionDep(p.isLeftKeyPressed(), false),
////        new TransitionConditionDep(p.isRightKeyPressed(), true)
////        }));
////
////        transitionDeprecateds.add(new Transition_deprecated_(p.getPlayerStates().get("walkingWestNorth"), new String[]{"walkingLeft"},
////        new TransitionConditionDep[]
////        {
////        new TransitionConditionDep(p.isUpKeyPressed(), true),
////        new TransitionConditionDep(p.isLeftKeyPressed(), true)
////        }));
////
////        transitionDeprecateds.add(new Transition_deprecated_(p.getPlayerStates().get("walkingWestSouth"), new String[]{"walkingLeft"},
////        new TransitionConditionDep[]
////        {
////        new TransitionConditionDep(p.isDownKeyPressed(), true),
////        new TransitionConditionDep(p.isLeftKeyPressed(), true)
////        }));
////
////        transitionDeprecateds.add(new Transition_deprecated_(p.getPlayerStates().get("meleeingWest"), new String[]{"punch1Left", "punch2Left", "kickLeft"},
////        new TransitionConditionDep[]
////        {
////        new TransitionConditionDep(p.isMeleeKeyPressed(), true),
////        new TransitionConditionDep(p.canAttack(), true)
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
//        // Up && Left
//        /*if(((Player)gameObject).isUpKeyPressed() && !((Player)gameObject).isDownKeyPressed() &&
//           ((Player)gameObject).isLeftKeyPressed() && !((Player)gameObject).isRightKeyPressed())
//        {
//            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("walkingLeft"));
//            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("walkingWestNorth"));
//        }
//
//        // Down && Left
//        if(!((Player)gameObject).isUpKeyPressed() && ((Player)gameObject).isDownKeyPressed() &&
//           ((Player)gameObject).isLeftKeyPressed() && !((Player)gameObject).isRightKeyPressed())
//        {
//            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("walkingLeft"));
//            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("walkingWestSouth"));
//        }
//
//        if(!((Player)gameObject).isLeftKeyPressed())
//        {
//            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("facingLeft"));
//            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("standing"));
//        }*/
//
//        ((Player) gameObject).position.x -= gameObject.getSpeed() * Gdx.graphics.getDeltaTime();
//    }
//
//    @Override
//    public void render(GameObject gameObject, SpriteBatch batch)
//    {
//        //batch.draw(((Player)gameObject).currentAnimation.getCurrentFrame(), (int)gameObject.position.x, (int)gameObject.position.y);
//        //batch.draw(((Player)gameObject).currentAnimation.getCurrentFrame(),
//        //(int)((Player)gameObject).position.x - ((Player)gameObject).currentAnimation.getCurrentFrame().getRegionWidth() / 2,
//        //(int)((Player)gameObject).position.y );
////        batch.draw(((Player)gameObject).currentAnimation.getCurrentFrame(),
////        (int)((Player)gameObject).position.x - ((Player)gameObject).currentAnimation.getCurrentFrame().getRegionWidth() / 2,
////        ((Player)gameObject).position.y - ((Player)gameObject).currentAnimation.getCurrentFrame().getRegionHeight() / 2.0f);
//    }
//}
