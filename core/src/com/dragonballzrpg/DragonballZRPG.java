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
import com.dragonballzrpg.utilities.SpriteSheetAnimationsExtractorXML;

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
	public GameInputProcessor inputProcessor;
	private SpriteSheetAnimationsExtractorXML spriteSheetAnimationsExtractorXML;

	@Override
	public void create()
	{
		assetManager = new AssetManager();
		spriteSheetAnimationsExtractorXML = new SpriteSheetAnimationsExtractorXML(assetManager);
		setOfAnimationSets = new HashMap<AnimationSet, HashMap<AnimationName, Animation>>();
		initialiseSetOfAnimationSets();
		sounds = new HashMap<SoundName, Sound>();
		screens = new HashMap<ScreenName, Screen>();
		camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
		viewport = new StretchViewport(VIEWPORT_WIDTH, VIEWPORT_HEIGHT, camera);
		inputProcessor = new GameInputProcessor();
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
		String spriteSheet = "spritesheets/futuretrunks/teenFutureTrunks.png";
		String spriteSheetProperties = "spritesheetproperties/teenFutureTrunksSpriteSheet.sprites";

		spriteSheetAnimationsExtractorXML.extractAnimations(spriteSheet, spriteSheetProperties);

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.FACE_UP,
		new Animation(spriteSheetAnimationsExtractorXML.getAnimation("faceUp"), 1));

		Animation animation = new Animation();
		animation.addFrame(spriteSheetAnimationsExtractorXML.getAnimationFrame("faceDown", 0), 5.0d);
		animation.addFrame(spriteSheetAnimationsExtractorXML.getAnimationFrame("faceDown", 1), .25d);
		animation.loops(true);
		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.FACE_DOWN, animation);

		animation = new Animation();
		animation.addFrame(spriteSheetAnimationsExtractorXML.getAnimationFrame("faceLeft", 0), 5.0d);
		animation.addFrame(spriteSheetAnimationsExtractorXML.getAnimationFrame("faceLeft", 1), .25d);
		animation.loops(true);
		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.FACE_LEFT, animation);

		animation = new Animation();
		animation.addFrame(spriteSheetAnimationsExtractorXML.getAnimationFrame("faceRight", 0), 5.0d);
		animation.addFrame(spriteSheetAnimationsExtractorXML.getAnimationFrame("faceRight", 1), .25d);
		animation.loops(true);
		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.FACE_RIGHT, animation);

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.WALK_UP,
		new Animation(spriteSheetAnimationsExtractorXML.getAnimation("walkUp"), .125d, true));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.WALK_DOWN,
		new Animation(spriteSheetAnimationsExtractorXML.getAnimation("walkDown"), .125d, true));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.WALK_LEFT,
		new Animation(spriteSheetAnimationsExtractorXML.getAnimation("walkLeft"), .125d, true));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.WALK_RIGHT,
		new Animation(spriteSheetAnimationsExtractorXML.getAnimation("walkRight"), .125d, true));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.RUN_UP,
		new Animation(spriteSheetAnimationsExtractorXML.getAnimation("runUp"), .125d, true));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.RUN_DOWN,
		new Animation(spriteSheetAnimationsExtractorXML.getAnimation("runDown"), .125d, true));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.RUN_LEFT,
		new Animation(spriteSheetAnimationsExtractorXML.getAnimation("runLeft"), .125d, true));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.RUN_RIGHT,
		new Animation(spriteSheetAnimationsExtractorXML.getAnimation("runRight"), .125d, true));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KNOCKED_BACK_UP,
		new Animation(spriteSheetAnimationsExtractorXML.getAnimation("knockedBackUp"), .25d));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KNOCKED_BACK_DOWN,
		new Animation(spriteSheetAnimationsExtractorXML.getAnimation("knockedBackDown"), .25d));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KNOCKED_BACK_LEFT,
		new Animation(spriteSheetAnimationsExtractorXML.getAnimation("knockedBackLeft"), .25d));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KNOCKED_BACK_RIGHT,
		new Animation(spriteSheetAnimationsExtractorXML.getAnimation("knockedBackRight"), .25d));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.PUNCH_UP_1,
		new Animation(spriteSheetAnimationsExtractorXML.getAnimation("punchUp1"), .0675d, true));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.PUNCH_DOWN_1,
		new Animation(spriteSheetAnimationsExtractorXML.getAnimation("punchDown1"), .0675d, true));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.PUNCH_LEFT_1,
		new Animation(spriteSheetAnimationsExtractorXML.getAnimation("punchLeft1"), 1, true));

