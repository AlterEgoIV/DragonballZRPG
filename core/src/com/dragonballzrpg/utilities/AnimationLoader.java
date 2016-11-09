package com.dragonballzrpg.utilities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Carl on 07/08/2016.
 */
public class AnimationLoader
{
    private Map<String, TextureRegion[]> animations;

    public AnimationLoader(Texture spriteSheet, String dataFile)
    {
        animations = new HashMap<String, TextureRegion[]>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(Gdx.files.internal(dataFile).read()));
        List<TextureRegion> frames = new ArrayList<TextureRegion>();

        try
        {
            try
            {
                String line;

                // While there is a line from the file left to be read, transfer it to line (String)
                while((line = reader.readLine()) != null)
                {
                    String[] values = line.split(","); // Split the line up into set of String values

                    if(values.length == 1) // If only one String in the line
                    {
                        String name = values[0]; // Set the Animation name

                        // Create TextureRegion array the same size as List of frames
                        TextureRegion[] textureRegions = new TextureRegion[frames.size()];

                        // Convert the List of frames to array of TextureRegions
                        for(int i = 0; i < frames.size(); ++i)
                        {
                            textureRegions[i] = frames.get(i);
                        }

                        // Add the current name and frames to the animations HashMap
                        animations.put(name, textureRegions);

                        // Reset frames
                        frames = new ArrayList<TextureRegion>();
                    }
                    else
                    {
                        // Convert the values
                        int frameX = Integer.parseInt(values[0]);
                        int frameY = Integer.parseInt(values[1]);
                        int frameWidth = Integer.parseInt(values[2]);
                        int frameHeight = Integer.parseInt(values[3]);

                        // Create a new TextureRegion and set it to the specified dimensions at the given coordinates
                        TextureRegion frame = new TextureRegion(spriteSheet, frameX, frameY, frameWidth, frameHeight);

                        frames.add(frame); // Add the frame to a List of frames
                    }
                }
            }
            finally
            {
                reader.close();
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public TextureRegion[] load(String animation)
    {
        return animations.get(animation);
    }

    public TextureRegion load(String animation, int frame)
    {
        TextureRegion[] frames = animations.get(animation);

        return new TextureRegion(frames[frame]);
    }
}