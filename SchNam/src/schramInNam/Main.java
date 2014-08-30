package schramInNam;

import schramInNam.util.GameFrame;

/*
 * This class is the class that runs the entire game. It creates an object of
 * the GameFrame class called "game" and executes the "run" method. 
 */

public class Main {

	public static void main(String[] args) {
		GameFrame game = new GameFrame();
		game.run();
	}
}
