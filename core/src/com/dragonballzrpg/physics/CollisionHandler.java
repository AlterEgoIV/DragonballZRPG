package com.dragonballzrpg.physics;

import com.dragonballzrpg.gameobjects.GameObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carl on 19/05/2017.
 */
public class CollisionHandler
{
    private List<GameObject> gameObjects;
    private List<Rectangle> staticRectangles;

    public CollisionHandler()
    {
        gameObjects = new ArrayList<GameObject>();
        staticRectangles = new ArrayList<Rectangle>();
    }

    public void add(GameObject gameObject)
    {
        gameObjects.add(gameObject);
    }

    public void add(Rectangle rectangle)
    {
        staticRectangles.add(rectangle);
    }

    public void handleXAxisCollisions(GameObject gameObject)
    {
        // Static
        for(Rectangle staticRectangle : staticRectangles)
        {
            if(gameObject.boundingBox.intersects(staticRectangle))
            {
                Rectangle rectangle = gameObject.boundingBox.intersection(staticRectangle);

                if(gameObject.boundingBox.x < staticRectangle.x)
                {
                    gameObject.position.x -= rectangle.width;
                    gameObject.boundingBox.setLocation((int)gameObject.position.x - gameObject.width / 2, (int)gameObject.position.y - gameObject.height / 2);
                }
                else if(gameObject.boundingBox.x > staticRectangle.x)
                {
                    gameObject.position.x += rectangle.width;
                    gameObject.boundingBox.setLocation((int)gameObject.position.x - gameObject.width / 2, (int)gameObject.position.y - gameObject.height / 2);
                }
            }
        }

        // Dynamic
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

    public void handleYAxisCollisions(GameObject gameObject)
    {
        // Static
        for(Rectangle staticRectangle : staticRectangles)
        {
            if(gameObject.boundingBox.intersects(staticRectangle))
            {
                Rectangle rectangle = gameObject.boundingBox.intersection(staticRectangle);

                if(gameObject.boundingBox.y < staticRectangle.y)
                {
                    gameObject.position.y -= rectangle.height;
                    gameObject.boundingBox.setLocation((int)gameObject.position.x - gameObject.width / 2, (int)gameObject.position.y - gameObject.height / 2);
                }
                else if(gameObject.boundingBox.y > staticRectangle.y)
                {
                    gameObject.position.y += rectangle.height;
                    gameObject.boundingBox.setLocation((int)gameObject.position.x - gameObject.width / 2, (int)gameObject.position.y - gameObject.height / 2);
                }
            }
        }

        // Dynamic
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
