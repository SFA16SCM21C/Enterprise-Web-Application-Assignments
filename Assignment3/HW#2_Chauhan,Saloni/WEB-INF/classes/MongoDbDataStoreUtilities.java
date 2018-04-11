import java.io.*;
import java.util.*;
import java.util.HashMap;
 import com.mongodb.client.FindIterable;
import com.mongodb.*;
import com.mongodb.DB;
import com.mongodb.MongoURI;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.ServerAddress;
import com.mongodb.DBCursor;
import com.mongodb.client.MongoCursor;
import com.mongodb.MongoClient;
import org.bson.Document;
import java.net.UnknownHostException;
 import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
 
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
 

import com.mongodb.DBObject;

public class MongoDbDataStoreUtilities
 {
public HashMap<String ,List<String>> map = new HashMap<String, List<String>>();
public List<String> list = new ArrayList<String>() ;

static DBCollection myreviews;
public String prodname=null;
public String prodprice = null;
public String prodcat=null;
public String retailname=null;
public String retailzip=null;
public String retailcity=null;
public String retailstate=null;
public String manuname=null;
public String userid=null;
public String userage=null;
public String usergender=null;
public String userocup=null;
public String reviewrating=null;
public String reviewdate=null;
public String comments=null;
              	
public static void getConnection()
{
MongoClient client = new MongoClient("localhost", 27017);
		MongoDatabase database = client.getDatabase("assign");
		MongoCollection collection = database.getCollection("myreviews");

}

public static void insert(String prodname,String prodprice, String prodcat, String retailname, String retailzip, String retailcity, String retailstate,String manuname, String userid, String userage, String usergender,String useroccupation, String reviewrating, String reviewdate, String comments   )
{
		
 		MongoClient client = new MongoClient("localhost", 27017);
		MongoDatabase database = client.getDatabase("CustomerReviews");
		MongoCollection collection = database.getCollection("myReviews");
		Document document = new Document();
		
		document.put("Product Name", prodname);
		document.put("Product Price", prodprice);
		document.put("Product Category", prodcat);
		document.put("Retailer Name", retailname);
		document.put("Retailer Zip", retailzip);
		document.put("Retailer City", retailcity);
		document.put("Retailer State", retailstate);
		document.put("Manufacturer Name", manuname);
		document.put("User ID", userid);
		document.put("User Age", userage);
		document.put("User Gender", usergender);
		document.put("User Occupation", useroccupation);
		document.put("Review Rating", reviewrating);
		document.put("Review Date", reviewdate);
		document.put("Comments", comments);
		collection.insertOne(document);
		client.close();
}

public  void findreview(String q)
{
		//String q=null;
		MongoClient client = new MongoClient("localhost", 27017);
		MongoDatabase database = client.getDatabase("CustomerReviews");
		MongoCollection<Document> collection = database.getCollection("myReviews");
		Document query = new Document("Product Name", q);
		FindIterable<Document> search = collection.find(query);
		for (Document current : search)
		 {
             	prodname =  current.getString("Product Name");
              	prodprice = current.getString("Product Price");
              	prodcat = current.getString("Product Category");
              	retailname = current.getString("Retailer Name");
              	retailzip = current.getString("Retailer Zip");
              	retailcity = current.getString("Retailer City");
              	retailstate = current.getString("Retailer State");
              	manuname = current.getString("Manufacturer Name");
              	userid = current.getString("User ID");
              	userage = current.getString("User Age");
              	usergender = current.getString("User Gender");
              	userocup = current.getString("User Occupation");
              	reviewrating = current.getString("Review Rating");
              	reviewdate = current.getString("Review Date");
              	comments = current.getString("Comments");
              	
    
              	list.add(prodname);
          		list.add(prodprice);
          		list.add(prodcat);
          		list.add(retailname);
          		list.add(retailzip);
          		list.add(retailcity);
          		list.add(retailstate);
          		list.add(manuname);
          		list.add(userid);
          		list.add(userage);
          		list.add(usergender);
              	list.add(userocup);
              	list.add(reviewrating);
              	list.add(reviewdate);
              	list.add(comments);
              	
              	map.put(prodname,list);
              	
       

	  	}
		
}
public HashMap<String, List<String>> getmap()
		{
		return map;
		}

}