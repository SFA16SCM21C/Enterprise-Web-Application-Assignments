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

public class chartsales extends HttpServlet{



	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html");
        HttpSession session=request.getSession(false);
      //	String emailid=(String)session.getAttribute("emailid");
		PrintWriter out = response.getWriter();
		MySqlDataStoreUtilities obj= new MySqlDataStoreUtilities();
		HashMap<String, Double> prodd =new HashMap<String, Double>();
        prodd=obj.chart2();
        
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
    	out.println("Online <span class='style3'>BEST DEALS</span>");
    	out.println("<span class='style4'><br />");
    	out.println("Best Electronics Items Available in the market! </span></div></td>");
    	out.println("<td>");
    	out.println("<img src='images/spacer.gif' width='1' height='185' alt='' /></td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td><div class='top_menu'>");
    	out.println("<ul>");
    	out.println("<li><a href='storemanager1'>Home</a></li>");
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
    	out.println("<div class='title'>");
    	out.println("</div>");
    	 out.println("<div class='content'>");
    	out.println("<p>");
    	out.println("<h3>Following is the Product v/s Quantity Graph </h3>");
    	//out.println("size:"+prodd.size());
    	//String items[] =new String[prodd.size()];
    	//int quants[] = new int[prodd.size()];
    	String name[]=new String[prodd.size()];
    	double num[]=new double[prodd.size()];
    	
    	int index=0;
    	for (Map.Entry<String, Double> entry : prodd.entrySet()) 
    	{
    	name[index] = entry.getKey();
    	num[index]=entry.getValue();
    	index++;
    	}
    	//prod.clear();
			  
	out.println("<script type='text/javascript' src='https://www.gstatic.com/charts/loader.js'></script>");
    //out.println("<div id='chart_div' style='width: 100%; height: 500px;'></div>");
    out.println("<div id='chart_div' style='width: 100%; height: 1000px;'></div>");
    out.println("<script type = 'text/javascript'>");
    out.println("google.charts.load('current', {packages: ['corechart', 'bar']});");
    out.println("google.charts.setOnLoadCallback(drawBasic);");

    out.println("function drawBasic() {");

    out.println("var data = google.visualization.arrayToDataTable([");
    out.println("['Product Name', 'Total Sale of Product',{ role: 'style' }, { role: 'annotation' }],");
                 for (int i=0;i<prodd.size(); i++)
                 {
					out.println("['"+name[i]+"',"+num[i]+", '#900C3F', '"+name[i]+"'],");
					
			  }
    out.println("]);");
    out.println("var options = {");
    out.println("title: 'Entire Sales v/s Prduct Purchased Graph',");
    out.println("chartArea: {width: '40%',left: 200, top: 50, 'height':700},");
    out.println(" hAxis: {");
    out.println("title: 'Sale',");
    out.println("showTextEvery: 1,");
    out.println("minValue: 0");
    out.println(" },");
    out.println(" vAxis: {");
    out.println(" title: 'Item Purchased',");
    out.println("showTextEvery: 1,");
    out.println("gridlines: { count: 1 } ");
    out.println(" }");
    out.println(" };");
    out.println("var chart = new google.visualization.BarChart(document.getElementById('chart_div'));");
    out.println("chart.draw(data, options);");
    out.println("}");
    out.println("</script>");
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
        out.println("</div>");
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