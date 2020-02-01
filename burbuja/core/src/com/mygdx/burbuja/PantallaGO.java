package com.mygdx.burbuja;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class PantallaGO extends Actor {
    Texture t;

    public PantallaGO(Texture textura) {

        t = textura;


    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(t, getX(), getY());
    }
}
