package com.dragonballzrpg.utilities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carl on 07/08/2016.
 */
public class Animation
{
    private List<Frame> frames;
    private int currentFrame;
    private double animationDuration;
    private double currentFrameDuration;
    private boolean loops;

    public Animation()
    {
        frames = new ArrayList<Frame>();
        currentFrame = 0;
        animationDuration = 0.0d;
        currentFrameDuration = 0.0d;
        loops = false;
    }

    public Animation(TextureRegion[] frames, double frameDuration)
    {
        this.frames = new ArrayList<Frame>();

        for(TextureRegion frame : frames)
        {
            this.frames.add(new Frame(frame, frameDuration));
        }

        currentFrame = 0;
        currentFrameDuration = 0.0d;
        animationDuration = frameDuration * frames.length;
        loops = false;
    }

    public Animation(TextureRegion[] frames, double frameDuration, boolean loops)
    {
        this.loops = loops;
        this.frames = new ArrayList<Frame>();

        for(TextureRegion frame : frames)
        {
            this.frames.add(new Frame(frame, frameDuration));
        }

        currentFrame = 0;
        currentFrameDuration = 0.0d;
        animationDuration = frameDuration * frames.length;
    }

    public void update()
    {
        currentFrameDuration += Gdx.graphics.getDeltaTime();

        if(currentFrameDuration >= frames.get(currentFrame).getDuration())
        {
            currentFrameDuration = 0.0d;

            if(currentFrame < frames.size() - 1)
            {
                ++currentFrame;
            }
            else
            {
                if(loops)
                {
                    currentFrame = 0;
                }
            }
        }
    }

    public void addFrame(TextureRegion frame, double duration)
    {
        animationDuration += duration;
        frames.add(new Frame(frame, duration));
    }

    public void removeFrame(int frame)
    {
        animationDuration -= frames.get(frame).getDuration();
        frames.remove(frame);
    }

    public TextureRegion getCurrentFrame()
    {
        return frames.get(currentFrame).getFrame();
    }

    public TextureRegion getFrame(int index)
    {
        return frames.get(index).getFrame();
    }

    public double getDuration()
    {
        return animationDuration;
    }

    public void reset()
    {
        currentFrame = 0;
        currentFrameDuration = 0.0d;
    }

    public void clear()
    {
        frames = new ArrayList<Frame>();
        currentFrame = 0;
        animationDuration = 0.0d;
        currentFrameDuration = 0.0d;
        loops = false;
    }

    public void loops(boolean loops)
    {
        this.loops = loops;
    }
}