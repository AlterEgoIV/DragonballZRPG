package com.dragonballzrpg;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dragonballzrpg.enums.AnimationName;
import com.dragonballzrpg.enums.AnimationSet;
import com.dragonballzrpg.enums.ScreenName;
import com.dragonballzrpg.enums.SoundName;
import com.dragonballzrpg.input.GameInputProcessor;
import com.dragonballzrpg.screens.PlayScreen;
import com.dragonballzrpg.utilities.Animation;
import com.dragonballzrpg.utilities.SpriteSheetAnimationsExtractor;

import java.util.HashMap;
import java.util.Map;

public class DragonballZRPG extends Game
{
	private final int VIEWPORT_WIDTH = 240;
	private final int VIEWPORT_HEIGHT = 160;
	public AssetManager assetManager;
	public Map<AnimationSet, HashMap<AnimationName, Animation>> setOfAnimationSets;
	public Map<SoundName, Sound> sounds;
	public Map<ScreenName, Screen> screens;
	public OrthographicCamera camera;
	private Viewport viewport;
	private SpriteSheetAnimationsExtractor spriteSheetAnimationsExtractor;
	public GameInputProcessor inputProcessor;

	@Override
	public void create()
	{
		assetManager = new AssetManager();
		spriteSheetAnimationsExtractor = new SpriteSheetAnimationsExtractor();
		setOfAnimationSets = new HashMap<AnimationSet, HashMap<AnimationName, Animation>>();
		initialiseSetOfAnimationSets();
		sounds = new HashMap<SoundName, Sound>();
		screens = new HashMap<ScreenName, Screen>();
		camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
		viewport = new StretchViewport(VIEWPORT_WIDTH, VIEWPORT_HEIGHT, camera);
		//inputProcessor = new GameInputProcessor();
		Gdx.input.setInputProcessor(inputProcessor);

		loadAssets(); // load assets first
		loadAnimations();
		loadSounds();

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

	private void initialiseSetOfAnimationSets()
	{
		setOfAnimationSets.put(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS, new HashMap<AnimationName, Animation>());
		setOfAnimationSets.put(AnimationSet.FUTURE_TRUNKS_ANIMATIONS, new HashMap<AnimationName, Animation>());
	}

	private void loadAnimations()
	{
		loadTeenFutureTrunksAnimations();
	}

	private void loadSounds()
	{
		sounds.put(SoundName.MELEE_1, assetManager.get("sounds/melee1.wav", Sound.class));
		sounds.put(SoundName.MELEE_2, assetManager.get("sounds/melee2.wav", Sound.class));
		sounds.put(SoundName.RUNNING, assetManager.get("sounds/running.wav", Sound.class));
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
		new Animation(spriteSheetAnimationsExtractor.getAnimation("walkingUp"), .125d, true));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.WALK_DOWN,
		new Animation(spriteSheetAnimationsExtractor.getAnimation("walkingDown"), .125d, true));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.WALK_LEFT,
		new Animation(spriteSheetAnimationsExtractor.getAnimation("walkingLeft"), .125d, true));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.WALK_RIGHT,
		new Animation(spriteSheetAnimationsExtractor.getAnimation("walkingRight"), .125d, true));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.RUN_UP,
		new Animation(spriteSheetAnimationsExtractor.getAnimation("runningUp"), .125d, true));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.RUN_DOWN,
		new Animation(spriteSheetAnimationsExtractor.getAnimation("runningDown"), .125d, true));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.RUN_LEFT,
		new Animation(spriteSheetAnimationsExtractor.getAnimation("runningLeft"), .125d, true));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.RUN_RIGHT,
		new Animation(spriteSheetAnimationsExtractor.getAnimation("runningRight"), .125d, true));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.PUNCH_UP_1,
		new Animation(spriteSheetAnimationsExtractor.getAnimation("punch1Up"), .0675d));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.PUNCH_DOWN_1,
		new Animation(spriteSheetAnimationsExtractor.getAnimation("punch1Down"), .0675d));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.PUNCH_LEFT_1,
		new Animation(spriteSheetAnimationsExtractor.getAnimation("punch1Left"), .0675d));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.PUNCH_RIGHT_1,
		new Animation(spriteSheetAnimationsExtractor.getAnimation("punch1Right"), .0675d));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.PUNCH_UP_2,
		new Animation(spriteSheetAnimationsExtractor.getAnimation("punch2Up"), .0675d));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.PUNCH_DOWN_2,
		new Animation(spriteSheetAnimationsExtractor.getAnimation("punch2Down"), .0675d));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.PUNCH_LEFT_2,
		new Animation(spriteSheetAnimationsExtractor.getAnimation("punch2Left"), .0675d));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.PUNCH_RIGHT_2,
		new Animation(spriteSheetAnimationsExtractor.getAnimation("punch2Right"), .0675d));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KICK_UP,
		new Animation(spriteSheetAnimationsExtractor.getAnimation("kickUp"), .0675d));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KICK_DOWN,
		new Animation(spriteSheetAnimationsExtractor.getAnimation("kickDown"), .0675d));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KICK_LEFT,
		new Animation(spriteSheetAnimationsExtractor.getAnimation("kickLeft"), .0675d));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KICK_RIGHT,
		new Animation(spriteSheetAnimationsExtractor.getAnimation("kickRight"), .0675d));
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

	private void initialiseScreens()
	{
		screens.put(ScreenName.PLAY_SCREEN, new PlayScreen(this));

		setScreen(screens.get(ScreenName.PLAY_SCREEN));
	}
}
