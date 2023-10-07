package Task2;

import java.util.Arrays;
import java.util.Comparator;

public class Order {
	private OrderItem[] items;
	public Order(OrderItem[] items) {
		super();
		this.items = items;
	}
	
	
	public double cost() {
		double result = 0;
		for (int i = 0; i < items.length; i++) {
			result += items[i].getPrice();
		}
		return result;
	}
	// using binary search approach
	public boolean contains(Product p) {
		Arrays.sort(this.items);
		int low = 0;
		int high = items.length-1;
		while (low <= high) {
			int mid = (low+high)/2;
			if (p.compareTo(items[mid].getP()) == 0) {
				return true;
			}
			if(p.compareTo(items[mid].getP()) < 0) high = mid - 1;
			else low = mid + 1;
		}
		return false;
	}
	
	// get all products based on the given type using 
	//linear search
	public Product[] filter(String type) {
		int count = 0;
		for (int i = 0; i < items.length; i++) {
			if(items[i].getType().equals(type)) count++;
		}
		Product[] result = new Product[count];
		for (int i = 0; i < items.length; i++) {
			if(items[i].getType().equals(type)) {
				result[--count] = items[i].getP();
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Product p1 = new Product("001", "Coca Cola", 9.0, "Drink");
		Product p2 = new Product("002", "Chips", 8.5, "Snack");
		Product p3 = new Product("003", "Pepsi", 8.0, "Drink");
		
		OrderItem it1 = new OrderItem(p1, 2);
		OrderItem it2 = new OrderItem(p2, 2);
		OrderItem it3 = new OrderItem(p3, 2);
		
		OrderItem[] items = {it1, it2, it3};
		
		Order order = new Order(items);
		
		System.out.println(order.cost());
		System.out.println(order.contains(p1));
		System.out.println(order.contains(p3));
		System.out.println(Arrays.toString(order.filter("Drink")));
	}
	
}
