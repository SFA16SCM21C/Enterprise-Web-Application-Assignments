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
		PrintWriter pw = response.getWriter();
		
		String prodname = request.getParameter("prodname");
		String prodprice = request.getParameter("prodprice");
		String prodcat = request.getParameter("prodtype");
		String retailername = request.getParameter("retailername");
		String retailerzip = request.getParameter("retailerzip");
		String retailercity = request.getParameter("retailercity");
		String retailerstate = request.getParameter("retailerstate");
		String manuname = request.getParameter("manufacturename");
		String userid = request.getParameter("userid");
		String userage = request.getParameter("userage");
		String usergender = request.getParameter("usergender");
		String userocup = request.getParameter("useroccupation");
		String rating = request.getParameter("reviewrating");
		String reviewdate = request.getParameter("reviewdate");
		String comment = request.getParameter("comment");
		String emailid=(String)session.getAttribute("emailid");
		
		MongoDbDataStoreUtilities obj = new MongoDbDataStoreUtilities();
		obj.insert(prodname, prodprice,prodcat,retailername,retailerzip,retailercity,retailerstate, manuname,userid,userage,usergender,userocup,rating, reviewdate,comment );
        response.sendRedirect("customer");
		}
}
