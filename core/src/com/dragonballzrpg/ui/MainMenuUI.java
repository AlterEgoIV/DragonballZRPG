package com.dragonballzrpg.ui;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dragonballzrpg.enums.*;
import com.dragonballzrpg.enums.MenuOption;
import com.dragonballzrpg.ui.uielements.*;

/**
 * Created by Carl on 25/05/2017.
 */
public class MainMenuUI extends UI
{
    public Cursor cursor;

    public MainMenuUI(AssetManager assetManager, Viewport viewport)
    {
        super(assetManager, viewport);

        cursor = new Cursor(new MenuOption[]{MenuOption.START, MenuOption.CONTROLS, MenuOption.EXIT});

        createUIElements(4);
    }

    private void createUIElements(int numElements)
    {
        float rootX = viewport.getWorldWidth() / 2, rootY = viewport.getWorldHeight() / 2;
        int rootWidth = (int)(viewport.getWorldWidth() * .4), rootHeight = (int)(viewport.getWorldHeight() * .8);
        Color rootColour = Color.ROYAL;
        float rootAlpha = 1f;

        float[] xPositions =
        {
            rootX,
            rootX,
            rootX
        };

        float[] yPositions =
        {
            rootY + (rootHeight / numElements),
            rootY,
            rootY - (rootHeight / numElements)
        };

        int[] widths =
        {
            (int)(rootWidth * .6),
            (int)(rootWidth * .6),
            (int)(rootWidth * .6)
        };

        int[] heights =
        {
            (int)(rootHeight * .2),
            (int)(rootHeight * .2),
            (int)(rootHeight * .2)
        };

        Color[] colours =
        {
            Color.NAVY,
            Color.NAVY,
            Color.NAVY
        };

        float[] alphas =
        {
            1f, 1f, 1f
        };

        String[] strings =
        {
            "Start", "Controls", "Exit"
        };

        // Create root element
        uiElements.add(new Panel(rootX, rootY, rootWidth, rootHeight, rootColour, rootAlpha));

        for(int i = 0; i < numElements - 1; ++i)
        {
            Panel panel = new Panel(xPositions[i], yPositions[i], widths[i], heights[i], colours[i], alphas[i],
            new Text(strings[i], assetManager.get("FreeSans10.ttf", BitmapFont.class), xPositions[i], yPositions[i],
            TextAlignment.CENTER));

            uiElements.add(panel);
            cursor.add(panel);
        }

        uiElements.add(cursor);
    }
}
