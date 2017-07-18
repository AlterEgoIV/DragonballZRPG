package com.dragonballzrpg.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.*;
import com.dragonballzrpg.DragonballZRPG;
import com.dragonballzrpg.controllers.PlayerController;
import com.dragonballzrpg.enums.*;
import com.dragonballzrpg.input.InputHandler;
import com.dragonballzrpg.physics.PhysicsSimulator;
import com.dragonballzrpg.gameobjects.GameObject;
import com.dragonballzrpg.gameobjects.characters.Player;
import com.dragonballzrpg.gameobjects.characters.players.TeenFutureTrunks;
import com.dragonballzrpg.ui.PlayUI;

import java.awt.Rectangle;
import java.util.*;
import java.util.List;

/**
 * Created by Carl on 04/08/2016.
 */
public class PlayScreen extends GameScreen implements InputProcessor
{
    private TiledMap map;
    private OrthogonalTiledMapRenderer mapRenderer;
    private int mapWidth, mapHeight;
    private Map<PlayerName, Player> players;
    private GameObject currentPlayer;
    private List<GameObject> entities;
    private PhysicsSimulator physicsSimulator;
    private int[] backgroundLayers, foregroundLayers;
    private PlayerController playerController;
    private InputHandler inputHandler;

    public PlayScreen(DragonballZRPG game)
    {
        super(game, new PlayUI(game.assetManager, game.viewport));

        inputHandler = new InputHandler(game.inputKeyMap);

        physicsSimulator = new PhysicsSimulator();

        loadMaps();

        players = new HashMap<PlayerName, Player>();
        entities = new ArrayList<GameObject>();

        createPlayers();
        currentPlayer = players.get(PlayerName.TEEN_FUTURE_TRUNKS);
        createEntities();

        //game.inputProcessor.add((InputHandler)currentPlayer);

        physicsSimulator.add(currentPlayer);
        playerController = new PlayerController((Player)currentPlayer);
    }

    private void loadMaps()
    {
        //TmxMapLoader.Parameters parameters = new TmxMapLoader.Parameters();
        //parameters.textureMinFilter = Texture.TextureFilter.Nearest;
        //parameters.textureMagFilter = Texture.TextureFilter.Nearest;
        //map = new TmxMapLoader().load("test2.tmx");
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
        mapWidth = map.getProperties().get("width", Integer.class) * map.getProperties().get("tilewidth", Integer.class);
        mapHeight = map.getProperties().get("height", Integer.class) * map.getProperties().get("tileheight", Integer.class);
    }

    private void createPlayers()
    {
        Player player;

        player = new Player(new Vector2(0, 0), 100.0f,
        game.animationManager.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS),
        game.animationManager.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).get(AnimationName.FACE_DOWN));

//        player = new TeenFutureTrunks(new Vector2(0, 0), 100.0f,
//          game.animationManager.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS),
//          game.animationManager.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).get(AnimationName.FACE_DOWN));

        players.put(PlayerName.TEEN_FUTURE_TRUNKS, player);
        inputHandler.setInputControllable(player);
    }

    private void createEntities()
    {
        entities.addAll(players.values());

        // Create other entities
    }

    @Override
    public void show()
    {
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta)
    {
        inputHandler.update();

        //playerController.update();

        for(GameObject gameObject : entities)
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
        for(GameObject gameObject : entities)
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

    @Override
    public boolean keyDown(int keycode)
    {
        inputHandler.setKey(keycode, true);

        return false;
    }

    @Override
    public boolean keyUp(int keycode)
    {
        inputHandler.setKey(keycode, false);

        return false;
    }

    @Override
    public boolean keyTyped(char character)
    {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button)
    {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button)
    {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer)
    {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY)
    {
        return false;
    }

    @Override
    public boolean scrolled(int amount)
    {
        return false;
    }
}
