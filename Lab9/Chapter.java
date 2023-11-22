package Lab9;

public class Chapter {
	private String title;
	private int numOfPages;
	public Chapter(String title, int numOfPages) {
		this.title = title;
		this.numOfPages = numOfPages;
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
	
	  public String toString() {
	        return "Chapter Title: " + title + ", Number of pages: " + numOfPages;
	    }
}
