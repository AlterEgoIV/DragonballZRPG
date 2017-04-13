package com.dragonballzrpg.screens;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.dragonballzrpg.DragonballZRPG;
import com.dragonballzrpg.entities.Entity;
import com.dragonballzrpg.entities.animatedentities.players.TeenFutureTrunks;
import com.dragonballzrpg.enums.AnimationName;
import com.dragonballzrpg.enums.AnimationSet;
import com.dragonballzrpg.utilities.Animation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carl on 04/08/2016.
 */
public class PlayScreen extends GameScreen
{
    private TiledMap map;
    private OrthogonalTiledMapRenderer mapRenderer;
    private int mapWidth;
    private int mapHeight;
    private List<Entity> entities;

    public PlayScreen(DragonballZRPG game)
    {
        super(game);

        map = new TmxMapLoader().load("test.tmx");
        mapRenderer = new OrthogonalTiledMapRenderer(map);
        mapWidth = map.getProperties().get("width", Integer.class) * map.getProperties().get("tilewidth", Integer.class);
        mapHeight = map.getProperties().get("height", Integer.class) * map.getProperties().get("tileheight", Integer.class);
        entities = new ArrayList<Entity>();

        createEntities();
    }

    private void createEntities()
    {
        entities.add(new TeenFutureTrunks(game.camera,
          new Vector2(0, 0), 100.0d,
          game.setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS),
          game.setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).get(AnimationName.FACE_DOWN),
          game.sounds));
    }

    @Override
    public void show()
    {

    }

    @Override
    public void render(float delta)
    {
//        for(Entity entity : game.entities.values())
//        {
//            entity.update();
//        }

        for(Entity entity : entities)
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

        batch.setProjectionMatrix(game.camera.combined);
        batch.begin();
        for(Entity entity : entities)
        {
            entity.render(batch);
        }
//        for(Entity entity : game.entities.values())
//        {
//            entity.render(batch);
//        }
        batch.end();
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
