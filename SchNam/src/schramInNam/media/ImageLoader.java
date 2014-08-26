package schramInNam.media;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageLoader {
	
	public static BufferedImage[] johnStand = new BufferedImage[2];;
	
	static {
		johnpics();
	}
	
	private static void johnpics() {
		johnStand = new BufferedImage[2];
		try {
			johnStand[0] = ImageIO.read(ImageLoader.class.getClassLoader().getResource("/resources/images/entities/john/Young Schram 3.png"));
		} catch (IOException e) {System.out.println(e);}
	}

}
