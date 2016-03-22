package com.mkrooted.gameobjects;

import com.badlogic.gdx.math.Vector2;

public class Bird {
    private Vector2 position, velocity, acceleration;

    private float rotation;
    private int width, heigth;

    public Bird(float x, float y, int width_, int heigth_){
        width = width_;
        heigth = heigth_;
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, 460);
    }

    public void update(float delta){
        velocity.add(acceleration.cpy().scl(delta));
        if (velocity.y>1000) {
            velocity.y = 1000;
        }
        position.add(velocity.cpy().scl(delta));

        if(isFalling()) {
            rotation += 480*delta;
            if(rotation>90){
                rotation=90;
            }
        }
        if(velocity.y<0){
            rotation -= 600*delta;
            if(rotation<-20){
                rotation = -20;
            }
        }

    }

    public void onClick(){
        velocity.y=-200;
    }
    public float getX(){
        return position.x;
    }
    public float getY(){
        return position.y;
    }
    public float getWidth(){
        return width;
    }
    public float getHeigth(){
        return heigth;
    }
    public float getRotation(){
        return rotation;
    }

    public boolean isFalling(){
        return velocity.y > 110;
    }
    public boolean notFlapping(){
        return velocity.y > 70;
    }
}
