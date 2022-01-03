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

public class EditProduct {
	
	JLabel l,lpno,lpname,lprice,lcgst,lsgst,lquantity;
	JTextField tpno,tpname,tprice,tcgst,tsgst,tquantity;
	JButton update,home,pno;
	
	boolean permission=false;
	
	
	JFrame frame;
	
	
	
	EditProduct() {
		frame=new JFrame("GST BILLING SYSTEM");
		Container con=frame.getContentPane();
		
		
		  con.setLayout(new GridBagLayout());
		  GridBagConstraints gbc=new GridBagConstraints();
		  gbc.insets=new Insets(5, 5, 5, 5);
		   
		  
		  l = new JLabel("Update Product");
		  l.setForeground(Color.blue);
		  l.setFont(new Font("Serif", Font.BOLD, 20));
		  
		  
		  lpno=new JLabel("Product No.");
		  tpno=new JTextField();
		  tpno=new JTextField();
		  pno=new JButton("FIND");
		  home=new JButton("HOME");
		  
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
		  
		  gbc.gridx=2;
	      gbc.gridy=1;
		  con.add(pno,gbc);
		  
		  
		  
		
		 
		  
		  lpname=new JLabel("Product Name");
		  lprice=new JLabel("Price");
		  lcgst=new JLabel("CGST (%)");
		  lsgst=new JLabel("SGST (%)");
		  lquantity=new JLabel("QTY");
		  
		  tpname=new JTextField();
		  tprice=new JTextField();
		  tcgst=new JTextField();
		  tsgst=new JTextField();
		  tquantity=new JTextField();
		  
		  update=new JButton("UPDATE");
		  
		 
		  
		  
		  
		  
		  
		  
		  gbc.gridx=0;
	      gbc.gridy=2;
	      gbc.fill=GridBagConstraints.HORIZONTAL;
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
		  con.add(update,gbc);
		  
		  gbc.gridx=1;
	      gbc.gridy=7;
		  con.add(home,gbc);
		  
          
		  pno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					String str=tpno.getText();

					Class.forName("com.mysql.jdbc.Driver");

					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gst", "root", "root");
					
					String select = "select * from product where pno=?";
				
					PreparedStatement ps = con.prepareStatement(select);
					 ps.setString(1,str);
					
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						
						permission=true;
						
						tpno.setText(rs.getString(1));
						tpname.setText(rs.getString(2));
						tprice.setText(String.valueOf(rs.getFloat(3)));
						tcgst.setText(String.valueOf(rs.getFloat(4)));
						tsgst.setText(String.valueOf(rs.getFloat(5)));
						tquantity.setText(String.valueOf(rs.getInt(6)));
						
						
					}
					else
					{
						JOptionPane.showMessageDialog(null," product not found");
					}

			
					ps.close();
					con.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				
				
			}
		});
		 
		  
	        update.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					
					
                     try{       
						
						Class.forName("com.mysql.jdbc.Driver");
						
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gst","root","root");
						
						String insert="update product set pno=?,pname=?,price=?,cgst=?,sgst=?,qty=? where pno=?";
						
						PreparedStatement ps=con.prepareStatement(insert);
						
						ps.setString(1,tpno.getText());
						ps.setString(2,tpname.getText());
						ps.setFloat(3,Float.parseFloat(tprice.getText()));
						ps.setFloat(4,Float.parseFloat(tcgst.getText()));
						ps.setFloat(5,Float.parseFloat(tsgst.getText()));
						ps.setInt(6,Integer.parseInt(tquantity.getText()));
						ps.setString(7,tpno.getText());
						
						if(permission!=false)
						{
						int i=ps.executeUpdate();
						if(i!=0)
						{
							tpno.setText(null);
							tpname.setText(null);
							tprice.setText(null);
							tcgst.setText(null);
							tsgst.setText(null);
							tquantity.setText(null);
						}
						con.close();
				        JOptionPane.showMessageDialog(null,"successfull");
				        
						}
						else
							JOptionPane.showMessageDialog(null,"first find the product");         
			            
			            
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null,"fill all field correctly");
					}

					
					
				}
			});
	        
	        
	        home.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					new AfterLogIn();
					
				}
			});
			  
		  
		    frame.setSize(400,400);
	        frame.setLocationRelativeTo(null);
	      //frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new EditProduct();
	}

}
