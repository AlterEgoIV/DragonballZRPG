package com.dragonballzrpg.states.deprecated.transitions_deprecated_.playerstates_deprecated_.facingstates;

/**
 * Created by Carl on 21/09/2016.
 */

//public class FacingDownState extends State
//{
//    @Override
//    public void initialiseTransitions(Player p)
//    {
////        transitionDeprecateds.add(new Transition_deprecated_(p.getPlayerStates().get("walkingNorth"), new String[]{"walkingUp"},
////        new TransitionConditionDep[]
////        {
////            new TransitionConditionDep(p.isUpKeyPressed(), true)
////        }));
////
////        transitionDeprecateds.add(new Transition_deprecated_(p.getPlayerStates().get("walkingSouth"), new String[]{"walkingDown"},
////        new TransitionConditionDep[]
////        {
////            new TransitionConditionDep(p.isDownKeyPressed(), true)
////        }));
////
////        transitionDeprecateds.add(new Transition_deprecated_(p.getPlayerStates().get("walkingWest"), new String[]{"walkingLeft"},
////        new TransitionConditionDep[]
////        {
////            new TransitionConditionDep(p.isLeftKeyPressed(), true)
////        }));
////
////        transitionDeprecateds.add(new Transition_deprecated_(p.getPlayerStates().get("walkingEast"), new String[]{"walkingRight"},
////        new TransitionConditionDep[]
////        {
////            new TransitionConditionDep(p.isRightKeyPressed(), true)
////        }));
////
////        transitionDeprecateds.add(new Transition_deprecated_(p.getPlayerStates().get("runningSouth"), new String[]{"runningDown"},
////        new TransitionConditionDep[]
////        {
////            new TransitionConditionDep(p.isDownKeyPressed(), true),
////            new TransitionConditionDep(p.getReadyToRunDown(), true)
////        }));
////
////        transitionDeprecateds.add(new Transition_deprecated_(p.getPlayerStates().get("meleeingSouth"), new String[]{"punch1Down", "punch2Down", "kickDown"},
////        new TransitionConditionDep[]
////        {
////            new TransitionConditionDep(p.getMKeyPressed(), true),
////            new TransitionConditionDep(p.getCanAttack(), true)
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
//    }
//
//    @Override
//    public void render(GameObject gameObject, SpriteBatch batch)
//    {
//        //batch.draw(((Player)gameObject).currentAnimation.getCurrentFrame(), gameObject.position.x, gameObject.position.y);
//        //batch.draw(((Player)gameObject).currentAnimation.getCurrentFrame(),
//        //(int)((Player)gameObject).position.x - ((Player)gameObject).currentAnimation.getCurrentFrame().getRegionWidth() / 2,
//        //(int)((Player)gameObject).position.y - ((Player)gameObject).currentAnimation.getCurrentFrame().getRegionHeight() / 2);
//    }
//}
