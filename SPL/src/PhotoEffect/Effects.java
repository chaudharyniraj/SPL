package PhotoEffect;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Effects {
	//Emboss
	public void Emboss(BufferedImage img) {
		int height = img.getHeight();
		int width = img.getWidth();
		
		for(int y = 0; y < height-1; y++){
		    for(int x =0; x <width-1 ; x++){
		    	int p = img.getRGB(x,y);
		    	int a = (p>>24)&0xff;
		    	int r = (p>>16)&0xff;
		        int g = (p>>8)&0xff;
		        int b = p&0xff;
		        
		        //getting neighbour pixel
		    	int buttomP = img.getRGB(x+1, y+1);
		    	int buttomR = (buttomP>>16)&0xff;
		        int buttomG = (buttomP>>8)&0xff;
		        int buttomB = buttomP&0xff;
		        
		        r = Math.min((Math.abs(r-buttomR)+128),255);
		        g = Math.min((Math.abs(g-buttomG)+128),255);
		        b = Math.min((Math.abs(b-buttomB)+128),255);
		       
		       	p = (a<<24) | (r<<16) | (g<<8) | b;
		       	img.setRGB(x, y, p);
		        
		    }
		}
	
	}

	
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
	
	
public void Edge(BufferedImage img) {
		
		int height = img.getHeight();
		int width = img.getWidth();
		int amount = 8;
		
		for(int y = 0; y < height-1; y++){
		    for(int x =0; x <width-1 ; x++){
		    	int p = img.getRGB(x,y);
		    	int a = (p>>24)&0xff;
		    	int r = (p>>16)&0xff;
		        int g = (p>>8)&0xff;
		        int b = p&0xff;
		        int avg = (r+g+b)/3;
		        
		        //getting neighbour pixel
		    	int buttomP = img.getRGB(x, y+1);
		    	int buttomR = (buttomP>>16)&0xff;
		        int buttomG = (buttomP>>8)&0xff;
		        int buttomB = buttomP&0xff;
		        int buttom_avg = (buttomR+buttomG+buttomB)/3;
		        
		        int rightP = img.getRGB(x+1, y);
		        int rightR = (rightP>>16)&0xff;
		        int rightG = (rightP>>8)&0xff;
		        int rightB = rightP&0xff;
		        int right_avg = (rightR+rightG+rightB)/3;
		        
		        if(Math.abs(avg-right_avg) < amount || Math.abs(avg-buttom_avg) < amount){
		        	int red =0, blue=0, green =0;
		        	p = (a<<24) | (red<<16) | (green<<8) | blue;
		        	img.setRGB(x, y, p);
		        }else{
		        	int red =255, blue=255, green =255;
		        	p = (a<<24) | (red<<16) | (green<<8) | blue;
		        	img.setRGB(x, y, p);
		        }
		    }
		}
		
	}


	public void Miror(BufferedImage img) {
		int height = img.getHeight();
		int width = img.getWidth();
		
		for(int y = 0; y < height; y++){
		    for(int x =0; x < width/2 ; x++){
		    	int p = img.getRGB(x,y);
		    	
		    	img.setRGB(x, y, img.getRGB(width - 1 - x, y));
                img.setRGB(width - 1 - x, y, p);
		    }
		}
	}

	public void Sharpen(BufferedImage img) {
		int height = img.getHeight();
		int width = img.getWidth();
		
		String content = JOptionPane.showInputDialog("Write your value");
		double value = Double.parseDouble(content);
		if(value < 0.5) value = 0.5;
		if(value > 10) value = 10;
		
		for(int y = 0; y < height-1; y++){
		    for(int x =0; x <width-1 ; x++){
		    	int p = img.getRGB(x,y);
		    	int a = (p>>24)&0xff;
		    	int r = (p>>16)&0xff;
		        int g = (p>>8)&0xff;
		        int b = p&0xff;
		        
		        //getting neighbour pixel
		    	int buttomP = img.getRGB(x+1, y+1);
		    	int buttomR = (buttomP>>16)&0xff;
		        int buttomG = (buttomP>>8)&0xff;
		        int buttomB = buttomP&0xff;
		        
		        r = (int) (r+(value*(r-buttomR)));
		        g = (int) (g+(value*(g-buttomG)));
		        b = (int) (b+(value*(b-buttomG)));
		        
		        if(r>255) r=255;
		        if(r<0) r=0;
		        if(g>255) g=255;
		        if(g<0) g=0;
		        if(b>255) b=255;
		        if(b<0) b=0;
		          
		       	p = (a<<24) | (r<<16) | (g<<8) | b;
		       	img.setRGB(x, y, p);
		        
		    }
		}
	}


	public void XRay(BufferedImage img) {
		int height = img.getHeight();
		int width = img.getWidth();
		
		for(int y = 0; y < height; y++){
		    for(int x =0; x < width ; x++){
		    	
		    	int p = img.getRGB(x,y);
		    	int a = (p>>24)&0xff;
		        int r = (p>>16)&0xff;
		        int g = (p>>8)&0xff;
		        int b = p&0xff;
		        
		        int avg = (r+g+b)/3 ;
		        int xray = 255-avg;

		        p = (a<<24) | (xray<<16) | (xray<<8) | xray;
		        img.setRGB(x, y, p);
		    }
		}
		
	}


	public void Contrast(BufferedImage img) {
		
		int height = img.getHeight();
		int width = img.getWidth();
		
		for(int y = 0; y < height-1; y++){
		    for(int x =0; x <width-1 ; x++){
		    	int p = img.getRGB(x,y);
		    	int a = (p>>24)&0xff;
		    	int r = (p>>16)&0xff;
		        int g = (p>>8)&0xff;
		        int b = p&0xff;
		        
		        int gray = 127;
		        int value = 25;
		        
		        r = r + (r - gray) * value / 100;
		        g = g + (g - gray) * value / 100;
		        b = b + (b - gray) * value / 100;
                if(r > 255) r = 255;
                else if(r<0) r = 0;
                
                if(g > 255) g = 255;
                else if(g < 0) g = 0;
                
                if(b > 255) b = 255;
                else if(b < 0) b = 0;
		          
		       	p = (a<<24) | (r<<16) | (g<<8) | b;
		       	img.setRGB(x, y, p);
		        
		    }
		}
	}

	
}
