package com.dragonballzrpg.actions;

import com.dragonballzrpg.enums.ActionName;
import com.dragonballzrpg.gameobjects.characters.Player;
import com.dragonballzrpg.utilities.Animation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Carl on 25/07/2017.
 */
public class InputActionRelayer
{
    private Player player;
    private Map<ActionName, PlayerAction> actions;

    public InputActionRelayer(Player player)
    {
        this.player = player;
        actions = new HashMap<ActionName, PlayerAction>();

        initialiseActions();
    }

    public void setPlayer(Player player)
    {
        this.player = player;
    }

    public void sendAction(ActionName actionName, Animation animation)
    {
        player.addAction(actions.get(actionName), animation);
    }

    private void initialiseActions()
    {
        actions.put(ActionName.MOVE_UP, new PlayerMoveUpAction(player));
    }
}
