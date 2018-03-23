package PhotoEffect;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame frame = new JFrame();
		ImageIcon img = new ImageIcon("C:\\Users\\niraj\\git\\SPL\\SPL\\flower.jpg");
		JLabel label = new JLabel(img);
		
		JLabel msg = new JLabel("WELCOME TO PHOTO FILTER");
		msg.setBounds(100,200,800,35);
		msg.setFont(new Font("Segoe Print", Font.BOLD, 40));
		msg.setForeground(Color.LIGHT_GRAY);
		label.add(msg);
		
		JButton button = new JButton("Enter");
		button.setBounds(400,500,100,25);
		button.setBackground(new Color(0, 102, 0));
		button.setFont(new Font("Segoe Print", Font.BOLD, 20));
		button.setForeground(Color.LIGHT_GRAY);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mainframe = new Options();
				mainframe.setTitle("Photo Effects");
				mainframe.setSize(800,500);		
				mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
				mainframe.setVisible(true);
				frame.setVisible(false);
			}
		});
		label.add(button);
		
		frame.add(label);
		frame.setSize(900, 600);
		frame.setResizable(false);
		frame.setVisible(true);

	}

}
