package com.dragonballzrpg.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.dragonballzrpg.enums.KeyName;
import com.dragonballzrpg.enums.MenuOption;
import com.dragonballzrpg.enums.TextAlignment;
import com.dragonballzrpg.ui.uielements.Panel;
import com.dragonballzrpg.ui.uielements.Text;
import com.dragonballzrpg.utilities.GameAssetManager;

import java.util.Map;

/**
 * Created by Carl on 07/06/2017.
 */
public class ControlsUI extends UI
{
    private Map<KeyName, String> actionStrings;

    public ControlsUI(GameAssetManager assetManager, Map<KeyName, String> actionStrings)
    {
        super(assetManager);

        this.actionStrings = actionStrings;

        createUIElements(20);
    }

    private void createUIElements(int numElements)
    {
        float rootX = Gdx.graphics.getWidth() / 2, rootY = Gdx.graphics.getHeight() / 2;
        int rootWidth = (int)(Gdx.graphics.getWidth() * .9), rootHeight = (int)(Gdx.graphics.getHeight() * .75);
        Color rootColour = Color.ROYAL;
        float rootAlpha = 1f;

        float[] xPositions =
        {
            rootX + (rootWidth / 3),
            rootX - (rootWidth / 5.5f),
            rootX - (rootWidth / 5.5f),
            rootX - (rootWidth / 5.5f),
            rootX - (rootWidth / 5.5f),
            rootX - (rootWidth / 5.5f),
            rootX - (rootWidth / 5.5f),
            rootX - (rootWidth / 5.5f),
            rootX - (rootWidth / 5.5f),
            rootX + (rootWidth / 3),
            rootX + (rootWidth / 3),
            rootX + (rootWidth / 3),
            rootX + (rootWidth / 3),
            rootX + (rootWidth / 3),
            rootX + (rootWidth / 3),
            rootX + (rootWidth / 3),
            rootX + (rootWidth / 3),
            rootX - (rootWidth / 6.55f),
            rootX + (rootWidth / 6.55f)
        };

        float[] yPositions =
        {
            rootY + (rootHeight / 2) + (rootHeight * .1f) / 1.6f,
            rootY + rootHeight / 2 - (rootHeight / (numElements / 2 - 1)),
            rootY + rootHeight / 2 - ((rootHeight / (numElements / 2 - 1)) * 2),
            rootY + rootHeight / 2 - ((rootHeight / (numElements / 2 - 1)) * 3),
            rootY + rootHeight / 2 - ((rootHeight / (numElements / 2 - 1)) * 4),
            rootY + rootHeight / 2 - ((rootHeight / (numElements / 2 - 1)) * 5),
            rootY + rootHeight / 2 - ((rootHeight / (numElements / 2 - 1)) * 6),
            rootY + rootHeight / 2 - ((rootHeight / (numElements / 2 - 1)) * 7),
            rootY + rootHeight / 2 - ((rootHeight / (numElements / 2 - 1)) * 8),
            rootY + rootHeight / 2 - (rootHeight / (numElements / 2 - 1)),
            rootY + rootHeight / 2 - ((rootHeight / (numElements / 2 - 1)) * 2),
            rootY + rootHeight / 2 - ((rootHeight / (numElements / 2 - 1)) * 3),
            rootY + rootHeight / 2 - ((rootHeight / (numElements / 2 - 1)) * 4),
            rootY + rootHeight / 2 - ((rootHeight / (numElements / 2 - 1)) * 5),
            rootY + rootHeight / 2 - ((rootHeight / (numElements / 2 - 1)) * 6),
            rootY + rootHeight / 2 - ((rootHeight / (numElements / 2 - 1)) * 7),
            rootY + rootHeight / 2 - ((rootHeight / (numElements / 2 - 1)) * 8),
            rootY - (rootHeight / 2) - (rootHeight * .1f) / 1.6f,
            rootY - (rootHeight / 2) - (rootHeight * .1f) / 1.6f,
        };

        int[] widths =
        {
            (int)(rootWidth * .3),
            (int)(rootWidth * .6), (int)(rootWidth * .6), (int)(rootWidth * .6), (int)(rootWidth * .6), (int)(rootWidth * .6),
            (int)(rootWidth * .6), (int)(rootWidth * .6), (int)(rootWidth * .6),
            (int)(rootWidth * .3), (int)(rootWidth * .3), (int)(rootWidth * .3), (int)(rootWidth * .3), (int)(rootWidth * .3),
            (int)(rootWidth * .3), (int)(rootWidth * .3), (int)(rootWidth * .3),
            (int)(rootWidth * .3), (int)(rootWidth * .3)
        };

        int[] heights =
        {
            (int)(rootHeight * .1),
            (int)(rootHeight * .1), (int)(rootHeight * .1), (int)(rootHeight * .1), (int)(rootHeight * .1), (int)(rootHeight * .1),
            (int)(rootHeight * .1), (int)(rootHeight * .1), (int)(rootHeight * .1),
            (int)(rootHeight * .1), (int)(rootHeight * .1), (int)(rootHeight * .1), (int)(rootHeight * .1),
            (int)(rootHeight * .1), (int)(rootHeight * .1), (int)(rootHeight * .1), (int)(rootHeight * .1),
            (int)(rootHeight * .1), (int)(rootHeight * .1)
        };

        Color[] colours =
        {
            Color.ROYAL,
            Color.NAVY, Color.NAVY, Color.NAVY, Color.NAVY, Color.NAVY, Color.NAVY, Color.NAVY, Color.NAVY,
            Color.NAVY, Color.NAVY, Color.NAVY, Color.NAVY, Color.NAVY, Color.NAVY, Color.NAVY, Color.NAVY,
            Color.ROYAL, Color.ROYAL
        };

        float[] alphas =
        {
            1f,
            1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f,
            1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f,
            1f, 1f
        };

        String[] strings =
        {
            "Keys",
            "Up", "Down", "Left", "Right", "Interact/Melee", "Cancel/Energy Technique", "Switch Technique", "Pause",
            actionStrings.get(KeyName.UP_KEY), actionStrings.get(KeyName.DOWN_KEY), actionStrings.get(KeyName.LEFT_KEY),
            actionStrings.get(KeyName.RIGHT_KEY), actionStrings.get(KeyName.INTERACT_OR_MELEE_KEY),
            actionStrings.get(KeyName.CANCEL_OR_ENERGY_ATTACK_KEY), actionStrings.get(KeyName.SWITCH_ENERGY_ATTACK_KEY),
            actionStrings.get(KeyName.PAUSE_KEY),
            "Reset to Default", "Back"
        };

        MenuOption[] menuOptions =
        {
            MenuOption.SET_UP_ACTION_INPUT, MenuOption.SET_DOWN_ACTION_INPUT, MenuOption.SET_LEFT_ACTION_INPUT,
            MenuOption.SET_RIGHT_ACTION_INPUT, MenuOption.SET_INTERACT_OR_MELEE_ACTION_INPUT,
            MenuOption.SET_CANCEL_OR_ENERGY_ATTACK_ACTION_INPUT, MenuOption.SET_SWITCH_ENERGY_ATTACK_ACTION_INPUT,
            MenuOption.SET_PAUSE_ACTION_INPUT, MenuOption.RESET_TO_DEFAULT, MenuOption.BACK
        };

        // Create root element
        uiElements.add(new Panel(rootX, rootY, rootWidth, rootHeight, rootColour, rootAlpha));

        for(int i = 0; i < numElements - 1; ++i)
        {
            Panel panel = new Panel(xPositions[i], yPositions[i], widths[i], heights[i], colours[i], alphas[i],
            new Text(strings[i], assetManager.get("FreeSans36.ttf", BitmapFont.class), xPositions[i], yPositions[i],
            TextAlignment.CENTER));

            uiElements.add(panel);

            if(i >= 9)
            {
                cursor.add(panel, menuOptions[i - 9]);
            }
        }

        cursor.setCurrentMenuOption(menuOptions[0]);
        uiElements.add(cursor);
    }
}
