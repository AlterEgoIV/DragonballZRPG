package com.dragonballzrpg;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dragonballzrpg.enums.*;
import com.dragonballzrpg.input.GameInputProcessor;
import com.dragonballzrpg.loaders.AnimationLoader;
import com.dragonballzrpg.screens.ControlsScreen;
import com.dragonballzrpg.screens.MainMenuScreen;
import com.dragonballzrpg.screens.PlayScreen;
import com.dragonballzrpg.utilities.Animation;
import com.dragonballzrpg.utilities.SpriteSheetAnimationsExtractorXML;

import java.util.HashMap;
import java.util.Map;

public class DragonballZRPG extends Game
{
	private final int VIEWPORT_WIDTH = 240;
	private final int VIEWPORT_HEIGHT = 160;
	public AssetManager assetManager;
	public Map<SoundName, Sound> sounds;
	public Map<ScreenName, Screen> screens;
	public OrthographicCamera camera;
	public Viewport viewport;
	public GameInputProcessor inputProcessor;
	public AnimationLoader animationLoader;
	public Map<ActionName, Integer> inputActions;

	@Override
	public void create()
	{
		assetManager = new AssetManager();
		loadAssets(); // load assets first

		sounds = new HashMap<SoundName, Sound>();
		loadSounds();

		animationLoader = new AnimationLoader(assetManager);
		animationLoader.loadAnimations();

		screens = new HashMap<ScreenName, Screen>();
		camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
		viewport = new StretchViewport(VIEWPORT_WIDTH, VIEWPORT_HEIGHT, camera);
		inputProcessor = new GameInputProcessor();
		Gdx.input.setInputProcessor(inputProcessor);

		inputActions = new HashMap<ActionName, Integer>();
		initialiseInputActions();

		initialiseScreens();
		initialiseCamera();
		initialiseViewport();
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
		assetManager.dispose();
		screens.get(ScreenName.PLAY_SCREEN).dispose();
	}

	@Override
	public void resize(int width, int height)
	{
		viewport.update(width, height);
	}

	private void loadAssets()
	{
		assetManager.load("spritesheets/futuretrunks/teenFutureTrunks.png", Texture.class);

		assetManager.load("sounds/melee1.wav", Sound.class);
		assetManager.load("sounds/melee2.wav", Sound.class);
		assetManager.load("sounds/running.wav", Sound.class);

		assetManager.finishLoading();
	}

	private void loadSounds()
	{
		sounds.put(SoundName.MELEE_1, assetManager.get("sounds/melee1.wav", Sound.class));
		sounds.put(SoundName.MELEE_2, assetManager.get("sounds/melee2.wav", Sound.class));
		sounds.put(SoundName.RUNNING, assetManager.get("sounds/running.wav", Sound.class));
	}

	private void initialiseInputActions()
	{
		inputActions.put(ActionName.UP, Input.Keys.UP);
		inputActions.put(ActionName.DOWN, Input.Keys.DOWN);
		inputActions.put(ActionName.LEFT, Input.Keys.LEFT);
		inputActions.put(ActionName.RIGHT, Input.Keys.RIGHT);
		inputActions.put(ActionName.INTERACT_MELEE, Input.Keys.M);
		inputActions.put(ActionName.CANCEL_ENERGY_ATTACK, Input.Keys.N);
		inputActions.put(ActionName.PAUSE, Input.Keys.ENTER);
		inputActions.put(ActionName.SWITCH_ENERGY_ATTACK, Input.Keys.B);
	}

	private void initialiseScreens()
	{
		screens.put(ScreenName.MAIN_MENU_SCREEN, new MainMenuScreen(this));
		screens.put(ScreenName.PLAY_SCREEN, new PlayScreen(this));
		screens.put(ScreenName.CONTROLS_SCREEN, new ControlsScreen(this));

		setScreen(screens.get(ScreenName.MAIN_MENU_SCREEN));
		//setScreen(screens.get(ScreenName.PLAY_SCREEN));
	}

	private void initialiseCamera()
	{
		// Move the cameras bottom left corner from (0, 0) to half the VIEWPORT_WIDTH right and half the VIEWPORT_HEIGHT up
		camera.translate(VIEWPORT_WIDTH / 2, VIEWPORT_HEIGHT / 2);
	}

	private void initialiseViewport()
	{
		viewport.apply();
	}
}
