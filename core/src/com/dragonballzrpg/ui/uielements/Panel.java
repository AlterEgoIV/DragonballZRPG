package com.dragonballzrpg.ui.uielements;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Carl on 26/05/2017.
 */
public class Panel extends UIElement
{
    private Texture selectedTexture, unselectedTexture;
    private Color colour;
    private Text text, defaultText;

    public Panel(float x, float y, int width, int height, Color colour, float alpha)
    {
        super(x, y, width, height);

        this.colour = colour;
        this.colour.a = alpha;
        pixmap.setColor(colour);
        pixmap.fillRectangle(0, 0, width, height);
        texture = new Texture(pixmap);
        unselectedTexture = new Texture(pixmap);

        pixmap.setColor(Color.RED);
        pixmap.fillRectangle(0, 0, width, height);
        selectedTexture = new Texture(pixmap);
        pixmap.dispose();

        text = new Text("", position.x, position.y, 1, 1);
        defaultText = new Text("", position.x, position.y, 1, 1);
    }

    public Panel(float x, float y, int width, int height, Color colour, float alpha, Text text)
    {
        super(x, y, width, height);

        this.text = text.copy();
        this.defaultText = text.copy();
        this.colour = colour;
        this.colour.a = alpha;
        pixmap.setColor(colour);
        pixmap.fillRectangle(0, 0, width, height);
        texture = new Texture(pixmap);
        unselectedTexture = new Texture(pixmap);

        pixmap.setColor(Color.RED);
        pixmap.fillRectangle(0, 0, width, height);
        selectedTexture = new Texture(pixmap);
        pixmap.dispose();
    }

    @Override
    public void update()
    {

    }

    @Override
    public void render(SpriteBatch batch)
    {
        batch.draw(texture, position.x - width / 2, position.y - height / 2);
        text.render(batch);
    }

    public void isSelected(boolean isSelected)
    {
        if(isSelected)
        {
            texture = selectedTexture;
        }
        else
        {
            texture = unselectedTexture;
        }
    }

    public void setText(String text)
    {
        this.text.setText(text, position.x, position.y);
    }

    public void resetText()
    {
        this.text = defaultText.copy();
    }
}