//		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).get(AnimationName.PUNCH_LEFT_1).getFrame(0).
//		setRegionX(setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).get(AnimationName.PUNCH_LEFT_1).getFrame(0).getRegionX() +
//		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).get(AnimationName.PUNCH_LEFT_1).getFrame(0).getRegionWidth());
//
//		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).get(AnimationName.PUNCH_LEFT_1).getFrame(0).
//		setRegionX(setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).get(AnimationName.PUNCH_LEFT_1).getFrame(0).getRegionX() +
//		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).get(AnimationName.PUNCH_LEFT_1).getFrame(0).getRegionWidth());
//
//		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).get(AnimationName.PUNCH_LEFT_1).getFrame(1).
//		setRegionX(setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).get(AnimationName.PUNCH_LEFT_1).getFrame(1).getRegionX() +
//		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).get(AnimationName.PUNCH_LEFT_1).getFrame(1).getRegionWidth());
//
//		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).get(AnimationName.PUNCH_LEFT_1).getFrame(2).
//		setRegionX(setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).get(AnimationName.PUNCH_LEFT_1).getFrame(2).getRegionX() +
//		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).get(AnimationName.PUNCH_LEFT_1).getFrame(2).getRegionWidth());
//
//		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).get(AnimationName.PUNCH_LEFT_1).getFrame(3).
//		setRegionX(setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).get(AnimationName.PUNCH_LEFT_1).getFrame(3).getRegionX() +
//		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).get(AnimationName.PUNCH_LEFT_1).getFrame(3).getRegionWidth());

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.PUNCH_RIGHT_1,
		new Animation(spriteSheetAnimationsExtractorXML.getAnimation("punchRight1"), 1, true));

//		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).get(AnimationName.PUNCH_RIGHT_1).getFrame(0).flip(true, false);
//		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).get(AnimationName.PUNCH_RIGHT_1).getFrame(1).flip(true, false);
//		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).get(AnimationName.PUNCH_RIGHT_1).getFrame(2).flip(true, false);
//		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).get(AnimationName.PUNCH_RIGHT_1).getFrame(3).flip(true, false);
//
		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.PUNCH_UP_2,
		new Animation(spriteSheetAnimationsExtractorXML.getAnimation("punchUp2"), .0675d, true));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.PUNCH_DOWN_2,
		new Animation(spriteSheetAnimationsExtractorXML.getAnimation("punchDown2"), .0675d, true));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.PUNCH_LEFT_2,
		new Animation(spriteSheetAnimationsExtractorXML.getAnimation("punchLeft2"), .0675d, true));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.PUNCH_RIGHT_2,
		new Animation(spriteSheetAnimationsExtractorXML.getAnimation("punchRight2"), .0675d, true));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KICK_UP,
		new Animation(spriteSheetAnimationsExtractorXML.getAnimation("kickUp"), .0675d, true));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KICK_DOWN,
		new Animation(spriteSheetAnimationsExtractorXML.getAnimation("kickDown"), .0675d, true));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KICK_LEFT,
		new Animation(spriteSheetAnimationsExtractorXML.getAnimation("kickLeft"), .0675d, true));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KICK_RIGHT,
		new Animation(spriteSheetAnimationsExtractorXML.getAnimation("kickRight"), .0675d, true));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KI_BLAST_UP,
		new Animation(spriteSheetAnimationsExtractorXML.getAnimation("kiBlastUp"), .25d, true));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KI_BLAST_DOWN,
		new Animation(spriteSheetAnimationsExtractorXML.getAnimation("kiBlastDown"), .25d, true));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KI_BLAST_LEFT,
		new Animation(spriteSheetAnimationsExtractorXML.getAnimation("kiBlastLeft"), .25d, true));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KI_BLAST_RIGHT,
		new Animation(spriteSheetAnimationsExtractorXML.getAnimation("kiBlastRight"), .25d, true));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.CONTINUOUS_KI_BLAST_UP,
		new Animation(spriteSheetAnimationsExtractorXML.getAnimation("continuousKiBlastUp"), .25d, true));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.CONTINUOUS_KI_BLAST_DOWN,
		new Animation(spriteSheetAnimationsExtractorXML.getAnimation("continuousKiBlastDown"), .25d, true));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.CONTINUOUS_KI_BLAST_LEFT,
		new Animation(spriteSheetAnimationsExtractorXML.getAnimation("continuousKiBlastLeft"), .25d, true));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.CONTINUOUS_KI_BLAST_RIGHT,
		new Animation(spriteSheetAnimationsExtractorXML.getAnimation("continuousKiBlastRight"), .25d, true));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.FLY_UP,
		new Animation(spriteSheetAnimationsExtractorXML.getAnimation("flyUp"), .25d, true));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.TRANSFORM_TO_SUPER,
		new Animation(spriteSheetAnimationsExtractorXML.getAnimation("transformToSuper"), .25d, true));

		setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.DIE,
		new Animation(spriteSheetAnimationsExtractorXML.getAnimation("die"), 1, true));
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
