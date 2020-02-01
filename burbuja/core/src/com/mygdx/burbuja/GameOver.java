package com.mygdx.burbuja;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameOver extends Pantalla {
    Texture pantalla;
    PantallaGO p;
    Stage stage;
    SpriteBatch batch;

    public GameOver(MyGdxGame m) {
        super(m);
        pantalla = new Texture("GO.png");
    }

    @Override
    public void dispose() {
        pantalla.dispose();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.4f, 0.5f, 0.8f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();


    }

    @Override
    public void show() {
        stage = new Stage();
        p = new PantallaGO(pantalla);
        stage.addActor(p);
        p.setPosition(0,0);


    }
}
