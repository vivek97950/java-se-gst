package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class LogInGui implements ActionListener{
		JLabel l1, l2, l3;
		JTextField tf1;
		JPasswordField p1;
		JButton btn1,btn2;
		JFrame frame;
			
		LogInGui() {
			
			   
			
			
			
			  frame = new JFrame("Login GST BILLING SYSTEM");
			  
			  Container con=frame.getContentPane();
			  
			  con.setLayout(new GridBagLayout());
			  GridBagConstraints gbc=new GridBagConstraints();
			  gbc.insets=new Insets(20, 20, 20, 20);
			  
			  
		
		  l1 = new JLabel("Login");
		  l1.setForeground(Color.blue);
		  l1.setFont(new Font("Serif", Font.BOLD, 20));
		 
		  l2 = new JLabel("Username");
		  l3 = new JLabel("Password");
		  tf1 = new JTextField();
		  p1 = new JPasswordField();
		  btn1 = new JButton("Login");
		  btn2 = new JButton("exit");
		 
		  gbc.gridx=0;
	      gbc.gridy=0;
		  con.add(l1,gbc);
		  gbc.gridx=0;
	      gbc.gridy=1;
		  con.add(l2,gbc);
		  gbc.gridx=1;
	      gbc.gridy=1;
	      gbc.fill=GridBagConstraints.HORIZONTAL;
	      gbc.weightx=100;
		  con.add(tf1,gbc);
		  gbc.gridx=0;
	      gbc.gridy=2;
	      gbc.fill=GridBagConstraints.NONE;
		  con.add(l3,gbc);
		  gbc.gridx=1;
	      gbc.gridy=2;
	      gbc.fill=GridBagConstraints.HORIZONTAL;
	      gbc.weightx=100;
		  con.add(p1,gbc);
		  gbc.gridx=0;
	      gbc.gridy=3;
	      gbc.fill=GridBagConstraints.NONE;
		  con.add(btn1,gbc);
		  gbc.gridx=1;
	      gbc.gridy=3;
		  con.add(btn2,gbc);
		  
		  btn1.addActionListener(this);
		  
		  btn2.addActionListener(new ActionListener() {			
				public void actionPerformed(ActionEvent e) {
				System.exit(0);	
				}
			});
		  
		 
			
		frame.setSize(400,400);
        frame.setLocationRelativeTo(null);
      //frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		

		
		}
		
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {		
			 String uname = tf1.getText();
			 String pass = p1.getText();
			   if(uname.equals("name") && pass.equals("pass"))
			   {
				   this.frame.dispose();
				   AfterLogIn al=new AfterLogIn(); 
			   }
			    else
			    {
			    	JOptionPane.showMessageDialog(null,"wrong input");
			    }
			  }	
			
			
			
		
		
		public static void main(String[] args) {
			
			 new LogInGui();
			 
		}
		}
		

