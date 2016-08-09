package com.dragonballzrpg;

import com.badlogic.gdx.Game;
import com.dragonballzrpg.screens.PlayScreen;

public class DragonballZRPG extends Game
{
	@Override
	public void create()
	{
		setScreen(new PlayScreen());
	}

	@Override
	public void render()
	{
		super.render();
	}
}
