package schramInNam.screens;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import schramInNam.media.ImageLoader;
import schramInNam.util.GameFrame;
import schramInNam.util.abstracts.AbstractScreen;

public class TitleScreen extends AbstractScreen {
	
	int x = 350;
	int y = 150;
	AffineTransform at;
	double rotation = .1;

	public TitleScreen(GameFrame game) {
		this.game = game;
		this.mouse = game.getMouse();
		this.keyboard = game.getKeyboard();
		
		at = new AffineTransform();
		at.setTransform(0, 1, 1, 0, x, y);
	}
	
	public void update() {
	}
	
	public void draw(Graphics2D g) {
		g.setColor(new Color(200,200,200));
		g.fillRect(0,0,799,599);
		
		g.drawImage(ImageLoader.firearms[0],150,150,null);
		at.rotate(rotation,60/2,56/2);
//		at.scale(.5,.5);
		g.drawImage(ImageLoader.firearms[1], at, null);
		
		g.drawImage(ImageLoader.johnStand[0],300,300,null);
		
		g.drawImage(ImageLoader.firearms[2],150,175,null);
	}

	public void reset() {
	}

}
