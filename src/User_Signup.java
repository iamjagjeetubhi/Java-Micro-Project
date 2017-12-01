import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class User_Signup extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JPasswordField passwordField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Signup frame = new User_Signup();
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
	public User_Signup() {
		setTitle("CAR RACING GAME");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(46, 49, 107, 15);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(46, 22, 91, 15);
		contentPane.add(lblLastName);
		
		JLabel lblGroup = new JLabel("Group:");
		lblGroup.setBounds(46, 76, 70, 15);
		contentPane.add(lblGroup);
		
		JLabel lblPrefferedCarName = new JLabel("Preffered Car Name:");
		lblPrefferedCarName.setBounds(46, 103, 194, 15);
		contentPane.add(lblPrefferedCarName);
		
		JLabel lblCredit = new JLabel("Credit:");
		lblCredit.setBounds(46, 130, 70, 15);
		contentPane.add(lblCredit);
		
		JLabel lblScore = new JLabel("Score:");
		lblScore.setBounds(46, 157, 70, 15);
		contentPane.add(lblScore);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(46, 181, 91, 15);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(46, 208, 107, 15);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(254, 20, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(254, 47, 114, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		textField_2 = new JTextField();
		textField_2.setBounds(254, 74, 114, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(254, 101, 114, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(254, 128, 114, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(254, 155, 114, 19);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(254, 177, 114, 19);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(254, 206, 114, 19);
		contentPane.add(passwordField);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setBounds(171, 225, 117, 25);
		contentPane.add(btnSignUp);
		btnSignUp.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		    // display admin frame when the button is pressed
				String Lname = textField.getText();
				String Fname = textField_1.getText();
				String grp = textField_2.getText();
				String car = textField_3.getText();
				String credit = textField_4.getText();
				String score = textField_5.getText();
				String username = textField_6.getText();
				//char[] password = passwordField.getPassword();
				String password = new String(passwordField.getPassword());
				
				   System.out.println(Lname+"\n"+Fname+"\n"+grp+"\n"+car+"\n"+credit+"\n"+score+"\n"+username+"\n"+password+"\n");
				  if(MySQLAccess.CheckUser(Fname, Lname, grp)=="True") {
					   System.out.println("You should great database");
					   MySQLAccess.CreateUser(Fname, Lname, grp, car, credit, score, username, password);
					   
				  }
				  else {
					      User_Second.main(null);
				  }
				  
			 setVisible(false);
		  }
		});
		
		
	}
}
