package PhotoEffect;

import java.awt.image.BufferedImage;

public class RGBCMY {
	
	public void Blue(BufferedImage img) {
		int height = img.getHeight();
		int width = img.getWidth();
		for(int y = 0; y < height; y++){
		    for(int x = 0; x < width; x++){
		    	
		    	int p = img.getRGB(x,y);
		    	int a = (p>>24)&0xff;
		        int r = (p>>16)&0xff;
		        int g = (p>>8)&0xff;
		        int b = p&0xff;
		        
		        //b=255;
		        r=0;
		        g=0;

		        p = (a<<24) | (r<<16) | (g<<8) | b;
		        img.setRGB(x, y, p);
		    	
		    }
		}
		
	}
	
	public void Green(BufferedImage img) {
		int height = img.getHeight();
		int width = img.getWidth();
		for(int y = 0; y < height; y++){
		    for(int x = 0; x < width; x++){
		    	
		    	int p = img.getRGB(x,y);
		    	int a = (p>>24)&0xff;
		        int r = (p>>16)&0xff;
		        int g = (p>>8)&0xff;
		        int b = p&0xff;
		        
		        //g=255;
		        r=0;
		        b=0;

		        p = (a<<24) | (r<<16) | (g<<8) | b;
		        img.setRGB(x, y, p);
		    	
		    }
		}		
	}

	public void Red(BufferedImage img) {
		int t=0;
		int height = img.getHeight();
		int width = img.getWidth();
		for(int y = 0; y < height; y++){
		    for(int x = 0; x < width; x++){
		    	
		    	int p = img.getRGB(x,y);
		    	int a = (p>>24)&0xff;
		        int r = (p>>16)&0xff;
		        int g = (p>>8)&0xff;
		        int b = p&0xff;
		        
		        r=0;
		        g=0;
		        b=0;
		        
		        t++;

		        p = (a<<24) | (r<<16) | (g<<8) | b;
		        img.setRGB(x, y, p);	    	
		    }
		}	
	}

	public void Cyan(BufferedImage img) {
		
		int height = img.getHeight();
		int width = img.getWidth();
		for(int y = 0; y < height; y++){
		    for(int x = 0; x < width; x++){
		    	
		    	int p = img.getRGB(x,y);
		    	int a = (p>>24)&0xff;
		        int r = (p>>16)&0xff;
		        int g = (p>>8)&0xff;
		        int b = p&0xff;
		        
		        int c = 1- (r/255);
		        int m = 1- (g/255);
		        int ye = 1- (b/255);
		        
		        int var_k = 1;
		        
		        if(c < var_k) var_k=c;
		        
		        if(var_k==1) c =0;
		        else c=(c-var_k)/(1-var_k);
		        
		        //int k = var_k;

		        p = (a<<24) | (c<<16) | (g<<8) | b;
		        img.setRGB(x, y, p);	    	
		    }
		}	
	}

	public void Magenta(BufferedImage img) {
		
		int height = img.getHeight();
		int width = img.getWidth();
		for(int y = 0; y < height; y++){
		    for(int x = 0; x < width; x++){
		    	
		    	int p = img.getRGB(x,y);
		    	int a = (p>>24)&0xff;
		        int r = (p>>16)&0xff;
		        int g = (p>>8)&0xff;
		        int b = p&0xff;
		        
		        int c = 1- (r/255);
		        int m = 1- (g/255);
		        int ye = 1- (b/255);
		        
		        int var_k = 1;
		        
		        if(m < var_k) var_k=m;
		        
		        if(var_k==1) m =0;
		        else m=(m-var_k)/(1-var_k);

		        p = (a<<24) | (r<<16) | (m<<8) | b;
		        img.setRGB(x, y, p);
		        	    	
		    }
		}
		
	}

	public void Yellow(BufferedImage img) {
		
		int height = img.getHeight();
		int width = img.getWidth();
		for(int y = 0; y < height; y++){
		    for(int x = 0; x < width; x++){
		    	
		    	int p = img.getRGB(x,y);
		    	int a = (p>>24)&0xff;
		        int r = (p>>16)&0xff;
		        int g = (p>>8)&0xff;
		        int b = p&0xff;
		        
		        int c = 1- (r/255);
		        int m = 1- (g/255);
		        int ye = 1- (b/255);
		        
		        int var_k = 1;
		        
		        if(m < var_k) var_k=ye;
		        
		        if(var_k==1) m =0;
		        else ye=(ye-var_k)/(1-var_k);

		        p = (a<<24) | (r<<16) | (g<<8) | ye;
		        img.setRGB(x, y, p);
		    	
		    }
		}
	}

}
