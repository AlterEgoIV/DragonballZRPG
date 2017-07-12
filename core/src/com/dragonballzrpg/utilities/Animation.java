package com.dragonballzrpg.utilities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Carl on 07/08/2016.
 */
public class Animation
{
    private List<Frame> frames;
    private int currentFrame;
    private double animationDuration, currentFrameDuration;
    private boolean loops;

    public Animation()
    {
        frames = new ArrayList<Frame>();
        currentFrame = 0;
        animationDuration = 0.0d;
        currentFrameDuration = 0.0d;
        loops = false;
    }

//    public Animation(TextureRegion[] frames, double frameDuration)
//    {
//        this.frames = new ArrayList<Frame>();
//
//        for(TextureRegion frame : frames)
//        {
//            this.frames.add(new Frame(frame, frameDuration));
//        }
//
//        currentFrame = 0;
//        currentFrameDuration = 0.0d;
//        animationDuration = frameDuration * frames.length;
//        loops = false;
//    }

    public Animation(Frame[] frames)
    {
        this.frames = new ArrayList<Frame>();
        this.frames.addAll(Arrays.asList(frames));

        currentFrame = 0;
        currentFrameDuration = 0.0d;
        loops = false;

        for(Frame frame : frames)
        {
            animationDuration += frame.getDuration();
        }
    }

//    public Animation(TextureRegion[] frames, double frameDuration, boolean loops)
//    {
//        this.loops = loops;
//        this.frames = new ArrayList<Frame>();
//
//        for(TextureRegion frame : frames)
//        {
//            this.frames.add(new Frame(frame, frameDuration));
//        }
//
//        currentFrame = 0;
//        currentFrameDuration = 0.0d;
//        animationDuration = frameDuration * frames.length;
//    }

    public Animation(Frame[] frames, boolean loops)
    {
        this.frames = new ArrayList<Frame>();
        this.frames.addAll(Arrays.asList(frames));
        this.loops = loops;

        currentFrame = 0;
        currentFrameDuration = 0.0d;

        for(Frame frame : frames)
        {
            animationDuration += frame.getDuration();
        }
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

//    public void addFrame(TextureRegion frame, double duration)
//    {
//        animationDuration += duration;
//        frames.add(new Frame(frame, duration));
//    }

    public void addFrame(Frame frame)
    {
        animationDuration += frame.getDuration();
        frames.add(frame);
    }

    public void removeFrame(int frame)
    {
        animationDuration -= frames.get(frame).getDuration();
        frames.remove(frame);
    }

    public Frame getCurrentFrame()
    {
        return frames.get(currentFrame);
    }

    public Frame getFrame(int index)
    {
        return frames.get(index);
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

    public void loops(boolean loops)
    {
        this.loops = loops;
    }
}