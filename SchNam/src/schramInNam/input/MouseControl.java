package schramInNam.input;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseControl implements MouseListener{
	
	boolean[] buttons = new boolean[4];
	Component component;
	Point curPos;
	
	public MouseControl(Component c){
    	for (int k = 0; k < buttons.length; k++)
    		buttons[k] = false;
    	c.addMouseListener(this);
    	component = c;
    	curPos = new Point(0,0);    	
    }
	
	public boolean isButtonDown(int button){return buttons[button];}
	
	public double getX(){
    	if (component.getMousePosition() != null)
			curPos  = component.getMousePosition();
    	return curPos.getX();
    }

    public double getY(){
    	if (component.getMousePosition() != null)
    		curPos  = component.getMousePosition();
    	return curPos.getY();
    }

	public void mousePressed(MouseEvent e) {
		if (e.getButton() > 0 && e.getButton() < 4){
        	buttons[e.getButton()] = true;
        }
	}

	public void mouseReleased(MouseEvent e) {
		if (e.getButton() > 0 && e.getButton() < 4){
        	buttons[e.getButton()] = false;
        }
	}    
    
	public void mouseExited(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}
}
