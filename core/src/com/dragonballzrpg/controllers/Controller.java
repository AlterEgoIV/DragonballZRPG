package com.dragonballzrpg.controllers;

import com.dragonballzrpg.entities.Entity;

/**
 * Created by Carl on 18/04/2017.
 */
public abstract class Controller
{
    protected Entity entity;

    protected Controller(Entity entity)
    {
        this.entity = entity;
    }

    public abstract void execute();
}
