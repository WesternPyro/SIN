package schramInNam.util.abstracts;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;

import schramInNam.input.MouseControl;
import schramInNam.media.ImageLoader;
import schramInNam.util.GameFrame;

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
	private boolean canFire;
	private GameFrame game;
	private MouseControl mouse;
	
	public Firearm(int identity, ProjectileController projctrl, GameFrame game/*, Entity entity*/){
//		holder = entity;
		pc = projctrl;
		id = identity;
		this.game = game;
		this.mouse = game.getMouse();
		at = new AffineTransform();
		at.setTransform(1,0,0,1,x,y);
		baseDelay = 100;
		canFire = true;
	}
	
	public void fire(){
		if(canFire){
			canFire= false;
			pc.add(new Projectile(x,y,0));
			long start= System.currentTimeMillis();
			long end = 0;
			while(end - start < baseDelay){
				end = System.currentTimeMillis();
			}
			canFire = true;
		}
	}

	public void draw(Graphics g){		
		g2D = (Graphics2D) g;
		g2D.drawImage(ImageLoader.firearms[id],at,null);
	}
	
	public void getAimPoint(Point aim){aimPoint = aim;}	
	public AffineTransform getTransform(){return at;}		
}
