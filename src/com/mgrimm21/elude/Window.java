package com.mgrimm21.elude;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {

	public Window(Dimension size) {
		JFrame frame = new JFrame();
		frame.setPreferredSize(size);
		frame.setMinimumSize(size);
		frame.setMaximumSize(size);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(Engine.instance.canvas);
		frame.pack();
		frame.setVisible(true);
		frame.setFocusable(true);
		frame.requestFocus();
		Engine.instance.start();
	}
	
}
