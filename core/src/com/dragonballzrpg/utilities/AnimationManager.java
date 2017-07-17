package com.dragonballzrpg.utilities;

import com.dragonballzrpg.enums.AnimationName;
import com.dragonballzrpg.enums.AnimationSet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Carl on 21/05/2017.
 */
public class AnimationManager
{
    private SpriteSheetAnimationsExtractor spriteSheetAnimationsExtractor;
    private Map<AnimationSet, HashMap<AnimationName, Animation>> setOfAnimationSets;

    public AnimationManager(GameAssetManager assetManager)
    {
        spriteSheetAnimationsExtractor = new SpriteSheetAnimationsExtractor(assetManager);
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

        spriteSheetAnimationsExtractor.extractAnimations(spriteSheet, spriteSheetProperties);

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.FACE_UP,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("faceUp")));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.FACE_DOWN,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("faceDown"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.FACE_LEFT,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("faceLeft"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.FACE_RIGHT,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("faceRight"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.WALK_UP,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("walkUp"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.WALK_DOWN,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("walkDown"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.WALK_LEFT,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("walkLeft"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.WALK_RIGHT,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("walkRight"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.RUN_UP,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("runUp"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.RUN_DOWN,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("runDown"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.RUN_LEFT,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("runLeft"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.RUN_RIGHT,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("runRight"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KNOCKED_BACK_UP,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("knockedBackUp")));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KNOCKED_BACK_DOWN,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("knockedBackDown")));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KNOCKED_BACK_LEFT,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("knockedBackLeft")));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KNOCKED_BACK_RIGHT,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("knockedBackRight")));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.PUNCH_UP_1,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("punchUp1"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.PUNCH_DOWN_1,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("punchDown1"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.PUNCH_LEFT_1,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("punchLeft1"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.PUNCH_RIGHT_1,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("punchRight1"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.PUNCH_UP_2,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("punchUp2"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.PUNCH_DOWN_2,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("punchDown2"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.PUNCH_LEFT_2,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("punchLeft2"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.PUNCH_RIGHT_2,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("punchRight2"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KICK_UP,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("kickUp"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KICK_DOWN,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("kickDown"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KICK_LEFT,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("kickLeft"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KICK_RIGHT,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("kickRight"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KI_BLAST_UP,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("kiBlastUp"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KI_BLAST_DOWN,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("kiBlastDown"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KI_BLAST_LEFT,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("kiBlastLeft"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.KI_BLAST_RIGHT,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("kiBlastRight"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.CONTINUOUS_KI_BLAST_UP,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("continuousKiBlastUp"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.CONTINUOUS_KI_BLAST_DOWN,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("continuousKiBlastDown"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.CONTINUOUS_KI_BLAST_LEFT,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("continuousKiBlastLeft"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.CONTINUOUS_KI_BLAST_RIGHT,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("continuousKiBlastRight"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.FLY_UP,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("flyUp"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.BEGIN_TRANSFORM_TO_SUPER,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("beginTransformToSuper"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.TRANSFORM_TO_SUPER,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("transformToSuper"), true));

        setOfAnimationSets.get(AnimationSet.TEEN_FUTURE_TRUNKS_ANIMATIONS).put(AnimationName.DIE,
        new Animation(spriteSheetAnimationsExtractor.getAnimation("die"), true));
    }
}
