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
		
		JFrame frame = new JFrame("Photo Filter");
		ImageIcon img = new ImageIcon("C:\\Users\\niraj_007\\Git\\SPL\\SPL\\SPL\\image.jpg");
		JLabel label = new JLabel(img);
		
		JLabel msg = new JLabel("WELCOME TO PHOTO FILTER");
		msg.setBounds(100,80,800,35);
		msg.setFont(new Font("Segoe Print", Font.BOLD, 40));
		msg.setForeground(Color.DARK_GRAY);
		label.add(msg);
		
		JButton button = new JButton("Enter");
		button.setBounds(400,500,100,25);
		button.setBackground(Color.RED);
		button.setFont(new Font("Segoe Print", Font.BOLD, 20));
		button.setForeground(Color.LIGHT_GRAY);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame mainframe = new Options();
				mainframe.setTitle("Photo Filter");
				mainframe.setSize(1200,700);		
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