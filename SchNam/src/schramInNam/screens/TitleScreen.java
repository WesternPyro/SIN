package schramInNam.screens;

import java.awt.Color;
import java.awt.Graphics2D;

import schramInNam.media.ImageLoader;
import schramInNam.util.GameFrame;
import schramInNam.util.abstracts.AbstractScreen;

public class TitleScreen extends AbstractScreen {
	
	int x = 50;
	int y = 50;

	public TitleScreen(GameFrame game) {
		this.game = game;
		this.mouse = game.getMouse();
		this.keyboard = game.getKeyboard();
	}
	
	public void update() {
	}
	
	public void draw(Graphics2D g) {
		g.setColor(new Color(255,255,255));
		g.fillRect(50,50,50,50);
		
		g.drawImage(ImageLoader.items[0],150,150,null);
	}

	public void reset() {
	}

}
