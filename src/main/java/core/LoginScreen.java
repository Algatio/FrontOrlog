package core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import metier.Compte;
import util.Context;

public class LoginScreen implements Screen {
	
	private Orlog parent;
	private Stage stage;
	
	private Label error; 
	
	
	public LoginScreen(Orlog orlog) {
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
        
 
        Skin skin = new Skin(Gdx.files.internal("core/skin/glassy-ui.json"));
        
        TextField login = new TextField("Login", skin);
        TextField password = new TextField("Password", skin);
        TextButton enter = new TextButton("Entrer", skin);
        
        error = new Label( "Erreur Id", skin );
        
		
      //add buttons to table
        table.add(login).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(password).fillX().uniformX();
        table.row();
        table.add(error);
        table.row();
        table.add(enter).fillX().uniformX();
        
        
        enter.addListener(new ChangeListener() {
        	@Override
        public void changed(ChangeEvent event, Actor actor) {
        		Compte c = Context.getInstance().getDaoCompte().checkConnect(login.getText(), password.getText());
        		if (c == null) {error.setColor(255,0,0,1);}
        		else {
        		parent.changeScreen(Orlog.APPLICATION);			
        		}
        	
        	}
        });
        
        
	
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();
		
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
		
	}

}
