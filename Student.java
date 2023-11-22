package Lab9;

public class Student {
	private String id, name;
	private int year;
	public Student(String id, String name, int year) {
		this.id = id;
		this.name = name;
		this.year = year;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	// so sánh hai sinh viên có bằng nhau hay không
	boolean equals (Student that) {
		return (this.id.equals(that.id)&& this.name.equals(that.name) && this.year == that.year);
	}
	
	public String toString() {
		return this.id + "\t" + this.name + "\t" + this.year + "\t";
	}
	// kiểm tra xem trong danh sách co sinh viên đã cho hay không
}
