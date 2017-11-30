import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.sql.*;

public class Admin_Window extends JFrame{

	
	private JFrame frame;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Window frame = new Admin_Window();
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
	public Admin_Window() {
		setTitle("CAR RACING GAME");
		setResizable(false);
		setBackground(Color.LIGHT_GRAY);
		setBounds(100, 100, 1024, 800);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		//Button to create database
		MySQLAccess mysql = new MySQLAccess();
		//Admin fist
		Admin_First adm_first = new Admin_First();
		JButton btnCreateTheDatabase = new JButton("CREATE THE DATABASE");
		btnCreateTheDatabase.setBounds(100, 243, 195, 25);
		getContentPane().add(btnCreateTheDatabase);
		btnCreateTheDatabase.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		    // display admin frame when the button is pressed
			  if(MySQLAccess.checkDB()) {
				  System.out.println("the database exists");
				  Admin_First.main(null);
				  

			  }
			  else {
				 MySQLAccess.createDB();
			  }
		  }
		});
		
		JButton btnInitializeTheDatabase = new JButton("INITIALIZE THE DATABASE");
		btnInitializeTheDatabase.setBounds(434, 243, 208, 25);
		getContentPane().add(btnInitializeTheDatabase);
		btnInitializeTheDatabase.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		    
			// display admin frame when the button is pressed
			  ReadFile.main(null);
		  }
		});
		
		JButton btnDisplayTheDatabase = new JButton("DISPLAY THE DATABASE");
		btnDisplayTheDatabase.setBounds(740, 243, 208, 25);
		getContentPane().add(btnDisplayTheDatabase);
		btnDisplayTheDatabase.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		    
			// display admin frame when the button is pressed
			  TableFromMySqlDatabase.main(null);
		  }
		});
		//exit button
		JButton btnExit = new JButton("EXIT ADMIN");
		btnExit.setBounds(831, 666, 117, 25);
		getContentPane().add(btnExit);
		btnExit.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		    // display admin frame when the button is pressed
			  setVisible(false);
		  }
		});
	
	}
}
