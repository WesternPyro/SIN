package schramInNam.util;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import schramInNam.input.KeyboardControl;
import schramInNam.input.MouseControl;
import schramInNam.screens.CutsceneScreen;
import schramInNam.screens.LevelScreen;
import schramInNam.screens.MainMenuScreen;
import schramInNam.screens.TitleScreen;
import schramInNam.util.abstracts.AbstractScreen;
import schramInNam.util.interfaces.Updatable;

public class GameFrame extends JFrame implements Updatable {
	private static final long serialVersionUID = 11011955L;
	
	public static final int TITLE = 0;
	public static final int MAIN_MENU = 0;
	
	public final int windowWidth = 800, windowHeight = 600;
	
	boolean isRunning, canRender;
	
	private RenderingEngine renderer;
	
	KeyboardControl keyboard;
	MouseControl mouse;
	
	BufferedImage backBuffer;
	
	AbstractScreen currentScreen, titleScreen, mainMenuScreen, level1Screen, cutscene1Screen;

	public GameFrame() {
		super();
		
		setTitle("Schram in 'Nam");
		setSize(windowWidth, windowHeight);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);	
		isRunning = false;
		canRender = false;
		
		mouse = new MouseControl(this);
		keyboard = new KeyboardControl(this);
		
		backBuffer = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_INT_RGB);
		
		renderer = new RenderingEngine(this);
		
		titleScreen = new TitleScreen(this);
		mainMenuScreen = new MainMenuScreen(this);
		level1Screen = new LevelScreen(this);
		cutscene1Screen = new CutsceneScreen(this);
		currentScreen = titleScreen;
	}
	
	public void run() {
		renderer.start();
		isRunning = true;
		
		while(isRunning) {
			long time = System.currentTimeMillis();

			canRender = false;
			update();
			canRender = true;

			time = (1000 / 30) - (System.currentTimeMillis() - time);
//			System.out.println(time);

			if (time > 0) {
				try{
					Thread.sleep(time);
				}catch(Exception e){}
			}
		}
	}
	
	public void update() {
		currentScreen.update();
	}
	
	public void superDraw() {
		Graphics g = getGraphics();
		Graphics2D bbg = backBuffer.createGraphics();
		
		currentScreen.draw(bbg);

		g.drawImage(backBuffer, 0, 0, this);
	}
	
	public void setScreen(int screen) {
	}
	
	public MouseControl getMouse() {
		return this.mouse;
	}
	
	public KeyboardControl getKeyboard() {
		return this.keyboard;
	}

}
