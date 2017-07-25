package com.dragonballzrpg.states.deprecated.transitions_deprecated_.playerstates_deprecated_.walkingstates;

/**
 * Created by Carl on 24/08/2016.
 */
//public class WalkingDownLeftState extends State
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
//        // Down
//        /*if(!((Player)gameObject).isUpKeyPressed() && ((Player)gameObject).isDownKeyPressed() &&
//           !((Player)gameObject).isLeftKeyPressed() && !((Player)gameObject).isRightKeyPressed())
//        {
//            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("walkingDown"));
//            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("walkingSouth"));
//        }
//
//        // Left
//        if(!((Player)gameObject).isUpKeyPressed() && !((Player)gameObject).isDownKeyPressed() &&
//           ((Player)gameObject).isLeftKeyPressed() && !((Player)gameObject).isRightKeyPressed())
//        {
//            ((Player)gameObject).setCurrentAnimation(((Player)gameObject).getStringAnimations().getAnimation("walkingLeft"));
//            ((Player)gameObject).setCurrentState(((Player)gameObject).getPlayerStates().getAnimation("walkingWest"));
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
//        ((Player) gameObject).position.x -= gameObject.getSpeed() * Gdx.graphics.getDeltaTime();
//        ((Player) gameObject).position.y -= gameObject.getSpeed() * Gdx.graphics.getDeltaTime();
//    }
//
//    @Override
//    public void render(GameObject gameObject, SpriteBatch batch)
//    {
//
//    }
//}
