package PhotoEffect;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Effects {
	
	//public void Original(BufferedImage img) {
		
	//	int height = img.getHeight();
	//	int width = img.getWidth();
		
	//	for(int y = 0; y < height; y++){
	//	    for(int x =0; x <= width/2; x++){
	//	    	int p = img.getRGB(x,y);
		    	
	//	    	img.setRGB(x, y,p);
	//	    }
	//	}
	//}
	public void Sepia(BufferedImage img) {
		// TODO Auto-generated method stub
		int height = img.getHeight();
		int width = img.getWidth();
		for(int y = 0; y < height; y++){
		    for(int x = 0; x < width; x++){
		        int p = img.getRGB(x,y);
		        
		        int a = (p>>24)&0xff;
		        int r = (p>>16)&0xff;
		        int g = (p>>8)&0xff;
		        int b = p&0xff;
		        double tr = 0.393*r + 0.769*g + 0.189*b;
                double tg = 0.349*r + 0.686*g + 0.168*b;
                double tb = 0.272*r + 0.534*g + 0.131*b;
                
                if(tr > 255){
                    r = 255;
                }else{
                    r = (int) tr;
                }                
                if(tg > 255){
                    g = 255;
                }else{
                    g = (int) tg;
                }                
                if(tb > 255){
                    b = 255;
                }else{
                    b = (int) tb;
                }
		        p = (a<<24) | (r<<16) | (g<<8) | b;
		        
		        img.setRGB(x, y, p);
		    }
		}
	}

	public void GrayScale(BufferedImage img) {
		// TODO Auto-generated method stub
		int height = img.getHeight();
		int width = img.getWidth();
		for(int y = 0; y < height; y++){
		    for(int x = 0; x < width; x++){
		    	
		    	int p = img.getRGB(x,y);
		    	int a = (p>>24)&0xff;
		        int r = (p>>16)&0xff;
		        int g = (p>>8)&0xff;
		        int b = p&0xff;
		        
		        int avg = (r+g+b)/3 ;

		        p = (a<<24) | (avg<<16) | (avg<<8) | avg;
		        img.setRGB(x, y, p);
		    	
		    }
		}
	}

	public void Negative(BufferedImage img) {
		// TODO Auto-generated method stub
		int height = img.getHeight();
		int width = img.getWidth();
		for(int y = 0; y < height; y++){
		    for(int x = 0; x < width; x++){
		    	
		    	int p = img.getRGB(x,y);
		    	int a = (p>>24)&0xff;
		        int r = (p>>16)&0xff;
		        int g = (p>>8)&0xff;
		        int b = p&0xff;
		        
		        r= 255-r ;
		        g= 255-g;
		        b= 255-b ;

		        p = (a<<24) | (r<<16) | (g<<8) | b ;
		        img.setRGB(x, y, p);
		    	
		    }
		}
	}

	public void BlackAndWhite(BufferedImage img) {
		// TODO Auto-generated method stub
		int height = img.getHeight();
		int width = img.getWidth();
		for(int y = 0; y < height; y++){
		    for(int x = 0; x < width; x++){
		    	
		    	int p = img.getRGB(x,y);
		    	int a = (p>>24)&0xff;
		        int r = (p>>16)&0xff;
		        int g = (p>>8)&0xff;
		        int b = p&0xff;
		        
		        int avg = (r+g+b)/3 ;
		        if(avg<=127){
		        	r=0;
		        	g=0;
		        	b=0;
		        }
		        else{
		        	r=255;
		        	g=255;
		        	b=255;
		        }
		        
		        p = (a<<24) | (r<<16) | (g<<8) | b ;
		        img.setRGB(x, y, p);		    	
		    }
		}
	}

	
	
	public void Posterization(BufferedImage img) {
		
		int height = img.getHeight();
		int width = img.getWidth();
		for(int y = 0; y < height; y++){
		    for(int x = 0; x < width; x++){
		    	
		    	int p = img.getRGB(x,y);
		    	int a = (p>>24)&0xff;
		        int r = (p>>16)&0xff;
		        int g = (p>>8)&0xff;
		        int b = p&0xff;
		        
		        if(r < 64){
                    r = 0;
                }else{
                    r = 255;
                }                
                if(g < 64){
                    g = 0;
                }else{
                    g = 255 ;
                }                
                if(b < 64){
                    b = 0;
                }else{
                    b = 255;
                }

		        p = (a<<24) | (r<<16) | (g<<8) | b;
		        img.setRGB(x, y, p);
		    	
		    }
		}
	}
	
	public void Solarise(BufferedImage img) {
		int height = img.getHeight();
		int width = img.getWidth();
		int threshold = 128;
		for(int y = 0; y < height; y++){
		    for(int x = 0; x < width; x++){
		    	
		    	int p = img.getRGB(x,y);
		    	int a = (p>>24)&0xff;
		        int r = (p>>16)&0xff;
		        int g = (p>>8)&0xff;
		        int b = p&0xff;

		        if(r <threshold) r = 255-r;
		        if(g <threshold) g = 255-g;
		        if(b <threshold) b = 255-b;
		        
		        p = (a<<24) | (r<<16) | (g<<8) | b;
		        img.setRGB(x, y, p);
		    }
		}
		
	}
	

	public void Miror(BufferedImage img) {
		int height = img.getHeight();
		int width = img.getWidth();
		
		for(int y = 0; y < height; y++){
		    for(int x =0; x <= width/2 ; x++){
		    	int p = img.getRGB(x,y);
		    	
		    	img.setRGB(x, y, img.getRGB(width - 1 - x, y));
                img.setRGB(width - 1 - x, y, p);
		    }
		}
	}
	

	public void Wave(BufferedImage img) {
		
		int height = img.getHeight();
		int width = img.getWidth();
		
		for(int y = 0; y < height; y++){
		    for(int x =0; x <width ; x++){
		    	
		    	int p = img.getRGB(x, y);
		    	int xx = x;
                int yy = (int) (y + 20*Math.sin(x* 2* Math.PI / 128));
                
                if (yy >= 0 && yy < height) {
                    img.setRGB(x, y, img.getRGB(xx, yy));
                }
		    }
		}
	}
	
	
}
