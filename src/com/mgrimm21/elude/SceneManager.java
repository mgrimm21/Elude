package com.mgrimm21.elude;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

public class SceneManager {

	private Map<String, Scene> scenes = new HashMap<String, Scene>();
	private Scene activeScene = null;
	
	
	
	public void addScene(String name, Scene scene) {
		synchronized(scenes) {
			scenes.put(name, scene);
		}
			if (activeScene == null) activeScene = scene;
	}
	
	public void removeScene(String name) {
		synchronized(scenes) {
			scenes.remove(name);
		}
	}
	
	public void setActiveScene(String name) {
		synchronized(scenes) {
			if (!scenes.containsKey(name)) return;
			synchronized(activeScene) {
				activeScene = scenes.get(name);
			}
		}
	}
	
	public void pollInput(Keyboard keyboard, Mouse mouse) {
		if (activeScene==null) return;
		synchronized(activeScene) {
			activeScene.pollInput(keyboard, mouse);
		}
	}
	
	public void tick() {
		if (activeScene==null) return;
		synchronized(activeScene) {
			activeScene.tick();
		}
	}
	
	public void render(Graphics g) {
		if (activeScene==null) return;
		synchronized(activeScene) {
			activeScene.render(g);
		}
	}
	
}
