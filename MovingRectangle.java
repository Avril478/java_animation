/*
 MovingRectangle.java: extends MovingShape and contains 3 constructors. The function of judging if a given point is in the rectangle ,function 
 to draw an rectangle and computing the area.
 UPI kwan380 429862422  name KAI WANG 


*/
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class MovingRectangle extends MovingShape {
	
	
	/**
	 * Constructor function without parameters
	 */
	public MovingRectangle() {
		this(0, 0, 100, 50, 800, 500, Color.yellow, Color.green, "CS230", 0);
	}
	
	/**
	 * Constructor function with one parameter
	 */
	public MovingRectangle(int side) {
		this(0, 0, side, side, 800, 500, Color.yellow, Color.green, "CS230", 0);
	}
	
	/**
	 * Constructor function with all parameters
	 */
	public MovingRectangle(int x, int y, int width, int height, int marginWidth, int marginHeight, Color borderColor, Color fillColor, String message, int pathID) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.marginWidth = marginWidth;
		this.marginHeight = marginHeight;
		this.borderColor = borderColor;
		this.fillColor = fillColor;
		this.message = message;
		setPath(pathID);
	}

	@Override
	public boolean contains(Point p) {
		// TODO Auto-generated method stub
		int dx = p.x - this.x;
		int dy = p.y - this.y;
		if (dx >= 0 && dx <= this.width && dy >= 0 && dy <= this.height) {
			return true;
		}
		return false;
	}

	/**
	 * Draw the Rectangle
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(this.fillColor);
		g.fillRect(this.x, this.y, this.width, this.height);
		g.setColor(this.borderColor);
		g.drawRect(this.x, this.y, this.width, this.height);
		drawMessage(g);
	}

	@Override
	public double getArea() {
		return this.width * this.height;
	}
}
