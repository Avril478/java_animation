/*
 MovingEllipse.java :Extends MovingShape and contains 3 constructors. 
 override the function of contains(Point p),draw(Graphics g) and getArea().
 UPI kwan380 429862422  KAI WANG
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.lang.Math;
import java.awt.geom.Ellipse2D;


public class MovingEllipse extends MovingShape {
	
	/**
	 * Constructor function without parameters
	 */
	public MovingEllipse() {
		this(0, 0, 100, 50, 800, 500, Color.yellow, Color.green, "CS230", 0);
	}
	
	/**
	 * Constructor function with one parameter
	 */
	public MovingEllipse(int diameter) {
		this(0, 0, diameter, diameter, 800, 500, Color.yellow, Color.green, "CS230", 0);
	}
	
	/**
	 * Constructor function with all parameters
	 */
	public MovingEllipse(int x, int y, int width, int height, int marginWidth, int marginHeight, Color borderColor, Color fillColor, String message, int pathID) {
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
	}

	@Override
	public boolean contains(Point p) {
		double dx, dy;
		Point endPt = new Point(this.x + this.width, this.y + this.height);
		dx = (2 * p.x - this.x - endPt.x) / (double) this.width;
		dy = (2 * p.y - this.y - endPt.y) / (double) this.height;
		return dx * dx + dy * dy < 1.0;
	}

	/**
	 * Draw the Ellipse
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(this.fillColor);  
	    g.fillOval(this.x, this.y, this.width, this.height); 
	    g.setColor(this.borderColor);
	    g.drawOval(this.x, this.y, this.width, this.height);
		drawMessage(g);
	}

	@Override
	public double getArea() {
		return Math.PI * (this.width/2.0) * (this.height/2.0);
	}

}
