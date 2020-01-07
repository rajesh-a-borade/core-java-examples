package rajesh.lambda.examples;

@FunctionalInterface
interface MyPredicate<T> {
	
	public abstract boolean test(T t);
	
	public default MyPredicate<T> and(MyPredicate<T> other) {
		return (T t) -> {
			return this.test(t) && other.test(t);
		};
	}
}

public class PredicateChainTest {

	public static void main(String[] args) {
		
		MyPredicate<String> isNotNull = s -> s != null;
		MyPredicate<String> isNotEmpty = s -> !s.isEmpty();
		
		MyPredicate<String> stringValidPredicate = isNotNull.and(isNotEmpty);
		
		System.out.println(stringValidPredicate.test(null));
		System.out.println(stringValidPredicate.test(""));
		System.out.println(stringValidPredicate.test("   "));
		System.out.println(stringValidPredicate.test(" 1 "));
		System.out.println(stringValidPredicate.test(" 12 345 "));
	}
}
