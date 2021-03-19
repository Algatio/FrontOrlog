package core;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import dice.TheDice;


public class MainScreen implements Screen {

	private Orlog parent;
	ShapeRenderer renderer;
	FitViewport viewport;
	TheDice dice;
	private SpriteBatch batch;
	private Texture img;
	private Sprite sprite;
	private Stage stage;



	public MainScreen(Orlog orlog) {
		parent = orlog;
		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);
	}



	@Override
	public void show() {
//		renderer = new ShapeRenderer();
//		viewport = new FitViewport(210,210);
//
		dice = new TheDice(viewport);	
		Gdx.input.setInputProcessor(dice);

		Gdx.input.setInputProcessor(stage); 
		// Create a table that fills the screen. Everything else will go inside this table.
		Table table = new Table();
		table.setFillParent(true);
		table.setDebug(true);
		stage.addActor(table);


		batch = new SpriteBatch();
		img = new Texture(Gdx.files.internal("core/fond.jpg") );
		sprite = new Sprite(img);


	}

	@Override
	public void render(float delta) {
		
//		viewport.apply();
//		Gdx.gl.glClearColor(1,1,1,1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//
//		renderer.setProjectionMatrix(viewport.getCamera().combined);
//		renderer.setAutoShapeType(true);
//		renderer.begin();
//		renderer.set(ShapeRenderer.ShapeType.Line);
//		renderer.setColor(0,0,0,1);
//		renderer.rect(5,5,200,200);
//		dice.update(delta);
//
//		dice.render(renderer);
//		renderer.end();

		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();
		batch.begin();
		sprite.draw(batch);
		batch.end();


	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height, true);
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose() {
		renderer.dispose();
	}
}
