package PhotoEffect;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Rotation {
	
	public void Rotation180(BufferedImage img) {
		int height = img.getHeight();
		int width = img.getWidth();
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width/2; x++){
				
				int p = img.getRGB(x,y);
				img.setRGB(x,y,img.getRGB(width-1-x, height-1-y));
				img.setRGB(width-1-x, height-1-y, p);
			}			
		}
		
	}
	
	public void Rotation90(BufferedImage img) {
		int height = img.getHeight();
		int width = img.getWidth();
		
		for(int y = 0; y < height/2; y++){
			for(int x = 0; x < width/2; x++){
				
				int p = img.getRGB(x,y);
				img.setRGB(x,y, img.getRGB(y,width-x-1));
				img.setRGB(y,width-1-x, img.getRGB( width-1-x,height-1-y));
				img.setRGB( width-1-x,height-1-y, img.getRGB(height-1-y,x));
				img.setRGB(height-1-y,x,p);

			}			
		}
		
	}

}