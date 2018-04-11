import java.io.*;
import java.util.*;
import java.sql.*;

import java.sql.Connection; 
import java.sql.DriverManager;
 import java.sql.ResultSet; 
 import java.sql.SQLException; 
 import java.sql.Statement;
 import java.sql.PreparedStatement;
 import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



public class MySqlDataStoreUtilities
 {
 public String f_name=null;
 public String itemname=null;
 public double price=0.0;
 public double total=0.0;
 public int id=0;
 public int size=0;
 public String exception=null;
 public String state=null;
 public int vendor=0;
 public int[] result;
 public String error=null;
 public String firstname=null;
 public String email=null;
 public String address=null;
 public String phone=null;
 String driver= "com.mysql.jdbc.Driver";
 String url="jdbc:mysql://localhost:3306/bestbuydatabase";
 String USER = "root";
 String PASS = "root";
 
Connection conn = null;
public void getConnection()
{
try
{ 
 Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection(url, USER, PASS);
 }
catch(Exception e)
      {
      }
}

public void insertuser(String fname, String emailid, String pwd)
{						
 try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		Statement stmt = conn.createStatement();
		String sql;
		String query = " insert into login (firstname, emailid, pwd)" + " values (?, ?, ?)";
		PreparedStatement pst = conn.prepareStatement(query);
		pst.setString(1,fname); 
		pst.setString(2,emailid); 
		pst.setString(3,pwd);
		pst.execute();
      
      conn.close();          
        }
    catch(SQLException se) {
     
      } catch(Exception e) {
      ;
      } 	
			}
			
public void login(String email, String pwd)
{
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement();
        String sql = "select emailid, pwd from login where emailid=? and pwd=?";
	PreparedStatement pst = conn.prepareStatement(sql);
	pst.setString(1,email);
	pst.setString(2,pwd);
	ResultSet rs = pst.executeQuery();
	while(rs.next())
 	{
 		f_name=rs.getString("emailid");
	}		
			}
			catch(SQLException se) {
       
      } catch(Exception e) {
     
      } 	
			
			}
			
public void salesmanlogin(String email, String pwd)
{
			try
			{
			Class.forName("com.mysql.jdbc.Driver");

   
         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);


        Statement stmt = conn.createStatement();
        String sql = "select emailid, pwd from salesmanlogin where emailid=? and pwd=?";
	PreparedStatement pst = conn.prepareStatement(sql);
	pst.setString(1,email);
	pst.setString(2,pwd);
	ResultSet rs = pst.executeQuery();
	while(rs.next())
 	{
 		f_name=rs.getString("emailid");
	}		
			}
			catch(SQLException se) {
       
      } catch(Exception e) {
     
      } 	
			
			}
			
public void storemanlogin(String email, String pwd)
{
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement();
        String sql = "select emailid, pwd from storemanlogin where emailid=? and pwd=?";
	PreparedStatement pst = conn.prepareStatement(sql);
	pst.setString(1,email);
	pst.setString(2,pwd);
	ResultSet rs = pst.executeQuery();
	while(rs.next())
 	{
 		f_name=rs.getString("emailid");
	}		
			}
			catch(SQLException se) {
       
      } catch(Exception e) {
     
      } 	
			
			}
			
public void insertorders(String id, String fname, String emaild, String phoneno, String add, String itemname, Double price)
{
			try
			{
			Class.forName("com.mysql.jdbc.Driver");

         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

       String query = " insert into orders (orderid, firstname, email, phone, address,itemname, price)" + " values (?, ?, ?, ?, ?, ?, ?)";
     PreparedStatement pst = conn.prepareStatement(query);
	 pst.setString(1,id);
      pst.setString(2,fname); 
     pst.setString(3,emaild); 
     pst.setString(4,phoneno);
       pst.setString(5,add);
       pst.setString(6,itemname);
       pst.setDouble(7,price);
            pst.execute(); 
           }
			catch(SQLException se) {
       
      } catch(Exception e) {
    
      } 	
			
}

public void vieworder(String email)
{
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement();
        String sql = "select orderid, itemname, price, sum(price) as total from orders where email=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1,email);
		ResultSet rs = pst.executeQuery();
		while(rs.next())
		{
			//orderid =rs.getString("orderid");
			itemname=rs.getString("itemname");
			price=rs.getDouble("price");
			total=rs.getDouble("total");
		}		
			}
			catch(SQLException se) {
   
      } catch(Exception e) {
 
      } 	
			
} 			
		
