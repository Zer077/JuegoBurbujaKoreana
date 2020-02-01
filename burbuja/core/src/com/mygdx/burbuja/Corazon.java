package com.mygdx.burbuja;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Corazon extends Actor {
    Texture t;
    public Corazon(Texture textura){

        t=textura;
        setHeight(t.getHeight());
        setWidth(t.getWidth());

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(t, getX(), getY());
    }


}
