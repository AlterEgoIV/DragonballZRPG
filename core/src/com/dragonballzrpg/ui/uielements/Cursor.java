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
    private int currentPanel;
    private MenuOption[] menuOptions;
    public MenuOption currentMenuOption;

    public Cursor(MenuOption[] menuOptions)
    {
        this.menuOptions = menuOptions;
        panels = new ArrayList<Panel>();
        panelOverlays = new ArrayList<Texture>();
        currentPanel = 0;
        currentMenuOption = menuOptions[0];
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

    public void add(Panel panel)
    {
        panels.add(panel);

        Pixmap pixmap = new Pixmap(panel.width, panel.height, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.drawRectangle(0, 0, panel.width, panel.height);
        panelOverlays.add(new Texture(pixmap));
        pixmap.dispose();
    }

    public void remove(Panel panel)
    {
        panels.remove(panel);
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

        currentMenuOption = menuOptions[currentPanel];
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

        currentMenuOption = menuOptions[currentPanel];
    }
}
