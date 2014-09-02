package schramInNam.media;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageLoader {
	
	public static BufferedImage[] johnStand = new BufferedImage[3];
	public static BufferedImage[] firearms = new BufferedImage[10];
	
	//THIS METHOD IS FOR TESTING PURPOSES ONLY AND WILL NOT BE USED.
	//EACH METHOD THAT LOADS IMAGES WILL BE CALLED ON THE CONSTRUCTION OF THE SPECIFIED OBJECT
	public static void loadAllImages() {
		loadJohnpics();
		loadGunModels();
	}
	
	private static void loadJohnpics() {
		try {
			johnStand[0] = ImageIO.read(ImageLoader.class.getResource("/resources/images/entities/john/YoungSchram3.png"));
			johnStand[1] = ImageIO.read(ImageLoader.class.getResource("/resources/images/entities/john/YoungSchram2.png"));
			johnStand[2] = ImageIO.read(ImageLoader.class.getResource("/resources/images/entities/john/YoungSchram1.png"));			
		} catch (IOException e) {System.out.println(e);}
	}
	
	private static void loadGunModels() {
		try {
			firearms[0] = ImageIO.read(ImageLoader.class.getResource("/resources/images/weapons/realistic/AK-47.png"));
			firearms[1] = ImageIO.read(ImageLoader.class.getResource("/resources/images/weapons/fantasy/SonicScrewdriver.png"));
			firearms[2] = ImageIO.read(ImageLoader.class.getResource("/resources/images/weapons/realistic/Uboinik.png"));
		} catch (IOException e){System.out.println(e);}
	}
}
