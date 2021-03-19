package core;

import com.badlogic.gdx.Screen;

public class LoadingScreen implements Screen {
	
	private Orlog parent;
	
	public LoadingScreen(Orlog orlog) {
		parent = orlog;
	}

	
	public void show() {
		// TODO Auto-generated method stub
		
	}


	public void render(float delta) {
		parent.changeScreen(Orlog.MENU);
		
	}

	
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
