package com.mgrimm21.elude;

import java.awt.Toolkit;

public class Main {

	public static void main(String[] args) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		SceneManager sceneManager = new SceneManager();
		new Engine(tk.getScreenSize(), sceneManager);
		TestEntity te = new TestEntity(500, 400, new Sprite("res/sprites/player.png"));
		Scene s = new Scene();
		s.add(te);
		UIButton button = new UIButton(800, 400, new Sprite("res/buttons/btn_test.png")) {
			
			@Override
			public void onClick() {
				System.out.println("Clicked");
			}
		};
		s.add(button);
		sceneManager.addScene("main", s);
	}

}
