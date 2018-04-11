import java.io.*;

import java.io.File;
import java.io.FileInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.servlet.http.HttpServlet;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement;
import java.sql.PreparedStatement; 
import java.util.*;



public class checkout1 extends HttpServlet  {
int count=(int )(Math. random() * 2000 + 1);
Long date = (new Date().getTime()) + (14 * 24 * 3600 * 1000) ;
Date newDate = new Date(date);
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session=request.getSession();
			Cart shoppingCart = new Cart();
			shoppingCart = (Cart) session.getAttribute("cart");
			HashMap<String, Double> items = shoppingCart.getCartItems();
			
					PrintWriter out = response.getWriter();
				//ServletContext scn = request.getServletContext();

			String firstname = request.getParameter("firstname");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			
            double k=0.0;
			Double tryq=0.0;
           	String kool=null;
			for(String key: items.keySet())
            {
				kool = key;
				tryq = items.get(key);
			}	
			String orderid = Integer.toString(count);
			MySqlDataStoreUtilities obj = new MySqlDataStoreUtilities();
			obj.insertorders(orderid, firstname, email, phone, address, kool, tryq);     
            response.sendRedirect("thankyou?count="+count+ "&next2Week=" + newDate);
}
}
