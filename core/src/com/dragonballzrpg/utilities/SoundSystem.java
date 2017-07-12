package com.dragonballzrpg.utilities;

import com.badlogic.gdx.audio.Sound;
import com.dragonballzrpg.enums.SoundName;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Carl on 12/07/2017.
 */
public class SoundSystem
{
    private GameAssetManager assetManager;
    private Map<SoundName, Sound> sounds;

    public SoundSystem(GameAssetManager assetManager)
    {
        this.assetManager = assetManager;
        sounds = new HashMap<SoundName, Sound>();

        initialiseSounds();
    }

    private void initialiseSounds()
    {
        sounds.put(SoundName.MELEE_1, assetManager.get("sounds/melee1.wav", Sound.class));
        sounds.put(SoundName.MELEE_2, assetManager.get("sounds/melee2.wav", Sound.class));
        sounds.put(SoundName.RUNNING, assetManager.get("sounds/running.wav", Sound.class));
    }

    public Sound get(SoundName soundName)
    {
        return sounds.get(soundName);
    }
}
