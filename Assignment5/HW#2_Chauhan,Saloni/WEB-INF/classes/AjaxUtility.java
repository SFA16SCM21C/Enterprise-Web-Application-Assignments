//package utils;
import java.io.*;
import java.util.*;
import java.sql.*;

import java.sql.Connection; 
import java.sql.DriverManager;
 import java.sql.ResultSet; 
 import java.sql.SQLException; 
 import java.sql.Statement;
 import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//import pojos.Product;

public class AjaxUtility {
	public static HashMap<String,Product> getData()
	{ 
	HashMap<String,Product> hm=new HashMap<String,Product>();
	try
	{ 
      String driver= "com.mysql.jdbc.Driver";
       String url="jdbc:mysql://localhost:3306/a1";
        String USER = "root";
      String PASS = "root";
 Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection(url, USER, PASS);

Statement stmt = conn.createStatement();
	String selectCustomerQuery="select * from products";
	ResultSet rs = stmt.executeQuery(selectCustomerQuery);
	while(rs.next())
	{
		
	Product p = new Product(null, rs.getString("itemId"),null, rs.getString("itemName"),null, null, 0.0, 0, null, null);
	//System.out.println(" in ajax utiltiy");
	//System.out.println("product id is"+ rs.getString("productid")+ "    product retailer is" + rs.getString("productretailer") );
	
	hm.put(rs.getString("itemId"), p);
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return hm;
	}

	
	public StringBuffer readdata(String searchId)
	{
		StringBuffer sb=new StringBuffer();
	HashMap<String,Product> data;
	data=getData();
	Iterator it = data.entrySet().iterator();
	while (it.hasNext())
	{
	Map.Entry pi = (Map.Entry)it.next();
	Product p=(Product)pi.getValue();
	if (p.getName().toLowerCase().startsWith(searchId))
	{
	sb.append("<product>");
	sb.append("<id>" + p.getId() + "</id>");
	sb.append("<productName>" + p.getName() + "</productName>");
	sb.append("</product>");
	}
	}
	return sb;
	}
	
	
}
