package schramInNam.util;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import schramInNam.input.KeyboardControl;
import schramInNam.input.MouseControl;
import schramInNam.media.ImageLoader;
import schramInNam.screens.CutsceneScreen;
import schramInNam.screens.LevelScreen;
import schramInNam.screens.MainMenuScreen;
import schramInNam.screens.TitleScreen;
import schramInNam.util.abstracts.AbstractScreen;
import schramInNam.util.interfaces.Updatable;

/*
 * This class is the bulk of the program. It is a JFrame that implements the Sikora-made Updatable interface.
 * It creates objects of the RenderingEngine, KeyboardControl, MouseControl, and AbstractScreen classes.
 * 
 */

public class GameFrame extends JFrame implements Updatable {
	private static final long serialVersionUID = 11011955L;
		
	private RenderingEngine renderer;
	KeyboardControl keyboard;
	MouseControl mouse;
	BufferedImage backBuffer;
	AbstractScreen currentScreen, titleScreen, mainMenuScreen, level1Screen, cutscene1Screen;
	Insets insets;

	public static final int TITLE = 0;
	public static final int MAIN_MENU = 0;
	
	public int windowWidth = 800, windowHeight = 600;
	boolean isRunning, canRender;
	
	/*
	 * The constructor of this class sets JFrame attributes, creates the back buffering, and makes new objects
	 * of the screens made previously
	 */
	
	
	public GameFrame() {
		setTitle("Schram in 'Nam");
		setSize(100,100);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);	
		isRunning = false;
		canRender = false;
		
		ImageLoader.loadAllImages();
		
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
	
	/*
	 * This is the run method called by the Main class. It has an infinite while loop
	 * that takes the current time, renders the game, then delays to give an illusion
	 * of 30 frames per second. AND YEAH I USED THREAD.SLEEP ARE YOU HAPPY NOW EH?!?!?!
	 */
	
	public void run() {
		renderer.start();
		isRunning = true;
		
		while(isRunning) {
			long time = System.currentTimeMillis();

			canRender = false;
			update();
			canRender = true;

			time = (1000 / 30) - (System.currentTimeMillis() - time);

			if (time > 0) {
				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {e.printStackTrace();}
			}
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see schramInNam.util.interfaces.Updatable#update()
	 * 
	 * updates the current screen.
	 */
	
	public void update() {
		currentScreen.update();
		
		System.out.println("X= " + mouse.getX() + " Y= " + mouse.getY());
	}
	
	/*
	 * called in the RenderingEngine class
	 */
	
	public void superDraw() {
		insets = getInsets();
		Graphics g = getGraphics();
		Graphics2D g2D = (Graphics2D) g;
		g2D.translate(insets.left, insets.top);
		
		Graphics2D bbg = backBuffer.createGraphics();
		setSize(windowWidth + insets.left + insets.right,windowHeight + insets.top + insets.bottom);		
		currentScreen.draw(bbg);
	
		g.drawImage(backBuffer, 0, 0, this);
	}
	/*
	 * This sets the screen of the current program output
	 */
	public void setScreen(int screen) {
		
	}
	
	public MouseControl getMouse() {
		return this.mouse;
	}
	
	public KeyboardControl getKeyboard() {
		return this.keyboard;
	}
}
