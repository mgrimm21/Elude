package com.mgrimm21.elude;

import java.awt.Graphics;

public interface IGameObject {

	public void pollInput(Keyboard keyboard, Mouse mouse);
	public void tick();
	public void render(Graphics g);
	
}
