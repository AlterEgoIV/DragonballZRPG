package com.dragonballzrpg;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dragonballzrpg.entities.Entity;
import com.dragonballzrpg.entities.animatedentities.players.TeenFutureTrunks;
import com.dragonballzrpg.input.GameInputProcessor;
import com.dragonballzrpg.input.InputHandler;
import com.dragonballzrpg.screens.PlayScreen;

import java.util.HashMap;
import java.util.Map;

public class DragonballZRPG extends Game
{
	private final int VIEWPORT_WIDTH = 240;
	private final int VIEWPORT_HEIGHT = 160;
	public OrthographicCamera camera;
	private Viewport viewport;
	public SpriteBatch batch;
	public Map<String, Entity> entities;
	private AssetManager assetManager;
	private Map<String, Screen> screens;
	private GameInputProcessor inputProcessor;

	@Override
	public void create()
	{
		initialiseCamera();
		initialiseViewport();

		batch = new SpriteBatch();

		loadAssets();
		initialiseInputProcessor();
		initialiseEntities();

		// Set the user controlled entity to TeenFutureTrunks object in entities
		inputProcessor.setInputHandler((InputHandler)entities.get("teenFutureTrunks"));

		initialiseScreens();
	}

	@Override
	public void render()
	{
		Gdx.gl.glClearColor(0, 0, 0, 1); // Set the colour the screen is cleared with
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear the screen

		super.render(); // ^Game.render()
	}

	@Override
	public void dispose()
	{
		batch.dispose();
		assetManager.dispose();
		screens.get("playScreen").dispose();
	}

	@Override
	public void resize(int width, int height)
	{
		viewport.update(width, height);
	}

	private void initialiseCamera()
	{
		camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);

		// Move the cameras bottom left corner from (0, 0) to half the VIEWPORT_WIDTH right and half the VIEWPORT_HEIGHT up
		camera.translate(VIEWPORT_WIDTH / 2, VIEWPORT_HEIGHT / 2);
	}

	private void initialiseViewport()
	{
		viewport = new StretchViewport(VIEWPORT_WIDTH, VIEWPORT_HEIGHT, camera);
		viewport.apply();
	}

	private void loadAssets()
	{
		assetManager = new AssetManager();

		assetManager.load("spritesheets/futuretrunks/teenFutureTrunks.png", Texture.class);

		assetManager.load("sounds/melee1.wav", Sound.class);
		assetManager.load("sounds/melee2.wav", Sound.class);
		assetManager.load("sounds/running.wav", Sound.class);

		assetManager.finishLoading();
	}

	private void initialiseInputProcessor()
	{
		inputProcessor = new GameInputProcessor();
		Gdx.input.setInputProcessor(inputProcessor);
	}

	private void initialiseEntities()
	{
		entities = new HashMap<String, Entity>();
		entities.put("teenFutureTrunks", new TeenFutureTrunks(assetManager, camera, inputProcessor));
	}

	private void initialiseScreens()
	{
		screens = new HashMap<String, Screen>();

		screens.put("playScreen", new PlayScreen(this));

		setScreen(screens.get("playScreen"));
	}
}
