package com.dragonballzrpg.states.deprecated.transitions_deprecated_.playerstates_deprecated_.runningstates;

/**
 * Created by Carl on 24/08/2016.
 */
//public class RunningLeftState extends State
//{
//    @Override
//    public void initialiseTransitions(Player p)
//    {
//
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
//            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("runningLeft"));
//            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("runningWestNorth"));
//        }
//
//        // Down && Left
//        if(!((Player)gameObject).isUpKeyPressed() && ((Player)gameObject).isDownKeyPressed() &&
//           ((Player)gameObject).isLeftKeyPressed() && !((Player)gameObject).isRightKeyPressed())
//        {
//            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("runningLeft"));
//            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("runningWestSouth"));
//        }
//
//        if(!((Player)gameObject).isLeftKeyPressed())
//        {
//            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("facingLeft"));
//            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("standing"));
//        }*/
//
//        ((Player) gameObject).position.x -= ((Player) gameObject).getRunSpeed() * Gdx.graphics.getDeltaTime();
//    }
//
//    @Override
//    public void render(GameObject gameObject, SpriteBatch batch)
//    {
//
//    }
//}
