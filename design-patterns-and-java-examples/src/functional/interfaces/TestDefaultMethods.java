package functional.interfaces;

@FunctionalInterface
interface Interface1 {

	void method1(String str);
	
	default void log(String str){
		System.out.println("I1 logging::"+str);
	}
	
	default void custom(String str){
		System.out.println("I1 logging::custom "+str);
	}
	
	static void print(String str){
		System.out.println("Printing "+str);
	}
	
	//trying to override Object method gives compile time error as
	//"A default method cannot override a method from java.lang.Object"
	
	//	default String toString(){
	//		return "i1";
	//	}	
}

@FunctionalInterface
interface Interface2 {

	void method2();
	
	default void log(String str){
		System.out.println("I2 logging::"+str);
	}

}

class MyClass implements Interface1, Interface2 {

	@Override
	public void method2() {
		System.out.println("MyClass::method2");
	}

	@Override
	public void method1(String str) {
		System.out.println("MyClass::method1 " + str);
	}

	//MyClass won't compile without having it's own log() implementation
		@Override
		public void log(String str){
			Interface1.super.log(str);
			System.out.println("MyClass logging::"+str);
			Interface1.print("abc");
		}
	
}

public interface TestDefaultMethods {

	public static void main(String[] args) {
		Interface1 one = new Interface1() {
			
			@Override
			public void method1(String str) {
				System.out.println("Anonymous " + str);
			}
		};
		
		one.method1("from Main -> ");
		one.log(" From Main log() ");
		
		Interface1.print("static from Main ");
		
		System.out.println("-----");
		
		Interface2 interface2 = new MyClass();
		
		interface2.log("123");
		
	}
}