public void insertdataintosql() throws IOException
			{
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
   			SAXParser saxParser = null;
			try 
			{
				saxParser = saxParserFactory.newSAXParser();
			} 	
			catch (ParserConfigurationException e) 
			{
				e.printStackTrace();
			}
				
			catch (SAXException e) 
			{
				e.printStackTrace();
			}
        		
        	MyHandler handler = new MyHandler();
        	try 
        	{
				saxParser.parse(new File("C:/Users/teleworld/Desktop/apache-tomcat-7.0.34/webapps/a1/WEB-INF/ProductCatalog.xml"), handler);
			} 	
			catch (SAXException e) 
			{
				e.printStackTrace();
			}

       		HashMap<String,Product> productList = handler.getEmpList();
			 
			try
			{
			//conn.setAutoCommit(false);
				Class.forName("com.mysql.jdbc.Driver");

         		Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         	 	Statement stmt = conn.createStatement();
         	 	size=productList.size();
         	 	String query = " replace into products (prodtype, itemId, imgname, itemName, prodCondition, retailerName, price)" + " values (?, ?, ?, ?, ?, ?, ?)"; 
     	  		PreparedStatement pst = conn.prepareStatement(query);
         	 	final int batchSize = 60;
				int count = 0;
				for (String key : productList.keySet() ) 
		 		{
		  
		 			 Product con= productList.get(key);
		  			 pst.setString(1,con.getProducttype()); 
     	  			 pst.setString(2,con.getId()); 
     	  			 pst.setString(3,con.getImage());
         			 pst.setString(4,con.getName());
         			 pst.setString(5,con.getCondition());
         			 pst.setString(6,con.getRetailer());
        			 pst.setDouble(7,con.getPrice());
          			 pst.addBatch();
          
           			if (++count == batchSize)
            		{
      					pst.executeBatch();
      					pst.executeBatch();
   					}	
          
				}
			    pst.executeBatch();
			        pst.executeBatch();
		 	}
			catch(SQLException ex) 
				{
				
				exception=ex.getMessage();
				state=ex.getSQLState();
				vendor=ex.getErrorCode();
				}
			catch(Exception e) 
				{
				
				e.printStackTrace();
				
				
      			} 
			//return productList;
			}
			
			
public HashMap<String, Product> displayfromsql() throws IOException
{
			Product p;
			HashMap<String,Product> map=new HashMap<String, Product>();
     		try
			{
			Class.forName("com.mysql.jdbc.Driver");

         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	
       	String sql = "select * from products";
     	PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
	
	while(rs.next())
 	{
 		String prodtype=rs.getString("prodtype");
 		String itemId=rs.getString("itemId");
 		String imgname=rs.getString("imgname");
 		String itemName=rs.getString("itemName");
 		String prodCondition=rs.getString("prodCondition");
 		String retailerName = rs.getString("retailerName");
 		double price=rs.getDouble("price");
 		
 		p = new Product(prodtype, itemId, imgname, itemName, prodCondition, retailerName, price);
 		
 		map.put(itemId, p);		
	}
	
	
	
     }
			 catch(SQLException ex) 
				{
				
				exception=ex.getMessage();
				state=ex.getSQLState();
				vendor=ex.getErrorCode();
				}
			catch(Exception e) 
				{
				
				e.printStackTrace();
				
				
      			} 
      			return map;
      			}
				
public void insert(String id, String f_name, String email_id, String phone, String add, String item_name, double price)
{
			try
			{
			Class.forName("com.mysql.jdbc.Driver");


         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

  
        Statement stmt = conn.createStatement();
        String query = " replace into orders (orderid, firstname, email, phone, address, itemname, price)" + " values (?, ?, ?, ?, ?, ?, ?)";
	PreparedStatement pst = conn.prepareStatement(query);
	pst.setString(1,id);
	pst.setString(2,f_name);
	pst.setString(3,email_id);
	
	pst.setString(4,phone);
	pst.setString(5,add);
	pst.setString(6,item_name);
	pst.setDouble(7,price);
	pst.execute();
			}
			catch(SQLException se) {
   
      } catch(Exception e) {
 
      }
			}
 }