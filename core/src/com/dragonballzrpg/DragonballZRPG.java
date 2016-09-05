package com.dragonballzrpg;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dragonballzrpg.entities.Entity;
import com.dragonballzrpg.entities.animatedentities.players.TeenFutureTrunks;
import com.dragonballzrpg.screens.PlayScreen;
import com.dragonballzrpg.input.GameInputProcessor;
import com.dragonballzrpg.input.InputHandler;

import java.util.HashMap;
import java.util.Map;

public class DragonballZRPG extends Game
{
	private final int VIEWPORT_WIDTH = 240;
	private final int VIEWPORT_HEIGHT = 160;
	public OrthographicCamera camera;
	public Viewport viewport;
	public SpriteBatch batch;
	public Map<String, Entity> entities;
	private AssetManager assetManager;
	private Screen playScreen;
	private GameInputProcessor inputProcessor;

	@Override
	public void create()
	{
		camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
		camera.translate(VIEWPORT_WIDTH / 2, VIEWPORT_HEIGHT / 2);
		viewport = new StretchViewport(VIEWPORT_WIDTH, VIEWPORT_HEIGHT, camera);
		viewport.apply();

		batch = new SpriteBatch();

		assetManager = new AssetManager();
		assetManager.load("spritesheets/futuretrunks/teenFutureTrunks.png", Texture.class);
		assetManager.finishLoading();

		inputProcessor = new GameInputProcessor();
		Gdx.input.setInputProcessor(inputProcessor);

		entities = new HashMap<String, Entity>();
		entities.put("teenFutureTrunks", new TeenFutureTrunks(assetManager, camera, inputProcessor));

		inputProcessor.setInputHandler((InputHandler)entities.get("teenFutureTrunks"));

		playScreen = new PlayScreen(this);
		setScreen(playScreen);
	}

	@Override
	public void render()
	{
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		super.render();
	}

	@Override
	public void dispose()
	{
		batch.dispose();
		assetManager.dispose();
		playScreen.dispose();
	}

	@Override
	public void resize(int width, int height)
	{
		viewport.update(width, height);
	}
}
