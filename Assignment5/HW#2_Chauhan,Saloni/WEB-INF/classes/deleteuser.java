import java.io.*;

import java.io.File;
import java.io.FileInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.servlet.http.HttpServlet;


public class deleteuser extends HttpServlet  {

	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String password = request.getParameter("pwd");
		String emailid = request.getParameter("emailid");
		PrintWriter pw = response.getWriter();
		String order_id= request.getParameter("orderid");
  			
		//int result = Integer.parseInt(order_id);
		HttpSession session=request.getSession();
  		MySqlDataStoreUtilities obj = new MySqlDataStoreUtilities();
		obj.deleteorder(order_id);
		response.sendRedirect("salesman1");
	}
}
