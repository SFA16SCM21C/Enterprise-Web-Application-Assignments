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

    private HashMap<String,Product> prodList = null;
    
    private Product product = null;


    public HashMap<String,Product> getEmpList() {
        return prodList;
    }

    boolean bImage = false;
    boolean bName = false;
    boolean bAccessories = false;
    boolean bCondition = false;
    boolean bPrice = false;
	boolean bQuantity=false;
    boolean bSale=false;
    boolean bRebate=false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("watch" )) {
           
            String id = attributes.getValue("id");
            
            product = new Product();
            product.setId(id);
            String retailer = attributes.getValue("retailer");
           
            product.setRetailer(retailer);
            product.setProducttype(qName);
   
            if (prodList == null)
                prodList = new HashMap<String,Product>();
        } else if (qName.equalsIgnoreCase("speaker" )) {
          
            String id = attributes.getValue("id");
           
            product = new Product();
            product.setId(id);
            String retailer = attributes.getValue("retailer");
          
            product.setRetailer(retailer);
            product.setProducttype(qName);
          
            if (prodList == null)
                prodList = new HashMap<String,Product>();
        } else if (qName.equalsIgnoreCase("laptop" )) {
          
            String id = attributes.getValue("id");
            
            product = new Product();
            product.setId(id);
            String retailer = attributes.getValue("retailer");
            
            product.setRetailer(retailer);
            product.setProducttype(qName);
           
            if (prodList == null)
                prodList = new HashMap<String,Product>();
        } else if (qName.equalsIgnoreCase("headphone" )) {
            
            String id = attributes.getValue("id");
            
            product = new Product();
            product.setId(id);
            String retailer = attributes.getValue("retailer");
            
            product.setRetailer(retailer);
            product.setProducttype(qName);
            
            if (prodList == null)
                prodList = new HashMap<String,Product>();
        } else if (qName.equalsIgnoreCase("phone" )) {
            
            String id = attributes.getValue("id");
            
            product = new Product();
            product.setId(id);
            String retailer = attributes.getValue("retailer");
            
            product.setRetailer(retailer);
            product.setProducttype(qName);
            
            if (prodList == null)
                prodList = new HashMap<String,Product>();
        } else if (qName.equalsIgnoreCase("storage" )) {
            
            String id = attributes.getValue("id");
            
            product = new Product();
            product.setId(id);
            String retailer = attributes.getValue("retailer");
            
            product.setRetailer(retailer);
            product.setProducttype(qName);
            
            if (prodList == null)
                prodList = new HashMap<String,Product>();
        } else if (qName.equalsIgnoreCase("name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("image")) {
            bImage = true;
        } else if (qName.equalsIgnoreCase("accessories")) {
            bAccessories = true;
        } else if (qName.equalsIgnoreCase("condition")) {
            bCondition = true;
        } else if (qName.equalsIgnoreCase("price")) {
            bPrice = true;
        } else if (qName.equalsIgnoreCase("quantity")) {
            bQuantity = true;
        } else if (qName.equalsIgnoreCase("sale")) {
            bSale = true;
        } else if (qName.equalsIgnoreCase("rebate")) {
            bRebate = true;
        } 
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("watch"))
        		{
          
            prodList.put(product.getId(),product);
        }
        else if(qName.equalsIgnoreCase("speaker"))
        		{
          
            prodList.put(product.getId(),product);
      		}
        		 else if(qName.equalsIgnoreCase("laptop"))
        		{
          
            prodList.put(product.getId(),product);
        		}
        		 else if(qName.equalsIgnoreCase("headphone"))
        		{
          
            prodList.put(product.getId(),product);
        		}
        		 else if(qName.equalsIgnoreCase("phone"))
        		{
          
            prodList.put(product.getId(),product);
        		}
        		 else if(qName.equalsIgnoreCase("storage"))
        		{
          
            prodList.put(product.getId(),product);
        		}
        }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if (bImage) {
           
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
        } else if (bQuantity) {
            product.setQuant(Integer.parseInt(new String(ch, start, length)));
            bQuantity = false;
        } else if (bSale) {
            product.setSale(new String(ch, start, length));
            bSale = false;
        } else if (bRebate) {
			product.setRebate(new String(ch, start, length));
            bRebate = false;
        }
    }
}
