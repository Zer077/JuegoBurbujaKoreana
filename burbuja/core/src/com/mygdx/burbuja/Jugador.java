package com.mygdx.burbuja;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.TimeUtils;

public class Jugador extends Actor {
    private Escenario1 escenario;
    TextureRegion jugador;
    Texture t;
    Burbuja b1;
    Burbuja b2;
    Burbuja b3;
    private int keycode = 0;
    long tiempo;

    public Jugador(TextureRegion textura) {
        jugador = textura;
        setSize(jugador.getRegionWidth(), jugador.getRegionHeight());
    }

    public Jugador(Texture textura, Burbuja b1, Burbuja b2, Burbuja b3, Escenario1 e) {
        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;
        t = textura;
        this.escenario = e;
        setSize(t.getWidth(), t.getHeight());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(t, getX(), getY());
    }

    @Override
    public void act(float delta) {

        switch (getKeycode()) {
            case Input.Keys.W:
                if (getY() + getHeight() <= Gdx.graphics.getHeight()) {
                    setPosition(getX(), getY() + 5);

                }





                break;
            case Input.Keys.A:
                if (getX() >= 0) {
                    setPosition(getX() - 5, getY());
                }


                break;
            case Input.Keys.S:
                if (getY() >= 0) {

                    setPosition(getX(), getY() - 5);
                }



                break;
            case Input.Keys.D:
                if (getX() + getWidth() <= Gdx.graphics.getWidth()) {
                    setPosition(getX() + 5, getY());
                }



                break;


        }


        double xCentro = b1.getX() + (b1.getWidth() / 2);
        double xCentroJ = getX() + (getWidth() / 2);
        double yCentro = b1.getY() + (b1.getHeight() / 2);
        double yCentroJ = getY() + (getHeight() / 2);
        double sumaderadios = (b1.getHeight() / 2) + (getHeight() / 2);
        if (Math.sqrt(Math.pow(xCentro - xCentroJ, 2) + Math.pow(yCentro - yCentroJ, 2)) < sumaderadios) {

            if (TimeUtils.timeSinceMillis(tiempo) > 800) {
                escenario.vida--;

                tiempo = TimeUtils.millis();
            }

            if (escenario.vida <= 0) {
                escenario.m.setScreen(new GameOver(escenario.m));

            }
            System.out.println(Gdx.graphics.getHeight() + "  " + Gdx.graphics.getBackBufferWidth());
            System.out.println("Golpeado");

        }
        xCentro = b2.getX() + (b2.getWidth() / 2);
        yCentro = b2.getY() + (b2.getHeight() / 2);
        sumaderadios = b2.getHeight() / 2 + getHeight() / 2;
        if (Math.sqrt(Math.pow(xCentro - xCentroJ, 2) + Math.pow(yCentro - yCentroJ, 2)) < sumaderadios) {

            if (TimeUtils.timeSinceMillis(tiempo) > 800) {
                escenario.vida--;

                tiempo = TimeUtils.millis();
            }


            if (escenario.vida <= 0) {
                escenario.m.setScreen(new GameOver(escenario.m));

            }

            System.out.println("Golpeado");

        }
        xCentro = b3.getX() + (b3.getWidth() / 2);
        yCentro = b3.getY() + (b3.getHeight() / 2);
        sumaderadios = b3.getHeight() / 2 + getHeight() / 2;
        if (Math.sqrt(Math.pow(xCentro - xCentroJ, 2) + Math.pow(yCentro - yCentroJ, 2)) < sumaderadios) {
            if (TimeUtils.timeSinceMillis(tiempo) > 800) {
                escenario.vida--;

                tiempo = TimeUtils.millis();
            }


            if (escenario.vida <= 0) {
                escenario.m.setScreen(new GameOver(escenario.m));

            }

            System.out.println("Golpeado");

        }

    }

    public int getKeycode() {
        return keycode;
    }

    public void setKeycode(int keycode) {
        this.keycode = keycode;
    }
}
