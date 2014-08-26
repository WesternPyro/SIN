package schramInNam.util.abstracts;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import schramInNam.util.interfaces.Drawable;
import schramInNam.util.interfaces.Updatable;

public abstract class Entity implements Updatable, Drawable {

	double x, y;
	int length, width;
	AbstractScreen screen;
	
	Rectangle hitBox;
	ArrayList<Point2D.Double> collisionPoints;
	
	public abstract void update();
	public abstract void draw(Graphics2D g);
	
}
