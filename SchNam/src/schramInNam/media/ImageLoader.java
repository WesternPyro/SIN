package schramInNam.media;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.prism.paint.Color;

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
		
		BufferedImage fixed = new BufferedImage(items[0].getWidth(),items[0].getHeight(),BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < fixed.getWidth(); x++) {
			for (int y = 0; y < fixed.getHeight(); y++) {
				if (items[0].getRGB(x,y) != Color.WHITE.getIntArgbPre()) {
					fixed.setRGB(x,y,items[0].getRGB(x,y));
				}
			}
		}
		
		items[0] = fixed;
	}

}
