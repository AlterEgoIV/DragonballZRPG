package com.dragonballzrpg.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dragonballzrpg.ui.uielements.MenuOption;
import com.dragonballzrpg.ui.uielements.Panel;
import com.dragonballzrpg.ui.uielements.Text;

/**
 * Created by Carl on 25/05/2017.
 */
public class MainMenuUI extends UI
{
    private Viewport viewport;

    public MainMenuUI(Viewport viewport)
    {
        this.viewport = viewport;

        createUIElements();
    }

    private void createUIElements()
    {
        int numElements = 3;
        String[] strings = {"Start", "Controls", "Exit"};
        Vector2 position = new Vector2(0, 0);
        int width = (int)viewport.getWorldWidth() / 7;
        int height = (int)viewport.getWorldHeight() / 7;
        int ySpacing = height / 5;

        for(int i = 0; i < numElements; ++i)
        {
            position.x = viewport.getWorldWidth() / 2;
            position.y = viewport.getWorldHeight() - (viewport.getWorldHeight() / numElements) + (height / 2) - ((height * i) + (ySpacing * i));
            Text text = new Text(position.cpy(), strings[i], .6f, .8f);
            text.position.x -= text.getWidth() / 2;
            text.position.y += text.getHeight() / 2;
            position.x -= width / 2;
            position.y -= height / 2;
            Panel panel = new Panel(position.cpy(), width, height, .45f, .4f, .65f, .5f, Color.CHARTREUSE);

            uiElements.add(new MenuOption(position, width, height, panel, text));
        }
    }
}
