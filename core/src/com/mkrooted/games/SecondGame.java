package com.mkrooted.games;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.mkrooted.screens.GameScreen;

public class SecondGame extends Game {
	@Override
	public void create() {
		setScreen(new GameScreen());
		Gdx.app.log("SecondGame", "Created");
	}
}
