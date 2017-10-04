package zsp;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

public class App extends Canvas implements Runnable {
	
	private boolean running = false;
	Thread thread;
	PointStorage storage = new PointStorage();
	RenderEngine renderEngine = new RenderEngine(storage);

	@Override
	public void run() {
		
		init();
		this.requestFocus();
		
		/*App loop*/
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running){
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
				frames = 0;
				updates = 0;
			}
		}
}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		renderEngine.render(g);	
		g.dispose();
		bs.show();
	}

	private void tick() {
		// TODO Auto-generated method stub
		
	}

	private void init() {
		this.addKeyListener(new KeyInput(this));
	}

	public synchronized void start() {
		if (running)
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public PointStorage getStorage() {
		return storage;
	}
	
	public static void main(String args[]) {
		new Window(640, 480, "ZSP Punt Middelaar", new App());
}

}
