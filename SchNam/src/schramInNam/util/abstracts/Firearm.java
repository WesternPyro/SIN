package schramInNam.util.abstracts;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;

import schramInNam.media.ImageLoader;

public class Firearm{
	private Entity holder;
	private AffineTransform at;
	private Point aimPoint;
	private Graphics2D g2D;
	private ProjectileController pc;
	private int x = 10, y = 10;
	private int id;
	private int baseDamage;
	private int baseRoF;
	private int baseDelay;
	private boolean isFiring;
	
	public Firearm(int identity, ProjectileController projctrl/*, Entity entity*/){
//		holder = entity;
		pc = projctrl;
		id = identity;
		at = new AffineTransform();
		at.setTransform(1,0,0,1,x,y);
	}
	
	public void fire(){
		
		
		
		pc.add(new Projectile(x,y,0));
	}

	public void draw(Graphics g){
		g2D = (Graphics2D) g;
		g2D.drawImage(ImageLoader.firearms[id],at,null);
	}
	
	public void getAimPoint(Point aim){aimPoint = aim;}	
	public AffineTransform getTransform(){return at;}		
}
