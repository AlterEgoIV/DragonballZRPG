package com.dragonballzrpg;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dragonballzrpg.entities.Entity;
import com.dragonballzrpg.entities.animatedentities.players.TeenFutureTrunks;
import com.dragonballzrpg.screens.PlayScreen;

import java.util.ArrayList;
import java.util.List;

public class DragonballZRPG extends Game
{
	public final int VIEWPORT_WIDTH = 240;
	public final int VIEWPORT_HEIGHT = 160;
	public OrthographicCamera camera;
	public Viewport viewport;
	public SpriteBatch batch;
	public List<Entity> entities;
	private AssetManager assetManager;
	private Screen playScreen;

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

		entities = new ArrayList<Entity>();
		entities.add(new TeenFutureTrunks(assetManager));

		playScreen = new PlayScreen(this);
		setScreen(playScreen);
	}

	@Override
	public void render()
	{
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		super.render();
	}

	@Override
	public void dispose()
	{
		batch.dispose();
		assetManager.dispose();
	}
}
