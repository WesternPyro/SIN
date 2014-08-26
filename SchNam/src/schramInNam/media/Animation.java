package schramInNam.media;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Animation {
	
	Image[] ani;
	Image curFrame;

	private boolean isPlaying;
	private int curFrameNum;
	private int frameLength;
	private int counter;

    public Animation(String name, String extension, int length, int frameLength){
    	ani = new Image[length];
    	this.frameLength = frameLength;
    	counter = 0;
    	
//////////////////////////////////////////////////////////////////
//I might rewrite this part to work with the ImageLoader class
    	
    	for (int count = 0; count < length; count++){
    		String number = Integer.toString(count);
    		String fullName = (name + number + "." + extension);

    		try{
    			ani[count] = ImageIO.read(getClass().getResource(fullName));
    		}catch (IOException e) {System.out.println(e);}
    	}
///////////////////////////////////////////////////////////////////

    	curFrame = ani[0];
    	curFrameNum = 0;
    	isPlaying = false;
    }

    public void update(){
    	if (isPlaying && (counter % frameLength) == 0){
    		curFrameNum++;
    	}

    	if (curFrameNum >= ani.length){
    		stop();
    	}
    	
    	if (isPlaying){
    		counter++;
    	}
    }

    public void stop(){
    	isPlaying = false;
    	curFrameNum = 0;
    	counter = 0;
    }

    public void pause(){
    	isPlaying = false;
    }

    public Image getFrame(){
    	return (Image) (ani[curFrameNum]);
    }

}
