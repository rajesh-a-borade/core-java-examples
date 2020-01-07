package hashcode_equals;



public class Student{

	private int roll;
	private String name;
	
	public Student() {
	}
	
	public Student(int roll, String name) {
		this.roll = roll;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		Student sObj = ((Student)obj);
		return this.getRoll() == (sObj.getRoll());
	}
	
	public int getRoll() {
		return roll;
	}
	
	public void setRoll(int roll) {
		this.roll = roll;
	}
	
	@Override
	public int hashCode() {
		
		return this.getRoll();
	}

	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + "]";
	}
	

//	
//	public int compareTwoStudents(Student s1,Student s2) {   
//	    
//	    StudentComparator sc = new StudentComparator();
//	    return sc.compare(s1, s2);
//	    
//	    
//	}
//	
}
