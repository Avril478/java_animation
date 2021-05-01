/*
MovingStarsMap.java: As a subclass of class MovingRectangle , specially adding two points , random point and moving methods into the GUI.
UPI kwan380    429862422 name KAI WANG

*/
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class MovingStarsMap extends MovingRectangle {
	private ArrayList<Point> points;
	
	/**
	 * Constructor function without parameters
	 */
	public MovingStarsMap(){
		this(0, 0, 100, 50, 800, 500, Color.yellow, Color.green, "CS230", 0);
		this.points = new ArrayList<Point>();
		this.points.add(new Point(this.x, this.y));
		addThreePoints();
	}
	
	/**
	 * Constructor function with one parameter
	 */
	public MovingStarsMap(int side) {
		this(0, 0, side, side, 800, 500, Color.yellow, Color.green, "CS230", 0);
		this.points = new ArrayList<Point>();
		this.points.add(new Point(this.x, this.y));
		this.addThreePoints();
	}
	
	/**
	 * Constructor function with all parameters
	 */
	public MovingStarsMap(int x, int y, int width, int height, int marginWidth, int marginHeight, Color borderColor, Color fillColor, String message, int pathID) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.marginWidth = marginWidth;
		this.marginHeight = marginHeight;
		this.fillColor = fillColor;
		this.borderColor = borderColor;
		this.message = message;
		setPath(pathID);
		this.points = new ArrayList<Point>();
		this.points.add(new Point(this.x, this.y));
		this.addThreePoints();
	}
	
	/**
	 * Generate another three points and add them into Points
	 */
	private void addThreePoints() {
		addRandomPoint();
		addRandomPoint();
		addRandomPoint();
	}
	
	/**
	 * Generate one different point from the points already having
	 */
	private void addRandomPoint() {
		boolean finished = false;
		boolean repeated;
		while(!finished) {
			int x = new Random().nextInt(this.width + 1) + this.x;
			int y = new Random().nextInt(this.height + 1) + this.y;
			repeated = false;
			for (int i = 0; i < this.points.size(); i++) {
				if(this.points.get(i).x == x && this.points.get(i).y == y) {
					repeated = true;
					break;
				}
			}
			if (repeated) {
				continue;
			}
			else {
				this.points.add(new Point(x, y));
				finished = true;
			}
		}
		
	}
	
	@Override
	public void setWidth(int width) {
		this.width = width;
		while (this.points.size() > 1) {
			this.points.remove(this.points.size() - 1);
		}
		this.addThreePoints();
	}
	
	@Override
	public void setHeight(int height) {
		this.height = height;
		while (this.points.size() > 1) {
			this.points.remove(this.points.size() - 1);
		}
		this.addThreePoints();
	}
	
	/**
	 * Every move needs to update the other three points
	 */
	@Override
	public void move() {
		for (int i = 1; i < this.points.size(); i++) {
			this.points.set(i, new Point(this.points.get(i).x - this.points.get(0).x, this.points.get(i).y - this.points.get(0).y));
		}
		super.move();
		this.points.set(0, new Point(this.x, this.y));
		for (int i = 1; i < this.points.size(); i++) {
			this.points.set(i, new Point(this.points.get(i).x + this.points.get(0).x, this.points.get(i).y + this.points.get(0).y));
		}
	}

	/**
	 * Draw the Stars Map
	 */
	@Override
	public void draw(Graphics g) {
		int[] coX = new int[this.points.size()];
		int[] coY = new int[this.points.size()];
		for (int i = 0; i < this.points.size(); i++) {
			coX[i] = this.points.get(i).x;
			coY[i] = this.points.get(i).y;
		}
		g.setColor(Color.white);
		g.fillRect(this.x, this.y, this.width, this.height);
		g.drawRect(this.x, this.y, this.width, this.height);
		g.setColor(this.fillColor);
		g.drawPolyline(coX, coY, this.points.size());
		drawMessage(g);
	}

}
