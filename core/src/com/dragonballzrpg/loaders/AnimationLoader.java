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
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("faceUp")));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.FACE_DOWN,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("faceDown"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.FACE_LEFT,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("faceLeft"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.FACE_RIGHT,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("faceRight"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.WALK_UP,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("walkUp"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.WALK_DOWN,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("walkDown"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.WALK_LEFT,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("walkLeft"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.WALK_RIGHT,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("walkRight"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.RUN_UP,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("runUp"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.RUN_DOWN,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("runDown"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.RUN_LEFT,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("runLeft"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.RUN_RIGHT,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("runRight"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KNOCKED_BACK_UP,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("knockedBackUp")));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KNOCKED_BACK_DOWN,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("knockedBackDown")));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KNOCKED_BACK_LEFT,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("knockedBackLeft")));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KNOCKED_BACK_RIGHT,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("knockedBackRight")));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.PUNCH_UP_1,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("punchUp1"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.PUNCH_DOWN_1,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("punchDown1"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.PUNCH_LEFT_1,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("punchLeft1"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.PUNCH_RIGHT_1,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("punchRight1"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.PUNCH_UP_2,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("punchUp2"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.PUNCH_DOWN_2,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("punchDown2"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.PUNCH_LEFT_2,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("punchLeft2"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.PUNCH_RIGHT_2,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("punchRight2"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KICK_UP,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("kickUp"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KICK_DOWN,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("kickDown"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KICK_LEFT,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("kickLeft"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KICK_RIGHT,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("kickRight"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KI_BLAST_UP,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("kiBlastUp"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KI_BLAST_DOWN,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("kiBlastDown"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KI_BLAST_LEFT,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("kiBlastLeft"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KI_BLAST_RIGHT,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("kiBlastRight"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.CONTINUOUS_KI_BLAST_UP,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("continuousKiBlastUp"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.CONTINUOUS_KI_BLAST_DOWN,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("continuousKiBlastDown"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.CONTINUOUS_KI_BLAST_LEFT,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("continuousKiBlastLeft"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.CONTINUOUS_KI_BLAST_RIGHT,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("continuousKiBlastRight"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.FLY_UP,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("flyUp"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.BEGIN_TRANSFORM_TO_SUPER,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("beginTransformToSuper"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.TRANSFORM_TO_SUPER,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("transformToSuper"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.DIE,
        new Animation(spriteSheetAnimationsExtractorXML.getAnimation("die"), true));
    }
}
