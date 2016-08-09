package com.dragonballzrpg.utilities;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Carl on 07/08/2016.
 */
public class Frame
{
    private TextureRegion frame;
    private double duration;

    public Frame(TextureRegion frame, double duration)
    {
        this.frame = frame;
        this.duration = duration;
    }

    public TextureRegion getFrame()
    {
        return frame;
    }

    public void setFrame(TextureRegion frame)
    {
        this.frame = frame;
    }

    public double getDuration()
    {
        return duration;
    }

    public void setDuration(double duration)
    {
        this.duration = duration;
    }
}