package Task2;

public class OrderItem implements Comparable<OrderItem>{
	private Product p;
	private int quality;
	public OrderItem(Product p, int quality) {
		this.p = p;
		this.quality = quality;
	}
	@Override
	public int compareTo(OrderItem o) {
		// TODO Auto-generated method stub
		return p.compareTo(o.p);
	}
	
	public String getType() {
		return this.p.getType();
	}

	public double getPrice() {
		return this.p.getPrice();
	}

	public Product getP() {
		return p;
	}
	public void setP(Product p) {
		this.p = p;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return p + ": " + quality;
	}
}
