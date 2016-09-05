package com.dragonballzrpg.screens;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.dragonballzrpg.DragonballZRPG;
import com.dragonballzrpg.entities.Entity;

/**
 * Created by Carl on 04/08/2016.
 */
public class PlayScreen extends GameScreen
{
    private TiledMap map;
    private OrthogonalTiledMapRenderer mapRenderer;
    private int mapWidth;
    private int mapHeight;

    public PlayScreen(DragonballZRPG game)
    {
        this.game = game;
        map = new TmxMapLoader().load("test.tmx");
        mapRenderer = new OrthogonalTiledMapRenderer(map);
        mapWidth = map.getProperties().get("width", Integer.class) * map.getProperties().get("tilewidth", Integer.class);
        mapHeight = map.getProperties().get("height", Integer.class) * map.getProperties().get("tileheight", Integer.class);
    }

    @Override
    public void show()
    {

    }

    @Override
    public void render(float delta)
    {
        for(Entity entity : game.entities.values())
        {
            entity.update();
        }

        game.camera.update();
        mapRenderer.setView(game.camera);
        mapRenderer.render();

        /*for(Collidable entity : game.entities)
        {
            if(entity.hasCollided())
            {
                collisionHandler.handleCollision(entity);
            }
        }*/

        game.batch.setProjectionMatrix(game.camera.combined);
        game.batch.begin();
        for(Entity entity : game.entities.values())
        {
            entity.render(game.batch);
        }
        game.batch.end();
    }

    @Override
    public void resize(int width, int height)
    {

    }

    @Override
    public void pause()
    {

    }

    @Override
    public void resume()
    {

    }

    @Override
    public void hide()
    {

    }

    @Override
    public void dispose()
    {
        map.dispose();
        mapRenderer.dispose();
    }
}
