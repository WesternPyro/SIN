package schramInNam.util.abstracts;

import java.awt.Graphics2D;

import schramInNam.input.KeyboardControl;
import schramInNam.input.MouseControl;
import schramInNam.util.GameFrame;
import schramInNam.util.interfaces.Drawable;
import schramInNam.util.interfaces.Updatable;

public abstract class AbstractScreen implements Updatable, Drawable {
	
/*******************************************************************************************
 *  NOTE: I need to finish classes including (but not limited to) the following:	
 *  	-TitleScreen			
 * 		-MainMenuScreen
 *  	-LevelScreen
 *  	-CutsceneScreen
 *  	-WinScreen
 *  	-CreditsScreen
 *******************************************************************************************/
	
	public GameFrame game;
	public MouseControl mouse;
	public KeyboardControl keyboard;

	public abstract void update();
	public abstract void draw(Graphics2D g);
	public abstract void reset();
	
	public GameFrame getGame(){
		return this.game;
	}
	
}
