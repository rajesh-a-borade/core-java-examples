package hashcode_equals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
	
	@SuppressWarnings("unchecked")
    public static void main(String[] args) {
		
		Student s1 = new Student(106, "D");
		Student s2 = new Student(102, "B");
		Student s3 = new Student(104, "X");
		Student s4 = new Student(101, "Z");
		
		Set<Student> set = new HashSet<>();
		set.add(s1);set.add(s2);set.add(s3);set.add(s4);
		
//		Map<Student, String> map = new HashMap<>();
//		
//		map.put(s1, "lee");
//		map.put(s4, "LeE");
//		System.out.println(map);
//		
		System.out.println(set);       
		
		StudentComparator studentComparator = new StudentComparator();
		List<Student> list = new ArrayList<Student>(set);
		Collections.sort(list,studentComparator); 
		 
		System.out.println(list);
		
		// System.out.println(s1.hashCode());
		// System.out.println(s2.hashCode());
		// System.out.println(s3.hashCode());
	}

}
