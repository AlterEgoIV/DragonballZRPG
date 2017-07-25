package com.dragonballzrpg.states.deprecated.transitions_deprecated_.playerstates_deprecated_.runningstates;

/**
 * Created by Carl on 24/08/2016.
 */
//public class RunningRightState extends State
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
//    }
//
//    @Override
//    public void enter(GameObject gameObject)
//    {
//        //gameObject.sounds.get(SoundName.RUNNING).loop();
//    }
//
//    @Override
//    public void exit(GameObject gameObject)
//    {
//        //gameObject.sounds.get(SoundName.RUNNING).stop();
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
//        // Up && Right
//        /*if(((Player)gameObject).isUpKeyPressed() && !((Player)gameObject).isDownKeyPressed() &&
//           !((Player)gameObject).isLeftKeyPressed() && ((Player)gameObject).isRightKeyPressed())
//        {
//            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("runningRight"));
//            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("runningEastNorth"));
//        }
//
//        // Down && Right
//        if(!((Player)gameObject).isUpKeyPressed() && ((Player)gameObject).isDownKeyPressed() &&
//           !((Player)gameObject).isLeftKeyPressed() && ((Player)gameObject).isRightKeyPressed())
//        {
//            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("runningRight"));
//            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("runningEastSouth"));
//        }
//
//        if(!((Player)gameObject).isRightKeyPressed())
//        {
//            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("facingRight"));
//            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("standing"));
//        }*/
//
//        ((Player) gameObject).position.x += ((Player) gameObject).getRunSpeed() * Gdx.graphics.getDeltaTime();
//    }
//
//    @Override
//    public void render(GameObject gameObject, SpriteBatch batch)
//    {
//
//    }
//}