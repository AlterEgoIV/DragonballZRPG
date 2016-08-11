package com.dragonballzrpg;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragonballzrpg.entities.Entity;
import com.dragonballzrpg.entities.animatedentities.players.TeenFutureTrunks;
import com.dragonballzrpg.screens.PlayScreen;

import java.util.ArrayList;
import java.util.List;

public class DragonballZRPG extends Game
{
	private SpriteBatch batch;
	private AssetManager assetManager;
	private List<Entity> entities;
	private Screen playScreen;

	@Override
	public void create()
	{
		batch = new SpriteBatch();
		assetManager = new AssetManager();
		assetManager.load("spritesheets/futuretrunks/teenFutureTrunks.png", Texture.class);
		assetManager.finishLoading();

		entities = new ArrayList<Entity>();
		entities.add(new TeenFutureTrunks(assetManager));

		playScreen = new PlayScreen(batch, entities);
		setScreen(playScreen);
	}

	@Override
	public void render()
	{
		//batch.begin();
		super.render();
		//batch.end();
	}

	@Override
	public void dispose()
	{
		batch.dispose();
		assetManager.dispose();
	}
}
