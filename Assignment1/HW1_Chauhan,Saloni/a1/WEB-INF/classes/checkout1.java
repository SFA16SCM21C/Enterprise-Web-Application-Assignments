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
			
	try {
           String fileName = "C:/Users/teleworld/Desktop/apache-tomcat-7.0.34/webapps/a1/WEB-INF/orders.txt";
            FileWriter fileWriter =
                new FileWriter(fileName,true);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);
            // Note that write() does not automatically
            // append a newline character.
            bufferedWriter.write("Your Order Number :"+count);
            bufferedWriter.newLine();
            bufferedWriter.write(firstname);
             bufferedWriter.newLine();
            bufferedWriter.write(email);
             bufferedWriter.newLine();
            bufferedWriter.write(phone);
             bufferedWriter.newLine();
             bufferedWriter.write(address);
              bufferedWriter.newLine();
                for(String key: items.keySet())
            {
           // bufferedWriter.newLine();
            bufferedWriter.write(key+"-");
            Double tryq = items.get(key);
            bufferedWriter.write(String.valueOf(tryq));
             bufferedWriter.newLine();   
            
            }
             count++;
         bufferedWriter.newLine();
            bufferedWriter.close();
           //pw.println("<h1>THANK you</h1>");
          
                     response.sendRedirect("thankyou?count="+count+ "&next2Week=" + newDate);
                     

          
        }
        catch(IOException ex) {
            System.out.println("Error writing to file");
            // Or we could just do this:
            // ex.printStackTrace();
        }
				
			
			

	}

}
