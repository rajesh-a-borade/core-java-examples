package singleton;




class MyClass {
	
	private int x;
	
	public MyClass(int x) {
		this.x = x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getX() {
		return x;
	}
}

public class Test {
	

	public static void main(String[] args) {
		
		
		final MyClass myClass1 = new MyClass(1);
		// MyClass myClass2 = new MyClass(2);
		// myClass1 = myClass2;
		myClass1.setX(3);
		
		Singleton S1 = Singleton.getInstance();
		
		S1.setX(1);
		S1.setY(2);
	}
}
