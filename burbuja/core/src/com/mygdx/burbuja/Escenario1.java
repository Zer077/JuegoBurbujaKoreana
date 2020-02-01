package com.mygdx.burbuja;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.TimeUtils;

public class Escenario1 extends Pantalla {

    Jugador j;
    Burbuja b1;
    Burbuja b2;
    Burbuja b3;
    Texture texturajugador, texturaburbuja, texturaburbuja32, texturaburbuja16;
    TextureRegion regionjugador, regionburbuja, regionburbuja2, regionburbuja3;
    Stage stage;
    Corazon corazon;
    int coordenadaX=10;
    int coordenadaY=10;
    long tiempo;
    int vida = 5;
    int score=0;
    BitmapFont bit;
    SpriteBatch batch;
    Texture fondo;


    public Escenario1(MyGdxGame m) {
        super(m);
        batch = new SpriteBatch();
        fondo=new Texture("fondo.PNG");
        texturajugador = new Texture("chepchep2.png");
        texturaburbuja = new Texture("burbuja1.png");
        texturaburbuja32 = new Texture("burbuja2.png");
        texturaburbuja16 = new Texture("burbuja3.png");
        corazon = new Corazon(new Texture("heart.png"));
//        regionjugador = new TextureRegion(texturajugador, 0, 0, 30, 30);
//        regionburbuja = new TextureRegion(texturaburbuja, 0, 0, 64, 64);
//        regionburbuja2 = new TextureRegion(texturaburbuja32, 0, 0, 32, 32);
//        regionburbuja3 = new TextureRegion(texturaburbuja16, 0, 0, 16, 16);

        Gdx.input.setInputProcessor(new Procesador(this));
        bit = new BitmapFont();


    }

    @Override
    public void show() {
        stage = new Stage();
        b1 = new Burbuja(texturaburbuja);
        b2 = new Burbuja(texturaburbuja32);
        b3 = new Burbuja(texturaburbuja16);
        j = new Jugador(texturajugador, b1, b2, b3, this);
        stage.addActor(corazon);
        stage.addActor(j);
        stage.addActor(b1);
        stage.addActor(b2);
        stage.addActor(b3);
        j.setPosition(20, 50);
        b1.setPosition(500, 50);
        b2.setPosition(70, 70);
        b3.setPosition(80, 100);


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.4f, 0.5f, 0.8f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        batch.draw(fondo,0,0);


        if (TimeUtils.timeSinceMillis(tiempo) > 800) {

score+=100;
            coordenadaX = (int) (Math.random() * Gdx.graphics.getWidth());
            coordenadaY = (int) (Math.random() * Gdx.graphics.getHeight());
            tiempo = TimeUtils.millis();
        }



        corazon.setX(coordenadaX);
        corazon.setY(coordenadaY);

        bit.draw(batch, "Life: " + vida + "  Score: " + score, Gdx.graphics.getWidth()-200, Gdx.graphics.getHeight()-20);

        batch.end();

        stage.act();
        stage.draw();


    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void hide() {
        stage.dispose();
    }

    @Override
    public void dispose() {
        batch.dispose();

        texturajugador.dispose();
        texturaburbuja.dispose();
    }
}
