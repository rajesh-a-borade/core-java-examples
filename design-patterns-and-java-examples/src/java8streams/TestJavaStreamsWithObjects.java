package java8streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestJavaStreamsWithObjects {

	public static void main(String[] args) {
		
		// populate some data
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee(1, "A", 1000, false));
		employeeList.add(new Employee(2, "B", 1500, true));
		employeeList.add(new Employee(3, "C", 6000, true));
		employeeList.add(new Employee(4, "D", 3500, true));
		employeeList.add(new Employee(5, "E", 3000, false));
		employeeList.add(new Employee(6, "F", 2000, true));
		employeeList.add(new Employee(7, "G", 5000, true));
		
		Comparator<Employee> salaryComparator = (o1, o2)-> new Integer(o1.getSalary()).compareTo(new Integer(o2.getSalary()));
				
		employeeList.stream()
					.sorted(salaryComparator)
					.filter(Employee::isActive)
					.limit(3)
					.map(Employee::getName)
					.collect(Collectors.toList())
					.stream()
					.forEach(e -> System.out.println(e));
	}
}
