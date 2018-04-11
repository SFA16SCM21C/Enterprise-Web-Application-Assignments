import java.io.*;

import java.io.File;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.util.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.HashMap;
import javax.servlet.http.HttpSession;

public class addorder extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	 {
		int random =(int )(Math. random() * 2000 + 1);
		String orderid = Integer.toString(random);
		PrintWriter pw = response.getWriter();
		String itemname=request.getParameter("itemname");
		String fname = request.getParameter("firstname");
		String emailid = request.getParameter("email");
		String phoneno = request.getParameter("phone");
		String add = request.getParameter("address");
		String price=request.getParameter("price");
		double cost = Double.parseDouble(price);
		HttpSession session=request.getSession();
  		MySqlDataStoreUtilities obj = new MySqlDataStoreUtilities();
		obj.insert(orderid,fname,emailid,phoneno,add,itemname,cost);
		response.sendRedirect("salesman1");
				
}
}
