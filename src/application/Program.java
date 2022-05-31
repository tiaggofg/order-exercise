package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter client data:\nName: ");
		String clientName = sc.nextLine();
		
		System.out.print("Email: ");
		String email = sc.nextLine();
		
		System.out.print("Birth Date(DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.nextLine());
		
		System.out.print("\nEnter order data:\nStatus: ");
		OrderStatus status = OrderStatus.valueOf(sc.nextLine());

		Order order = new Order(status, new Date(), new Client(clientName, email, birthDate));
		
		System.out.print("How many items to this order? ");
		int itemsQuantity = sc.nextInt();
		
		for (int i = 1; i <= itemsQuantity; i++) {
			System.out.print("\nEnter #" + i + " item data:\nProduct name: ");
			String name = sc.next();
			
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			order.addItem(quantity, name, price);
		}
		
		System.out.println(order);
		
		sc.close();
	}

}
