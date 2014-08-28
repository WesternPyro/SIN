package schramInNam.input;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseControl implements MouseListener , MouseMotionListener{
	
	boolean[] buttons = new boolean[4];
	Component component;
	Point curPos;
	
	public MouseControl(Component c){
    	for (int k = 0; k < buttons.length; k++)
    		buttons[k] = false;
    	c.addMouseListener(this);
    	component = c;
    	curPos = new Point(0,0);
    	
    	System.out.println(MouseEvent.MOUSE_FIRST + " " + MouseEvent.MOUSE_LAST + " " + MouseEvent.BUTTON1);
    	
    }

	//DREW URGENT PROBLEM: THE MOUSE FIELDS OF THE BUTTONS ARE NOT BETWEEN 0 AND 4, THEY ARE
	//BETWEEN 500 AND 507, SO NONE OF THE MOSUE BUTTONS ARE ACTUALLY BEING LSITENED TO ME.
	
	//oh wait
	//maybe not
	//button 1 might be just at 1
	
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
	
	public void mouseExited(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}

	public void mouseDragged(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}

}
