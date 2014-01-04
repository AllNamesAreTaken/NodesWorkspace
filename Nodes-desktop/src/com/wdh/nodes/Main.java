package com.wdh.nodes;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Nodes";
		cfg.useGL20 = false;
		cfg.width = 800;
		cfg.height = 600;
		
		new LwjglApplication(new NodesGame(), cfg);
	}
}
