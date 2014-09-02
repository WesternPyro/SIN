package schramInNam.util.abstracts;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;

public class Projectile{
	private int laserX, laserY;
	private double laserDirection;
	private AffineTransform at;
	private Graphics2D g2D;

	private static int SPEED = 10;
	
	public Projectile(int x, int y, double direction){
		at = new AffineTransform();
		laserX = x + 15;
		laserY = y + 15;
		laserDirection = direction + Math.toRadians(-2);
	}
	
	public void update(){
		at.setTransform(1,0,0,1,laserX,laserY);
		at.rotate(laserDirection,15,15);
		laserX -= SPEED * Math.cos(laserDirection);
		laserY -= SPEED * Math.sin(laserDirection);
	}
	
	public void draw(Graphics g){
		
	}

	public Point getLocation(){
		return new Point(laserX+15,laserY+15);
	}
}