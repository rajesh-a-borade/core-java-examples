package java8streams;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamSequence {
	
	public static void main(String[] args) {
		
		int[] int_array = {9,8,7,6,5,4,3,2,1,0};
		IntStream.of(int_array)
				 .parallel()
				 .mapToObj(val -> String.valueOf(val))
				 .map(Integer::parseInt)
				 .map(String::valueOf)
				 .mapToInt(val -> Integer.parseInt(val))
				 .filter(x -> x % 2 == 0)
				 .sorted()
				 .mapToObj(val -> String.valueOf(val))
				 .map(val -> new Integer(val))
				 .collect(Collectors.toList())
				 .stream()
				 .sorted(Comparator.reverseOrder())
				 .limit(3)
				 .map(x -> x * 2)
				 .forEach(System.out::println);
	}
}
