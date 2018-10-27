package com.mgrimm21.elude;

public abstract class UIElement extends Entity{
	
	protected int width, height;

	public UIElement(int x, int y, Sprite sprite) {
		super(x, y, sprite);
		this.width = sprite.getWidth();
		this.height = sprite.getHeight();
	}
	
	
}
