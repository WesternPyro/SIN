package schramInNam.util.abstracts;

import java.awt.Rectangle;
import java.util.ArrayList;

import schramInNam.util.GameFrame;

public class ProjectileController {
	private ArrayList<Projectile> projList;
	public static Rectangle bounds;

	public ProjectileController(){
		projList = new ArrayList<Projectile>();
		bounds = new Rectangle(0,0,GameFrame.windowWidth,GameFrame.windowHeight);
	}
	
	public void update(){
		for (int a = 0; a < projList.size(); a++){
			projList.get(a).update();
			if (!(bounds.contains(projList.get(a).getLocation()))){
				projList.remove(a);
			}
		}
	}
	
	public void add(Projectile proj){
		projList.add(proj);
		System.out.println("You have fired a projectile!");
	}
}
