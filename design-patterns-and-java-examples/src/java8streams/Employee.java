package java8streams;

public class Employee implements Comparable<Employee> {
	
	private int id;
	private String name;
	private int salary;
	private boolean isActive;
	
	public Employee(int id, String name, int salary, boolean isActive) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.isActive = isActive;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public boolean isActive() {
		return isActive;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", isActive=" + isActive + "]";
	}

	@Override
	public int compareTo(Employee o) {
		
		return new Integer(this.id).compareTo(new Integer(o.getId()));
	}
	
}
