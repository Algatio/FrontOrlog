package com.orlog.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import core.Orlog;
import util.Context;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Context.getInstance().getEmf().createEntityManager();
		
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		new Lwjgl3Application(new Orlog(), config);
		Context.getInstance().closeEmf();
	}
}


