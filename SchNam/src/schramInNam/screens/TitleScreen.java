package schramInNam.screens;

import java.awt.Color;
import java.awt.Graphics2D;

import schramInNam.media.ImageLoader;
import schramInNam.util.GameFrame;
import schramInNam.util.abstracts.AbstractScreen;
import schramInNam.util.abstracts.Firearm;
import schramInNam.util.abstracts.ProjectileController;

public class TitleScreen extends AbstractScreen {
	private Firearm ak;
	private ProjectileController pc;

	public TitleScreen(GameFrame game) {
		this.game = game;
		this.mouse = game.getMouse();
		this.keyboard = game.getKeyboard();
		this.pc = game.getProjectileController();
		
		ak = new Firearm(0,pc);
	}
	
	public void update() {
		pc.update();
	}
	
	public void draw(Graphics2D g) {
		g.setColor(new Color(200,200,200));
		g.fillRect(0,0,799,599);
		
		g.drawImage(ImageLoader.firearms[0],150,150,null);
		
		if(mouse.isButtonDown(1)){
			ak.fire();
		}
	}

	public void reset() {
		
	}

}
