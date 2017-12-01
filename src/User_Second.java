import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class User_Second extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Second frame = new User_Second();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public User_Second() {
		setTitle("CAR RACING GAME");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Either you are not registered or your");
		lblNewLabel.setBounds(82, 62, 297, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name, First Name and Group are not correct");
		lblNewLabel_1.setBounds(36, 89, 376, 15);
		contentPane.add(lblNewLabel_1);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(158, 116, 117, 25);
		contentPane.add(btnOk);
		btnOk.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		    
			// display admin frame when the button is pressed
				 setVisible(false);
		  }
		});
	}
}
