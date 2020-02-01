package com.mygdx.burbuja;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.TimeUtils;

public class Burbuja extends Actor {
    TextureRegion burbuja;
    Texture t;
    int velocidad = 4;
    int velocidadY = 4;
    int variableVelocidadPositiva=4;
    int VariableVelocidadNegativa=-4;
    long tiempo;

    public Burbuja(TextureRegion textura) {
        burbuja = textura;
        setSize(burbuja.getRegionWidth(), burbuja.getRegionHeight());
    }

    public Burbuja(Texture texturaburbuja) {
        t = texturaburbuja;
        setSize(t.getWidth(), t.getHeight());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(t, getX(), getY());
    }

    @Override
    public void act(float delta) {
        if (TimeUtils.timeSinceMillis(tiempo) > 1000) {

            variableVelocidadPositiva++;
            VariableVelocidadNegativa--;

            tiempo = TimeUtils.millis();
        }





        if (getX() + getWidth() >= Gdx.graphics.getWidth()) {
            velocidad = VariableVelocidadNegativa;

        }
        if (getX() <= 0) {
            velocidad = variableVelocidadPositiva;

        }
        if (getY() + getHeight() >= Gdx.graphics.getHeight()) {
            velocidadY = VariableVelocidadNegativa;

        }
        if (getY() <= 0) {
            velocidadY = variableVelocidadPositiva;

        }
        setX(getX() + velocidad);
        setY(getY() + velocidadY);
    }


}
