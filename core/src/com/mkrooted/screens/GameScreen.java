package com.mkrooted.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.mkrooted.gameworld.GameRenderer;
import com.mkrooted.gameworld.GameWorld;
import com.mkrooted.helpers.InputHandler;

public class GameScreen implements Screen{

    private GameWorld world;
    private GameRenderer renderer;
    private float runTime;

    public GameScreen() {
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 136;
        float gameHeight = screenHeight/(screenWidth/gameWidth);
        int midY = (int) gameHeight/2;

        world = new GameWorld(midY);
        renderer = new GameRenderer(world, (int) gameHeight, midY);

        Gdx.input.setInputProcessor(new InputHandler(world.getBird()));
        runTime = 0;
    }

    @Override
    public void show() {
        Gdx.app.log("GameScreen", "show");
    }

    @Override
    public void render(float delta) {
        Gdx.app.log("GameScreen", "FPS: "+1/delta+"");
        Gdx.gl.glClearColor(0.3f, 0.3f, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        runTime += delta;

        world.update(delta);
        renderer.render(runTime);
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen", "resize");
    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "pause");
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "resume");
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen", "hide");
    }

    @Override
    public void dispose() {
        Gdx.app.log("GameScreen", "dispose");
    }
}
