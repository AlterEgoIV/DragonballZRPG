package com.dragonballzrpg.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
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
    }

    @Override
    public void show()
    {
        map = new TmxMapLoader().load("test.tmx");
        mapRenderer = new OrthogonalTiledMapRenderer(map);
        mapWidth = map.getProperties().get("width", Integer.class) * map.getProperties().get("tilewidth", Integer.class);
        mapHeight = map.getProperties().get("height", Integer.class) * map.getProperties().get("tileheight", Integer.class);
    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        handleInput();
        checkBoundaries();

        mapRenderer.setView(game.camera);
        mapRenderer.render();

        for(Entity entity : game.entities)
        {
            entity.update();
        }

        /*for(Collidable entity : game.entities)
        {
            if(entity.hasCollided())
            {
                collisionHandler.handleCollision(entity);
            }
        }*/

        game.batch.begin();
        for(Entity entity : game.entities)
        {
            entity.render(game.batch);
        }
        game.batch.end();
    }

    private void handleInput()
    {
        if(Gdx.input.isKeyPressed(Input.Keys.UP))
        {
            game.camera.translate(0, 5);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
        {
            game.camera.translate(0, -5);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
        {
            game.camera.translate(-5, 0);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
        {
            game.camera.translate(5, 0);
        }
    }

    private void checkBoundaries()
    {
        if(game.camera.position.x < game.VIEWPORT_WIDTH / 2)
        {
            game.camera.position.x = game.VIEWPORT_WIDTH / 2;
        }

        if(game.camera.position.x > mapWidth - (game.VIEWPORT_WIDTH / 2))
        {
            game.camera.position.x = mapWidth - (game.VIEWPORT_WIDTH / 2);
        }

        if(game.camera.position.y < game.VIEWPORT_HEIGHT / 2)
        {
            game.camera.position.y = game.VIEWPORT_HEIGHT / 2;
        }

        if(game.camera.position.y > mapHeight - (game.VIEWPORT_HEIGHT / 2))
        {
            game.camera.position.y = mapHeight - (game.VIEWPORT_HEIGHT / 2);
        }
    }

    @Override
    public void resize(int width, int height)
    {
        game.viewport.update(width, height);
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
