package com.dragonballzrpg.utilities;

import com.badlogic.gdx.Gdx;
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
public class SpriteSheetAnimationsExtractor
{
    private ResourceManager assetManager;
    private Map<String, Frame[]> animations;

    public SpriteSheetAnimationsExtractor(ResourceManager assetManager)
    {
        this.assetManager = assetManager;
        animations = new HashMap<String, Frame[]>();
    }

    public void extractAnimations(String spriteSheet, String spriteSheetDataFile)
    {
        Texture sheet = assetManager.get(spriteSheet);
        List<Frame> frames = new ArrayList<Frame>();

        try
        {
            XmlReader.Element rootElement = new XmlReader().parse(Gdx.files.internal(spriteSheetDataFile));
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
                    int xOffset = Integer.parseInt(nestedChild.get("xOffset"));
                    int yOffset = Integer.parseInt(nestedChild.get("yOffset"));
                    double duration = Double.parseDouble(nestedChild.get("duration"));

                    frames.add(new Frame(new TextureRegion(sheet, x, y, width, height), xOffset, yOffset, duration));
                }

                Frame[] tempFrames = new Frame[frames.size()];

                for(int k = 0; k < frames.size(); ++k)
                {
                    tempFrames[k] = frames.get(k);
                }

                animations.put(animationName, tempFrames);
                frames.clear();
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public Frame[] getAnimation(String animation)
    {
        return animations.get(animation);
    }

    public Frame getAnimationFrame(String animation, int frame)
    {
        Frame[] frames = animations.get(animation);

        return frames[frame];
    }
}
