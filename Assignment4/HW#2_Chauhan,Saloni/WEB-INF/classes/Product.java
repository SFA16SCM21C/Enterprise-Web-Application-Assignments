

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String id;
    private String retailer;
    private String image;
    private String name;
    private String condition;
    private Double price;
    private int quant;
    private String producttype;
    private String sale;
    private String rebate;
    public String getProducttype() {
		return producttype;
	}
	public void setProducttype(String producttype) {
		this.producttype = producttype;
	}


 public Product(String producttype, String id, String image, String name, String condition, String retailer, double price, int quant, String sale,String rebate)
    {
    this.producttype=producttype;
    this.id=id;
    this.image=image;
    this.name=name;
    this.condition=condition;
    this.retailer=retailer;
    this.price=price;
    this.quant=quant;
    this.sale=sale;
    this.rebate=rebate;
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
	
	 public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}
	
	public String getSale() {
		return sale;
	}


	public void setSale(String sale) {
		this.sale = sale;
	}
	
	
		public String getRebate() {
		return rebate;
	}


	public void setRebate(String rebate) {
		this.rebate = rebate;
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
                " Condition=" + this.condition +" Price=" + this.price.toString()+" Quantity=" + this.quant;
    }
}