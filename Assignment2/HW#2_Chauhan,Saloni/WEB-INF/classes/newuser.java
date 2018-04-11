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


public class newuser extends HttpServlet  {

	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		HttpSession session=request.getSession();
      	String emailid=(String)session.getAttribute("emailid");
			
					PrintWriter pw = response.getWriter();
				//ServletContext scn = request.getServletContext();

				String password = request.getParameter("pwd");
			
				String emailid1 = request.getParameter("emailid");
			
				String firstname = request.getParameter("firstname");
					
MySqlDataStoreUtilities obj = new MySqlDataStoreUtilities();
obj.insertuser(firstname, emailid1, password);	
			                     response.sendRedirect("/a1/index.html");
		}
}
