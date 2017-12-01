import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class User_Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Login frame = new User_Login();
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
	public User_Login() {
		setTitle("CAR RACING GAME");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(205, 56, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(114, 58, 98, 15);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(112, 85, 87, 15);
		contentPane.add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(171, 118, 117, 25);
		contentPane.add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(205, 87, 114, 19);
		contentPane.add(passwordField);
		btnLogin.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		    // display admin frame when the button is pressed
				String username = textField.getText();
				String password = new String(passwordField.getPassword());
				
				  if(MySQLAccess.LoginUser(username,password)=="True") {
					   System.out.println("Logged In!!!");
					  
					   
				  }
				  else {
					      User_First.main(null);
					     
					      
						   System.out.println("Wrong Id pass");

					      
				  }
				  
					 setVisible(false);

		  }
		});
	}
}
