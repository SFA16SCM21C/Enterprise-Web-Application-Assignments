
import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import javax.servlet.*;
import java.io.File;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.servlet.http.HttpSession;
import org.xml.sax.SAXException;
public class caraousel1 extends HttpServlet{


	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html");
		buy b;
		
        PrintWriter out=response.getWriter();
        
  		HttpSession session=request.getSession();
      	String emailid=(String)session.getAttribute("emailid");
        String name1 = request.getParameter("name");
        Double price= Double.parseDouble(request.getParameter("price"));
        
        
        
        
        String title="This is just a title and nothing except that..";

        out.println("<html>");
        
        out.println("<head>");
        
        out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' integrity='sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u' crossorigin='anonymous'>");


out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css' integrity='sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp' crossorigin='anonymous'>");


out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js'></script>");


out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js' integrity='sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa' crossorigin='anonymous'></script>");
        
        
        
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
    	out.println("<div class='title'><h3>Suggested accessory for your product<h3>");
    	//out.println("<h3>"+emailid+" Cart's</h3>");
    	out.println("</div>");
    	out.println("<div class='content'>");
    	out.println("<p>");
            out.println("<table border='1px'>");
             out.println("<tr>");
             out.println("<th>Item Name</th>");
              out.println("<th>Price</th>");
              out.println("</tr>");
                out.println("<tr>");
             out.println("<th>"+name1+"</th>");
              out.println("<th>"+price+"</th>");
              out.println("</tr>");
              out.println("</div>");
    	out.println("</div></td>");
            //out.println("<h1>"+total+"</h1>");
  
    
            out.println("</table>");
            out.println("<br>");
            out.println("<br>");
            
                out.println("<div id='carousel-example-generic' class='carousel slide' data-ride='carousel'>");
  
  out.println("<ol class='carousel-indicators'>");
    out.println("<li data-target='#carousel-example-generic' data-slide-to='0' class='active'></li>");
    out.println("<li data-target='#carousel-example-generic' data-slide-to='1'></li>");
    out.println("<li data-target='#carousel-example-generic' data-slide-to='2'></li>");
    out.println("<li data-target='#carousel-example-generic' data-slide-to='3'></li>");
    out.println("<li data-target='#carousel-example-generic' data-slide-to='4'></li>");
    out.println("<li data-target='#carousel-example-generic' data-slide-to='5'></li>");
  out.println("</ol>");

  
  out.println("<div class='carousel-inner' role='listbox'>");
    out.println("<div class='item active'>");
     
      out.println("<img src='/a1/images/speakerasc1.jpg'  align='center' width='150' height='150'>");
      out.println("<h5 style = 'color: #990000;'> Insignia™ - 6 Stereo Audio Cable'  </h5>");
		out.println("<h5 style = 'color: #990000;'> Price:10.49$</h5>");
       out.println("<div class='carousel-caption'>");
     out.println("<form action='buy'>");
      out.println("<input type='hidden' name='name' value='Insignia Stereo Audio RCA Cable'>");
      out.println("<input type='hidden' name='price' value='10.49'>");
      out.println("<h4 style = 'color: #000066'>You can buy the item with a discount</h4>");
      out.println("<input style = 'color: #000000;' type='submit' value='Buy Now'>");
      out.println("</form>");
out.println("</div>");	
      
    out.println("</div>");	
    out.println("<div class='item'>");
      out.println("<img src='/a1/images/speakerasc2.jpg'  align='center' width='150' height='150'>");
       out.println("<h5 style = 'color: #990000;'>Rocketfish™ - 8 Stereo Audio' </h5>");
       out.println("<h5 style = 'color: #990000;'> Price:18.99$</h5>");
       out.println("<br>");
          out.println("<div class='carousel-caption'>");
     out.println("<form action='buy'>");
      out.println("<input type='hidden' name='name' value='Rocketfish Stereo Audio RCA Cable'>");
      out.println("<input type='hidden' name='price' value='18.99'>");
      out.println("<h4 style = 'color: #000066'>You can buy the item with a discount</h4>");
      out.println("<input style = 'color: #000000;' type='submit' value='Buy Now'>");
      out.println("</form>");
    out.println("</div>");
     out.println("</div>");
     
