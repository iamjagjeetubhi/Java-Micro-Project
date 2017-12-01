import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class User_First extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_First frame = new User_First();
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
	public User_First() {
		setTitle("CAR RACING GAME");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTheLoginAnd = new JLabel("The Login and password provided are not correct");
		lblTheLoginAnd.setBounds(42, 65, 396, 15);
		contentPane.add(lblTheLoginAnd);
		
		JLabel lblPleaseTryAgain = new JLabel("Please try again if you already registered");
		lblPleaseTryAgain.setBounds(42, 92, 337, 15);
		contentPane.add(lblPleaseTryAgain);
		
		JLabel lblOrCompleteYour = new JLabel("or complete your registration if you are not");
		lblOrCompleteYour.setBounds(42, 119, 354, 15);
		contentPane.add(lblOrCompleteYour);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(138, 146, 117, 25);
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
