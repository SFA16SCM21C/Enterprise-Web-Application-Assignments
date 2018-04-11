import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;





public class MyHandler extends DefaultHandler {

    //List to hold Employees object
    public HashMap<String,Product> prodList = null;
    
    public Product product = null;


    //getter method for employee list
    public HashMap<String,Product> getEmpList() {
        return prodList;
    }

    boolean bImage = false;
    boolean bName = false;
    boolean bAccessories = false;
    boolean bCondition = false;
    boolean bPrice = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("watch" )) {
            //create a new Employee and put it in Map
            String id = attributes.getValue("id");
            //initialize Employee object and set id attribute
            product = new Product();
            product.setId(id);
            String retailer = attributes.getValue("retailer");
            //initialize Employee object and set id attribute
            product.setRetailer(retailer);
            product.setProducttype(qName);
            //initialize list
            if (prodList == null)
                prodList = new HashMap<String,Product>();
        } 
        else if (qName.equalsIgnoreCase("speaker" )) {
            //create a new Employee and put it in Map
            String id = attributes.getValue("id");
            //initialize Employee object and set id attribute
            product = new Product();
            product.setId(id);
            String retailer = attributes.getValue("retailer");
            //initialize Employee object and set id attribute
            product.setRetailer(retailer);
            product.setProducttype(qName);
            //initialize list
            if (prodList == null)
                prodList = new HashMap<String,Product>();
        } 
         else if (qName.equalsIgnoreCase("laptop" )) {
            //create a new Employee and put it in Map
            String id = attributes.getValue("id");
            //initialize Employee object and set id attribute
            product = new Product();
            product.setId(id);
            String retailer = attributes.getValue("retailer");
            //initialize Employee object and set id attribute
            product.setRetailer(retailer);
            product.setProducttype(qName);
            //initialize list
            if (prodList == null)
                prodList = new HashMap<String,Product>();
        } 
          else if (qName.equalsIgnoreCase("headphone" )) {
            //create a new Employee and put it in Map
            String id = attributes.getValue("id");
            //initialize Employee object and set id attribute
            product = new Product();
            product.setId(id);
            String retailer = attributes.getValue("retailer");
            //initialize Employee object and set id attribute
            product.setRetailer(retailer);
            product.setProducttype(qName);
            //initialize list
            if (prodList == null)
                prodList = new HashMap<String,Product>();
        } 
        else if (qName.equalsIgnoreCase("phone" )) {
            //create a new Employee and put it in Map
            String id = attributes.getValue("id");
            //initialize Employee object and set id attribute
            product = new Product();
            product.setId(id);
            String retailer = attributes.getValue("retailer");
            //initialize Employee object and set id attribute
            product.setRetailer(retailer);
            product.setProducttype(qName);
            //initialize list
            if (prodList == null)
                prodList = new HashMap<String,Product>();
        } 
           else if (qName.equalsIgnoreCase("storage" )) {
            //create a new Employee and put it in Map
            String id = attributes.getValue("id");
            //initialize Employee object and set id attribute
            product = new Product();
            product.setId(id);
            String retailer = attributes.getValue("retailer");
            //initialize Employee object and set id attribute
            product.setRetailer(retailer);
            product.setProducttype(qName);
            //initialize list
            if (prodList == null)
                prodList = new HashMap<String,Product>();
        } 
        
        
  
        else if (qName.equalsIgnoreCase("name")) {
            //set boolean values for fields, will be used in setting Employee variables
            bName = true;
        } else if (qName.equalsIgnoreCase("image")) {
            bImage = true;
        } else if (qName.equalsIgnoreCase("accessories")) {
            bAccessories = true;
        }else if (qName.equalsIgnoreCase("condition")) {
            bCondition = true;
        } else if (qName.equalsIgnoreCase("price")) {
            bPrice = true;
        } 
         }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("watch"))
        		{
            //add Product object to list
            prodList.put(product.getId(),product);
        }
        else if(qName.equalsIgnoreCase("speaker"))
        		{
            //add Product object to list
            prodList.put(product.getId(),product);
        		}
        		 else if(qName.equalsIgnoreCase("laptop"))
        		{
            //add Product object to list
            prodList.put(product.getId(),product);
        		}
        		 else if(qName.equalsIgnoreCase("headphone"))
        		{
            //add Product object to list
            prodList.put(product.getId(),product);
        		}
        		 else if(qName.equalsIgnoreCase("phone"))
        		{
            //add Product object to list
            prodList.put(product.getId(),product);
        		}
        		 else if(qName.equalsIgnoreCase("storage"))
        		{
            //add Product object to list
            prodList.put(product.getId(),product);
        		}
        }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if (bImage) {
            //age element, set Employee age
            product.setImage(new String(ch, start, length));
            bImage = false;
        } else if (bName) {
            product.setName(new String(ch, start, length));
            bName = false;
        } else if (bCondition) {
            product.setCondition(new String(ch, start, length));
            bCondition = false;
        } else if (bPrice) {
            product.setPrice(Double.parseDouble(new String(ch, start, length)));
            bPrice = false;
        }
    }

}
