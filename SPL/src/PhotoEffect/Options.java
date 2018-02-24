package PhotoEffect;

import java.awt.BorderLayout;
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
import javax.swing.filechooser.FileNameExtensionFilter;

public class Options extends JFrame implements ActionListener {
	
	JMenu file,effects;
	JMenuItem open,save,exit;
	JMenuItem sepia, blackAndWhite, grayScale, wave, solarise, xRay, edge, posterization, oilPaint, outline, sharpen;
	JMenuItem   redImage, blueImage, greenImage, emboss, invert, negative, mirror;
	JLabel label, newlabel;
	JPanel imgpanel = new JPanel();
	//JPanel newimgPanel = new JPanel();
	
	JFileChooser openchooser = new JFileChooser("select your Image");
	String filename = null;
	
	Image img;
	BufferedImage bimg;
	
	
	public Options(){
		
		//JFrame mainframe = new JFrame();
		JMenuBar m_bar1 = new JMenuBar();
		
		file = new JMenu("File");
		effects = new JMenu("Effect");
		m_bar1.add(file);
		m_bar1.add(effects);
		setJMenuBar(m_bar1);
		
		open = new JMenuItem("Open");
		save = new JMenuItem("Save");
		exit = new JMenuItem("Exit");
		file.add(open);
		file.add(save);
		file.add(exit);
		
		open.addActionListener(this);
		save.addActionListener(this);
		exit.addActionListener(this);
		
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
		effects.add(wave);
		wave.addActionListener(this);
		
		solarise = new JMenuItem("Solarise");
		effects.add(solarise);
		solarise.addActionListener(this);
		
		xRay = new JMenuItem("X-Ray");
		//effects.add(xRay);
		xRay.addActionListener(this);
		
		edge = new JMenuItem("Edge");
		effects.add(edge);
		edge.addActionListener(this);
		
		oilPaint = new JMenuItem("Oil Paint");
		//effects.add(oilPaint);
		oilPaint.addActionListener(this);
		
		outline = new JMenuItem("Outline");
		//effects.add(outline);
		outline.addActionListener(this);
		
		sharpen = new JMenuItem("Sharpen");
		//effects.add(sharpen);
		sharpen.addActionListener(this);
		
		redImage = new JMenuItem("RedImage");
		effects.add(redImage);
		redImage.addActionListener(this);
		
		blueImage = new JMenuItem("BlueImage");
		effects.add(blueImage);
		blueImage.addActionListener(this);
		
		greenImage = new JMenuItem("GreenImage");
		effects.add(greenImage);
		greenImage.addActionListener(this);
		
		posterization = new JMenuItem("Posterization");
		effects.add(posterization);
		posterization.addActionListener(this);
		
		emboss = new JMenuItem("Emboss");
		//effects.add(emboss);
		emboss.addActionListener(this);
		
		//invert = new JMenuItem("Invert");
		//effects.add(invert);
		//invert.addActionListener(this);
		
		negative = new JMenuItem("Negative");
		effects.add(negative);
		negative.addActionListener(this);
		
		mirror = new JMenuItem("Mirror");
		effects.add(mirror);
		mirror.addActionListener(this);
		
		
		label = new JLabel();
		imgpanel.add(label, BorderLayout.CENTER);
		imgpanel.setLayout(new FlowLayout());
		add(imgpanel);
		
		newlabel = new JLabel();
		imgpanel.add(newlabel, BorderLayout.CENTER);
		add(imgpanel);
		
		FileNameExtensionFilter openfilter = new FileNameExtensionFilter("Images", "jpg", "bmp");
		openchooser.setFileFilter(openfilter);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JMenuItem compare = (JMenuItem) (e.getSource());
		Effects effect = new Effects();
		
		if (compare.getText().compareTo("Open") == 0) {
			setImage();

		} 
		else if (compare.getText().compareTo("Exit") == 0) {
			System.exit(0);

		} 
		else if (compare.getText().compareTo("Sepia") == 0) {
			effect.Sepia(bimg);
			DisplayImage2();
		} 
		else if (compare.getText().compareTo("GrayScale") == 0) {
			effect.GrayScale(bimg);
			DisplayImage2();
		} 
		else if (compare.getText().compareTo("Wave") == 0) {
			effect.Wave(bimg);
			DisplayImage2();
		}
		
		else if (compare.getText().compareTo("Negative") == 0) {
			effect.Negative(bimg);
			DisplayImage2();
		}
		else if (compare.getText().compareTo("Black And White") == 0) {
			effect.BlackAndWhite(bimg);
			DisplayImage2();
		}
		else if (compare.getText().compareTo("BlueImage") == 0) {
			effect.Blue(bimg);
			DisplayImage2();
		}
		else if (compare.getText().compareTo("GreenImage") == 0) {
			effect.Green(bimg);
			DisplayImage2();
		}
		else if (compare.getText().compareTo("RedImage") == 0) {
			effect.Red(bimg);
			DisplayImage2();
		}
		else if (compare.getText().compareTo("Posterization") == 0) {
			effect.Posterization(bimg);
			DisplayImage2();
		}
		else if (compare.getText().compareTo("Mirror") == 0) {
			effect.Miror(bimg);
			DisplayImage2();
		}
		else if (compare.getText().compareTo("Solarise") == 0) {
			effect.Solarise(bimg);
			DisplayImage2();
		}
		//else if (compare.getText().compareTo("Edge") == 0) {
		//	effect.Edge(bimg);
		//	DisplayImage2();
		//}
		
	}
	


	// prepare and read image
	public void setImage() {
		// TODO Auto-generated method stub
		int returnVal = openchooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			filename = openchooser.getSelectedFile().getAbsolutePath();
			try {
				img = ImageIO.read(new File(filename));
				bimg = ImageIO.read(new File(filename));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			DisplayImage();
		} else {
			JOptionPane.showMessageDialog(null, "please select image");
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
