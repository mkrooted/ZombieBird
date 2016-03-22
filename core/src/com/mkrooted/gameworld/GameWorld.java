package com.mkrooted.gameworld;

import com.badlogic.gdx.Gdx;
import com.mkrooted.gameobjects.Bird;

public class GameWorld {
    private Bird bird;

    public GameWorld(int midY){
        bird = new Bird(33, midY-5, 17,12);
    }
    public void update(float delta){
        bird.update(delta);
    }
    public Bird getBird(){
        return bird;
    }
}
