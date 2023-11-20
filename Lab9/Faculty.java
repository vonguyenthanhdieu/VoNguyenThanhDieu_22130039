package Lab9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Faculty {
	private String name;
	private String address;
	private List<Course> courses;
	public Faculty(String name, String address, List<Course> courses) {
		this.name = name;
		this.address = address;
		this.courses = courses;
	}
	//trả về course thực hành có nhiều sinh viên đăng ký nhất.
	public Course getMaxPraticalCourse() {
		Course result = null;
		for (Course c: courses) 
			if (c.isPractice()) 
				if (result == null || c.countStudent() > result.countStudent()) {
					result = c;
				}	
		return result;
	}
	
	//thống kê danh sách sinh viên theo năm vào học, với key
	//là năm vào học và value là các sinh viên tương ứng
	public Map<Integer, List<Student>> groupStudentsByYear(){
		Map<Integer, List<Student>> re = new HashMap<>();
		for (Course c: courses) {
			for (Student st: c.getStudents()) {
				int key = st.getYear();
				if (!re.containsKey(key)) {
					List<Student> values = new ArrayList<>();
					values.add(st);
					re.put(key, values);
				}
				else {
					List<Student> values = re.get(key);
					if (!values.contains(st))
						values.add(st);
				}
			}
			
		}
		return re;
	}
	
//	public Map<Integer, List<Student>> groupStudentsByYear() {
//        Map<Integer, List<Student>> studentByYear = new HashMap<>();
//        for (Course course : courses) {
//            List<Student> students = course.getStudents();
//            for (Student student : students) {
//                int year = student.getYear();
//                if (!studentByYear.containsKey(year)) {
//                    studentByYear.put(year, new ArrayList<>());
//                }
//                studentByYear.get(year).add(student);
//            }
//        }
//        return studentByYear;
//    }
	
	// trả về các course theo loại cho trước (type). 
	// Các course được sắp xếp giảm dần theo số 
	// lượng sinh viên đăng ký học
	
//	public Set<Course> filterCourse(String type){
//		
//		Set<Course> re = new TreeSet<Course>(new Comparator<>() {
//		});
//		for (Course c: courses) {
//			if( c.compareToType(type) == 0) 
//				re.add(c);
//		}
//		
//		return re;
//	}
	
	public Set<Course> filterCourse(String type) {
        Set<Course> re = new TreeSet<>((c1, c2) -> c2.getStudents().size() - c1.getStudents().size());
        for (Course course : courses) {
            if (course.getType().equals(type)) {
                re.add(course);
            }
        }
        return re;
    }

	
	public static void main(String[] args) {
		Student s1 = new Student("001", "Nguyễn Thị A", 2004);
		Student s2 = new Student("002", "Bành Văn Khôi", 2003);
		Student s3 = new Student("003", "Nguyễn Thị Bưởi", 2004);
		Student s4 = new Student("004", "Phạm Bạch Tuyết", 2004);
		Student s5 = new Student("005", "Hoàng Văn Thụ", 2003);
		Student s6 = new Student("006", "Chu Văn Bá", 2003);
		
		List<Student> listst1 = new ArrayList<>();
		listst1.add(s1);
		listst1.add(s2);
		listst1.add(s3);
		listst1.add(s4);
		
		List<Student> listst2 = new ArrayList<>();
		listst2.add(s1);
		listst2.add(s4);
		listst2.add(s5);
		
		List<Student> listst3 = new ArrayList<>();
		listst3.add(s5);
		listst3.add(s6);
		
		List<Student> listst4 = new ArrayList<>();
		listst4.add(s4);
		listst4.add(s5);
		listst4.add(s6);
		listst4.add(s2);
		listst4.add(s3);
		
		Course c1 = new Course("01", "Toán rời rạc", "Lý thuyết", listst1, "1");
		Course c2 = new Course("02", "Xác suất thống kê", "Lý thuyết", listst2, "2");
		Course c3 = new Course("03", "Lập trình nâng cao", "Thực hành", listst3, "3");
		Course c4 = new Course("04", "Cấu trúc dữ liệu", "Thực hành", listst4, "4");
		
		List<Course> listC = new ArrayList<>();
		listC.add(c1);
		listC.add(c2);
		listC.add(c3);
		listC.add(c4);
		
		Faculty fac = new Faculty("Khoa công nghệ thông tin", "Đại học Nông Lâm", listC);
		
		System.out.println(fac.getMaxPraticalCourse().toString());
		System.out.println(fac.groupStudentsByYear().toString());
		System.out.println(fac.filterCourse("Thực hành"));
	}
}
