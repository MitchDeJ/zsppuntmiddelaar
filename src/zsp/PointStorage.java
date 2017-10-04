package zsp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PointStorage {
	
	private List<Point> storage = new ArrayList<Point>();
	
	public void addPoint(Point p) {
		storage.add(p);
	}
	
	public void removePoint(Point p) {
		storage.remove(p);
	}
	
	public void clear() {
		storage.clear();
	}
	
	public List<Point> get() {
		return storage;
	}
	
	public void seed(int count) {
		Random rand = new Random();
		for (int i=0; i<=count; i++) {
		    int randomx = rand.nextInt((640 - 10) + 1) + 10;
		    int randomy = rand.nextInt((480 - 10) + 1) + 10;
			storage.add(new Point(randomx, randomy));
		}
	}
	
	public void generateCenteredPoint() {
		
		int allx=0;
		int ally=0;
		int count=0;
		
		for (int i=0;i<storage.size();i++) {
			count++;
			Point p = storage.get(i);
			if (!(p instanceof CenteredPoint)) {
				allx += p.getX();
				ally += p.getY();
			}
		}
		
		int newx = allx/count;
		int newy = ally/count;
		
		addPoint(new CenteredPoint(newx, newy));
	}
	
}
