package com.dragonballzrpg;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dragonballzrpg.enums.*;
import com.dragonballzrpg.utilities.AnimationManager;
import com.dragonballzrpg.screens.ControlsScreen;
import com.dragonballzrpg.screens.MainMenuScreen;
import com.dragonballzrpg.screens.PlayScreen;
import com.dragonballzrpg.utilities.GameAssetManager;
import com.dragonballzrpg.utilities.SoundSystem;

import java.util.HashMap;
import java.util.Map;

public class DragonballZRPG extends Game
{
	private final int VIEWPORT_WIDTH = 240;
	private final int VIEWPORT_HEIGHT = 160;
	public GameAssetManager assetManager;
	public SoundSystem soundSystem;
	public Map<ScreenName, Screen> screens;
	public OrthographicCamera camera;
	public Viewport viewport;
	//public GameInputProcessor inputProcessor;
	public AnimationManager animationManager;
	public Map<ActionName, Integer> inputToActionMap;

	@Override
	public void create()
	{
		assetManager = new GameAssetManager();
		assetManager.loadAssets(); // load assets first

		animationManager = new AnimationManager(assetManager);
		animationManager.loadAnimations();

		soundSystem = new SoundSystem(assetManager);

		screens = new HashMap<ScreenName, Screen>();
		camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
		viewport = new StretchViewport(VIEWPORT_WIDTH, VIEWPORT_HEIGHT, camera);
		//inputProcessor = new GameInputProcessor();
		//Gdx.input.setInputProcessor(inputProcessor);

		inputToActionMap = new HashMap<ActionName, Integer>();
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

	private void initialiseInputActions()
	{
		inputToActionMap.put(ActionName.UP, Input.Keys.UP);
		inputToActionMap.put(ActionName.DOWN, Input.Keys.DOWN);
		inputToActionMap.put(ActionName.LEFT, Input.Keys.LEFT);
		inputToActionMap.put(ActionName.RIGHT, Input.Keys.RIGHT);
		inputToActionMap.put(ActionName.INTERACT_OR_MELEE, Input.Keys.M);
		inputToActionMap.put(ActionName.CANCEL_OR_ENERGY_ATTACK, Input.Keys.N);
		inputToActionMap.put(ActionName.PAUSE, Input.Keys.SPACE);
		inputToActionMap.put(ActionName.SWITCH_ENERGY_ATTACK, Input.Keys.B);
		inputToActionMap.put(ActionName.SELECT, Input.Keys.ENTER);
	}

	private void initialiseScreens()
	{
		screens.put(ScreenName.MAIN_MENU_SCREEN, new MainMenuScreen(this));
		screens.put(ScreenName.PLAY_SCREEN, new PlayScreen(this));
		screens.put(ScreenName.CONTROLS_SCREEN, new ControlsScreen(this));

		//setScreen(screens.get(ScreenName.MAIN_MENU_SCREEN));
		//setScreen(screens.get(ScreenName.PLAY_SCREEN));
		setScreen(screens.get(ScreenName.CONTROLS_SCREEN));
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
