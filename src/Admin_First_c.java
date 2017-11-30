import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Admin_First_c extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_First_c frame = new Admin_First_c();
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
	public Admin_First_c() {
		setTitle("CAR RACING GAME");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTableCreatedSuccessfully = new JLabel("Table Successfully Created ...");
		lblTableCreatedSuccessfully.setBounds(133, 78, 224, 15);
		contentPane.add(lblTableCreatedSuccessfully);
		
		JLabel lblClickOkTo = new JLabel("Click OK to continue...");
		lblClickOkTo.setBounds(153, 105, 168, 15);
		contentPane.add(lblClickOkTo);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(174, 132, 117, 25);
		contentPane.add(btnOk);
		btnOk.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		    // display admin frame when the button is pressed
			 setVisible(false);
			 //MySQLAccess object

		  }
		});
	}
}
