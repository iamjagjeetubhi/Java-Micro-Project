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
	int totalAttempts= 0;

	static int gas = 0;
	static int moreGas = 0;
	
	//Method that generates a random amount of gas to be used for acceleration (between minx10 and maxx10)
	static int createInjection(int min, int max){
		int myInjection = (int)(Math.random() * 10 * (Math.random() > 0.5 ? max : min));	
		return myInjection;
		}

	/**
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
					  setVisible(false);
					//  System.out.println("Logged In!!!");
					  try {
						JTextAreaOutputStream.main(null);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					  
					   
				  }
				  if(!(MySQLAccess.LoginUser(username,password)=="True")) {
					  System.out.println(totalAttempts);
					  
					  totalAttempts++;
					  if(totalAttempts>3) {
						  User_First_b.main(null);
					  }
					  else {
						  User_First.main(null);
					  }
					  
					  
					   
				  }
				 
				  
				  
					// setVisible(false);

		  }
		});
	}
	public static void car() {
		boolean wasCrash = false;
		
        //Create a car named specified just by its name : �Toyota�.  
		Car myFirstCar = new Car("YourPreferedCar");
		
        //Create a car with a specified name: �Mazda� to be driven by a non-experienced person.
		//This Car will start the race with an initial speed given by the player as a parameter to the constructor 
		//Let's take 20.
		Car mySecondCar = new Car ("ComputerCar");

        //Create the first Driver that will drive the first car
		Driver firstDriver = new Driver();
		
		//Create the second Driver that will drive the second car
		Driver secondDriver = new Driver();

		String theWinner = "";

		System.out.println();
		System.out.println("\t\t\t\t" + "CAR RACING");
		System.out.println("\t\t\t\t" + "----------");
		System.out.println();
		System.out.println();
       
		//Cars start  
		myFirstCar.start(1, 0);
		mySecondCar.start(1, 0);
       
		//Cars start running. From here they all get the current speed
		myFirstCar.StartRunning();
		myFirstCar.setSpeedIncreaseStep(myFirstCar.getCurrentSpeed());
       
		mySecondCar.StartRunning();
		mySecondCar.setSpeedIncreaseStep(mySecondCar.getCurrentSpeed());

		//Let's race for 30 seconds
		int i = 1;
		while (i < 60)
		{
			//if myFirstCar speedIncreaseStep is positive (Acceleration)
			if (myFirstCar.getSpeedIncreaseStep() > 0){
        	   System.out.print(myFirstCar.getSpeedIncreaseStep() +" :: " +myFirstCar.getCarName() + " >>> : " +myFirstCar.getCurrentSpeed() +"\t\t" );
			}
			//if myFirstCar current speedIncreaseStep is negative (Deceleration - Slow down)
			else if (myFirstCar.getSpeedIncreaseStep() < 0){
        	   System.out.print(myFirstCar.getSpeedIncreaseStep() +" :: " +myFirstCar.getCarName() + " <<< : " +myFirstCar.getCurrentSpeed() +"\t\t");
			}
			//if myFirstCar speedIncreaseStep speed is zero (Constant speed)
			else{ 
    		   //increment the car zeroCounter counter 	
    		   myFirstCar.setZeroCounter(myFirstCar.getZeroCounter() + 1);
    		   //prepare gas  	
    		   gas = createInjection(2, 0);
    		   //Increase the speed related to the amount of gas alloted
    		   myFirstCar.setSpeedIncreaseStep(gas);
    		   //Get this speed when the driver punches on the accelerator pedal 
               firstDriver.punchOnAccelorPedal(myFirstCar, myFirstCar.getSpeedIncreaseStep());
               System.out.print(myFirstCar.getSpeedIncreaseStep() +" :: " +myFirstCar.getCarName() + " +++ : " +myFirstCar.getCurrentSpeed() +"\t\t");
               //if the number of times zeroCounter has passed to zero is multiple of 3
               if(myFirstCar.getZeroCounter() % 3 == 0){
            	   //prepare even more gas
            	   moreGas=createInjection(myFirstCar.getZeroCounter(), 0);
            	   //Automatically increase the speed related to the amount of gas alloted
            	   myFirstCar.automaticAccelerationIncrease(gas);
            	   System.out.print(myFirstCar.getSpeedIncreaseStep() +" :: " +myFirstCar.getCarName() + " *** : " +myFirstCar.getCurrentSpeed() +"\t\t");
               }
    	   }
			//if mySecondCar speedIncreaseStep is positive (Acceleration)
       	   if (mySecondCar.getSpeedIncreaseStep() > 0){
        	   System.out.println(mySecondCar.getSpeedIncreaseStep() +" :: "  +mySecondCar.getCarName() + " >>> : " +mySecondCar.getCurrentSpeed() );
        	   //if mySecondCar current speedIncreaseStep is negative (Deceleration - Slow down)
       	   		}
    	   else if (mySecondCar.getSpeedIncreaseStep() < 0){
        	   System.out.println(mySecondCar.getSpeedIncreaseStep() +" :: "  +mySecondCar.getCarName() + " <<< : " +mySecondCar.getCurrentSpeed() );
    	   }
       	   //if mySecondCar  speedIncreaseStep speed is zero (Constant speed)		
    	   else{ 
   		   		//increment the car zeroCounter counter 	
    		   	mySecondCar.setZeroCounter(mySecondCar.getZeroCounter() + 1);
    			//increment the car zeroCounter counter 
    		   	gas = createInjection(1, 0);
    		   	//Increase the speed related to the amount of gas alloted
    		   	mySecondCar.setSpeedIncreaseStep(gas);
    		   	//Get this speed when the driver punches on the accelerator pedal 
    		   	secondDriver.punchOnAccelorPedal(mySecondCar, mySecondCar.getSpeedIncreaseStep());
    		   	System.out.println(mySecondCar.getSpeedIncreaseStep() +" :: " +mySecondCar.getCarName() + " +++ : " +mySecondCar.getCurrentSpeed() +"\t\t");
    		   	//if the number of times zeroCounter has passed to zero is multiple of 3
    		   	if(mySecondCar.getZeroCounter() % 3 == 0){
    		   		//prepare even more gas
    		   		moreGas=createInjection(mySecondCar.getZeroCounter(), 0);
    		   		//Automatically increase the speed related to the amount of gas alloted
    		   		mySecondCar.automaticAccelerationIncrease(gas);
    		   		System.out.println(mySecondCar.getSpeedIncreaseStep() +" :: " +mySecondCar.getCarName() + " *** : " +mySecondCar.getCurrentSpeed() +"\t\t");
    		   	}
    	   }

          //Keep running both the cars
          myFirstCar.run(2, -1);
          mySecondCar.run(2, -1);
          //Pass the seconds between two sppeeds
      	  try
    	  { 
    		 Thread.sleep(1000);   
    	  	}
      	  catch(Exception e)
      	  {
    		System.out.println("there is an error");
      	  	}
          i++;       
		}  
		System.out.println();
		System.out.println();
		
	    if (myFirstCar.getCurrentSpeed() == mySecondCar.getCurrentSpeed())
	    	{
	    	   System.out.println("\t\t" + "There is no winner for this Race ");
	    	}
	    else if (myFirstCar.getCurrentSpeed() > mySecondCar.getCurrentSpeed())
	       {
	          theWinner = myFirstCar.getCarName();
	          System.out.println("\t\t" + "The winner of this Race is :  " + theWinner);
	       }
	    else
	       {
	          theWinner = mySecondCar.getCarName();	
	          System.out.println("\t\t" + "The winner of this Race is :  " + theWinner);
       }

       System.out.println();
       System.out.println();
 }
 
}
