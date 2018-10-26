package com.mgrimm21.elude;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

public class Engine implements Runnable{

	public static Engine instance;
	
	private boolean running = false;
	private Thread thread;
	private Dimension size;
	public Canvas canvas = new Canvas();
	private Keyboard keyboard = new Keyboard();
	private Mouse mouse = new Mouse();
	private SceneManager sceneManager;
	
	
	private Color backgroundColor = Color.black;
	
	public Engine(Dimension windowSize, SceneManager sceneManager) {
		instance = this;
		size = windowSize;
		this.sceneManager = sceneManager;
		new Window(size);
		canvas.addKeyListener(keyboard);
	}
	
	private void tick() {
		if (keyboard.isDown(KeyEvent.VK_ESCAPE)) System.exit(0);
		sceneManager.pollInput(keyboard, mouse);
		sceneManager.tick();
	}
	
	private void render() {
		BufferStrategy bs = canvas.getBufferStrategy();
		if (bs == null) {
			canvas.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(backgroundColor);
		g.fillRect(0, 0, size.width, size.height);
		sceneManager.render(g);
		bs.show();
		g.dispose();
		
	}
	
	public synchronized void start() {
		if (running) return;
		thread = new Thread(this);
		running = true;
		thread.start();
	}
	
	public synchronized void stop() {
		if (!running) return;
		try {
			thread.join();
			running = false;
			System.exit(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running){
			canvas.requestFocus();
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
					
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}
	
	public void setBackgroundColor(Color color) {
		this.backgroundColor = color;
	}
	
	public Color getBackgroundColor() {
		return backgroundColor;
	}
	
}
