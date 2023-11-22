package Lab9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course {
	private String id, title, type;
	private List<Student> students;
	private String lecturer;
	
	public Course(String id, String title, String type, List<Student> students, String lecturer) {
		this.id = id;
		this.title = title;
		this.type = type;
		this.students = students;
		this.lecturer = lecturer;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public String getLecturer() {
		return lecturer;
	}
	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}
	
	int countStudent() {
		return students.size();
	}
	
	boolean isPractice() {
		return this.type.equals("Thực hành");
	}
//	Map<Integer, List<Student>> groupStudentByYear(){
//		Map<Integer, List<Student>> map = new HashMap<>();
//		for (Student s: students) {
//			int key = s.getYear();
//			if (!map.containsKey(key)) {
//				List<Student> values = new ArrayList<Student>();
//				map.put(key, values);
//				map.get(key).add(s);
//			} else
//				if(!map.get(key).contains(s))
//					map.get(key).add(s);
//		}
//		return map;
//	}
	
	
	public String toString() {
		return this.id + "\t" + this.title + "\t" + this.type + "\t";
	}
}
