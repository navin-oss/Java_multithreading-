import java.util.*;

public class demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student> list = new ArrayList<>();
		
		list.add(new Student("Navin" , 101 , 98));
		list.add(new Student("Varad" , 102 , 96));
		
		
//		Comparator<Student> c1 = new SortByName();
//		Comparator<Student> c2 = new SortBymarks();
//		Comparator<Student> c3 = new SortByName();
		
//		Collections.sort(list , new Comparator<Student>() {
//			
//			@Override
//			public int compare(Student s1 , Student s2) {
//				return s1.name.compareTo(s2.name);
//			}
//		});
//		
		
		Collections.sort(list , (s1 , s2) -> s1.marks - s2.marks);
		
		for(Student s : list) {
			System.out.println(s.name + " , " + s.rollNo + " , " + s.marks);
		}
		
		
		

	}

}


//class SortByName implements Comparator<Student>{
//	@Override
//   public int compare(Student s1 , Student s2) {
//		return s1.name.compareTo(s2.name);
//	}
//}
//
//class SortByroll implements Comparator<Student>{
//	@Override
//   public int compare(Student s1 , Student s2) {
//		return s1.rollNo - s2.rollNo ;
//	}
//}
//
//class SortBymarks implements Comparator<Student>{
//	@Override
//   public int compare(Student s1 , Student s2) {
//		return s1.marks - s2.marks ;
//	}
//}


class Student implements Comparable<Student>{
	String name ;
	int rollNo;
	int marks;
	
	public Student(String name , int rollNo , int marks) {
		this.name = name ;
		this.rollNo = rollNo ;
		this.marks = marks ;
		
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.marks - o.marks;
	}
	
//
//    @Override
//    public String toString() {
//        return name + " " + rollNo + " " + marks;
//    }
//	
}