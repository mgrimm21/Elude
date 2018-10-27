package com.mgrimm21.elude;

public abstract class UIButton extends UIElement{
	
	private boolean hovering = true;

	public UIButton(int x, int y, Sprite sprite) {
		super(x, y, sprite);
	}

	@Override
	public void pollInput(Keyboard keyboard, Mouse mouse) {
		if (Mouse.left && hovering) {
			onClick();
			Mouse.left = false;
		}
	}

	@Override
	public void tick() {
		if (Mouse.mouseX > x && Mouse.mouseX < x + width) {
			if (Mouse.mouseY > y && Mouse.mouseY < y + height) {
				hovering = true;
			}
		}
	}
	
	public abstract void onClick();

}
