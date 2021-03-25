package core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MenuScreen implements Screen{
	
	private Orlog parent;
	private Stage stage;
	private SpriteBatch batch;
	private Texture img;
	private Sprite sprite;
	
	public MenuScreen(Orlog orlog) {
		parent = orlog;
		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);
		

	}
	

	@Override
	public void show() {

		
		Gdx.input.setInputProcessor(stage); 
		// Create a table that fills the screen. Everything else will go inside this table.
		Table table = new Table();
		table.setFillParent(true);
        table.setDebug(true);
        stage.addActor(table);
        
       
//        batch = new SpriteBatch();
//        img = new Texture(Gdx.files.internal("core/fond.jpg") );
//        sprite = new Sprite(img);
//        
 
        Skin skin = new Skin(Gdx.files.internal("core/skin/glassy-ui.json"));
        
        //create buttons
        TextButton newGame = new TextButton("New Game", skin);
        TextButton preferences = new TextButton("Preferences", skin);
        TextButton exit = new TextButton("Exit", skin);
        TextButton login = new TextButton("Login", skin);
        
        //add buttons to table
        table.add(newGame).fillX().uniformX();
		table.row().pad(10, 0, 10, 0);
		table.add(preferences).fillX().uniformX();
		table.row();
		table.add(exit).fillX().uniformX();
		table.row();
		table.add(login).fillX().uniformX();
		
		// create button listeners
		exit.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				Gdx.app.exit();				
			}
		});
		
		newGame.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				parent.changeScreen(Orlog.APPLICATION);			
			}
		});
		
		preferences.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				parent.changeScreen(Orlog.PREFERENCES);					
			}
		});
		
		login.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				parent.changeScreen(Orlog.LOGIN);					
			}
		});
		
	}
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();
//		batch.begin();
//		sprite.draw(batch);
//		batch.end();
//		
		
		
	}

	@Override
	public void resize(int width, int height) {

		stage.getViewport().update(width, height, true);

		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		stage.dispose();
		batch.dispose();
		img.dispose();
		
	}

}
