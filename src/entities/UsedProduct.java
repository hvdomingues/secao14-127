package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {
	
	private Date manufactureDate;
	private static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	
	public UsedProduct() {
		super();
	}
	
	public UsedProduct(String name, Double price, Date manufactereDate) {
		super(name,price);
		this.manufactureDate = manufactereDate;
	}
	
	public Date getManufactereDate() {
		return manufactureDate;
	}

	public void setManufactereDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	@Override
	public String priceTag() {
		return name + " (used) $ " + String.format("%.2f", price) + " (Manufacture Date: " + sdf1.format(manufactureDate) + ")\n";
	}
	
}
