package com.mygdx.burbuja;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.utils.TimeUtils;


public class Procesador extends InputAdapter {
    Escenario1 aplication;

    public Procesador(Escenario1 a) {
        aplication = a;

    }

    @Override
    public boolean keyUp(int keycode) {


        switch (keycode) {
            case Input.Keys.W:

                aplication.j.setKeycode(0);


                break;
            case Input.Keys.A:

                aplication.j.setKeycode(0);

                break;
            case Input.Keys.S:

                aplication.j.setKeycode(0);

                break;
            case Input.Keys.D:

                aplication.j.setKeycode(0);


                break;


        }
        return true;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.W:

                aplication.j.setKeycode(Input.Keys.W);


                break;
            case Input.Keys.A:

                aplication.j.setKeycode(Input.Keys.A);

                break;
            case Input.Keys.S:

                aplication.j.setKeycode(Input.Keys.S);

                break;
            case Input.Keys.D:

                aplication.j.setKeycode(Input.Keys.D);


                break;


        }
        return true;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        //buscar donde está el objeto, o todos los objetos, sumar su altura al eje Y y anchura al X para saber su “contorno”
        if (touchX(aplication.coordenadaX, screenX) && touchY(aplication.coordenadaY, Gdx.graphics.getHeight() - screenY)) {


            aplication.coordenadaX = (int) (Math.random() * Gdx.graphics.getWidth());
            aplication.coordenadaY = (int) (Math.random() * Gdx.graphics.getHeight());
            aplication.tiempo = TimeUtils.millis();
            aplication.vida=aplication.vida+1;
            System.out.println("TOCADO");


        }else {

            aplication.vida=aplication.vida-1;


        }
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return true;
    }

    private boolean touchX(int coordenadasXdelObjeto, int x) {
        if (x >= coordenadasXdelObjeto && x <= coordenadasXdelObjeto + aplication.corazon.getWidth()) {

            return true;
        } else {
            return false;
        }
    }

    private boolean touchY(int coordenadasYdelObjeto, int y) {
        if (y >= coordenadasYdelObjeto && y <= coordenadasYdelObjeto + aplication.corazon.getHeight()) {

            return true;
        } else {

            return false;
        }
    }





}