package com.mkrooted.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mkrooted.gameobjects.Bird;
import com.mkrooted.helpers.AssetLoader;


public class GameRenderer {
    private GameWorld world;
    private OrthographicCamera camera;
    private ShapeRenderer shapeRenderer;

    private SpriteBatch batch;
    private int midY, gameHeight;

    private Bird bird;

    public GameRenderer(GameWorld _world, int height, int midPointY){
        world = _world;

        gameHeight = height;
        midY = midPointY;

        camera = new OrthographicCamera();
        camera.setToOrtho(true, 136, gameHeight);

        batch = new SpriteBatch();
        batch.setProjectionMatrix(camera.combined);

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);

        bird = world.getBird();
        AssetLoader.load();
    }
    public void render(float runTime){
        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(55/255.0f, 80/255.0f, 100/255.0f, 1);
        shapeRenderer.rect(0, 0, 136, midY + 66);

        shapeRenderer.setColor(Color.CHARTREUSE);
        shapeRenderer.rect(0, midY + 66, 136, 11);

        shapeRenderer.setColor(Color.BROWN);
        shapeRenderer.rect(0, midY + 77, 136, 52);

        shapeRenderer.end();

        batch.begin();
        batch.disableBlending();
        batch.draw(AssetLoader.bg, 0, midY + 23, 136, 43);

        batch.enableBlending();
        batch.draw(AssetLoader.birdAnimation.getKeyFrame(runTime), bird.getX(), bird.getY(),
                bird.getWidth(), bird.getHeigth());
        batch.end();
    }
}
