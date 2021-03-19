package core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class PreferencesScreen implements Screen {
	
	private Orlog parent;
	private Stage stage;
	// our new fields
	private Label titleLabel; 
	private Label volumeMusicLabel;
	private Label volumeSoundLabel;
	private Label musicOnOffLabel;
	private Label soundOnOffLabel;

	
	
	public PreferencesScreen(Orlog orlog) {
		parent = orlog;
		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void show() {
		stage.clear();
		Gdx.input.setInputProcessor(stage);
		
		// Create a table that fills the screen. Everything else will go inside
		// this table.
		Table table = new Table();
		table.setFillParent(true);
		//table.setDebug(true);
		stage.addActor(table);

		// temporary until we have asset manager in
		Skin skin = new Skin(Gdx.files.internal("core/skin/glassy-ui.json"));

//		// music volume
		final Slider volumeMusicSlider = new Slider(0f, 1f, 0.1f, false, skin);
		volumeMusicSlider.setValue(parent.getPreferences().getMusicVolume());
		volumeMusicSlider.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				parent.getPreferences().setMusicVolume(volumeMusicSlider.getValue());
				// updateVolumeLabel();
				return false;
			}
		});
		
		// sound volume
		final Slider soundMusicSlider = new Slider(0f, 1f, 0.1f, false, skin);
		soundMusicSlider.setValue(parent.getPreferences().getSoundVolume());
		soundMusicSlider.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				parent.getPreferences().setSoundVolume(soundMusicSlider.getValue());
				// updateVolumeLabel();
				return false;
			}
		});

		// music on/off
		final CheckBox musicCheckbox = new CheckBox(null, skin);
		musicCheckbox.setChecked(parent.getPreferences().isMusicEnabled());
		musicCheckbox.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				boolean enabled = musicCheckbox.isChecked();
				parent.getPreferences().setMusicEnabled(enabled);
				return false;
			}
		});

		// sound on/off
		final CheckBox soundEffectsCheckbox = new CheckBox(null, skin);
		soundEffectsCheckbox.setChecked(parent.getPreferences().isSoundEffectsEnabled());
		soundEffectsCheckbox.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				boolean enabled = soundEffectsCheckbox.isChecked();
				parent.getPreferences().setSoundEffectsEnabled(enabled);
				return false;
			}
		});

		// return to main screen button
		final TextButton backButton = new TextButton("Back", skin, "small");
		backButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				parent.changeScreen(Orlog.MENU);

			}
		});
		
		titleLabel = new Label( "Preferences", skin );
		volumeMusicLabel = new Label( "Music Volume", skin );
		volumeSoundLabel = new Label( "Sound Volume", skin );
		musicOnOffLabel = new Label( "Music", skin );
		soundOnOffLabel = new Label( "Sound Effect", skin );
		
		table.add(titleLabel).colspan(2);
		table.row().pad(10,0,0,10);
		table.add(volumeMusicLabel).left();
		table.add(volumeMusicSlider);
		table.row().pad(10,0,0,10);
		table.add(musicOnOffLabel).left();
		table.add(musicCheckbox);
		table.row().pad(10,0,0,10);
		table.add(volumeSoundLabel).left();
		table.add(soundMusicSlider);
		table.row().pad(10,0,0,10);
		table.add(soundOnOffLabel).left();
		table.add(soundEffectsCheckbox);
		table.row().pad(10,0,0,10);
		table.add(backButton).colspan(2);

	}
	@Override
	public void render(float delta) {
		//parent.changeScreen(TheLegendOfSopra.PRINCIPAL);
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();

	}

	

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

}
