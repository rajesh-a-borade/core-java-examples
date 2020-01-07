package rajesh.lambda.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




@FunctionalInterface
interface MyConsumerInterface<T> {
	
	public abstract void consume(T t);

	public default MyConsumerInterface<T> andThen(MyConsumerInterface<T> other) {
		return (T t) -> { 
			this.consume(t);
			other.consume(t); 
		};
		
	};
	
	
}

public class Consumer2Consumers {

	public static void main(String[] args) {
		
		
		List<String> arrList = new ArrayList<>(Arrays.asList("a", "b", "c"));
		
		MyConsumerInterface<List<String>> c1 = list -> list.add("c1");
		MyConsumerInterface<List<String>> c2 = list -> list.add("c2");
		
		MyConsumerInterface<List<String>> c3 = c1.andThen(c2);
		
		c3.consume(arrList);
		
		System.out.println(arrList);
	}
}
