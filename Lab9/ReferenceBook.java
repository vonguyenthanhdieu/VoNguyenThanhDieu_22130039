package Lab9;

import java.util.List;

public class ReferenceBook extends Publication{
	private String field;
	private List<Chapter> listOfChapter;
	public ReferenceBook(String title, int numOfPages, int year, String author, double price, String field,
			List<Chapter> listOfChapter) {
		super(title, numOfPages, year, author, price);
		this.field = field;
		this.listOfChapter = listOfChapter;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public List<Chapter> getListOfChapter() {
		return listOfChapter;
	}
	public void setListOfChapter(List<Chapter> listOfChapter) {
		this.listOfChapter = listOfChapter;
	}
	
	// tìm chương sách nhiều trang nhất của một cuốn sách tham khảo
	Chapter haveTheMostPages() {
		Chapter result = null;
		int max =0;
		for (Chapter c: listOfChapter) 
			if (c.getNumOfPages() > max) {
				max = c.getNumOfPages();
				result = c;
			}
		return result;
	}
	
	 public String toString() {
	        String chapterString = "";
	        for (Chapter chapter : listOfChapter) {
	            chapterString += chapter.toString() + "\n";
	        }

	        return super.toString() + ", Field: " + field + "\nChapters:\n" + chapterString;
	    }
}
