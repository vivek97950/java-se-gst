package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DeleteProduct {
	
	JLabel l,lpno;
	JTextField tpno;
	JButton delete,home;
	
	
JFrame frame;
	
	
	
	DeleteProduct() {
		frame=new JFrame("GST BILLING SYSTEM");
		Container con=frame.getContentPane();
		
		
		  con.setLayout(new GridBagLayout());
		  GridBagConstraints gbc=new GridBagConstraints();
		  gbc.insets=new Insets(5, 5, 5, 5);
		   
		  
		  l = new JLabel("Delete Product");
		  l.setForeground(Color.blue);
		  l.setFont(new Font("Serif", Font.BOLD, 20));
		  
		  
		  lpno=new JLabel("Product No.");
		  tpno=new JTextField();
		  home=new JButton("HOME");
		  delete=new JButton("DELETE");
		  
		  gbc.gridx=0;
	      gbc.gridy=0;
	      gbc.fill=GridBagConstraints.NONE;
		  con.add(l,gbc);
		  
		  gbc.gridx=0;
	      gbc.gridy=1;
	      gbc.fill=GridBagConstraints.HORIZONTAL;
		  con.add(lpno,gbc);
		  
		  
		  gbc.gridx=1;
	      gbc.gridy=1;
	      gbc.fill=GridBagConstraints.HORIZONTAL;
	      gbc.weightx=50;
		  con.add(tpno,gbc);
		  
		  gbc.gridx=0;
	      gbc.gridy=2;
		  con.add(delete,gbc);
		  
		  gbc.gridx=1;
	      gbc.gridy=2;
		  con.add(home,gbc);
		  
		  
		  
		  home.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new AfterLogIn();
				
			}
		});
		  
		  delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gst","root","root");
					
					String delete="delete from product where pno=?";
					//get get a vehicle
					PreparedStatement ps=con.prepareStatement(delete);
					ps.setString(1,tpno.getText());
					
		            int i=ps.executeUpdate();
		            if(i!=0)
		            {
		            	JOptionPane.showMessageDialog(null,"successfull");
		            }
		            else
		            	JOptionPane.showMessageDialog(null,"unsuccessfull");
		            ps.close();
		            con.close();
		           
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"unsuccessfull");
					ex.printStackTrace();
				}
	
			}
		});
		  
		  
		  frame.setSize(400,400);
	        frame.setLocationRelativeTo(null);
	      //frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			
			
			

}
	public static void main(String[] args) {
		new DeleteProduct();
	}
}
