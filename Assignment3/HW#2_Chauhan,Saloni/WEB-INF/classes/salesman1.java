import java.io.*;
import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.*;
import java.io.File;
import java.util.HashMap;
import javax.servlet.http.HttpSession;

public class salesman1 extends HttpServlet{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html");
        HttpSession session=request.getSession(false);
      	String emailid=(String)session.getAttribute("emailid");
		PrintWriter out = response.getWriter();
        out.println("<html>");
        
        out.println("<head>");
        out.println("<title>Online Shopping market</title>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=iso-8859-1' />");
        out.println("<link href='style.css' rel='stylesheet' type='text/css' />");
       	out.println("</head>");
        out.println("<body bgcolor='550403' style='leftmargin=0px; topmargin=0px; marginwidth=0px; marginheight=0px;'>");
        out.println("<span class='style6'></span>");
        out.println("<div id='body'>");
        out.println("<br />");
        out.println("<br />");
        out.println("<br />");
        out.println("<table style='width=1001px; height=1001px;' border='0' align='center' cellpadding='0' cellspacing='0' id='Table_01'>");
        out.println("<tr>");
        out.println("<td colspan='2' rowspan='3'><div id='logo'>");
        out.println("<div class='logo'><a href='index.html'><span class='style5'>BEST<br />");
    	out.println("DEAL</span></a></div>");
    	out.println("</div></td>");
    	out.println("<td colspan='3'><div class='style1' id='header'>");
    	out.println("<br />");
    	out.println("Online <span class='style3'>Shopping Portal</span>");
    	out.println("<span class='style4'><br />");
    	out.println("Best Electronics Items Available in the market! </span></div></td>");
    	out.println("<td>");
    	out.println("<img src='images/spacer.gif' width='1' height='185' alt='' /></td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td><div class='top_menu'>");
    	out.println("<ul>");
    	out.println("<li><a href='salesman1'>Home</a></li>");
    	out.println("<li><a href='login.html'>Login</a></li>");
    	out.println("<li><a href='logout'>Log Out</a></li>");
    	out.println("<li><a href='mycart'>My Cart</a></li>");
    	out.println("</ul>");
    	out.println("</div></td>");
    	out.println("<td colspan='2'>");
    	out.println("<img src='images/index_04.jpg' width='128' height='42' alt='' /></td>");
    	out.println("<td>");
    	out.println("<img src='images/spacer.gif' width='1' height='42' alt='' /></td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td colspan='2' rowspan='2'><div id='content'>");
    	out.println("<div class='title'><h3>Welcome to Smart Portable ! </h3>");
    	out.println("</div>");
    	out.println("<div class='content'>");
    	out.println("<p>");
    	out.println("<h2> Welcome Salesman -  "+emailid+"</h2>");
    	
    	out.println("<form action='/a1/registerbysales.html'>");
    	out.println("Click to Add User Accounts");
    	out.println("<br>");
		out.println("<br>");
		out.println("<input type='submit' value='Create New User'>");
		out.println("</form>");
		out.println("<form action='/a1/addorder.html'>");
    	out.println("Click to Create New Order for a Customer");
    	out.println("<br>");
		out.println("<br>");
		out.println("<input type='submit' value='Create New Order'>");
		out.println("</form>");
		out.println("<form action='/a1/updateorder.html'>");
    	out.println("Click to Update an Order Details");
    	out.println("<br>");
		out.println("<br>");
		out.println("<input type='submit' value='Update an Existing Order'>");
		out.println("</form>");
		out.println("<form action='/a1/deleteuser.html'>");
    	out.println("Click to Delete Orders");
    	out.println("<br>");
		out.println("<br>");
		out.println("<input type='submit' value='Delete Orders'>");
		out.println("</form>");
		out.println("Click to View Customer Orders");
		out.println("<br>");
		out.println("<br>");
		out.println("<form action='vieworders'>");
		out.println("<input type='submit' value='View Orders'>");
		out.println("</form>");
		out.println("<img src='images/back.png' width='670' height='500' alt='' />");
		

    	out.println("</div>");
    	out.println("</div></td>");
    	out.println("<td rowspan='3'>");
    	out.println("<img src='images/index_06.jpg' width='27' height='773' alt='' /></td>");
    	out.println("<td>");
    	out.println("<img src='images/spacer.gif' width='1' height='76' alt='' /></td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td rowspan='2'><img src='images/index_07.jpg' width='70' height='697' alt=''/></td>");
    	out.println("<td><div class='left_menu'>");
    	out.println("<ul>");
    	out.println("<li><a href='watch'>Smart Watches</a></li>");
        out.println("<li><a href='speaker'>Speakers</a></li>");
        out.println("<li><a href='headphone'>Headphones</a></li>");
        out.println("<li><a href='phone'>Phones</a></li>");
       out.println( "<li><a href='laptop'>Laptops</a></li>");
        out.println("<li><a href='storage'>Ext Storage</a></li>");
        out.println("</ul>");
        out.println("</td></div>");
        out.println("<td>");
        out.println("<img src='images/spacer.gif' width='1' height='651' alt='' /></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td colspan='3'><div id='footer'>Prices and offers are subject to change. 2017 Smart Portable<iv></td>");
       out.println( "<td>");
        out.println("<img src='images/spacer.gif' width='1' height='46' alt='' /></td>");
       out.println( "</tr>");
       out.println( "<tr>");
        out.println("<td>");
        out.println("<img src='images/spacer.gif' width='70' height='1' alt='' /></td>");
	    out.println("<td>");
	    out.println("<img src='images/spacer.gif' width='179' height='1' alt='' /></td>");
	    out.println("<td>");	        
	    out.println("<img src='images/spacer.gif' width='623' height='1' alt='' /></td>");
	    out.println("<td>");
	    out.println("<img src='images/spacer.gif' width='101' height='1' alt='' /></td>");
	    out.println("<td>");
	    out.println("<img src='images/spacer.gif' width='27' height='1' alt='' /></td>");
	    out.println("<td></td>");
	    out.println("</tr>");
	    out.println("</table>");
	    out.println("<div id='lft'><a href='http://www.merkkleding-outlet.nl'>merkkleding online</a></div><br />");
        out.println("<br />");
        out.println( "</div>");
		out.println("</body>");
		out.println("</html>");
    }
    }