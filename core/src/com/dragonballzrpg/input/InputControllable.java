package com.dragonballzrpg.input;

/**
 * Created by Carl on 18/07/2017.
 */
public interface InputControllable
{
    void move(double x, double y);
    void moveUp();
    void moveUpFast();
    void moveDown();
    void moveLeft();
    void moveRight();
    void melee();
}
