import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JDialog;

public class Main_Window {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Window window = new Main_Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main_Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Main frame
		frame = new JFrame("CAR RACING GAME");
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 1024, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//Admin frame
		Admin_Window admin = new Admin_Window();
		
		//Main frame button
		JButton btnAdminins = new JButton("ADMINISTRATOR");
		btnAdminins.setBounds(115, 176, 153, 25);
		frame.getContentPane().add(btnAdminins);
		btnAdminins.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		    // display admin frame when the button is pressed
			  admin.setVisible(true);
		  }
		});
		//Main frame button
		JButton btnUser = new JButton("USER");
		btnUser.setBounds(793, 176, 117, 25);
		frame.getContentPane().add(btnUser);
	}
}
