package entities;

public class OrderItem {
	
	private Integer quantity;
	private Product product;
	private Double priceSale;
	
	public OrderItem() {
	}
	
	public OrderItem(Integer quantity, Double priceSale, Product product) {
		this.product = product;
		this.quantity = quantity;
		this.priceSale = priceSale;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public double getPriceSale() {
		return priceSale;
	}
	
	public void setPriceSale(Double priceSale) {
		this.priceSale = priceSale;
	}
	
	public double subTotal() {
		return quantity * product.getPrice();
	}
	
	@Override
	public String toString() {
		return product.getName() +
				", $" + String.format("%.2f", priceSale) +
				", Quantity: " + quantity +
				", Subtotal: " + String.format("%.2f", subTotal()) + "\n";
	}
}