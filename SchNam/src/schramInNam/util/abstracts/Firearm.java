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
	private int x = 10, y = 10;
	private int id;
	private int baseDamage;
	private int baseRecoil;
	private int baseRoF;
	
	public Firearm(int identity, Entity entity){
		holder = entity;
		id = identity;
		at = new AffineTransform();
		at.setTransform(1,0,0,1,x,y);
	}
	
	public void fire(){
		
	}

	public void draw(Graphics g){
		g2D = (Graphics2D) g;
		g2D.drawImage(ImageLoader.firearms[id],at,null);
	}
	
	public void getAimPoint(Point aim){aimPoint = aim;}	
	public AffineTransform getTransform(){return at;}		
}
