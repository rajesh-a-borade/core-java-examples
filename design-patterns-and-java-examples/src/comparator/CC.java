package comparator;


class Base {
	
	static {
		System.out.println("Base Static");
	}
	public Base() {
		System.out.println("Base()");
	}
	
	void show() {
		System.out.println("Base show()");
	}
}


class Child extends Base {
	
	static {
		System.out.println("Child Static");
	}
	public Child() {
		System.out.println("Child()");
	}
}


public class CC {
	
	public static void main(String[] args) {
		Base b = new Child();
		b.show();
	}

}
