package PhotoEffect;

import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
	
	JMenu file,effects,rgbcmy,rotation;
	JMenuItem open,save,exit;
	JMenuItem sepia, blackAndWhite, grayScale, wave, solarise, xRay, edge,blur;
	JMenuItem  emboss, original, negative, mirror, posterization, oilPaint, outline, sharpen, contrast;
	JMenuItem red, blue, green, yellow, cyan,magenta;
	JMenuItem rotate90, rotate180, rotate270;
	JLabel label, newlabel;
	JPanel imgpanel = new JPanel();
	//JPanel newimgPanel = new JPanel();
	JSlider sharpenSlider;
	
	JFileChooser openchooser = new JFileChooser("select your Image");
	String filename = null;
	
	Image img;
	BufferedImage bimg;
	
	
	public Options(){
		
		//JFrame mainframe = new JFrame();
		JMenuBar m_bar1 = new JMenuBar();
		
		file = new JMenu("File");
		effects = new JMenu("Effect");
		rgbcmy = new JMenu("RGBCMY");
		rotation = new JMenu("Rotation");
		m_bar1.add(file);
		m_bar1.add(effects);
		m_bar1.add(rgbcmy);
		m_bar1.add(rotation);
		setJMenuBar(m_bar1);
		
		//File menu
		open = new JMenuItem("Open");
		save = new JMenuItem("Save");
		exit = new JMenuItem("Exit");
		file.add(open);
		file.add(save);
		file.add(exit);
		
		open.addActionListener(this);
		save.addActionListener(this);
		exit.addActionListener(this);

		//original = new JMenuItem("Original");
		//effects.add(original);
		//original.addActionListener(this);
		
		// Filters menu
		sepia = new JMenuItem("Sepia");
		effects.add(sepia);
		sepia.addActionListener(this);
		
		blackAndWhite = new JMenuItem("Black And White");
		effects.add(blackAndWhite);
		blackAndWhite.addActionListener(this);
		
		grayScale = new JMenuItem("GrayScale");
		effects.add(grayScale);
		grayScale.addActionListener(this);
		
		wave = new JMenuItem("Wave");
		//effects.add(wave);
		wave.addActionListener(this);
		
		solarise = new JMenuItem("Solarise");
		effects.add(solarise);
		solarise.addActionListener(this);
		
		xRay = new JMenuItem("X-Ray");
		effects.add(xRay);
		xRay.addActionListener(this);
		
		edge = new JMenuItem("Edge");
		effects.add(edge);
		edge.addActionListener(this);
		
		oilPaint = new JMenuItem("Oil Paint");
		//effects.add(oilPaint);
		oilPaint.addActionListener(this);
		
		outline = new JMenuItem("Outline");
		effects.add(outline);
		outline.addActionListener(this);
		
		
		posterization = new JMenuItem("Posterization");
		effects.add(posterization);
		posterization.addActionListener(this);
		
		emboss = new JMenuItem("Emboss");
		effects.add(emboss);
		emboss.addActionListener(this);
		
		negative = new JMenuItem("Negative");
		effects.add(negative);
		negative.addActionListener(this);
		
		sharpen = new JMenuItem("Sharpen");
		effects.add(sharpen);
		sharpen.addActionListener(this);
		
		contrast = new JMenuItem("Contrast");
		effects.add(contrast);
		contrast.addActionListener(this);
		
		blur = new JMenuItem("Blur");
		effects.add(blur);
		blur.addActionListener(this);
		
		mirror = new JMenuItem("Mirror");
		effects.add(mirror);
		mirror.addActionListener(this);
		
		
		//RGBCMY menuitem
		red = new JMenuItem("Red");
		rgbcmy.add(red);
		red.addActionListener(this);
		
		blue = new JMenuItem("Blue");
		rgbcmy.add(blue);
		blue.addActionListener(this);
		
		green = new JMenuItem("Green");
		rgbcmy.add(green);
		green.addActionListener(this);
		
		cyan = new JMenuItem("Cyan");
		rgbcmy.add(cyan);
		cyan.addActionListener(this);
		
		magenta = new JMenuItem("Magenta");
		rgbcmy.add(magenta);
		magenta.addActionListener(this);
		
		yellow = new JMenuItem("Yellow");
		rgbcmy.add(yellow);
		yellow.addActionListener(this);
		
		//Rotation
		rotate90 = new JMenuItem("Rotate90");
		rotation.add(rotate90);
		rotate90.addActionListener(this);
		
		rotate180 = new JMenuItem("Rotate180");
		rotation.add(rotate180);
		rotate180.addActionListener(this);
		
		rotate270 = new JMenuItem("Rotate270");
		rotation.add(rotate270);
		rotate270.addActionListener(this);
		
		label = new JLabel();
		imgpanel.add(label, BorderLayout.CENTER);
		imgpanel.setLayout(new FlowLayout());
		add(imgpanel);
		
		newlabel = new JLabel();
		imgpanel.add(newlabel, BorderLayout.CENTER);
		add(imgpanel);
		
		JScrollPane png = new JScrollPane(imgpanel);
		add(png);
		
		FileNameExtensionFilter openfilter = new FileNameExtensionFilter("Images", "jpg", "bmp");
		openchooser.setFileFilter(openfilter);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JMenuItem compare = (JMenuItem) (e.getSource());
		Effects effect = new Effects();
		RGBCMY rgbcmy = new RGBCMY();
		Rotation rotation = new Rotation();
		
		if (compare.getText().compareTo("Open") == 0) {
			setImage();

		} 
		else if (compare.getText().compareTo("Exit") == 0) {
			System.exit(0);

		}
		//else if (compare.getText().compareTo("Original") == 0) {
		//	ReadImage();
			//effect.Original(bimg);
		//	DisplayImage();
		//} 
		else if (compare.getText().compareTo("Blue") == 0) {
			ReadImage();
			rgbcmy.Blue(bimg);
			DisplayImage2();
		}
		else if (compare.getText().compareTo("Green") == 0) {
			ReadImage();
			rgbcmy.Green(bimg);
			DisplayImage2();
		}
		else if (compare.getText().compareTo("Red") == 0) {
			ReadImage();
			rgbcmy.Red(bimg);
			DisplayImage2();
		}
		else if (compare.getText().compareTo("Cyan") == 0) {
			ReadImage();
			rgbcmy.Cyan(bimg);
			DisplayImage2();
		}
		else if (compare.getText().compareTo("Magenta") == 0) {
			ReadImage();
			rgbcmy.Magenta(bimg);
			DisplayImage2();
		}
		else if (compare.getText().compareTo("Yellow") == 0) {
			ReadImage();
			rgbcmy.Yellow(bimg);
			DisplayImage2();
		}
		else if (compare.getText().compareTo("Sepia") == 0) {
			ReadImage();
			effect.Sepia(bimg);
			DisplayImage2();
		} 
		else if (compare.getText().compareTo("GrayScale") == 0) {
			ReadImage();
			effect.GrayScale(bimg);
			DisplayImage2();
		} 
		else if (compare.getText().compareTo("Wave") == 0) {
			ReadImage();
			//effect.Wave(bimg);
			DisplayImage2();
		}
		
		else if (compare.getText().compareTo("Negative") == 0) {
			ReadImage();
			effect.Negative(bimg);
			DisplayImage2();
		}
		else if (compare.getText().compareTo("Black And White") == 0) {
			ReadImage();
			effect.BlackAndWhite(bimg);
			DisplayImage2();
		}
		else if (compare.getText().compareTo("Posterization") == 0) {
			ReadImage();
			effect.Posterization(bimg);
			DisplayImage2();
		}
		else if (compare.getText().compareTo("Emboss") == 0) {
			ReadImage();
			effect.Emboss(bimg);
			DisplayImage2();
		}
		else if (compare.getText().compareTo("Contrast") == 0) {
			ReadImage();
			effect.Contrast(bimg);
			DisplayImage2();
		}
		else if (compare.getText().compareTo("Mirror") == 0) {
			ReadImage();
			effect.Miror(bimg);
			DisplayImage2();
		}
		else if (compare.getText().compareTo("Solarise") == 0) {
			ReadImage();
			effect.Solarise(bimg);
			DisplayImage2();
		}
		else if (compare.getText().compareTo("X-Ray") == 0) {
			ReadImage();
			effect.XRay(bimg);
			DisplayImage2();
		}
		else if (compare.getText().compareTo("Edge") == 0) {
			ReadImage();
			effect.Edge(bimg);
			DisplayImage2();
		}
		else if (compare.getText().compareTo("Outline") == 0) {
			ReadImage();
			effect.Outline(bimg);
			DisplayImage2();
		}
		else if (compare.getText().compareTo("Blur") == 0) {
			ReadImage();
			//effect.Blur(bimg);
			DisplayImage2();
		}
		else if (compare.getText().compareTo("Sharpen") == 0) {
			
			ReadImage();
			
//			sharpenSlider = new JSlider(JSlider.HORIZONTAL, 0, 5, 0);
//			add(sharpenSlider, BorderLayout.SOUTH);
//			sharpenSlider.addChangeListener(new ChangeListener(){
//
//				@Override
//				public void stateChanged(ChangeEvent arg0) {
//					int value = sharpenSlider.getValue();
//					System.out.println(value);
//					effect.Sharpen(bimg,value);
//				}				
//			});
			effect.Sharpen(bimg);
			DisplayImage2();
		}
		
		
		
		
		
		else if (compare.getText().compareTo("Rotate90") == 0) {
			ReadImage();
			int h = bimg.getHeight();
			int w = bimg.getWidth();
			BufferedImage rotated = new BufferedImage(h,w, bimg.getType());
			//rotation.Rotation90(bimg,rotated);
			//rotation.Rotation90(bimg);
			//DisplayImage2();
			newlabel.setIcon(new ImageIcon(rotated));
			//bimg=rotated;
		}
		else if (compare.getText().compareTo("Rotate180") == 0) {
			ReadImage();
			rotation.Rotation180(bimg);
			//rotation.Rotation90(bimg);
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


}
