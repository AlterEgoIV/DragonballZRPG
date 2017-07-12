package com.dragonballzrpg.loaders;

import com.badlogic.gdx.assets.AssetManager;
import com.dragonballzrpg.enums.AnimationName;
import com.dragonballzrpg.enums.AnimationSet;
import com.dragonballzrpg.utilities.Animation;
import com.dragonballzrpg.utilities.GameAssetManager;
import com.dragonballzrpg.utilities.SpriteSheetAnimationsExtractorXML;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Carl on 21/05/2017.
 */
public class AnimationLoader
{
    private SpriteSheetAnimationsExtractorXML spriteSheetAnimationsExtractorXML;
    private Map<AnimationSet, HashMap<AnimationName, Animation>> setOfAnimationSets;

    public AnimationLoader(GameAssetManager assetManager)
    {
        spriteSheetAnimationsExtractorXML = new SpriteSheetAnimationsExtractorXML(assetManager);
        setOfAnimationSets = new HashMap<AnimationSet, HashMap<AnimationName, Animation>>();

        initialiseSetOfAnimationSets();
    }

    public HashMap<AnimationName, Animation> get(AnimationSet animationSet)
    {
        return setOfAnimationSets.get(animationSet);
    }

    private void initialiseSetOfAnimationSets()
    {
        setOfAnimationSets.put(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS, new HashMap<AnimationName, Animation>());
        setOfAnimationSets.put(AnimationSet.FUTURE_TRUNKS_ANIMATIONS, new HashMap<AnimationName, Animation>());
    }

    public void loadAnimations()
    {
        loadTeenFutureTrunksAnimations();
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

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.PUNCH_RIGHT_1,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("punchRight1"), 1, true));

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

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.BEGIN_TRANSFORM_TO_SUPER,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("beginTransformToSuper"), .25d, true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.TRANSFORM_TO_SUPER,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("transformToSuper"), .25d, true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.DIE,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("die"), 1, true));
    }
}
