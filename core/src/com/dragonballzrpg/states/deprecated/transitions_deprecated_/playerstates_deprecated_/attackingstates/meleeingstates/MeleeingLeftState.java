package com.dragonballzrpg.states.deprecated.transitions_deprecated_.playerstates_deprecated_.attackingstates.meleeingstates;

/**
 * Created by Carl on 06/09/2016.
 */
//public class MeleeingLeftState extends State
//{
//    @Override
//    public void initialiseTransitions(Player p)
//    {
////        transitionDeprecateds.add(new Transition_deprecated_(p.getPlayerStates().get("facingWest"), new String[]{"facingLeft"},
////        new TransitionConditionDep[]
////        {
////        new TransitionConditionDep(p.isRightKeyPressed(), false)
////        }));
////
////        transitionDeprecateds.add(new Transition_deprecated_(p.getPlayerStates().get("walkingNorth"), new String[]{"walkingUp"},
////        new TransitionConditionDep[]
////        {
////        new TransitionConditionDep(p.isUpKeyPressed(), true)
////        }));
////
////        transitionDeprecateds.add(new Transition_deprecated_(p.getPlayerStates().get("walkingSouth"), new String[]{"walkingDown"},
////        new TransitionConditionDep[]
////        {
////        new TransitionConditionDep(p.isDownKeyPressed(), true)
////        }));
////
////        transitionDeprecateds.add(new Transition_deprecated_(p.getPlayerStates().get("walkingWest"), new String[]{"walkingLeft"},
////        new TransitionConditionDep[]
////        {
////        new TransitionConditionDep(p.isLeftKeyPressed(), true)
////        }));
////
////        transitionDeprecateds.add(new Transition_deprecated_(p.getPlayerStates().get("walkingEast"), new String[]{"walkingRight"},
////        new TransitionConditionDep[]
////        {
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
////        transitionDeprecateds.add(new Transition_deprecated_(p.getPlayerStates().get("walkingEastNorth"), new String[]{"walkingRight"},
////        new TransitionConditionDep[]
////        {
////        new TransitionConditionDep(p.isUpKeyPressed(), true),
////        new TransitionConditionDep(p.isRightKeyPressed(), true)
////        }));
////
////        transitionDeprecateds.add(new Transition_deprecated_(p.getPlayerStates().get("walkingWestSouth"), new String[]{"walkingLeft"},
////        new TransitionConditionDep[]
////        {
////        new TransitionConditionDep(p.isDownKeyPressed(), true),
////        new TransitionConditionDep(p.isLeftKeyPressed(), true)
////        }));
////
////        transitionDeprecateds.add(new Transition_deprecated_(p.getPlayerStates().get("walkingEastSouth"), new String[]{"walkingRight"},
////        new TransitionConditionDep[]
////        {
////        new TransitionConditionDep(p.isDownKeyPressed(), true),
////        new TransitionConditionDep(p.isRightKeyPressed(), true)
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
//            for(Transition_deprecated_ transition : transitionDeprecateds)
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