	out.println("<div class='item'>");
	  out.println("<img src='/a1/images/speakerasc3.jpg'  align='center' width='250' height='250'>");
	  out.println("<h5 style = 'color: #990000;'> XP Clear Jacket MKIII 100 Cable</h5>");
	  out.println("<h5 style = 'color: #990000;'> Price:89.99$</h5>");
	  out.println("<br>");
	  out.println("<div class='carousel-caption'>");
	    out.println("<form action='buy'>");
      out.println("<input type='hidden' name='name' value='Monster PLatinum XP clear jacket cable'>");
      out.println("<input type='hidden' name='price' value='89.99'>");
      out.println("<h4 style = 'color: #000066'>You can buy the item with a discount</h4>");
      out.println("<input style = 'color: #000000;' type='submit' value='Buy Now'>");
      out.println("</form>");
	  
	out.println("</div>");
	 out.println("</div>");	
    out.println("<div class='item'>");
      out.println("<img src='/a1/images/speakerasc4.jpg'  align='center' width='150' height='150'>");
       out.println("<h5 style = 'color: #990000;'>AudioQuest RCA Cable</h5>");
       out.println("<h5 style = 'color: #990000;'> Price:65.99$</h5>");
       out.println("<br>");
          out.println("<div class='carousel-caption'>");
     out.println("<form action='buy'>");
      out.println("<input type='hidden' name='name' value='AudioQuest RCA-RCA Cable>");
      out.println("<input type='hidden' name='price' value='65.99'>");
      out.println("<h4 style = 'color: #000066'>You can buy the item with a discount</h4>");
      out.println("<input style = 'color: #000000;' type='submit' value='Buy Now'>");
      out.println("</form>");
    out.println("</div>");
     out.println("</div>");
     
     out.println("<div class='item'>");
      out.println("<img src='/a1/images/speakerasc5.jpg'  align='center' width='150' height='150'>");
       out.println("<h5 style = 'color: #990000;'>Niles MicroFasher Apple Watch </h5>");
       out.println("<h5 style = 'color: #990000;'> Price:304.98$</h5>");
       out.println("<br>");
          out.println("<div class='carousel-caption'>");
     out.println("<form action='buy'>");
      out.println("<input type='hidden' name='name' value='Niles IR MicroFasher'>");
      out.println("<input type='hidden' name='price' value='304.98'>");
      out.println("<h4 style = 'color: #000066'>You can buy the item with a discount</h4>");
      out.println("<input style = 'color: #000000;' type='submit' value='Buy Now'>");
      out.println("</form>");
    out.println("</div>");
     out.println("</div>");
     
      out.println("<div class='item'>");
      out.println("<img src='/a1/images/speakerasc6.jpg'  align='center' width='150' height='150'>");
       out.println("<h5 style = 'color: #990000;'>Niles - High-Output  </h3>");
       out.println("<h5 style = 'color: #990000;'> Price:39.89$</h3>");
       out.println("<br>");
          out.println("<div class='carousel-caption'>");
     out.println("<form action='buy'>");
      out.println("<input type='hidden' name='name' value='Niles - High-Output IR FLasher'>");
      out.println("<input type='hidden' name='price' value='39.89'>");
      out.println("<h4 style = 'color: #000066'>You can buy the item with a discount</h4>");
      out.println("<input style = 'color: #000000;' type='submit' value='Buy Now'>");
      out.println("</form>");
    out.println("</div>");
     out.println("</div>");
	
	
	
	
  out.println("</div>");


  out.println("<a class='left carousel-control' href='#carousel-example-generic' role='button' data-slide='prev'>");
    out.println("<span class='glyphicon glyphicon-chevron-left' aria-hidden='true'></span>");
    out.println("<span class='sr-only'>Previous</span>");
  out.println("</a>");
   out.println("<a class='right carousel-control' href='#carousel-example-generic' role='button' data-slide='next'>");
   out.println("<span class='glyphicon glyphicon-chevron-right' aria-hidden='true'></span>");
    out.println("<span class='sr-only'>Next</span>");
  out.println("</a>");
 out.println("</div>");

         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
            
    	
    	
    	
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