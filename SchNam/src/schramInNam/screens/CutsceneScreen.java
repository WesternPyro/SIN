package schramInNam.screens;

import java.awt.Graphics2D;

import schramInNam.util.GameFrame;
import schramInNam.util.abstracts.AbstractScreen;

public class CutsceneScreen extends AbstractScreen {

	public CutsceneScreen(GameFrame game){
		this.game = game;
		this.mouse = game.getMouse();
		this.keyboard = game.getKeyboard();
	}
	
	public void update() {
	}

	public void draw(Graphics2D g) {
	}

	public void reset() {
	}
	
}
