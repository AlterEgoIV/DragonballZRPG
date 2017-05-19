package com.dragonballzrpg;

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
            //handleXAxisCollisions(gameObject);

            gameObject.position.y += gameObject.velocity.y * Gdx.graphics.getDeltaTime();
            gameObject.boundingBox.setLocation((int)gameObject.position.x - gameObject.width / 2, (int)gameObject.position.y - gameObject.height / 2);

            collisionHandler.handleYAxisCollisions(gameObject);
            //handleYAxisCollisions(gameObject);
        }
    }

    private void handleXAxisCollisions(GameObject gameObject)
    {
        for(GameObject otherObject : gameObjects)
        {
            if(otherObject != gameObject)
            {
                if(gameObject.boundingBox.intersects(otherObject.boundingBox))
                {
                    Rectangle rectangle = gameObject.boundingBox.intersection(otherObject.boundingBox);

                    if(gameObject.boundingBox.x < otherObject.boundingBox.x)
                    {
                        gameObject.position.x -= rectangle.width;
                        gameObject.boundingBox.setLocation((int)gameObject.position.x - gameObject.width / 2, (int)gameObject.position.y - gameObject.height / 2);
                    }
                    else if(gameObject.boundingBox.x > otherObject.boundingBox.x)
                    {
                        gameObject.position.x += rectangle.width;
                        gameObject.boundingBox.setLocation((int)gameObject.position.x - gameObject.width / 2, (int)gameObject.position.y - gameObject.height / 2);
                    }
                }
            }
        }
    }

    private void handleYAxisCollisions(GameObject gameObject)
    {
        for(GameObject otherObject : gameObjects)
        {
            if(otherObject != gameObject)
            {
                if(gameObject.boundingBox.intersects(otherObject.boundingBox))
                {
                    Rectangle rectangle = gameObject.boundingBox.intersection(otherObject.boundingBox);

                    if(gameObject.boundingBox.y < otherObject.boundingBox.y)
                    {
                        gameObject.position.y -= rectangle.height;
                        gameObject.boundingBox.setLocation((int)gameObject.position.x - gameObject.width / 2, (int)gameObject.position.y - gameObject.height / 2);
                    }
                    else if(gameObject.boundingBox.y > otherObject.boundingBox.y)
                    {
                        gameObject.position.y += rectangle.height;
                        gameObject.boundingBox.setLocation((int)gameObject.position.x - gameObject.width / 2, (int)gameObject.position.y - gameObject.height / 2);
                    }
                }
            }
        }
    }
}
