package com.dragonballzrpg.wrappers;

/**
 * Created by Carl on 17/09/2016.
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

    public boolean getValue()
    {
        return value;
    }

    public void setValue(boolean value)
    {
        this.value = value;
    }

    public boolean equals(boolean value)
    {
        return this.value == value;
    }

    public boolean equals(Bool object)
    {
        return this.value == object.getValue();
    }
}
