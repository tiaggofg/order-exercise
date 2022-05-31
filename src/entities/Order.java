package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Client client;
	private Date moment;
	private OrderStatus status;
	private List<OrderItem> orderItem = new ArrayList<>();
	
	public Order() {
	}
	
	public Order(OrderStatus status, Date moment, Client client) {
		this.status = status;
		this.moment = moment;
		this.client = client;
	}
	
	public Date getDate() {
		return moment;
	}
	
	public OrderStatus getStatus() {
		return status;
	}
	
	public void addItem(int quantity, String name, double price) {
		orderItem.add(new OrderItem(quantity, new Product(name, price)));
	}
	
	public void removeItem(String name) {
		for (OrderItem item : orderItem) {
			if (item.getProduct().getName() == name) {
				orderItem.remove(item);
			} else {
				continue;
			}
		}
	}
	
	public double total(List<OrderItem> orderItem) {
		double totalValue = 0;
		for (OrderItem item : orderItem) {
			totalValue += item.subTotal();
		}
		return totalValue;
	}
	
	@Override
	public String toString() {
		StringBuilder orderSumary = new StringBuilder();
		
		orderSumary.append("\nORDER SUMARY:\n");
		orderSumary.append("Order Moment: " + sdf.format(moment) + "\n");
		orderSumary.append("Order Status: " + status + "\n");
		orderSumary.append("Client: " + client.getName() + " (" + client.getBithDate() + ") - " + client.getEmail() + "\n");
		orderSumary.append("Order items:\n");
		
		for (OrderItem item : orderItem) {
			orderSumary.append(
					item.getProduct().getName() +
					", $" + item.getProduct().getPrice() +
					", Quantity: " + item.getQuantity() +
					", Subtotal: $" + item.subTotal()
			);
		}
		orderSumary.append("Total price: " + this.total(orderItem));
		
		return String.valueOf(orderSumary);
	}
}
