import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class JTextAreaOutputStream extends OutputStream
{
    private final JTextArea destination;
    private JPanel contentPane;
	public JTextArea textArea;
	static int gas = 0;
	static int moreGas = 0;
	
	//Method that generates a random amount of gas to be used for acceleration (between minx10 and maxx10)
	static int createInjection(int min, int max){
		int myInjection = (int)(Math.random() * 10 * (Math.random() > 0.5 ? max : min));	
		return myInjection;
		}

	/**
	 * Launch the application.
	 */

    public JTextAreaOutputStream (JTextArea destination)
    {
        if (destination == null)
            throw new IllegalArgumentException ("Destination is null");

        this.destination = destination;
    }

    @Override
    public void write(byte[] buffer, int offset, int length) throws IOException
    {
        final String text = new String (buffer, offset, length);
        SwingUtilities.invokeLater(new Runnable ()
            {
                @Override
                public void run() 
                {
                    destination.append (text);
                }
            });
    }

    @Override
    public void write(int b) throws IOException
    {
        write (new byte [] {(byte)b}, 0, 1);
    }

    public static void main (String[] args) throws Exception
    {
    	UseMyCar car = new UseMyCar();
        JTextArea textArea = new JTextArea (50, 0);
        textArea.setEditable (false);
        
        

        JFrame frame = new JFrame ("CAR RACING GAME");
        frame.setBounds(100, 100, 1024, 800);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
                 
		JButton btnNewButton = new JButton();
		btnNewButton.setBounds(666, 117, 100, 100);

		btnNewButton.setText("Music");
		frame.add(btnNewButton,BorderLayout.LINE_START);
		btnNewButton.addActionListener(new ActionListener()
		{
			int clicked = 0;

		  public void actionPerformed(ActionEvent e)
		  {
			  clicked++;

			  InputStream in;
		         try{
		             in =new FileInputStream(new File ("src/resources/sound.wav"));
		             
		             AudioStream audios=new AudioStream(in);
		             if(clicked==1) {
		             AudioPlayer.player.start(audios);}
		        
		         }
		         catch(Exception e1){
		             JOptionPane.showMessageDialog(null, e1);
		             
		         }// TODO add your handling code here:
		    //GEN-LAST:event_jButton1ActionPerformed
		  
			
		  }
		  
		});
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(778, 117, 100, 100);
		frame.add(textArea_1,BorderLayout.LINE_START);
		
		JButton btnNewButton1 = new JButton();
		btnNewButton1.setBounds(890, 117, 100, 100);

		btnNewButton1.setText("Credit");
		frame.add(btnNewButton1,BorderLayout.LINE_START);
		
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(890, 618, 100, 100);
		frame.add(textArea_2,BorderLayout.LINE_START);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(778, 618, 100, 100);
		frame.add(textArea_3,BorderLayout.LINE_START);
		
        JPanel south = new JPanel();
        south.setBorder(new EmptyBorder(5, 5, 5, 5));
        south.add (
                new JScrollPane (
                		
                        textArea, 
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),
                    BorderLayout.CENTER);
        frame.add(south, BorderLayout.LINE_START);
        


        frame.setVisible (true);
        JTextAreaOutputStream out1 = new JTextAreaOutputStream (textArea_1);
        System.setOut (new PrintStream (out1));
		System.out.println(MySQLAccess.userscores());

	

        
        JTextAreaOutputStream out = new JTextAreaOutputStream (textArea);
        System.setOut (new PrintStream (out));

     //  UseMyCar.main(null);

		
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