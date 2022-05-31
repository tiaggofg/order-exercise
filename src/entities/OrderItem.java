package entities;

public class OrderItem {
	
	private int quantity;
	private Product product;
	
	public OrderItem() {
	}
	
	public OrderItem(int quantity, Product product) {
		this.product = product;
		this.quantity = quantity;
	}
	
	public String getProductName() {
		return product.getName();
	}
	
	public double getProductPrice() {
		return product.getPrice();
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double subTotal() {
		return quantity * product.getPrice();	
	}

}