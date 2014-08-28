package schramInNam.input;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardControl implements KeyListener {

	boolean[] keys = new boolean[KeyEvent.KEY_LAST];
	
	public KeyboardControl(Component c){
        for(int k = 0; k < 256; k++)
        	keys[k] = false;
        c.addKeyListener(this);
    }
	
	public boolean isKeyDown(int keyCode){
        if (keyCode > 0 && keyCode < 256){
        	return keys[keyCode];
        }
        return false;
    }

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() > 0 && e.getKeyCode() < 256){
        	keys[e.getKeyCode()] = true;
        }
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() > 0 && e.getKeyCode() < 256){
        	keys[e.getKeyCode()] = false;
        }
	}
	
	public void keyTyped(KeyEvent e) {}

}
