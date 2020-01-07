package anonymous;

interface MyInterface {
	public void show();
}

public class Test {

	public static void someMethod(MyInterface m) {
		m.show();
	}
	
	public static void main(String[] args) {
		
		someMethod(new MyInterface() {
			@Override
			public void show() {
				System.out.println("Hello Anonymous");
			}
		});
		
	}
}
