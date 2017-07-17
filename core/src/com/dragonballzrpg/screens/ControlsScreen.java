package com.dragonballzrpg.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.dragonballzrpg.DragonballZRPG;
import com.dragonballzrpg.enums.ActionName;
import com.dragonballzrpg.enums.ScreenName;
import com.dragonballzrpg.ui.ControlsUI;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Carl on 07/09/2016.
 */
public class ControlsScreen extends GameScreen implements InputProcessor
{
    private Map<ActionName, String> actionStrings;
    private Map<ActionName, Integer> defaultActions;
    private boolean optionSelected;

    public ControlsScreen(DragonballZRPG game)
    {
        super(game);

        actionStrings = new HashMap<ActionName, String>();
        defaultActions = new HashMap<ActionName, Integer>();
        optionSelected = false;

        for(Map.Entry<ActionName, Integer> entry : game.inputToActionMap.entrySet())
        {
            actionStrings.put(entry.getKey(), Input.Keys.toString(entry.getValue()));
            defaultActions.put(entry.getKey(), entry.getValue());
        }

        ui = new ControlsUI(game.assetManager, actionStrings);
    }

    @Override
    public void show()
    {
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta)
    {
        batch.begin();
        ui.render(batch);
        batch.end();
    }

    @Override
    public void resize(int width, int height)
    {

    }

    @Override
    public void pause()
    {

    }

    @Override
    public void resume()
    {

    }

    @Override
    public void hide()
    {

    }

    @Override
    public void dispose()
    {

    }

    @Override
    public boolean keyDown(int keycode)
    {
        if(!optionSelected)
        {
            if(keycode == game.inputToActionMap.get(ActionName.UP))
            {
                ui.previousOption();
            }
            else if(keycode == game.inputToActionMap.get(ActionName.DOWN))
            {
                ui.nextOption();
            }
        }

        return false;
    }

    @Override
    public boolean keyUp(int keycode)
    {
        if(optionSelected)
        {
            switch(ui.getCurrentMenuOption())
            {
                case SET_UP_ACTION_INPUT:
                {
                    if(keycode != game.inputToActionMap.get(ActionName.SELECT))
                    {
                        game.inputToActionMap.put(ActionName.UP, keycode);
                        ui.setCurrentMenuOptionText(Input.Keys.toString(keycode));
                        optionSelected = false;
                        ui.highlightCurrentMenuOption(false);
                    }

                    break;
                }

                case SET_DOWN_ACTION_INPUT:
                {
                    if(keycode != game.inputToActionMap.get(ActionName.SELECT))
                    {
                        game.inputToActionMap.put(ActionName.DOWN, keycode);
                        ui.setCurrentMenuOptionText(Input.Keys.toString(keycode));
                        optionSelected = false;
                        ui.highlightCurrentMenuOption(false);
                    }

                    break;
                }

                case SET_LEFT_ACTION_INPUT:
                {
                    if(keycode != game.inputToActionMap.get(ActionName.SELECT))
                    {
                        game.inputToActionMap.put(ActionName.LEFT, keycode);
                        ui.setCurrentMenuOptionText(Input.Keys.toString(keycode));
                        optionSelected = false;
                        ui.highlightCurrentMenuOption(false);
                    }

                    break;
                }

                case SET_RIGHT_ACTION_INPUT:
                {
                    if(keycode != game.inputToActionMap.get(ActionName.SELECT))
                    {
                        game.inputToActionMap.put(ActionName.RIGHT, keycode);
                        ui.setCurrentMenuOptionText(Input.Keys.toString(keycode));
                        optionSelected = false;
                        ui.highlightCurrentMenuOption(false);
                    }

                    break;
                }

                case SET_INTERACT_OR_MELEE_ACTION_INPUT:
                {
                    if(keycode != game.inputToActionMap.get(ActionName.SELECT))
                    {
                        game.inputToActionMap.put(ActionName.INTERACT_OR_MELEE, keycode);
                        ui.setCurrentMenuOptionText(Input.Keys.toString(keycode));
                        optionSelected = false;
                        ui.highlightCurrentMenuOption(false);
                    }

                    break;
                }

                case SET_CANCEL_OR_ENERGY_ATTACK_ACTION_INPUT:
                {
                    if(keycode != game.inputToActionMap.get(ActionName.SELECT))
                    {
                        game.inputToActionMap.put(ActionName.CANCEL_OR_ENERGY_ATTACK, keycode);
                        ui.setCurrentMenuOptionText(Input.Keys.toString(keycode));
                        optionSelected = false;
                        ui.highlightCurrentMenuOption(false);
                    }

                    break;
                }

                case SET_SWITCH_ENERGY_ATTACK_ACTION_INPUT:
                {
                    if(keycode != game.inputToActionMap.get(ActionName.SELECT))
                    {
                        game.inputToActionMap.put(ActionName.SWITCH_ENERGY_ATTACK, keycode);
                        ui.setCurrentMenuOptionText(Input.Keys.toString(keycode));
                        optionSelected = false;
                        ui.highlightCurrentMenuOption(false);
                    }

                    break;
                }

                case SET_PAUSE_ACTION_INPUT:
                {
                    if(keycode != game.inputToActionMap.get(ActionName.SELECT))
                    {
                        game.inputToActionMap.put(ActionName.PAUSE, keycode);
                        ui.setCurrentMenuOptionText(Input.Keys.toString(keycode));
                        optionSelected = false;
                        ui.highlightCurrentMenuOption(false);
                    }

                    break;
                }
            }
        }

        if(keycode == game.inputToActionMap.get(ActionName.SELECT))
        {
            switch(ui.getCurrentMenuOption())
            {
                case RESET_TO_DEFAULT:
                {
                    game.inputToActionMap.clear();

                    for(Map.Entry<ActionName, Integer> entry : defaultActions.entrySet())
                    {
                        game.inputToActionMap.put(entry.getKey(), entry.getValue());
                    }

                    ui.resetText();

                    break;
                }

                case BACK:
                {
                    game.setScreen(game.screens.get(ScreenName.MAIN_MENU_SCREEN));
                    break;
                }

                default:
                {
                    optionSelected = true;
                    ui.highlightCurrentMenuOption(true);
                }
            }
        }

        return false;
    }

    @Override
    public boolean keyTyped(char character)
    {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button)
    {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button)
    {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer)
    {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY)
    {
        return false;
    }

    @Override
    public boolean scrolled(int amount)
    {
        return false;
    }
}
