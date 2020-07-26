package entities;

public class ImportedProduct extends Product{

	private Double customsFee;
	
	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String name, Double price, Double customsFree) {
		super(name, price);
		this.customsFee = customsFree;
	}

	public Double getCustomsFree() {
		return customsFee;
	}

	public void setCustomsFree(Double customsFree) {
		this.customsFee = customsFree;
	}
	
	@Override
	public String priceTag() {
		return name + " $" + price + " (Custom fee: $" + customsFee + ")";
	}
}

