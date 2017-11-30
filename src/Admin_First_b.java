import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Admin_First_b extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_First_b frame = new Admin_First_b();
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
	public Admin_First_b() {
		setTitle("CAR RACING GAME");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDatabase = new JLabel("Database Successfully Created...");
		lblDatabase.setBounds(118, 64, 259, 15);
		contentPane.add(lblDatabase);
		
		JLabel lblClickOkTo = new JLabel("Click OK to continue");
		lblClickOkTo.setBounds(160, 91, 199, 15);
		contentPane.add(lblClickOkTo);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBounds(179, 136, 117, 25);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		    // display admin frame when the button is pressed
			 setVisible(false);
			 //MySQLAccess object
			 MySQLAccess mysql = new MySQLAccess();
			 mysql.createTB();
		  }
		});
	}
}
