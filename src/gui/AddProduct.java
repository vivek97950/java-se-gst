package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class AddProduct {
	
	JLabel l,lpno,lpname,lprice,lcgst,lsgst,lquantity;
	JTextField tpno,tpname,tprice,tcgst,tsgst,tquantity;
	JButton add,reset,home;
	
	
	JFrame frame;
	
	
	
	AddProduct() {
		frame=new JFrame("GST BILLING SYSTEM");
		
		 Container con=frame.getContentPane();
		  
		  con.setLayout(new GridBagLayout());
		  GridBagConstraints gbc=new GridBagConstraints();
		  gbc.insets=new Insets(10, 10, 10, 10);
		  
		  l = new JLabel("Add Product");
		  l.setForeground(Color.blue);
		  l.setFont(new Font("Serif", Font.BOLD, 20));
		  
		  
		  lpno=new JLabel("Product No.");
		  lpname=new JLabel("Product Name");
		  lprice=new JLabel("Price");
		  lcgst=new JLabel("CGST (%)");
		  lsgst=new JLabel("SGST (%)");
		  lquantity=new JLabel("QTY");
		  
		  
		  tpno=new JTextField();
		  tpname=new JTextField();
		  tprice=new JTextField();
		  tcgst=new JTextField();
		  tsgst=new JTextField();
		  tquantity=new JTextField();
		  
		  add=new JButton("ADD");
		  reset=new JButton("RESET");
		  home=new JButton("HOME");
		  
		  
		  
		  
		  
		  gbc.gridx=0;
	      gbc.gridy=0;
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
		  con.add(lpname,gbc);
		  
		  gbc.gridx=1;
	      gbc.gridy=2;
	      gbc.fill=GridBagConstraints.HORIZONTAL;
	      gbc.weightx=100;
		  con.add(tpname,gbc);
		  
		  gbc.gridx=0;
	      gbc.gridy=3;   
		  con.add(lprice,gbc);
		  
		  gbc.gridx=1;
	      gbc.gridy=3;
	      gbc.fill=GridBagConstraints.HORIZONTAL;
	      gbc.weightx=50;
		  con.add(tprice,gbc);
		  
		  gbc.gridx=0;
	      gbc.gridy=4;
		  con.add(lcgst,gbc);
		  
		  gbc.gridx=1;
	      gbc.gridy=4;
	      gbc.fill=GridBagConstraints.HORIZONTAL;
	      gbc.weightx=50;
		  con.add(tcgst,gbc);
		  
		  gbc.gridx=0;
	      gbc.gridy=5;
		  con.add(lsgst,gbc);
		  
		  gbc.gridx=1;
	      gbc.gridy=5;
	      gbc.fill=GridBagConstraints.HORIZONTAL;
	      gbc.weightx=50;
		  con.add(tsgst,gbc);
		  
		  gbc.gridx=0;
	      gbc.gridy=6;
		  con.add(lquantity,gbc);
		  
		  gbc.gridx=1;
	      gbc.gridy=6;
	      gbc.fill=GridBagConstraints.HORIZONTAL;
	      gbc.weightx=100;
		  con.add(tquantity,gbc);
		  
		  
		  gbc.gridx=0;
	      gbc.gridy=7;
		  con.add(add,gbc);
		  
		  gbc.gridx=1;
	      gbc.gridy=7;
		  con.add(reset,gbc);
		  
		  gbc.gridx=2;
	      gbc.gridy=7;
		  con.add(home,gbc);
		  
		  
		  reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				tpno.setText(null);
				tpname.setText(null);
				tprice.setText(null);
				tcgst.setText(null);
				tsgst.setText(null);
				tquantity.setText(null);
			}
		});
		  
		  home.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new AfterLogIn();
				
			}
		});
		  
		  add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ee) {
				
					try{
						
						Class.forName("com.mysql.jdbc.Driver");
						
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gst","root","root");
						
						String insert="insert into product value(?,?,?,?,?,?)";
						
						PreparedStatement ps=con.prepareStatement(insert);
						
						ps.setString(1,tpno.getText());
						ps.setString(2,tpname.getText());
						ps.setFloat(3,Float.parseFloat(tprice.getText()));
						ps.setFloat(4,Float.parseFloat(tcgst.getText()));
						ps.setFloat(5,Float.parseFloat(tsgst.getText()));
						ps.setInt(6,Integer.parseInt(tquantity.getText()));
						
						
						ps.executeUpdate();
			         
			         
			            con.close();
			            JOptionPane.showMessageDialog(null,"successfull");
			            reset.doClick();
			            
			            
					}
					catch(Exception e)
					{
						e.printStackTrace();
						JOptionPane.showMessageDialog(null,"fill all field with unique product no");
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
		new AddProduct();
	}

}
