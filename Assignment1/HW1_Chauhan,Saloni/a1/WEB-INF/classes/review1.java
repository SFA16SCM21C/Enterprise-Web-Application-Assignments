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


public class review1 extends HttpServlet  {

	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		HttpSession session=request.getSession(false);
      	String emailid=(String)session.getAttribute("emailid");
			
					PrintWriter pw = response.getWriter();
				//ServletContext scn = request.getServletContext();

				String prodid = request.getParameter("prodid");
			
			String prodname = request.getParameter("prodname");
			
			String name = request.getParameter("name");
			
			String comment = request.getParameter("comment");
		
			
								
 try {
           String fileName = "C:/Users/teleworld/Desktop/apache-tomcat-7.0.34/webapps/a1/WEB-INF/review.txt";
            FileWriter fileWriter =
                new FileWriter(fileName,true);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
            bufferedWriter.write("Product id: "+prodid);
          bufferedWriter.newLine();
            bufferedWriter.write("Product Name: "+prodname);
          bufferedWriter.newLine();
               bufferedWriter.write("Reviewed By: "+name);
          bufferedWriter.newLine();
             bufferedWriter.write("Comments: "+comment);
          bufferedWriter.newLine();
            bufferedWriter.close();
           pw.println("<h3>THANK YOU!</h3>");
                     response.sendRedirect("/a1/index.html");

          
        }
        catch(IOException ex) {
            System.out.println("Error writing to file");
            // Or we could just do this:
            // ex.printStackTrace();
        }
				
			
			
			
			}

	

}
