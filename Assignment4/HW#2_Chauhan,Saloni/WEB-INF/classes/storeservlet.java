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

public class storeservlet extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	 {
		String password = request.getParameter("pwd");
		String emailid = request.getParameter("emailid");
		PrintWriter pw = response.getWriter();
		HttpSession session=request.getSession();
  		MySqlDataStoreUtilities obj = new MySqlDataStoreUtilities();
		obj.storemanlogin(emailid, password);	
			
			String f_name=obj.f_name;
			
			
			if(f_name!=null)	
				{
  
				response.sendRedirect("storeman1");
				session.setAttribute("emailid",emailid);  
            }
            else
            {
            pw.println("<h1>not valid user</h1>");
            System.out.println("not valid data");
            }
}

}
