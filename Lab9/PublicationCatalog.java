package Lab9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PublicationCatalog {
	List<Publication> listOfPublication;

	public PublicationCatalog(List<Publication> listOfPublication) {
		this.listOfPublication = listOfPublication;
	}
	
	
	//phương thức xác định loại ấn phẩm (Tạp chí hay sách tham khảo)
	public String isTypeOfPublication(Publication p) {
		if (p.isMagazine())
			return "Tạp Chí";
		else return "Sách tham khảo";
	}
	
	//phương thức kiểm tra ấn phẩm là tạp chí và có thời gian
	// xuất bản cách đây (2021) 10 năm hay không
	public boolean isMagezinePublished10Years(Publication p) {
		return (p.isMagazine() && p.getYear() == 2011);
			
	}
	
	//kiểm tra xem hai ấn phẩm này có cùng loại và cùng
	// tác giả hay không
	public boolean isSameTypeAndSameAuthor(Publication p1, Publication p2) {
		return p1.isSameTypeAndSameAuthor(p2);
	}
	
	//tính tổng tiền của tất cả các ấn phẩm trong nhà sách
	public double totalAmount() {
		double result = 0.0;
		for (Publication p : listOfPublication) 
			result += p.getPrice();
		return result;
	}
	
	// tìm quyển sách tham khảo có chương sách nhiều nhất
	public Publication haveTheMostPage() {
		Publication result = null;
		int max =0;
		for (Publication p : listOfPublication) {
			if (!p.isMagazine()) 
				if (p.haveTheMostPages().getNumOfPages() > max) {
					max = p.haveTheMostPages().getNumOfPages();
					result = p;
				}	
		}
		return result;
	}
	
	//tìm xem trong danh sách các ấn phẩm có chứa một tạp chí
	// có tên cho trước hay không
	public boolean isContainMagazineName(String name) {
		for (Publication p: listOfPublication) {
			if (p.isMagazine()) {
				Magazine m = (Magazine) p;
				if (m.getName().equals(name))
					return true;
			}
		}
		return false;
	}
	
	//Lấy danh sách các tạp chí được xuất bản vào 1 năm cho trước
	public List<Publication> getMagazinesByYear(int year) {
        List<Publication> listOfMagazines = new ArrayList<>();
        for (Publication p : listOfPublication) {
            if (p.isMagazine() && p.year == year) {
                listOfMagazines.add(p);
            }
        }
        return listOfMagazines;
    }
	
	
	class PublicationComparator implements Comparator<Publication> {
	    @Override
	    public int compare(Publication p1, Publication p2) {
	        return p1.getTitle().compareTo(p2.getTitle());
	    }
	}
	
	
	//Sắp xếp ấn phẩm tăng dần theo tiêu đề và giảm dần theo
	// năm xuất bản (sử dụng interface Comparable hoặc Comparator)
	public void sortByTitleAndYear() {
		Collections.sort(listOfPublication);
		for (Publication p: listOfPublication) {
			System.out.println(p.toString());
		}
	}
	
	//Thống kê số lượng ấn phẩm theo năm xuất bản
	 public Map<Integer, Integer> getPublicationCountByYear() {
	        Map<Integer, Integer> publicationCountByYear = new HashMap<>();

	        for (Publication publication : listOfPublication) {
	            int year = publication.getYear();
	            publicationCountByYear.put(year, publicationCountByYear.getOrDefault(year, 0) + 1);
	        }

	        return publicationCountByYear;
	    }
	
	 public static void main(String[] args) {
		 
		 //Chapter
		 Chapter c1 = new Chapter("chap 11", 9);
		 Chapter c2 = new Chapter("chap 12", 3);
		 Chapter c3 = new Chapter("chap 13", 10);
		 Chapter c4 = new Chapter("chap 21", 13);
		 Chapter c5 = new Chapter("chap 22", 7);
		 
		 List<Chapter> listOfChapter1 = new ArrayList<>();
		 listOfChapter1.add(c1);
		 listOfChapter1.add(c2);
		 listOfChapter1.add(c3);
		 
		 List<Chapter> listOfChapter2 = new ArrayList<>();
		 listOfChapter2.add(c4);
		 listOfChapter2.add(c5);
		 
		 // Add some publications
		 Magazine m1 = new Magazine("Magazine 1", 50, 2020, "Author 1", 10.0, "Magazine A");
		 Magazine m2 = new Magazine("Magazine 2", 40, 2011, "Author 1", 8.0, "Magazine B");
		 Magazine m3 = new Magazine("Magazine 3", 30, 2021, "Author 3", 12.0, "Magazine C");
		 ReferenceBook r1 = new ReferenceBook("Reference Book 1", 200, 2020, "Author 1", 20.0, "Field A", listOfChapter1);
		 ReferenceBook r2 = new ReferenceBook("Reference Book 1", 150, 2021, "Author 2", 18.0, "Field B", listOfChapter2);
		 
		 List<Publication> listOfPublication = new ArrayList<>();
	     listOfPublication.add(m1);
	     listOfPublication.add(m2);
	     listOfPublication.add(m3);
	     listOfPublication.add(r1);
	     listOfPublication.add(r2);
	     
	     PublicationCatalog catalog = new PublicationCatalog(listOfPublication);
	     
	     System.out.println(catalog.isTypeOfPublication(r1));
	     System.out.println();
	     System.out.println(catalog.isMagezinePublished10Years(m2));
	     System.out.println(catalog.isMagezinePublished10Years(r2));
	     System.out.println();
	     System.out.println(catalog.isSameTypeAndSameAuthor(m1, r2));
	     System.out.println();
	     System.out.println(catalog.totalAmount());
	     System.out.println();
	     System.out.println(catalog.haveTheMostPage().toString());
	     System.out.println();
	     System.out.println(catalog.isContainMagazineName("Magazine A"));
	     System.out.println();
	     System.out.println(catalog.getMagazinesByYear(2021));
	     System.out.println("Sort");
	     catalog.sortByTitleAndYear();
	     System.out.println();
	     Map<Integer, Integer> publicationCountByYear = catalog.getPublicationCountByYear();
	        // Print the publication count by year
	        for (Map.Entry<Integer, Integer> entry : publicationCountByYear.entrySet()) {
	            System.out.println(entry.getKey() + ": " + entry.getValue());
	        }
	 } 
}
