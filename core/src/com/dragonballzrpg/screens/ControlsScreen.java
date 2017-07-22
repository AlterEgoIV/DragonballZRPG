package com.dragonballzrpg.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.dragonballzrpg.DragonballZRPG;
import com.dragonballzrpg.enums.KeyName;
import com.dragonballzrpg.enums.ScreenName;
import com.dragonballzrpg.ui.ControlsUI;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Carl on 07/09/2016.
 */
public class ControlsScreen extends GameScreen implements InputProcessor
{
    private Map<KeyName, String> actionStrings;
    private Map<KeyName, Integer> defaultActions;
    private boolean optionSelected;

    public ControlsScreen(DragonballZRPG game)
    {
        super(game);

        actionStrings = new HashMap<KeyName, String>();
        defaultActions = new HashMap<KeyName, Integer>();
        optionSelected = false;

        for(Map.Entry<KeyName, Integer> entry : game.inputKeyMap.entrySet())
        {
            actionStrings.put(entry.getKey(), Input.Keys.toString(entry.getValue()));
            defaultActions.put(entry.getKey(), entry.getValue());
        }

        ui = new ControlsUI(game.resourceManager, actionStrings);
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
            if(keycode == game.inputKeyMap.get(KeyName.UP_KEY))
            {
                ui.previousOption();
            }
            else if(keycode == game.inputKeyMap.get(KeyName.DOWN_KEY))
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
                    if(keycode != game.inputKeyMap.get(KeyName.SELECT_KEY))
                    {
                        game.inputKeyMap.put(KeyName.UP_KEY, keycode);
                        ui.setCurrentMenuOptionText(Input.Keys.toString(keycode));
                        optionSelected = false;
                        ui.highlightCurrentMenuOption(false);
                    }

                    break;
                }

                case SET_DOWN_ACTION_INPUT:
                {
                    if(keycode != game.inputKeyMap.get(KeyName.SELECT_KEY))
                    {
                        game.inputKeyMap.put(KeyName.DOWN_KEY, keycode);
                        ui.setCurrentMenuOptionText(Input.Keys.toString(keycode));
                        optionSelected = false;
                        ui.highlightCurrentMenuOption(false);
                    }

                    break;
                }

                case SET_LEFT_ACTION_INPUT:
                {
                    if(keycode != game.inputKeyMap.get(KeyName.SELECT_KEY))
                    {
                        game.inputKeyMap.put(KeyName.LEFT_KEY, keycode);
                        ui.setCurrentMenuOptionText(Input.Keys.toString(keycode));
                        optionSelected = false;
                        ui.highlightCurrentMenuOption(false);
                    }

                    break;
                }

                case SET_RIGHT_ACTION_INPUT:
                {
                    if(keycode != game.inputKeyMap.get(KeyName.SELECT_KEY))
                    {
                        game.inputKeyMap.put(KeyName.RIGHT_KEY, keycode);
                        ui.setCurrentMenuOptionText(Input.Keys.toString(keycode));
                        optionSelected = false;
                        ui.highlightCurrentMenuOption(false);
                    }

                    break;
                }

                case SET_INTERACT_OR_MELEE_ACTION_INPUT:
                {
                    if(keycode != game.inputKeyMap.get(KeyName.SELECT_KEY))
                    {
                        game.inputKeyMap.put(KeyName.INTERACT_OR_MELEE_KEY, keycode);
                        ui.setCurrentMenuOptionText(Input.Keys.toString(keycode));
                        optionSelected = false;
                        ui.highlightCurrentMenuOption(false);
                    }

                    break;
                }

                case SET_CANCEL_OR_ENERGY_ATTACK_ACTION_INPUT:
                {
                    if(keycode != game.inputKeyMap.get(KeyName.SELECT_KEY))
                    {
                        game.inputKeyMap.put(KeyName.CANCEL_OR_ENERGY_ATTACK_KEY, keycode);
                        ui.setCurrentMenuOptionText(Input.Keys.toString(keycode));
                        optionSelected = false;
                        ui.highlightCurrentMenuOption(false);
                    }

                    break;
                }

                case SET_SWITCH_ENERGY_ATTACK_ACTION_INPUT:
                {
                    if(keycode != game.inputKeyMap.get(KeyName.SELECT_KEY))
                    {
                        game.inputKeyMap.put(KeyName.SWITCH_ENERGY_ATTACK_KEY, keycode);
                        ui.setCurrentMenuOptionText(Input.Keys.toString(keycode));
                        optionSelected = false;
                        ui.highlightCurrentMenuOption(false);
                    }

                    break;
                }

                case SET_PAUSE_ACTION_INPUT:
                {
                    if(keycode != game.inputKeyMap.get(KeyName.SELECT_KEY))
                    {
                        game.inputKeyMap.put(KeyName.PAUSE_KEY, keycode);
                        ui.setCurrentMenuOptionText(Input.Keys.toString(keycode));
                        optionSelected = false;
                        ui.highlightCurrentMenuOption(false);
                    }

                    break;
                }
            }
        }

        if(keycode == game.inputKeyMap.get(KeyName.SELECT_KEY))
        {
            switch(ui.getCurrentMenuOption())
            {
                case RESET_TO_DEFAULT:
                {
                    game.inputKeyMap.clear();

                    for(Map.Entry<KeyName, Integer> entry : defaultActions.entrySet())
                    {
                        game.inputKeyMap.put(entry.getKey(), entry.getValue());
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
