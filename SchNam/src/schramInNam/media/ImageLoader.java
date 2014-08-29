package schramInNam.media;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Color;
import javax.imageio.ImageIO;

public class ImageLoader {
	
	public static BufferedImage[] johnStand = new BufferedImage[2];
	public static BufferedImage[] items = new BufferedImage[10];
	
	public static void loadImages() {
		loadJohnpics();
		loadGunModels();
	}
	
	private static void loadJohnpics() {
		try {
			johnStand[0] = ImageIO.read(ImageLoader.class.getResource("/resources/images/entities/john/YoungSchram3.png"));
		} catch (IOException e) {System.out.println(e);}
	}
	
	private static void loadGunModels() {
		try {
			items[0] = ImageIO.read(ImageLoader.class.getResource("/resources/images/weapons/realistic/AK-47.png"));
		} catch (IOException e){System.out.println(e);}
	}
}
