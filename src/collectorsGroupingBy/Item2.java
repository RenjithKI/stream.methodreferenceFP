package collectorsGroupingBy;

import java.math.BigDecimal;

public class Item2 {

    private String name;
    private int qty;
    private Long price;   
    
	public Item2(String name, int qty, Long price) {
		
		this.name = name;
		this.qty = qty;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public int getQty() {
		return qty;
	}
	public Long getPrice() {
		return price;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public void setPrice(Long price) {
		this.price = price;
	}

    //constructors, getter/setters 
    
}