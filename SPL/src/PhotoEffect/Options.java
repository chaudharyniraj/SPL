package PhotoEffect;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Options extends JFrame implements ActionListener {
	
	JButton open,save,exit;
	JButton sepia, blackAndWhite, grayScale, wave, solarise, xRay,blur;
	JButton  emboss, original, negative, mirror, posterization,edge, edge2;
	JButton red, blue, green, yellow, cyan,magenta;
	JButton rotate90, rotate180, rotate270;
	JLabel label, newlabel;
	JPanel imgpanel = new JPanel();
	JPanel effects = new JPanel();
	JPanel north = new JPanel();
	JPanel south = new JPanel();
	JSlider sharpenSlider, contrastSlider;
	
	JFileChooser openchooser = new JFileChooser("select your Image");
	JFileChooser savechooser = new JFileChooser("Save your Image here");
	String filename = null;
	
	Image img;
	BufferedImage bimg;
	
	
	public Options(){
		
		//File 
		open = new JButton("Open");
		save = new JButton("Save");
		exit = new JButton("Exit");
		north.add(open);
		north.add(save);
		north.add(exit);
		
		open.addActionListener(this);
		save.addActionListener(this);
		exit.addActionListener(this);
		
		//Rotation
		rotate90 = new JButton("Rotate90");
		north.add(rotate90);
		rotate90.addActionListener(this);
				
		rotate180 = new JButton("Rotate180");
		north.add(rotate180);
		rotate180.addActionListener(this);
				
		rotate270 = new JButton("Rotate270");
		north.add(rotate270);
		rotate270.addActionListener(this);
		
		add(north, BorderLayout.NORTH);
		north.setPreferredSize(new Dimension(10,30));
		north.setLayout(new GridLayout(1,6));

		//original = new JMenuItem("Original");
		//effects.add(original);
		//original.addActionListener(this);
		
		// Filters 
		sepia = new JButton("Sepia");
		effects.add(sepia);
		sepia.addActionListener(this);
		
		blackAndWhite = new JButton("Black And White");
		effects.add(blackAndWhite);
		blackAndWhite.addActionListener(this);
		
		grayScale = new JButton("GrayScale");
		effects.add(grayScale);
		grayScale.addActionListener(this);
		
		wave = new JButton("Wave");
		//effects.add(wave);
		wave.addActionListener(this);
		
		solarise = new JButton("Solarise");
		effects.add(solarise);
		solarise.addActionListener(this);
		
		xRay = new JButton("X-Ray");
		effects.add(xRay);
		xRay.addActionListener(this);
		
		edge = new JButton("Edge1");
		effects.add(edge);
		edge.addActionListener(this);
		
		edge2 = new JButton("Edge2");
		effects.add(edge2);
		edge2.addActionListener(this);
		
		
		posterization = new JButton("Posterization");
		effects.add(posterization);
		posterization.addActionListener(this);
		
		emboss = new JButton("Emboss");
		effects.add(emboss);
		emboss.addActionListener(this);
		
		negative = new JButton("Negative");
		effects.add(negative);
		negative.addActionListener(this);
		
//		sharpen = new JButton("Sharpen");
//		effects.add(sharpen);
//		sharpen.addActionListener(this);
		
		blur = new JButton("Blur");
		effects.add(blur);
		blur.addActionListener(this);
		
		mirror = new JButton("Mirror");
		effects.add(mirror);
		mirror.addActionListener(this);
		
		
		//RGBCMY 
		red = new JButton("Red");
		effects.add(red);
		red.addActionListener(this);
		
		blue = new JButton("Blue");
		effects.add(blue);
		blue.addActionListener(this);
		
		green = new JButton("Green");
		effects.add(green);
		green.addActionListener(this);
		
		cyan = new JButton("Cyan");
		effects.add(cyan);
		cyan.addActionListener(this);
		
		magenta = new JButton("Magenta");
		effects.add(magenta);
		magenta.addActionListener(this);
		
		yellow = new JButton("Yellow");
		effects.add(yellow);
		yellow.addActionListener(this);
		
		/////////// Filters panel //////
		add(effects,BorderLayout.WEST);
		effects.setPreferredSize(new Dimension(130,0));
		effects.setLayout(new GridLayout(18,1));
		
		////////////// image pannel ///////////////////////
		label = new JLabel();
		imgpanel.add(label);
		add(imgpanel);
		
		newlabel = new JLabel();
		imgpanel.add(newlabel);
		add(imgpanel,BorderLayout.CENTER);
		imgpanel.setLayout(new GridLayout(1,2));
		
		
		///////////////////// JScrollpane /////////////////////////////
		JScrollPane png = new JScrollPane(imgpanel);
		add(png);
		
		//////////////// Slider Contrast ///////////////////////////
		JLabel contrast = new JLabel("Contrast");
		south.add(contrast);		
		contrastSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
		//add(contrastSlider, BorderLayout.SOUTH);
		contrastSlider.addChangeListener(new ChangeListener(){
			Effects effect = new Effects();
			public void stateChanged(ChangeEvent arg0) {
				int value = (contrastSlider.getValue());
				//System.out.println(value);
				ReadImage();
				effect.Contrast(bimg,value);
				DisplayImage2();
				repaint();
			}				
		});
		south.add(contrastSlider);
		
		////// sharpen Slider//////////////////
		JLabel sharpen = new JLabel("Sharpen");
		south.add(sharpen);		
		sharpenSlider = new JSlider(JSlider.HORIZONTAL, 0, 200, 0);
		//add(sharpenSlider, BorderLayout.SOUTH);
		sharpenSlider.addChangeListener(new ChangeListener(){
			Effects effect = new Effects();
			public void stateChanged(ChangeEvent arg0) {
				double value = (sharpenSlider.getValue())/100;
				System.out.println(sharpenSlider.getValue()/100);
				ReadImage();
				effect.Sharpen(bimg,value);
				DisplayImage2();
				repaint();
			}				
		});
		south.add(sharpenSlider);
		add(south,BorderLayout.SOUTH);
		south.setPreferredSize(new Dimension(100,30));
		south.setLayout(new FlowLayout());
		
		
		FileNameExtensionFilter openfilter = new FileNameExtensionFilter("Images", "jpg", "bmp");
		openchooser.setFileFilter(openfilter);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//JMenuItem compare = (JMenuItem) (e.getSource());
		String compare1 = e.getActionCommand();
		Effects effect = new Effects();
		RGBCMY rgbcmy = new RGBCMY();
		Rotation rotation = new Rotation();
		
		if (compare1.equals("Open")) {
			setImage();

		} 
		else if (compare1.equals("Save")) {
			saveImage();

		}
		else if (compare1.equals("Exit")) {
			System.exit(0);

		}
		
		else if (compare1.equals("Rotate90")) {
			ReadImage();
			rotation.Rotation90(bimg);
			DisplayImage2();
		}
		else if (compare1.equals("Rotate180")) {
			ReadImage();
			rotation.Rotation180(bimg);
			DisplayImage2();
		}
		else if (compare1.equals("Rotate270")) {
			ReadImage();
			rotation.Rotation90(bimg);
			rotation.Rotation90(bimg);
			rotation.Rotation90(bimg);
			DisplayImage2();
		}
		else if (compare1.equals("Blue")) {
			ReadImage();
			rgbcmy.Blue(bimg);
			DisplayImage2();
		}
		else if (compare1.equals("Green")) {
			ReadImage();
			rgbcmy.Green(bimg);
			DisplayImage2();
		}
		else if (compare1.equals("Red")) {
			ReadImage();
			rgbcmy.Red(bimg);
			DisplayImage2();
		}
		else if (compare1.equals("Cyan")) {
			ReadImage();
			rgbcmy.Cyan(bimg);
			DisplayImage2();
		}
		else if (compare1.equals("Magenta")) {
			ReadImage();
			rgbcmy.Magenta(bimg);
			DisplayImage2();
		}
		else if (compare1.equals("Yellow")) {
			ReadImage();
			rgbcmy.Yellow(bimg);
			DisplayImage2();
		}
		else if (compare1.equals("Sepia")) {
			ReadImage();
			effect.Sepia(bimg);
			DisplayImage2();
		} 
		else if (compare1.equals("GrayScale")) {
			ReadImage();
			effect.GrayScale(bimg);
			DisplayImage2();
		} 
		else if (compare1.equals("Wave")) {
			ReadImage();
			//effect.Wave(bimg);
			DisplayImage2();
		}
		
		else if (compare1.equals("Negative")) {
			ReadImage();
			effect.Negative(bimg);
			DisplayImage2();
		}
		else if (compare1.equals("Black And White")) {
			ReadImage();
			effect.BlackAndWhite(bimg);
			DisplayImage2();
		}
		else if (compare1.equals("Posterization")) {
			ReadImage();
			effect.Posterization(bimg);
			DisplayImage2();
		}
		else if (compare1.equals("Emboss")) {
			ReadImage();
			effect.Emboss(bimg);
			DisplayImage2();
		}
		else if (compare1.equals("Mirror")) {
			ReadImage();
			effect.Miror(bimg);
			DisplayImage2();
		}
		else if (compare1.equals("Solarise")) {
			ReadImage();
			effect.Solarise(bimg);
			DisplayImage2();
		}
		else if (compare1.equals("X-Ray")) {
			ReadImage();
			effect.XRay(bimg);
			DisplayImage2();
		}
		else if (compare1.equals("Edge1")) {
			ReadImage();
			effect.Edge(bimg);
			DisplayImage2();
		}
		else if (compare1.equals("Edge2")) {
			ReadImage();
			effect.Edge2(bimg);
			DisplayImage2();
		}
		else if (compare1.equals("Blur")) {
			ReadImage();
			effect.Blur(bimg);
			DisplayImage2();
		}
		
	}
	


	// select image
	public void setImage() {
		// TODO Auto-generated method stub
		int returnVal = openchooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			
			ReadImage();
			DisplayImage();
		} else {
			JOptionPane.showMessageDialog(null, "please select image");
		}
	}
	
	//read image
	public void ReadImage(){
		filename = openchooser.getSelectedFile().getAbsolutePath();
		try {
			img = ImageIO.read(new File(filename));
			bimg = ImageIO.read(new File(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//display original image
	private void DisplayImage() {
		
		label.setIcon(new ImageIcon(img));
	}
	
	//display processed image
	public void DisplayImage2(){
		newlabel.setIcon(new ImageIcon(bimg));
	}
	
	//SaveImage
	public void saveImage() {
		int save = savechooser.showSaveDialog(this);	
		if (save == JFileChooser.APPROVE_OPTION) {
			try {
				ImageIO.write( (RenderedImage) bimg,"jpg",savechooser.getSelectedFile());		
			} catch (IOException e) {
				e.printStackTrace();
			}
						
		} 
					 
	}


}
