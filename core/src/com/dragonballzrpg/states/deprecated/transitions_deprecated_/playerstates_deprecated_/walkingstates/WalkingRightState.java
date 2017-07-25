package com.dragonballzrpg.states.deprecated.transitions_deprecated_.playerstates_deprecated_.walkingstates;

/**
 * Created by Carl on 24/08/2016.
 */
//public class WalkingRightState extends State
//{
//    @Override
//    public void initialiseTransitions(Player player)
//    {
//        transitionDeprecateds.add(new Transition_deprecated_(player.states.get(StateName.STANDING), new AnimationName[]{AnimationName.FACE_RIGHT},
//        new TransitionConditionDep[]
//        {
//            new TransitionConditionDep(player.isRightKeyPressed, false)
//        }));
//
//        transitionDeprecateds.add(new Transition_deprecated_(player.states.get(StateName.MELEEING_RIGHT),
//                        new AnimationName[]{AnimationName.PUNCH_RIGHT_1, AnimationName.PUNCH_RIGHT_2, AnimationName.KICK_RIGHT},
//        new TransitionConditionDep[]
//        {
//            new TransitionConditionDep(player.isMeleeKeyPressed, true),
//            new TransitionConditionDep(player.canAttack, true)
//        }));
//
////        transitionDeprecateds.add(new Transition_deprecated_(p.getPlayerStates().get("walkingWest"), new String[]{"walkingLeft"},
////        new TransitionConditionDep[]
////        {
////        new TransitionConditionDep(p.isLeftKeyPressed(), true),
////        new TransitionConditionDep(p.isRightKeyPressed(), false)
////        }));
////
////        transitionDeprecateds.add(new Transition_deprecated_(p.getPlayerStates().get("walkingEastNorth"), new String[]{"walkingRight"},
////        new TransitionConditionDep[]
////        {
////        new TransitionConditionDep(p.isUpKeyPressed(), true),
////        new TransitionConditionDep(p.isRightKeyPressed(), true)
////        }));
////
////        transitionDeprecateds.add(new Transition_deprecated_(p.getPlayerStates().get("walkingEastSouth"), new String[]{"walkingRight"},
////        new TransitionConditionDep[]
////        {
////        new TransitionConditionDep(p.isDownKeyPressed(), true),
////        new TransitionConditionDep(p.isRightKeyPressed(), true)
////        }));
////
////        transitionDeprecateds.add(new Transition_deprecated_(p.getPlayerStates().get("meleeingEast"), new String[]{"punch1Right", "punch2Right", "kickRight"},
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
//            transition.update(gameObject);
//        }
//
//        gameObject.position.x += gameObject.getSpeed() * Gdx.graphics.getDeltaTime();
//    }
//
//    @Override
//    public void render(GameObject gameObject, SpriteBatch batch)
//    {
//
//    }
//}
