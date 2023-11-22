package Lab9;

public class Magazine extends Publication{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Magazine(String title, int numOfPages, int year, String author, double price, String name) {
		super(title, numOfPages, year, author, price);
		this.name = name;
	}
	
	Chapter haveTheMostPages() {
		return null;
	}
	
	public String toString() {
        return super.toString() + ", Magazine Name: " + name;
    }
	
}
