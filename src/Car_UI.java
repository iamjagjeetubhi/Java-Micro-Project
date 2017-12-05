import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import sun.audio.*;


public class Car_UI extends JFrame {

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
	public static void main(String[] args) {
		
		

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Car_UI frame = new Car_UI();
						    
					
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
	
	
	public Car_UI() {
		
		setTitle("CAR RACING GAME");

		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setBounds(815, 48, 70, 15);
		contentPane.add(lblNewLabel);
		
		textArea = new JTextArea();
		textArea.setBounds(61, 48, 593, 670);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton();
		btnNewButton.setBounds(666, 117, 100, 100);
		 try {
			    Image img = ImageIO.read(getClass().getResource("resources/music-player.png"));
			    btnNewButton.setIcon(new ImageIcon(img));
			  } catch (Exception ex) {
			    System.out.println(ex);
			  }
		 
		contentPane.add(btnNewButton);
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
		contentPane.add(textArea_1);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(890, 117, 100, 100);
		 try {
			    Image img1 = ImageIO.read(getClass().getResource("resources/coin.png"));
			    btnNewButton_1.setIcon(new ImageIcon(img1));
			  } catch (Exception ex) {
			    System.out.println(ex);
			  }
		contentPane.add(btnNewButton_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(890, 618, 100, 100);
		contentPane.add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(778, 618, 100, 100);
		contentPane.add(textArea_3);
		
	}
}
