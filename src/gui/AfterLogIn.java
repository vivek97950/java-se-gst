package gui;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTable;

import java.sql.*;
import java.util.Vector;
public class AfterLogIn {
	JFrame frame;
	JTable table;
    JLabel l1;
    Vector vect,data,column;
    JLabel l;
	 AfterLogIn(){
		frame =new JFrame("GST BILLING SYSTEM");
		JMenuBar menuBar=new JMenuBar();
		
		JMenu product=new JMenu("PRODUCT");
		JMenu logout=new JMenu("LOGOUT");
		JMenu bill=new JMenu("BILL");
		
		
		
		JMenuItem itemadd=new JMenuItem("ADD");
		JMenuItem itemupdate=new JMenuItem("UPDATE");
		JMenuItem itemdelete=new JMenuItem("DELETE");
		JMenuItem itemlogout=new JMenuItem("LOGOUT");
		
		JMenuItem itemsell=new JMenuItem("SELL PRODUCT");
		JMenuItem itempurchase=new JMenuItem("PURCHASE PRODUCT");
		JMenuItem itemviewsell =new JMenuItem("VIEW SELL");
		JMenuItem itemviewpurchase =new JMenuItem("VIEW PURCHASE");
		
		product.add(itemadd);
		product.addSeparator();
		product.add(itemdelete);
		product.addSeparator();
		product.add(itemupdate);
	    
		bill.add(itemsell);
		bill.addSeparator();
		bill.add(itempurchase);
		bill.addSeparator();
		bill.add(itemviewsell);
		bill.addSeparator();
		bill.add(itemviewpurchase);
		
		logout.add(itemlogout);
		
		menuBar.add(product);
		menuBar.add(bill);
		menuBar.add(logout);
		
		
		
            itemlogout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
			frame.dispose();
		    new LogInGui();
				
			}
		});
		
          itemadd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			frame.dispose();
			new AddProduct();
			
				
			}
		});
          
         
        itemdelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new DeleteProduct();
				
			}
		});
        
          itemupdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new EditProduct();
				
			}
		});
          
          
          
          Container con=frame.getContentPane();
  		
  		
		  con.setLayout(new GridBagLayout());
		  GridBagConstraints gbc=new GridBagConstraints();
		  gbc.insets=new Insets(5, 5, 5, 5);
		   
		  
		  l = new JLabel("Product");
		  l.setForeground(Color.blue);
		  l.setFont(new Font("Serif", Font.BOLD, 20));
		  
		  gbc.gridx=0;
	      gbc.gridy=0;
	      gbc.fill=GridBagConstraints.NONE;
		  con.add(l,gbc);
          
          
         
          data =new Vector();
          try{
  			
  			Class.forName("com.mysql.jdbc.Driver");
  		
  			Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/gst","root","root");
  			
  			String select="select * from product";
  			
  			PreparedStatement ps=con1.prepareStatement(select);
  			
  			ResultSet rs = ps.executeQuery();
  			 
  			ResultSetMetaData metaData = rs.getMetaData();
  			
  			int col = metaData.getColumnCount();
  			  
  				 while(rs.next())
  				 {
  					vect =new Vector(); 
  					for (int i = 1; i <= col; i++) {
  				       vect.addElement(rs.getObject(i));
  				    
  				       }
  				       data.addElement(vect);
  				 }
  			
			
  				column=new Vector();
  				column.addElement("PRODUCT NO");
  				column.addElement("PRODUCT NAME");
  				column.addElement("PRICE");
  				column.addElement("CGST");
  				column.addElement("SGST");
  				column.addElement("QUANTITY");
  				 
  				
  				
             
              
              
              
              
              ps.close();
              con1.close();
  		}
  		catch(Exception e)
  		{
  			e.printStackTrace();
  		}
          
      
  		
          
          
          
          
		 
      table=new JTable(data,column);
      table.setEnabled(false);
      gbc.gridx=0;
      gbc.gridy=1;
      gbc.fill=GridBagConstraints.HORIZONTAL;
      gbc.weightx=400;
      gbc.weighty=400;
	  con.add(table,gbc);
          
        frame.setJMenuBar(menuBar);
		
		
		
		
		
		frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	 
	 
	 
	 public static void main(String[] args){
		 new AfterLogIn();
	 }

}
