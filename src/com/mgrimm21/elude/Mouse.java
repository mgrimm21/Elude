package com.mgrimm21.elude;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener{

	public static int mouseX = 0, mouseY = 0;
	public static boolean left = false;
	public static boolean right = false;
	
	//unused for now
	//private boolean leftReleased = true;
	//private boolean rightReleased = true;
	
	public int getMouseX() {
		return mouseX;
	}
	
	public int getMouseY() {
		return mouseY;
	}
	
	public void pollInput() {
		mouseX = Engine.instance.canvas.getMousePosition().x;
		mouseY = Engine.instance.canvas.getMousePosition().y;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		if (arg0.getButton() == MouseEvent.BUTTON1) left = true;
		if (arg0.getButton() == MouseEvent.BUTTON2) right = true;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		if (arg0.getButton() == MouseEvent.BUTTON1) left = false;
		if (arg0.getButton() == MouseEvent.BUTTON2) right = false;
	}

}
