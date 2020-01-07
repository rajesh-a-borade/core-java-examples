package constructorchaining;

public class Employee implements Comparable<Employee>{

	private int id;
	private String name;

	
	
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		return this.getId() == ((Employee) obj).getId();
	}
	
	@Override
	public String toString() {
		return this.getId() + " " + this.getName();
	}

	@Override
	public int compareTo(Employee emp) {
		
		if(this.getId() > emp.getId()) {
			return 1;
		}
		if(this.getId() < emp.getId()) {
			return -1;
		}
		return 0;
	}
}
