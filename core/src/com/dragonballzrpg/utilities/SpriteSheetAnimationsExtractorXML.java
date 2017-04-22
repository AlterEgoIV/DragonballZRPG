package com.dragonballzrpg.utilities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.XmlReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Carl on 22/04/2017.
 */
public class SpriteSheetAnimationsExtractorXML
{
    private AssetManager assetManager;
    private Map<String, TextureRegion[]> animations;

    public SpriteSheetAnimationsExtractorXML(AssetManager assetManager)
    {
        this.assetManager = assetManager;
        animations = new HashMap<String, TextureRegion[]>();
    }

    public void extractAnimations(String spriteSheet, String xml)
    {
        Texture sheet = assetManager.get(spriteSheet);
        List<TextureRegion> frames = new ArrayList<TextureRegion>();

        try
        {
            XmlReader.Element rootElement = new XmlReader().parse(Gdx.files.internal(xml));
            XmlReader.Element element = rootElement.getChildByName("definitions").getChildByName("dir");

            for(int i = 0; i < element.getChildCount(); ++i)
            {
                XmlReader.Element child = element.getChild(i);
                String animationName = child.get("name");

                for(int j = 0; j < child.getChildCount(); ++j)
                {
                    XmlReader.Element nestedChild = child.getChild(j);

                    int x = Integer.parseInt(nestedChild.get("x"));
                    int y = Integer.parseInt(nestedChild.get("y"));
                    int width = Integer.parseInt(nestedChild.get("w"));
                    int height = Integer.parseInt(nestedChild.get("h"));

                    TextureRegion frame = new TextureRegion(sheet, x, y, width, height);
                    frames.add(frame);
                }

                TextureRegion[] textureRegions = new TextureRegion[frames.size()];

                for(int k = 0; k < frames.size(); ++k)
                {
                    textureRegions[k] = frames.get(k);
                }

                animations.put(animationName, textureRegions);
                frames.clear();
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public TextureRegion[] getAnimation(String animation)
    {
        return animations.get(animation);
    }

    public TextureRegion getAnimationFrame(String animation, int frame)
    {
        TextureRegion[] frames = animations.get(animation);

        return frames[frame];
    }
}
