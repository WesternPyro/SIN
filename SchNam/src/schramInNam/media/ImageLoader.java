package schramInNam.media;

import java.awt.image.BufferedImage;
import java.io.IOException;
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
			johnStand[0] = ImageIO.read(ImageLoader.class.getClassLoader().getResource("/resources/images/entities/john/Young Schram 3.png"));
			System.out.println("hello");
		} catch (IOException e) {System.out.println(e);}
	}
	
	private static void loadGunModels() {
		try {
			items[0] = ImageIO.read(ImageLoader.class.getClassLoader().getResource("/resources/images/weapons/realistic/AK-47.png"));
		} catch (IOException e){System.out.println(e);}
	}

}
