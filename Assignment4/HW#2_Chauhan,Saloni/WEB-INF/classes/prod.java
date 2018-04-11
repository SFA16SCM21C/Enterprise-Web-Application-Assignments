

import java.util.ArrayList;
import java.util.List;

public class prod {
    private String name;
    private double price;
    private int cnt;
    private double totalsale;

 public prod(String name, double price, int cnt, double totalsale)
    {
    this.name=name;
    this.price=price;
    this.cnt=cnt;
    this.totalsale=totalsale;
    }
    

	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}

    
    
    public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	 public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	public Double getTotalSale()
	{
	return totalsale;
	}
	public void setTotalSale(double totalsale)
	{
	this.totalsale=totalsale;
	}
	
}