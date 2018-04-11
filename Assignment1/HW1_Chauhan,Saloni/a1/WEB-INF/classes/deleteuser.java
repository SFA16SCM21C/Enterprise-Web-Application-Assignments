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
			
			String emailid = request.getParameter("emailid");
			//PrintWriter pw = response.getWriter();
			HttpSession session=request.getSession();
			String lineToRemove = null;
			String line = null;
								
 try {
			String fileName = "C:/Users/teleworld/Desktop/apache-tomcat-7.0.34/webapps/a1/WEB-INF/userdata.txt";
			File inFile = new File(fileName);
			if (!inFile.isFile()) {
			System.out.println("Parameter is not an existing file");
			return;
			}
            //FileWriter fileWriter = new FileWriter(fileName,true);
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			File tempFile = new File(inFile.getAbsolutePath() + ".tmp");
			PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
				while((line = br.readLine()) != null) 
			{
				String [] token=line.split(";");
					if (token[1].equals(emailid))
					{
						String fname = token[0];
						String mail = token[1];
						String pass = token[2];
						lineToRemove = fname + ";" + mail + ";" + pass;

						if (!line.trim().equals(line)) {
							//pw.println(lineToRemove);
							//pw.flush();
						}
					}
			}
			pw.close();
			br.close();
			if (!inFile.delete()) {
				System.out.println("Could not delete file");
				return;
			}
			
			if (!tempFile.renameTo(inFile))
			System.out.println("Could not rename file");
 }
			catch (FileNotFoundException ex) {
			ex.printStackTrace();
			}
            // Always wrap FileWriter in BufferedWriter.
            //BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
            //bufferedWriter.write(firstname+";");
            //bufferedWriter.write(emailid1+";");
            //bufferedWriter.write(password);
			//bufferedWriter.newLine();
            //bufferedWriter.close();
            //pw.println("<h1>THANK YOU!</h1>");
            response.sendRedirect("/a1/deletethankyou.html");
			}
}
