/*
 MovingHeart.java: extends MovingRectangle and contains 3 constructors. The function 
 to draw an heart and computing the area.
 UPI kwan380 429862422  name KAI WANG 


*/

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class MovingHeart extends MovingRectangle {
	/**
	 * Constructor function without parameters
	 */
	public MovingHeart() {
		this(0, 0, 100, 50, 800, 500, Color.yellow, Color.green, "CS230", 0);
	}
	
	/**
	 * Constructor function with one parameter
	 */
	public MovingHeart(int side) {
		this(0, 0, side, side, 800, 500, Color.yellow, Color.green, "CS230", 0);
	}
	
	/**
	 * Constructor function with all parameters
	 */
	public MovingHeart(int x, int y, int width, int height, int marginWidth, int marginHeight, Color borderColor, Color fillColor, String message, int pathID) {
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

	/**
	 * Draw the Heart
	 */
	@Override
	public void draw(Graphics g) {
		int[] trX = {
	            this.x - 2 * this.width / 18,
	            this.x + this.width + 2 * this.width / 18,
	            (this.x - 2 * this.width / 18 + this.x + this.width + 2 * this.width / 18) / 2};
	    int[] trY = { 
	            this.y + this.height - 2 * this.height / 3, 
	            this.y + this.height - 2 * this.height / 3, 
	            this.y + this.height };
	    g.setColor(this.fillColor);
	    
	    g.fillOval(this.x - this.width / 12, this.y, this.width / 2 + this.width / 6, this.height / 2); 
	    g.fillOval(this.x + this.width / 2 - this.width / 12, this.y, this.width / 2 + this.width / 6, this.height / 2);
	    g.fillPolygon(trX, trY, trX.length);
	    g.drawPolyline(trX, trY, trX.length);
	    g.setColor(borderColor);
	    drawMessage(g);
	}

	/**
	 * Compute the area of the heart shape
	 */
	@Override
	public double getArea() {
		double halfCircleArea = Math.PI * (width/4.0) * (width/4.0);
		double trArea = width * height / 4.0;
		return halfCircleArea * 2 + trArea;
	}
}
