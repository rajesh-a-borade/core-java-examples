package generics;

import java.io.Closeable;
import java.io.DataInput;
import java.util.ArrayList;
import java.util.List;


class Employee {}

public class Test {
	
	
	public <T extends DataInput & Closeable> void operation(T one, T two) {
	}
	
	// List<? super F>
	public <T extends Number> double add(T one, T two)
	{
	    return one.doubleValue() + two.doubleValue(); 
	}
	
	public static Integer add(Integer a, Integer b) {
		return a + b;
	}
	
	public static Float add(Float a, Float b) {
		return a + b;
	}
	
	public static void main(String[] args) {
		
		
		//Map<String, Object> cvpSession = new HashMap();		
		
		
		Employee e = new Employee();
		
		// pre jdk 1.5 - We need generics to avoid run time errors
		List<Employee> list = new ArrayList<>();
		list.add(e);
		//list.add("abc");
		//list.add(1);
		
		// System.out.println(list);
		
		for(Object c : list) {
			Employee emp = (Employee) c; 
			System.out.println(emp);
		}
		 		
		System.out.println(add(1, 2));
		Float f1 = 0.1f;
		Float f2 = 0.2f;
		System.out.println(add(f1,f2));
		// generics
		
	}
}
