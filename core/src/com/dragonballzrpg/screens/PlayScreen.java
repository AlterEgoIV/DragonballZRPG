package com.dragonballzrpg.screens;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.dragonballzrpg.DragonballZRPG;
import com.dragonballzrpg.entities.Entity;
import com.dragonballzrpg.entities.players.Player;
import com.dragonballzrpg.entities.players.TeenFutureTrunks;
import com.dragonballzrpg.enums.AnimationName;
import com.dragonballzrpg.enums.AnimationSet;
import com.dragonballzrpg.enums.PlayerName;
import com.dragonballzrpg.input.InputHandler;

import java.util.*;

/**
 * Created by Carl on 04/08/2016.
 */
public class PlayScreen extends GameScreen
{
    private TiledMap map;
    private OrthogonalTiledMapRenderer mapRenderer;
    private int mapWidth;
    private int mapHeight;
    private Map<PlayerName, Player> players;
    private Entity currentPlayer;
    private List<Entity> entities;

    public PlayScreen(DragonballZRPG game)
    {
        super(game);

        map = new TmxMapLoader().load("test.tmx");
        mapRenderer = new OrthogonalTiledMapRenderer(map);
        mapWidth = map.getProperties().get("width", Integer.class) * map.getProperties().get("tilewidth", Integer.class);
        mapHeight = map.getProperties().get("height", Integer.class) * map.getProperties().get("tileheight", Integer.class);

        players = new HashMap<PlayerName, Player>();
        entities = new ArrayList<Entity>();

        createPlayers();
        currentPlayer = players.get(PlayerName.TEEN_FUTURE_TRUNKS);
        createEntities();

        game.inputProcessor.add((InputHandler)currentPlayer);
    }

    private void createPlayers()
    {
        Player player;

        player = new TeenFutureTrunks(game.camera,
          new Vector2(0, 0), 100.0d,
          game.setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS),
          game.setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).get(AnimationName.DIE),
          game.sounds,
          Input.Keys.UP, Input.Keys.DOWN, Input.Keys.LEFT, Input.Keys.RIGHT, Input.Keys.M);

        players.put(PlayerName.TEEN_FUTURE_TRUNKS, player);
    }

    private void createEntities()
    {
        entities.addAll(players.values());

        // Create other entities
    }

    @Override
    public void show()
    {

    }

    @Override
    public void render(float delta)
    {
        for(Entity entity : entities)
        {
            entity.update();
        }

        game.camera.update();
        mapRenderer.setView(game.camera);
        mapRenderer.render();

        batch.setProjectionMatrix(game.camera.combined);
        batch.begin();
        for(Entity entity : entities)
        {
            entity.render(batch);
        }
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
