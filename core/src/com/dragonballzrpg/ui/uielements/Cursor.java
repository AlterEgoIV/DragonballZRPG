package com.dragonballzrpg.ui.uielements;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dragonballzrpg.enums.MenuOption;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carl on 08/06/2017.
 */
public class Cursor extends UIElement
{
    private List<Panel> panels;
    private List<Texture> panelOverlays;
    private List<MenuOption> menuOptions;
    private int currentPanel;
    private MenuOption currentMenuOption;

    public Cursor()
    {
        panels = new ArrayList<Panel>();
        panelOverlays = new ArrayList<Texture>();
        menuOptions = new ArrayList<MenuOption>();
        currentPanel = 0;
        currentMenuOption = MenuOption.NULL;
    }

    @Override
    public void update()
    {

    }

    @Override
    public void render(SpriteBatch batch)
    {
        batch.draw(panelOverlays.get(currentPanel),
        panels.get(currentPanel).position.x - panels.get(currentPanel).width / 2,
        panels.get(currentPanel).position.y - panels.get(currentPanel).height / 2);
    }

    public void add(Panel panel, MenuOption menuOption)
    {
        panels.add(panel);
        menuOptions.add(menuOption);

        Pixmap pixmap = new Pixmap(panel.width, panel.height, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.drawRectangle(0, 0, panel.width, panel.height);
        panelOverlays.add(new Texture(pixmap));
        pixmap.dispose();
    }

    public void next()
    {
        if(currentPanel < panels.size() - 1)
        {
            ++currentPanel;
        }
        else
        {
            currentPanel = 0;
        }

        currentMenuOption = menuOptions.get(currentPanel);
    }

    public void previous()
    {
        if(currentPanel > 0)
        {
            --currentPanel;
        }
        else
        {
            currentPanel = panels.size() - 1;
        }

        currentMenuOption = menuOptions.get(currentPanel);
    }

    public MenuOption getCurrentMenuOption()
    {
        return currentMenuOption;
    }

    public Panel getCurrentPanel()
    {
        return panels.get(currentPanel);
    }

    public void setCurrentMenuOption(MenuOption menuOption)
    {
        this.currentMenuOption = menuOption;
    }

    public void setCurrentMenuOptionText(String key)
    {
        this.panels.get(currentPanel).setText(key);
    }

    public void resetAllPanelText()
    {
        for(Panel panel : panels)
        {
            panel.resetText();
        }
    }
}
