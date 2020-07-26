package entities;

public class ImportedProduct extends Product{

	private Double customsFee;
	
	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public Double getCustomsFree() {
		return customsFee;
	}

	public void setCustomsFree(Double customsFree) {
		this.customsFee = customsFree;
	}
	
	@Override
	public String priceTag() {
		return name + " $ " + String.format("%.2f",(price + customsFee)) + " (Custom fee: $" + customsFee + ")";
	}
}

