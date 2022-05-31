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
	
	public Product getProduct() {
		return product;
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