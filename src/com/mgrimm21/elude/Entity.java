package com.mgrimm21.elude;

import java.awt.Graphics;

public abstract class Entity implements IGameObject{

	protected int x, y, vx, vy;
	private Sprite sprite;
	
	public Entity(int x, int y, Sprite sprite) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getVx() {
		return vx;
	}

	public int getVy() {
		return vy;
	}
	
	@Override
	public void render(Graphics g) {
		sprite.render(x, y, g);
	}
	
}
