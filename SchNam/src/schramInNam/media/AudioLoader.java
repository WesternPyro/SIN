package schramInNam.media;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioLoader {
	Clip clip;
	AudioInputStream inputStream;
	long microseconds;
	
	public AudioLoader(String file) throws Throwable{
		clip = AudioSystem.getClip();
		inputStream = AudioSystem.getAudioInputStream(getClass().getResource(file));
		clip.open(inputStream);
		microseconds = 0;
    }

    public AudioLoader(String file, long frames) throws Throwable{
		clip = AudioSystem.getClip();
		inputStream = AudioSystem.getAudioInputStream(getClass().getResource(file));
		clip.open(inputStream);
		microseconds = frames;
    }

    public void start(boolean loop){
    	if (clip.isActive())
    		clip.setMicrosecondPosition(microseconds);

    	if (loop)
    		clip.loop(Clip.LOOP_CONTINUOUSLY);
    	else if (!loop){
    		clip.setMicrosecondPosition(microseconds);
    		clip.start();
    	}
    }

    public void start(boolean loop, long mCs){
    	if (loop){
    		clip.setMicrosecondPosition(microseconds);
    		clip.loop(Clip.LOOP_CONTINUOUSLY);
    	}
    	else if (!loop){
    		clip.setMicrosecondPosition(microseconds);
    		clip.start();
    	}
    }

    public void stop(){
    	clip.stop();
    }

    public void loop(int loop){
    	clip.loop(loop);
    }

    public long getLength(){
    	return clip.getMicrosecondLength();
    }

}
