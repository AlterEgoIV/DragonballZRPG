package com.dragonballzrpg.states.deprecated.transitions_deprecated_.playerstates_deprecated_.attackingstates.meleeingstates;

/**
 * Created by Carl on 06/09/2016.
 */
//public class MeleeingRightState extends State
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
//        transitionDeprecateds.add(new Transition_deprecated_(player.states.get(StateName.WALKING_RIGHT), new AnimationName[]{AnimationName.WALK_RIGHT},
//        new TransitionConditionDep[]
//        {
//            new TransitionConditionDep(player.isRightKeyPressed, true)
//        }));
//
////        transitionDeprecateds.add(new Transition_deprecated_(p.getPlayerStates().value("walkingNorth"), new String[]{"walkingUp"},
////        new TransitionConditionDep[]
////        {
////            new TransitionConditionDep(p.isUpKeyPressed(), true)
////        }));
////
////        transitionDeprecateds.add(new Transition_deprecated_(p.getPlayerStates().value("walkingSouth"), new String[]{"walkingDown"},
////        new TransitionConditionDep[]
////        {
////            new TransitionConditionDep(p.isDownKeyPressed(), true)
////        }));
////
////        transitionDeprecateds.add(new Transition_deprecated_(p.getPlayerStates().value("walkingWest"), new String[]{"walkingLeft"},
////        new TransitionConditionDep[]
////        {
////            new TransitionConditionDep(p.isLeftKeyPressed(), true)
////        }));
////
////        transitionDeprecateds.add(new Transition_deprecated_(p.getPlayerStates().value("walkingEast"), new String[]{"walkingRight"},
////        new TransitionConditionDep[]
////        {
////            new TransitionConditionDep(p.isRightKeyPressed(), true)
////        }));
////
////        transitionDeprecateds.add(new Transition_deprecated_(p.getPlayerStates().value("walkingWestNorth"), new String[]{"walkingLeft"},
////        new TransitionConditionDep[]
////        {
////            new TransitionConditionDep(p.isUpKeyPressed(), true),
////            new TransitionConditionDep(p.isLeftKeyPressed(), true)
////        }));
////
////        transitionDeprecateds.add(new Transition_deprecated_(p.getPlayerStates().value("walkingEastNorth"), new String[]{"walkingRight"},
////        new TransitionConditionDep[]
////        {
////            new TransitionConditionDep(p.isUpKeyPressed(), true),
////            new TransitionConditionDep(p.isRightKeyPressed(), true)
////        }));
////
////        transitionDeprecateds.add(new Transition_deprecated_(p.getPlayerStates().value("walkingWestSouth"), new String[]{"walkingLeft"},
////        new TransitionConditionDep[]
////        {
////            new TransitionConditionDep(p.isDownKeyPressed(), true),
////            new TransitionConditionDep(p.isLeftKeyPressed(), true)
////        }));
////
////        transitionDeprecateds.add(new Transition_deprecated_(p.getPlayerStates().value("walkingEastSouth"), new String[]{"walkingRight"},
////        new TransitionConditionDep[]
////        {
////            new TransitionConditionDep(p.isDownKeyPressed(), true),
////            new TransitionConditionDep(p.isRightKeyPressed(), true)
////        }));
//    }
//
//    @Override
//    public void enter(GameObject gameObject)
//    {
//        Player player = (Player) gameObject;
//
//        player.canAttack.set(false);
//        //player.sounds.get(getRandomValue(new SoundName[]{SoundName.MELEE_1, SoundName.MELEE_2})).play();
//
//        //p.canAttack().set(false);
//        //p.setCanAttack(false);
//        //p.getSounds().value(getRandomValue(new String[]{"melee1", "melee2"})).play();
//    }
//
//    @Override
//    public void exit(GameObject gameObject)
//    {
//        Player player = (Player) gameObject;
//    }
//
//    @Override
//    public void update(GameObject gameObject)
//    {
//        currentDuration += Gdx.graphics.getDeltaTime();
//
//        if(currentDuration >= gameObject.currentAnimation.getDuration())
//        {
//            currentDuration = 0.0d;
//            gameObject.currentAnimation.reset();
//
//            for(Transition_deprecated_ transition : transitionDeprecateds)
//            {
//                transition.update(gameObject);
//            }
//        }
//    }
//
//    @Override
//    public void render(GameObject gameObject, SpriteBatch batch)
//    {
//        //batch.draw(((Player)gameObject).currentAnimation.getCurrentFrame(), (int)gameObject.position.x, (int)gameObject.position.y);
////        batch.draw(((Player)gameObject).currentAnimation.getCurrentFrame(),
////        (int)((Player)gameObject).position.x,
////        (int)((Player)gameObject).position.y - ((Player)gameObject).currentAnimation.getCurrentFrame().getRegionHeight() / 2);
//    }
//}
