package com.dragonballzrpg.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.dragonballzrpg.DragonballZRPG;
import com.dragonballzrpg.actions.ActionManager;
import com.dragonballzrpg.controllers.PlayerController;
import com.dragonballzrpg.enums.*;
import com.dragonballzrpg.input.InputHandler;
import com.dragonballzrpg.input.PlayInputProcessor;
import com.dragonballzrpg.physics.PhysicsSimulator;
import com.dragonballzrpg.gameobjects.GameObject;
import com.dragonballzrpg.gameobjects.characters.Player;
import com.dragonballzrpg.ui.PlayUI;

import java.awt.Rectangle;
import java.util.*;
import java.util.List;

/**
 * Created by Carl on 04/08/2016.
 */
public class PlayScreen extends GameScreen
{
    private TiledMap map;
    private OrthogonalTiledMapRenderer mapRenderer;
    // private int mapWidth, mapHeight;
    private PlayInputProcessor playInputProcessor;
    private Map<PlayerName, Player> players;
    private Player currentPlayer;
    private List<GameObject> gameObjects;
    private PhysicsSimulator physicsSimulator;
    private int[] backgroundLayers, foregroundLayers;
    //private ActionManager actionManager;
    //private InputHandler inputHandler;

    public PlayScreen(DragonballZRPG game)
    {
        super(game, new PlayUI(game.resourceManager, game.viewport));

        playInputProcessor = new PlayInputProcessor(game.inputKeyMap);
        physicsSimulator = new PhysicsSimulator();
        players = new HashMap<PlayerName, Player>();
        gameObjects = new ArrayList<GameObject>();

        loadMaps();
        createPlayers();
        createEntities();
        currentPlayer = players.get(PlayerName.TEEN_FUTURE_TRUNKS);
        currentPlayer.setController(new PlayerController(currentPlayer, playInputProcessor.keyStateViewer));

        //playInputProcessor.addInputController((PlayerController)currentPlayer.controller);

        //actionManager = new ActionManager(game.resourceManager);
        //actionManager.addActionProcessor(currentPlayer.actionProcessor);
        //inputHandler = new InputHandler(game.inputKeyMap, actionManager);
        //inputHandler = new InputHandler(game.inputKeyMap, currentPlayer);
        physicsSimulator.add(currentPlayer);
    }

    private void loadMaps()
    {
        map = new TmxMapLoader().load("untitled.tmx");

        MapObjects mapObjects = map.getLayers().get("collision").getObjects();

        for(RectangleMapObject rectangleMapObject : mapObjects.getByType(RectangleMapObject.class))
        {
            com.badlogic.gdx.math.Rectangle r = rectangleMapObject.getRectangle();
            Rectangle rectangle = new Rectangle((int)r.x, (int)r.y, (int)r.width, (int)r.height);
            physicsSimulator.add(rectangle);
        }

        backgroundLayers = new int[]{0, 1};
        foregroundLayers = new int[]{2};

        mapRenderer = new OrthogonalTiledMapRenderer(map);
        // mapWidth = map.getProperties().get("width", Integer.class) * map.getProperties().get("tilewidth", Integer.class);
        // mapHeight = map.getProperties().get("height", Integer.class) * map.getProperties().get("tileheight", Integer.class);
    }

    private void createPlayers()
    {
        Player player;

        player = new Player(new Vector2(0, 0), 100.0f,
        game.resourceManager.getAnimationSet(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS),
        game.resourceManager.getAnimationSet(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).get(AnimationName.FACE_DOWN));

//        player = new TeenFutureTrunks(new Vector2(0, 0), 100.0f,
//          game.animationLoader.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS),
//          game.animationLoader.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).get(AnimationName.FACE_DOWN));

        players.put(PlayerName.TEEN_FUTURE_TRUNKS, player);
    }

    private void createEntities()
    {
        gameObjects.addAll(players.values());

        // Create other gameObjects
    }

    @Override
    public void show()
    {
        Gdx.input.setInputProcessor(playInputProcessor);
        //Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta)
    {
        playInputProcessor.update();
        //inputHandler.update();

        for(GameObject gameObject : gameObjects)
        {
            gameObject.update();
        }

        physicsSimulator.update();

        game.camera.position.x = (int)currentPlayer.position.x;
        game.camera.position.y = (int)currentPlayer.position.y;

        game.camera.update();
        mapRenderer.setView(game.camera);
        mapRenderer.render(backgroundLayers);

        batch.setProjectionMatrix(game.camera.combined);
        batch.begin();
        for(GameObject gameObject : gameObjects)
        {
            gameObject.render(batch);
        }
        batch.end();

        mapRenderer.render(foregroundLayers);
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
