package Lab9;

public abstract class Publication implements Comparable<Publication> {
	protected String title;
	protected int numOfPages;
	protected int year;
	protected String author;
	protected double price;
	public Publication(String title, int numOfPages, int year, String author, double price) {
		this.title = title;
		this.numOfPages = numOfPages;
		this.year = year;
		this.author = author;
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getNumOfPages() {
		return numOfPages;
	}
	public void setNumOfPages(int numOfPages) {
		this.numOfPages = numOfPages;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	//kiểm tra xem ấn phẩm này có phải là tạp chí không
	public boolean isMagazine() {
		return this instanceof Magazine;
	}
	
	//kiểm tra xem hai ấn phẩm này có cùng loại và cùng
	// tác giả hay không
	public boolean isSameTypeAndSameAuthor(Publication o) {
		if ((this.isMagazine() && o.isMagazine()) || (!this.isMagazine() && !o.isMagazine()))
			return this.getAuthor().equals(o.getAuthor());
		else
			return false;
	}
	
	@Override
    public int compareTo(Publication other) {
        int titleComparison = this.title.compareTo(other.title);
        if (titleComparison != 0) {
            return titleComparison;
        }
        return Integer.compare(other.year, this.year);
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Number of pages: " + numOfPages
                + ", Year: " + year + ", Author: " + author
                + ", Price: " + price;
    }
	
	abstract Chapter haveTheMostPages();
}
