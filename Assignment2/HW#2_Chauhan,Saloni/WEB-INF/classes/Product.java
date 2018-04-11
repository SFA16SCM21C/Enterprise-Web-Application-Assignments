

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String id;
    private String retailer;
    private String image;
    private String name;
    private String condition;
    private Double price;
    private String producttype;
    public String getProducttype() {
		return producttype;
	}
	public void setProducttype(String producttype) {
		this.producttype = producttype;
	}


 public Product(String producttype, String id, String image, String name, String condition, String retailer, double price)
    {
    this.producttype=producttype;
    this.id=id;
    this.image=image;
    this.name=name;
    this.condition=condition;
    this.retailer=retailer;
    this.price=price;
    }
    


	List<String> accessories;
    
    public Product(){
        accessories=new ArrayList<String>();
    }
    public String getCondition() {
		return condition;
	}


	public void setCondition(String condition) {
		this.condition = condition;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}

    
    
    public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getRetailer() {
		return retailer;
	}


	public void setRetailer(String retailer) {
		this.retailer = retailer;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	List getAccessories() {
		return accessories;
	}

	@Override
    public String toString() {
        return "Product:: ID="+this.id+" Name=" + this.name + " Image=" + this.image + " Retailer=" + this.retailer +
                " Condition=" + this.condition +" Price=" + this.price.toString();
    }
}