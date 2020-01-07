package rajesh.lambda.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CombineFunctionTest {

	public static void main(String[] args) {
		
		List<Predicate<String>> predicates = new ArrayList<>();
		predicates.add(s -> s != null);
		predicates.add(s -> !s.isEmpty());
		predicates.add(s -> s.length() < 5);

        Predicate<String> combinedPredicate =
                predicates.stream().reduce(s -> true, Predicate::and);
        
        System.out.println(combinedPredicate.test(null));
        System.out.println(combinedPredicate.test(""));
        System.out.println(combinedPredicate.test(" "));
        System.out.println(combinedPredicate.test(" 123 abc "));
	}
}
