package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
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
		orderItem.add(new OrderItem(quantity, name, price));
	}
	
	public void removeItem(String name) {
		for (OrderItem item : orderItem) {
			if (item.getProductName() == name) {
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
}
