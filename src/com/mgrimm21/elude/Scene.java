package com.mgrimm21.elude;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Scene {

	private List<IGameObject> objects = new ArrayList<IGameObject>();
	private List<UIElement> UIElements = new ArrayList<UIElement>();
	
	public void add(IGameObject o) {
		synchronized(objects) {
			objects.add(o);
		}
	}
	
	public void remove(IGameObject o) {
		synchronized(objects) {
			objects.remove(o);
		}
	}
	
	public void add(UIElement o) {
		synchronized(UIElements) {
			UIElements.add(o);
		}
	}
	
	public void remove(UIElement o) {
		synchronized(UIElements) {
			UIElements.remove(o);
		}
	}
	
	public void pollInput(Keyboard keyboard, Mouse mouse) {
		synchronized(objects) {
			for (IGameObject o: objects) o.pollInput(keyboard, mouse);
		}
		synchronized(objects) {
			for (UIElement o: UIElements) o.pollInput(keyboard, mouse);
		}
	}
	
	public void tick() {
		synchronized(objects) {
			for (IGameObject o: objects) o.tick();
		}
		synchronized(objects) {
			for (UIElement o: UIElements) o.tick();
		}
	}
	
	public void render(Graphics g) {
		synchronized(objects) {
			for (IGameObject o: objects) o.render(g);
		}
		synchronized(objects) {
			for (UIElement o: UIElements) o.render(g);
		}
	}
	
}
