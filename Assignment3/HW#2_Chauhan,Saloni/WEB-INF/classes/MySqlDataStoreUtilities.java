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
 String DB_URL="jdbc:mysql://localhost:3306/bestbuydatabase";
 String USER = "root";
 String PASS = "root";
 
Connection conn = null;

//assign2
public void getConnection()
{
try
{ 
 Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
 }
catch(Exception e)
      {
      }
}

//assign2
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
	
//assign2	
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

//assign2			
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
	
//assign2	
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
	
//assign3 to get the date for the chart generation and tranaction purpose
private static java.sql.Date getCurrentDate() {
    java.util.Date today = new java.util.Date();
    return new java.sql.Date(today.getTime());
}

//assign2	
public void insertorders(String id, String fname, String emaild, String phoneno, String add, String itemname, Double price)
{
			try
			{
			Class.forName("com.mysql.jdbc.Driver");

         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

       String query = " insert into orders (orderid, firstname, email, phone, address, itemname, price, purchase_date)" + " values (?, ?, ?, ?, ?, ?, ?, ?)";
     PreparedStatement pst = conn.prepareStatement(query);
	 pst.setString(1,id);
      pst.setString(2,fname); 
     pst.setString(3,emaild); 
     pst.setString(4,phoneno);
       pst.setString(5,add);
       pst.setString(6,itemname);
       pst.setDouble(7,price);
	   pst.setDate(8,getCurrentDate());
            pst.execute(); 
			int cnt =1;
			//to put the data into product count table as well to get the count
			String query1 = " insert into productcount (prodname, price, cnt, purchase_date)" + " values (?, ?, ?, ?)";
            PreparedStatement pst1 = conn.prepareStatement(query1);
            pst1.setString(1,itemname);
            pst1.setDouble(2,price);
            pst1.setInt(3,cnt);
            pst1.setDate(4,getCurrentDate());
            pst1.execute();
           }
			catch(SQLException se) {
       
      } catch(Exception e) {
    
      } 	
			
}

//assign2
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
		
//assign2
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
         	 	String query = " replace into products (prodtype, itemId, imgname, itemName, prodCondition, retailerName, price, quantity, sale, rebate)" + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
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
					 pst.setInt(8,con.getQuant());
        			 pst.setString(9,con.getSale());
        			 pst.setString(10,con.getRebate());
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
			
//assign3	
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
		int quantity=rs.getInt("quantity");
 		String sale=rs.getString("sale");
 		String rebate=rs.getString("rebate");
 		
 		p = new Product(prodtype, itemId, imgname, itemName, prodCondition, retailerName, price, quantity, sale, rebate);
 		
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

