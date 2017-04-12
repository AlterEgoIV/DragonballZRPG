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
import com.dragonballzrpg.enums.AnimationName;
import com.dragonballzrpg.enums.AnimationSet;
import com.dragonballzrpg.input.GameInputProcessor;
import com.dragonballzrpg.input.InputHandler;
import com.dragonballzrpg.screens.PlayScreen;
import com.dragonballzrpg.utilities.Animation;
import com.dragonballzrpg.utilities.SpriteSheetAnimationsExtractor;

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
	private SpriteSheetAnimationsExtractor spriteSheetAnimationsExtractor;
	private Map<String, Screen> screens;
	private GameInputProcessor inputProcessor;
	private Map<AnimationSet, HashMap<AnimationName, Animation>> setOfAnimationSets;

	@Override
	public void create()
	{
		assetManager = new AssetManager();
		spriteSheetAnimationsExtractor = new SpriteSheetAnimationsExtractor();
		setOfAnimationSets = new HashMap<AnimationSet, HashMap<AnimationName, Animation>>();
		initialiseSetOfAnimationSets();
		camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
		viewport = new StretchViewport(VIEWPORT_WIDTH, VIEWPORT_HEIGHT, camera);
		entities = new HashMap<String, Entity>();
		screens = new HashMap<String, Screen>();

		loadAssets(); // load assets first
		loadAnimations();

		initialiseCamera();
		initialiseViewport();

		batch = new SpriteBatch();

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

	private void loadAssets()
	{
		assetManager.load("spritesheets/futuretrunks/teenFutureTrunks.png", Texture.class);

		assetManager.load("sounds/melee1.wav", Sound.class);
		assetManager.load("sounds/melee2.wav", Sound.class);
		assetManager.load("sounds/running.wav", Sound.class);

		assetManager.finishLoading();
	}

	private void initialiseSetOfAnimationSets()
	{
		setOfAnimationSets.put(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS, new HashMap<AnimationName, Animation>());
		setOfAnimationSets.put(AnimationSet.FUTURE_TRUNKS_ANIMATIONS, new HashMap<AnimationName, Animation>());
	}

	private void loadAnimations()
	{
		loadTeenFutureTrunksAnimations();
	}

	private void loadTeenFutureTrunksAnimations()
	{
		Animation animation = new Animation();
		String spriteSheet = "spritesheets/futuretrunks/teenFutureTrunks.png";
		String spriteSheetProperties = "spritesheetproperties/teenFutureTrunks.csv";

		spriteSheetAnimationsExtractor.extractAnimations(assetManager.get(spriteSheet, Texture.class), spriteSheetProperties);

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.FACE_UP,
		new Animation(spriteSheetAnimationsExtractor.getAnimation("facingUp"), 1));

		animation.addFrame(spriteSheetAnimationsExtractor.getAnimationFrame("facingDown", 0), 5.0d);
		animation.addFrame(spriteSheetAnimationsExtractor.getAnimationFrame("facingDown", 1), .25d);
		animation.loops(true);
		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.FACE_DOWN, animation);

		animation = new Animation();
		animation.addFrame(spriteSheetAnimationsExtractor.getAnimationFrame("facingLeft", 0), 5.0d);
		animation.addFrame(spriteSheetAnimationsExtractor.getAnimationFrame("facingLeft", 1), .25d);
		animation.loops(true);
		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.FACE_LEFT, animation);

		animation = new Animation();
		animation.addFrame(spriteSheetAnimationsExtractor.getAnimationFrame("facingRight", 0), 5.0d);
		animation.addFrame(spriteSheetAnimationsExtractor.getAnimationFrame("facingRight", 1), .25d);
		animation.loops(true);
		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.FACE_RIGHT, animation);

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.WALK_UP,
		new Animation(spriteSheetAnimationsExtractor.getAnimation("walkingUp"), .125d));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.WALK_DOWN,
		new Animation(spriteSheetAnimationsExtractor.getAnimation("walkingDown"), .125d));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.WALK_LEFT,
		new Animation(spriteSheetAnimationsExtractor.getAnimation("walkingLeft"), .125d));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.WALK_RIGHT,
		new Animation(spriteSheetAnimationsExtractor.getAnimation("walkingRight"), .125d));
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

	private void initialiseInputProcessor()
	{
		inputProcessor = new GameInputProcessor();
		Gdx.input.setInputProcessor(inputProcessor);
	}

	private void initialiseEntities()
	{
		entities.put("teenFutureTrunks", new TeenFutureTrunks(assetManager, camera, inputProcessor,
		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS)));
	}

	private void initialiseScreens()
	{
		screens.put("playScreen", new PlayScreen(this));

		setScreen(screens.get("playScreen"));
	}
}
