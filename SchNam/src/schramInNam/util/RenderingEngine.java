package schramInNam.util;

/*
 * 
 * 
 * 
 */

public class RenderingEngine extends Thread {

	private int fps;
	GameFrame game;
	int x;

    public RenderingEngine(GameFrame game){
    	super("Renderer");
    	this.fps = 30;
    	this.game = game;
    	this.x = 0;
    }

    public void run(){
    	while(x == 0){
			long time = System.currentTimeMillis();			
			boolean hasRendered = false;
			
			//Render the game
			while (!hasRendered) {
				if (game.canRender) {
					game.superDraw();
					hasRendered = true;
				}
			}

			//Delay to get current FPS
			time = (1000 / fps) - (System.currentTimeMillis() - time);
			if (time > 0){
				try{
					Thread.sleep(time);
				}
				catch(Exception e){}
			}
		}
    }
}
