package com.dragonballzrpg.physics;

import com.badlogic.gdx.Gdx;
import com.dragonballzrpg.gameobjects.GameObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carl on 19/05/2017.
 */
public class PhysicsSimulator
{
    private CollisionHandler collisionHandler;
    private List<GameObject> gameObjects;

    public PhysicsSimulator()
    {
        collisionHandler = new CollisionHandler();
        gameObjects = new ArrayList<GameObject>();
    }

    public void add(GameObject gameObject)
    {
        collisionHandler.add(gameObject);
        gameObjects.add(gameObject);
    }

    public void add(Rectangle rectangle)
    {
        collisionHandler.add(rectangle);
    }

    public void update()
    {
        for(GameObject gameObject : gameObjects)
        {
            gameObject.position.x += gameObject.velocity.x * Gdx.graphics.getDeltaTime();
            gameObject.boundingBox.setLocation((int)gameObject.position.x - gameObject.width / 2, (int)gameObject.position.y - gameObject.height / 2);

            collisionHandler.handleXAxisCollisions(gameObject);

            gameObject.position.y += gameObject.velocity.y * Gdx.graphics.getDeltaTime();
            gameObject.boundingBox.setLocation((int)gameObject.position.x - gameObject.width / 2, (int)gameObject.position.y - gameObject.height / 2);

            collisionHandler.handleYAxisCollisions(gameObject);
        }
    }
}
