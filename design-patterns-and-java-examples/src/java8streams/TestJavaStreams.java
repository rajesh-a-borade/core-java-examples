package java8streams;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class TestJavaStreams {

	public static void main(String[] args) {
		
		
		int my_array[] = {7,8,9,4,5,6,1,2,3,0}; 
		
		for (Integer i : my_array) {
			//// System.out.println(i);
		}
		for(int i = 0; i < my_array.length; i++) {
			if(my_array[i] % 2 == 0) {
				// System.out.println(my_array[i] * 2);
			}
		}
		// System.out.println();
		IntStream.of(my_array)
					.forEach(new IntConsumer() {
						@Override
						public void accept(int value) {
							// System.out.println(value);
						}
					});
		
		
		IntStream.of(my_array)
			.forEach((value) -> {
				// System.out.println(value);
			});
		

		IntStream.of(my_array)
			.filter(value -> value % 2 == 0)
			.map(value -> value * 2)
			.filter(value -> value > 4)
			.sorted()
			.map(value -> value / 2)
			.limit(1)
			.forEach(System.out::println);
		
		
		
		/*
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		List<Integer> list = RandomUtils.getRandomNumbersList(10, 1, 100);
		// convert to array
		int[] int_array = list.stream().mapToInt(i -> i).toArray();

		// System.out.println("Looping - ");
		// looping
		IntStream.of(int_array)
			.forEach(number -> // System.out.println(number));		
		
		
		
		// find statistics
		// System.out.println("Statistics - ");
		int min = IntStream.of(int_array)
							.min()
							.getAsInt();
		// System.out.println(min);
		
		IntStream.of(int_array)
							.min()
							.ifPresent(new IntConsumer() {
								@Override
								public void accept(int value) {
									// System.out.println(value);
								}
							});

		
		IntStream.of(int_array)
							.min()
							.ifPresent(internal_min -> // System.out.println(internal_min));
		
		IntSummaryStatistics statistics = IntStream.of(int_array).summaryStatistics();
		statistics.getMin();
		
		// find 3 distinct smallest integers
		// System.out.println("Smallest 3 - ");
		IntStream.of(int_array)
					.sorted()
					.distinct()
					.limit(3)
					.forEach(number -> // System.out.println(number));
		
		
		// consumers
		// System.out.println("Consumers - ");
		List<Integer> generatedList = IntStream.range(1,10).boxed().collect(Collectors.toList());
		// System.out.println(generatedList);
		
		*/
	}
}
