package zsp;

import java.awt.Color;
import java.awt.Graphics;

public class RenderEngine {

	private PointStorage storage;
	private int pointSize = 8;

	public RenderEngine(PointStorage storage) {
		this.storage = storage;
	}

	public void render(Graphics g) {
		
		g.setColor(new Color(66, 161, 244));
		g.fillRect(0, 0, 800, 800);
		
		for (int i=0;i<storage.get().size();i++) {
			Point p = storage.get().get(i);
			
			if (p instanceof CenteredPoint) {
				g.setColor(Color.YELLOW);
			} else {
				g.setColor(Color.RED);
			}
			if (p != null) {
				//draw the point
				g.fillRect(p.getX()-(pointSize/2), p.getY()-(pointSize/2), pointSize, pointSize);
				
				//draw the lines between points
				if (i+1 < storage.get().size())
					if (!(storage.get().get(i+1) instanceof CenteredPoint))
						g.drawLine(p.getX(), p.getY(), storage.get().get(i+1).getX(), storage.get().get(i+1).getY());
			}
		}
	}

}
