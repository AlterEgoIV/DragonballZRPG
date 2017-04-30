package com.dragonballzrpg.utilities;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Carl on 07/08/2016.
 */
public class Frame
{
    private TextureRegion frame;
    private double duration;
    public Vector2 relativePosition;

    public Frame(TextureRegion frame, double duration)
    {
        this.frame = frame;
        this.duration = duration;
        relativePosition = new Vector2();
    }

    public TextureRegion getTextureRegion()
    {
        return frame;
    }

    public double getDuration()
    {
        return duration;
    }
}