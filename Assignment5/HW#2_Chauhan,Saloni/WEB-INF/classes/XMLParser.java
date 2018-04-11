import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class XMLParser {

    public static void main(String[] args) {
    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
    try {
        SAXParser saxParser = saxParserFactory.newSAXParser();
        MyHandler handler = new MyHandler();
        saxParser.parse(new File("C:/Users/teleworld/Desktop/apache-tomcat-7.0.34/webapps/a1/WEB-INF/classes/ProductCatalog.xml"), handler);
        //Get Product list
        HashMap<String,Product> productList = handler.getEmpList();
        //print product information
         for (String key : productList.keySet() ) 
		 {
		  Product con= productList.get(key);
		  String producttype=con.getProducttype();
		  String itemId=con.getId();
		  String itemName = con.getName(); 
		  Double price=con.getPrice();
		  //List<String> accessories = con.getAccessories();
		  if(producttype=="console")
		  {
		  System.out.println(itemId +"\n"+ itemName +"\n"+ price + "\n" + producttype);
        	 }
		 }
    } catch (ParserConfigurationException | SAXException | IOException e) {
        e.printStackTrace();
    }
    }

}
