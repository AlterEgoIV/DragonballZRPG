package com.dragonballzrpg.wrappers;

/**
 * Created by Carl on 14/04/2017.
 */
public class Bool
{
    private boolean value;

    public Bool()
    {
        value = false;
    }

    public Bool(boolean value)
    {
        this.value = value;
    }

    public boolean value()
    {
        return value;
    }

    public void set(boolean value)
    {
        this.value = value;
    }

    public boolean equals(boolean value)
    {
        return this.value == value;
    }

    public boolean equals(Bool object)
    {
        return this.value == object.value();
    }
}
