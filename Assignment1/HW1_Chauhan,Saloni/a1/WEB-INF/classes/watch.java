import java.io.*;
//import javax.servlet.*;

//import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
public class watch extends HttpServlet{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html");

        PrintWriter out=response.getWriter();
  SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
   SAXParser saxParser = null;
try {
	saxParser = saxParserFactory.newSAXParser();
} catch (ParserConfigurationException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SAXException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
        MyHandler handler = new MyHandler();
        try {
			saxParser.parse(new File("C:/Users/teleworld/Desktop/apache-tomcat-7.0.34/webapps/a1/WEB-INF/ProductCatalog.xml"), handler);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session=request.getSession(false);
      	String emailid=(String)session.getAttribute("emailid");
        //Get Product list
        HashMap<String,Product> productList = handler.getEmpList();
        //print product information
  
  
  
  
        String title="This is just a title and nothing except that..";

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
        out.println("<div class='logo'><a href='index.html'><span class='style5'>Smart<br />");
    	out.println("Portable</span></a></div>");
    	out.println("</div></td>");
    	out.println("<td colspan='3'><div class='style1' id='header'>");
    	out.println("<br />");
    	out.println("Online <span class='style3'>BEST DEAL</span>");
    	out.println("<span class='style4'><br />");
    	out.println("Best Electronics Items Available in the market! </span></div></td>");
    	out.println("<td>");
    	out.println("<img src='images/spacer.gif' width='1' height='185' alt='' /></td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td><div class='top_menu'>");
    	out.println("<ul>");
    	out.println("<li><a href='index.html'>Home</a></li>");
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
    	out.println("<div class='title'><h3>Welcome to Watch Section !</h3>");
    	out.println("</div>");
    	out.println("<div class='content'>");
    	out.println("<p>");
     
    	//System.out.println(key);
    	 for (String key : productList.keySet() ) 
		 {
		  Product con= productList.get(key);
		  String producttype=con.getProducttype();
		  String itemId=con.getId();
		  String imgname=con.getImage();
		  String itemName = con.getName(); 
		  String condition = con.getCondition();
		  String retailername = con.getRetailer();
		  Double price=con.getPrice();
		  //List<String> accessories = con.getAccessories();
		  if(producttype=="watch")
		  {
		 out.println("<img src='"+imgname+"' width='120' height='100' alt=''/>");
		 out.println("<br>");
			out.println("Product ID:"+itemId);
		  out.println("<br>");
		  out.println("Product Name:"+itemName);
		  out.println("<br>");
		  out.println("Price"+price+"$");

		  out.println("<br>");
		  out.println("Retailer"+retailername);
		  out.println("&nbsp");
		  out.println("Condition:"+condition);
		out.println("<div id='frm'>"); 
             out.println("<form action='buy'>");
             out.println("<input type='submit' value='Buy'>");
              out.println("<input type='hidden' name='id' value='"+itemId+"'>");
            out.println("<input type='hidden' name='name' value='"+itemName+"'>");
            out.println("<input type='hidden' name='price' value='"+price+"'>");
             out.println("</form>");
             out.println("<form action='/a1/review.html'>");
              out.println("<input type='submit' value='Write Review'>");
              out.println("</form>");
              out.println("<form action='viewreview'>");
            out.println("<input type='submit' value='Read Review'>");
            out.println("</form>"); 
             out.println("<form action='caraousel'>");
                 out.println("<input type='hidden' name='id' value='"+itemId+"'>");
            out.println("<input type='hidden' name='name' value='"+itemName+"'>");
            out.println("<input type='hidden' name='price' value='"+price+"'>");
            out.println("<input type='submit' value='View Accessories'>");
            out.println("</form>");
            out.println("</div>");
            out.println("<br>");
          }
          
          }
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