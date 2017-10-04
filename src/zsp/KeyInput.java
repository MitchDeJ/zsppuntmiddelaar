package zsp;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {
	
	private App app;

	public KeyInput(App app) {
		this.app = app;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		app.getStorage().clear();
		app.getStorage().seed(15);
		app.getStorage().generateCenteredPoint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