//assign3				
public HashMap<String, Product> displaysale() throws IOException
			{
			Product p;
			HashMap<String,Product> sale=new HashMap<String, Product>();
			String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
       		String DB_URL="jdbc:mysql://localhost:3306/bestbuydatabase";
      		String USER = "root";
     		String PASS = "root";
     		try
			{
			Class.forName("com.mysql.jdbc.Driver");

         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	
       	String sql = " select * from products where sale='YES'";
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
 		int quantity=rs.getInt("quantity");
 		String sales=rs.getString("sale");
 		String rebate=rs.getString("rebate");
 		p = new Product(prodtype, itemId, imgname, itemName, prodCondition, retailerName, price,quantity,sales,rebate);
 		
 		sale.put(itemId, p);
 		
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
      			return sale;
      			}

//assign3				
public HashMap<String, Product> rebates() throws IOException
			{
			Product p;
			HashMap<String,Product> rebates=new HashMap<String, Product>();
			String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
       		String DB_URL="jdbc:mysql://localhost:3306/bestbuydatabase";
      		String USER = "root";
     		String PASS = "root";
     		try
			{
			Class.forName("com.mysql.jdbc.Driver");

         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	
       	String sql = " select * from products where rebate='YES'";
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
 		int quantity=rs.getInt("quantity");
 		String sales=rs.getString("sale");
 		String rebate=rs.getString("rebate");
 		p = new Product(prodtype, itemId, imgname, itemName, prodCondition, retailerName, price,quantity,sales,rebate);
 		
 		rebates.put(itemId, p);		
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
      			return rebates;
      			}

//assign3
public HashMap<String, Integer> chart1() throws IOException
			{
			HashMap<String,Integer> charts=new HashMap<String, Integer>();
			charts.clear();
			String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
       		String DB_URL="jdbc:mysql://localhost:3306/bestbuydatabase";
      		String USER = "root";
     		String PASS = "root";
     		try
			{
			Class.forName("com.mysql.jdbc.Driver");

         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	
       	String sql = "select itemName,quantity from products";
     	PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		charts.clear();
	
	while(rs.next())
 	{
 		String prodname=rs.getString("itemName");
 		int quantity=rs.getInt("quantity");
 		
 		charts.put(prodname, quantity);
 		
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
      			return charts;     			
      			}
				
//updateorder function
public void insert(String id, String f_name, String email_id, String phone, String add, String item_name, double price)
{
			try
			{
			Class.forName("com.mysql.jdbc.Driver");


         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

  
        Statement stmt = conn.createStatement();
        String query = " replace into orders (orderid, firstname, email, phone, address, itemname, price, purchase_date)" + " values (?, ?, ?, ?, ?, ?, ?, ?)";
	PreparedStatement pst = conn.prepareStatement(query);
	pst.setString(1,id);
	pst.setString(2,f_name);
	pst.setString(3,email_id);
	pst.setString(4,phone);
	pst.setString(5,add);
	pst.setString(6,item_name);
	pst.setDouble(7,price);
	pst.setDate(8,getCurrentDate());
	pst.execute();
			}
			catch(SQLException se) {
   
      } catch(Exception e) {
 
      }
 }
 
 //updateorder function servlet
 public void updateorder(int id)
			{
			
			
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
       String DB_URL="jdbc:mysql://localhost:3306/bestbuydatabase";


      String USER = "root";
      String PASS = "root";
			try
			{
			Class.forName("com.mysql.jdbc.Driver");


         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

  
        Statement stmt = conn.createStatement();
        String sql = "select orderid, firstname,email, phone, address, itemname,price from orders where orderid=?";
	PreparedStatement pst = conn.prepareStatement(sql);
	pst.setInt(1,id);
	ResultSet rs = pst.executeQuery();
	while(rs.next())
 	{
 		id=rs.getInt("orderid");
 		firstname=rs.getString("firstname");
 		email=rs.getString("email");
 		phone=rs.getString("phone");
 		address=rs.getString("address");
 		itemname=rs.getString("itemname");
 		price=rs.getDouble("price");

 		
	}		
			}
			catch(SQLException se) {
   
      } catch(Exception e) {
 
      } 	
			
			} 
			
//function for report of the sales
public HashMap<String, prod> report1() throws IOException
{
			prod p;
			HashMap<String,prod> map=new HashMap<String, prod>();
			String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
       		String DB_URL="jdbc:mysql://localhost:3306/bestbuydatabase";
      		String USER = "root";
     		String PASS = "root";
     		try
			{
			Class.forName("com.mysql.jdbc.Driver");

         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	
       	String sql = "select prodname, price, sum(cnt) as totalsold,sum(price*cnt) as total_sales from productcount group by prodname;";
     	PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
	
	while(rs.next())
 	{
 	
 		String prodname=rs.getString(1);
 		double price=rs.getDouble(2);
 		int sold=rs.getInt(3);
 		double sale=rs.getDouble(4);
 		p = new prod(prodname, price, sold, sale);
 		
 		map.put(prodname, p);
 		
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
				
//function for report 2 to be generated with sales
public HashMap<String, Double> report2() throws IOException
{
			HashMap<String,Double> local=new HashMap<String, Double>();
			String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
       		String DB_URL="jdbc:mysql://localhost:3306/bestbuydatabase";
      		String USER = "root";
     		String PASS = "root";
     		try
			{
			Class.forName("com.mysql.jdbc.Driver");

         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	
       	String sql = " select purchase_date, sum(price*cnt) as total from productcount group by purchase_date;";
     	PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
	
	while(rs.next())
 	{
 		String d=rs.getString(1);
 		double quantity=rs.getDouble(2);		
 		local.put(d, quantity);
 		
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
      			return local;      			
      			}
				
//second chart for sales department generated
			public HashMap<String, Double> chart2() throws IOException
			{
			HashMap<String,Double> chart2=new HashMap<String, Double>();
			String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
       		String DB_URL="jdbc:mysql://localhost:3306/bestbuydatabase";
      		String USER = "root";
     		String PASS = "root";
     		try
			{
			Class.forName("com.mysql.jdbc.Driver");
         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
       	String sql = "select prodname, price, sum(cnt) as totalsold,sum(price*cnt) as total_sales from productcount group by prodname;";
     	PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
	
	while(rs.next())
 	{
 		String prodname=rs.getString(1);
 		double sale=rs.getDouble(4);
 		chart2.put(prodname, sale);	
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
      			return chart2;
      			
      			}
 }