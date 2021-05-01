/* 
MovingSquare.java: Extends super class MovingRectangle with 3 contructors, overriding setWidth and setHeight  function. 
UPI kwan380  429862422  name KAI WANG

*/
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

// MovingSquare only needs to inherit MovingRectangle
public class MovingSquare extends MovingRectangle {
	
	/**
	 * Constructor function without parameters
	 */
	public MovingSquare() {
		this(0, 0, 50, 800, 500, Color.yellow, Color.green, "CS230", 0);
	}
	
	/**
	 * Constructor function with one parameter
	 */
	public MovingSquare(int side) {
		this(0, 0, side, 800, 500, Color.yellow, Color.green, "CS230", 0);
	}
	
	/**
	 * Constructor function with all parameters
	 */
	public MovingSquare(int x, int y, int side, int marginWidth, int marginHeight, Color borderColor, Color fillColor, String message, int pathID) {
		this.x = x;
		this.y = y;
		this.width = side;
		this.height = side;
		this.marginWidth = marginWidth;
		this.marginHeight = marginHeight;
		this.fillColor = fillColor;
		this.borderColor = borderColor;
		this.message = message;
		setPath(pathID);
	}
	
	/**
	 * Square need the width and height being same
	 */
	@Override
	public void setWidth(int width) {
		this.width = width;
		this.height = width;
	}
	
	/**
	 * Square need the width and height being same
	 */
	@Override
	public void setHeight(int height) {
		this.width = height;
		this.height = height;
	}
}
