package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {
	
	private Date manufactereDate;
	private static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	
	public UsedProduct() {
		super();
	}
	
	public UsedProduct(String name, Double price, Date manufactereDate) {
		super(name,price);
		this.manufactereDate = manufactereDate;
	}
	
	public Date getManufactereDate() {
		return manufactereDate;
	}

	public void setManufactereDate(Date manufactereDate) {
		this.manufactereDate = manufactereDate;
	}
	
	@Override
	public String priceTag() {
		return name + " (used) $ " + String.format("%.2f", price) + " (Manufactere Date: " + sdf1.format(manufactereDate) + ")\n";
	}
	
}
