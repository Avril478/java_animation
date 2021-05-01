/*
MovingSpinningCircle.java : Extends MovingEllipse, with 3 constructors. Override setHeght, setWidth, draw methods.
UPI kwan380  429862422  name: KAI WANG

*/
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

// MovingSpinningCircle only needs to inherit MovingEllipse
public class MovingSpinningCircle extends MovingEllipse {
	
	public static final int ROTATION_SPEED = 20;
	private int startAngle = 0;
	
	/**
	 * Constructor function without parameters
	 */
	public MovingSpinningCircle() {
		this(0, 0, 50, 800, 500, Color.yellow, Color.green, "CS230",0);
	}
	
	/**
	 * Constructor function with one parameter
	 */
	public MovingSpinningCircle(int diameter) {
		this(0, 0, diameter, 800, 500, Color.yellow, Color.green, "CS230", 0);
	}
	
	/**
	 * Constructor function with all parameters
	 */
	public MovingSpinningCircle(int x, int y, int diameter, int marginWidth, int marginHeight, Color borderColor, Color fillColor, String message, int pathID) {
		this.x = x;
		this.y = y;
		this.width = diameter;
		this.height = diameter;
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
	public void setWidth(int w) {
		super.setWidth(w);
		this.height = this.width;
	}
	
	/**
	 * Square need the width and height being same
	 */
	@Override
	public void setHeight(int h) {
		super.setHeight(h);
		this.width = this.height;
	}
	
	/**
	 * Draw the spinning circle
	 */
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		g.setColor(this.borderColor);
		this.startAngle = (this.startAngle + MovingSpinningCircle.ROTATION_SPEED) % 360;
		g.fillArc(this.x, this.y, this.width, this.height, this.startAngle, 90);
		g.fillArc(this.x, this.y, this.width, this.height, (this.startAngle + 180) % 360, 90);
	}
}
