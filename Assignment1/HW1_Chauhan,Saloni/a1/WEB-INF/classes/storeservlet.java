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
    try 
    {
    HttpSession session=request.getSession();
        String line = null;
        String fileName = "C:/Users/teleworld/Desktop/apache-tomcat-7.0.34/webapps/a1/WEB-INF/store.txt";
        FileReader fileReader =   new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while((line = bufferedReader.readLine()) != null) 
        {
            String [] token=line.split(";");
            if (token[1].equals(emailid) && token[2].equals(password))
            {
            	
				response.sendRedirect("storeman1");
				//HttpSession session=request.getSession(); 
				session.setAttribute("emailid",emailid);  
            }
            else
            {
            pw.println("<h1>not valid user</h1>");
            System.out.println("not valid data");
            }
        }   

        bufferedReader.close();         
    }

    catch(IOException ex) 
    {
        System.out.println("Error");                  
    }
}

}
