package com.dragonballzrpg.utilities;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Carl on 07/08/2016.
 */
public class Frame
{
    private TextureRegion frame;
    private int xOffset, yOffset;
    private double duration;

    public Frame(TextureRegion frame, int xOffset, int yOffset, double duration)
    {
        this.frame = frame;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.duration = duration;
    }

    public TextureRegion getTextureRegion()
    {
        return frame;
    }

    public int getXOffset()
    {
        return xOffset;
    }

    public int getYOffset()
    {
        return yOffset;
    }

    public double getDuration()
    {
        return duration;
    }
}