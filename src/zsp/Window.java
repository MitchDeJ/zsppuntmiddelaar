package zsp;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {
	
	public Window(int w, int h, String title, App app) {
		
		app.setPreferredSize(new Dimension(w, h));
		app.setMinimumSize(new Dimension(w, h));		
		app.setMaximumSize(new Dimension(w, h));	
		
		JFrame frame = new JFrame(title);
		frame.add(app);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		app.start();
		
	}

}
