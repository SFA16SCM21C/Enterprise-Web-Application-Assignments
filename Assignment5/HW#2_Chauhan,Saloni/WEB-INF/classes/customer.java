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

public class customer extends HttpServlet{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html");
        HttpSession session=request.getSession(false);
      	String emailid=(String)session.getAttribute("emailid");
		PrintWriter out = response.getWriter();
		
		MySqlDataStoreUtilities obj= new MySqlDataStoreUtilities();
		obj.insertdataintosql();
		
		//assign5
		AjaxUtility obj1=new AjaxUtility();
		HashMap<String, Product> cool=new HashMap<String,Product>();
		cool=obj1.getData();
		HashMap<String, Product> p =new HashMap<String, Product>();
        p=obj.displayfromsql();
		
        out.println("<html>");
        
        out.println("<head>");
        out.println("<title>Online Shopping market</title>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=iso-8859-1' />");
        out.println("<link href='style.css' rel='stylesheet' type='text/css' />");
		out.println("<script type='text/javascript' src='javascript.js'> </script>");
       	out.println("</head>");
        out.println("<body bgcolor='550403' style='leftmargin=0px; topmargin=0px; marginwidth=0px; marginheight=0px;'>");
        out.println("<span class='style6'></span>");
        out.println("<div id='body'>");
        out.println("<body onload='init()'>");
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
    	out.println("Best Electronics Iems Available in the market! </span></div></td>");
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
    	out.println("<div class='title'><h3>Welcome to Smart Portable ! </h3>");
    	out.println("</div>");
		
		
    	out.println("<div class='content'>");
    	out.println("<p>");
    	out.println("<h3> Welcome "+emailid+"</h3>");
    	out.println("<h4> Please Select category and proceed further </h4>");
    	out.println("<p>");
    	out.println("<h4> My Account Details </h4>");
    	out.println("<form action='myaccount'>");
    	out.println("<input type='submit' value='My Account'>");
		out.println("<br />");
		out.println("<br />");
    	out.println("</form>");
		//assign4
		out.println("<form name='autofillform' action='autoComplete'>");
		out.println("<h4>As an extra feature in this current update we are givng customers to search for Products. Enter a name explore the feature");
		out.println("<h4>Search bar: ");
		out.println("<input type='text' size='20' name='searchId' id='searchId'  onkeyup='doCompletion()'  placeholder='search for product here..' style='padding: 5px; font-size: 16px;'>");
		out.println("<table id='complete-table' class='gridtable' bordercolor='black' border='1' style='display: table; position: absolute; left: 38%';></table>");
		out.println("</form>");
		
		//assign5
		out.println("<h4>GUARENTEED PRICE MATCH</h4>");
    	
    	String filename="C:/Users/teleworld/Desktop/apache-tomcat-7.0.34/webapps/a1/WEB-INF/classes/DealMatches.txt";
    	
    	 String str;
    	 HashMap<String, Product> d =new HashMap<String, Product>();
    	 for(Map.Entry<String, Product>entry:p.entrySet())
    	  {
    	   BufferedReader br = new BufferedReader(new FileReader(filename));
     while((str=br.readLine())!=null)
     {
    	if (str.contains(entry.getValue().getName()))
    	{
    	d.put(entry.getKey(),entry.getValue());
		out.println("**  ");
    	 out.println(str);
		 out.println("<br>");
    	  }
    	   }
 
    	   }
    	   
    	   out.println("<h4>Following are the MATCHED DEALS</h4>");
    	 
 for (String key : d.keySet() ) 
    	
		 {
		  Product con= d.get(key);
		  String producttype=con.getProducttype();
		  String itemId=con.getId();
		  String imgname=con.getImage();
		  String itemName = con.getName(); 
		  String condition = con.getCondition();
		  String retailername = con.getRetailer();
		  String sale = con.getSale();
		  Double price=con.getPrice();
		  out.println("<img src='"+imgname+"' align='right' width='95' height='90'>");
		  out.println("Product ID: "+itemId);
		  out.println("<br>");
		  out.println("Product Name: "+itemName);
		  out.println("<br>");
		  out.println("Price: "+price+"$");

		  out.println("<br>");
		  out.println("Retailer: "+retailername);
		  out.println("<br>");
		  out.println(" Condition: "+condition);
		  out.println("<br>");
		  out.println(" On Sale YES/NO: "+sale);
		  out.println("<br>");
		  out.println("<div id='frm'>");
		  out.println("<br>");
          out.println("<form action='buy'>");
          out.println("<input type='submit'  value='Buy'>");
          out.println("<input type='hidden' name='id' value='"+itemId+"'>");
          out.println("<input type='hidden' name='prodtype' value='"+producttype+"'>");
          out.println("<input type='hidden' name='name' value='"+itemName+"'>");
          out.println("<input type='hidden' name='price' value='"+price+"'>");
          out.println("</form>");
          out.println("<form action='inputreview'>");
          out.println("<input type='submit'  value='Write Review'>");
          out.println("<input type='hidden' name='productprice' value='"+price+"'>");
          out.println("<input type='hidden' name='productname' value='"+itemName+"'>");
          out.println("<input type='hidden' name='producttype' value='"+producttype+"'>");
          out.println("</form>");
          out.println("<form action='viewreview'>");
          out.println("<input type='hidden'  name='productname' value='"+itemName+"'>");
          out.println("<input type='submit'  value='Read Review'>");
          out.println("</form>"); 
          out.println("</div>");
          out.println("<br>");
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