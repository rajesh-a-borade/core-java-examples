package comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Test {

	public static void main(String[] args) {
		
		Employee e1 = new Employee(1, "C");
		Employee e3 = new Employee(3, "B");
		Employee e2 = new Employee(2, "A");
		
		Set<Employee> set = new TreeSet<>();
		set.add(e3);
		set.add(e1);
		set.add(e2);
		
		for(Employee e : set) {
			// System.out.println(e.toString());
		}
		
		List<Employee> list = new ArrayList<>();
		list.addAll(set);	
		
		
		Collections.sort(list, new NameComparator());
		
		for(Employee e : list) {
			System.out.println(e.toString());
		}
	}
}
