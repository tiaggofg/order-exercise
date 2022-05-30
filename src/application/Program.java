package application;

import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Order order = new Order(OrderStatus.PENDING_PAYMENT, new Date(), new Client());
		
		int itemsQuantity = sc.nextInt();
		
		for (int i = 0; i < itemsQuantity; i++) {
			String name = sc.nextLine();
			int quantity = sc.nextInt();
			double price = sc.nextDouble();
			
			order.addItem(quantity, name, price);
			
		}
		
		sc.close();

	}

}
