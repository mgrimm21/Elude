package com.mgrimm21.elude;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{
	
	private boolean[] keysDown = new boolean[500];

	public boolean isDown(int key) {
		return keysDown[key];
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		keysDown[arg0.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		keysDown[arg0.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
}
