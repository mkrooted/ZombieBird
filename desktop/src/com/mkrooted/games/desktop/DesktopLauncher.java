package com.mkrooted.games.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mkrooted.games.SecondGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "BIRDS";
		config.height = 400;
		config.width = 300;
		new LwjglApplication(new SecondGame(), config);
	}
}
