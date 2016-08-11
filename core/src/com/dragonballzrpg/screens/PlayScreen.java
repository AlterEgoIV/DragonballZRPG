package com.dragonballzrpg.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dragonballzrpg.entities.Entity;

import java.util.List;

/**
 * Created by Carl on 04/08/2016.
 */
public class PlayScreen implements Screen
{
    private SpriteBatch batch;
    private final int VIEWPORT_WIDTH = 240;
    private final int VIEWPORT_HEIGHT = 160;
    private OrthographicCamera camera;
    private TiledMap map;
    private OrthogonalTiledMapRenderer mapRenderer;
    private Viewport viewport;
    private int mapWidth;
    private int mapHeight;
    private List<Entity> entities;

    public PlayScreen(SpriteBatch batch, List<Entity> entities)
    {
        this.batch = batch;
        this.entities = entities; // changes will be reflected in original List
    }

    @Override
    public void show()
    {
        camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        camera.translate(VIEWPORT_WIDTH / 2, VIEWPORT_HEIGHT / 2);
        map = new TmxMapLoader().load("test.tmx");
        mapRenderer = new OrthogonalTiledMapRenderer(map);
        viewport = new StretchViewport(VIEWPORT_WIDTH, VIEWPORT_HEIGHT, camera);
        viewport.apply();
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

        camera.update();
        mapRenderer.setView(camera);
        mapRenderer.render();

        for(Entity entity : entities)
        {
            entity.update();
        }

        /*for(Collidable entity : entities)
        {
            if(entity.hasCollided())
            {
                collisionHandler.handleCollision(entity);
            }
        }*/

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        for(Entity entity : entities)
        {
            entity.render(batch);
        }
        batch.end();
    }

    private void handleInput()
    {
        if(Gdx.input.isKeyPressed(Input.Keys.UP))
        {
            camera.translate(0, 5);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
        {
            camera.translate(0, -5);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
        {
            camera.translate(-5, 0);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
        {
            camera.translate(5, 0);
        }
    }

    private void checkBoundaries()
    {
        if(camera.position.x < VIEWPORT_WIDTH / 2)
        {
            camera.position.x = VIEWPORT_WIDTH / 2;
        }

        if(camera.position.x > mapWidth - (VIEWPORT_WIDTH / 2))
        {
            camera.position.x = mapWidth - (VIEWPORT_WIDTH / 2);
        }

        if(camera.position.y < VIEWPORT_HEIGHT / 2)
        {
            camera.position.y = VIEWPORT_HEIGHT / 2;
        }

        if(camera.position.y > mapHeight - (VIEWPORT_HEIGHT / 2))
        {
            camera.position.y = mapHeight - (VIEWPORT_HEIGHT / 2);
        }
    }

    @Override
    public void resize(int width, int height)
    {
        viewport.update(width, height);
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
        //batch.dispose();
        map.dispose();
        mapRenderer.dispose();
    }
}
