package multithreading.streams;

import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Stream;

public class FastFind {

	public static void main(String[] args) {
		
		/*
		List<Integer> list = new Random().ints(1, 50).limit(50).boxed().collect(Collectors.toList());
		
		System.out.println("Total values - " + list.size());
		System.out.println(list);
		System.out.println("***");
		long startSeq = System.currentTimeMillis();
		int maxBySeq = list.stream().collect(Collectors.summarizingInt(Integer::intValue)).getMax();
		long endSeq = System.currentTimeMillis();
		System.out.println("***maxBySeq");
		System.out.println(maxBySeq);
		System.out.println("***");
		System.out.println("Time taken - " + (endSeq - startSeq));
		System.out.println("***");
		
		long startPar = System.currentTimeMillis();
		int maxByPar = list.parallelStream().collect(Collectors.summarizingInt(Integer::intValue)).getMax();
		long endPar = System.currentTimeMillis();
		System.out.println("***maxByPar");
		System.out.println(maxByPar);
		System.out.println("***");
		System.out.println("Time taken - " + (startPar - endPar));
		
		*/
		
		
		Stream<Integer> intStream = new Random().ints(1, 100).limit(10).boxed();
		intStream.forEach(System.out::println);
		System.out.println();
		System.out.println("***");
		//Integer maxValue = intStream.max(Integer::compare).get();
		OptionalInt max = intStream.mapToInt(Integer::intValue).max();
		System.out.println();
		System.out.println("***");
		System.out.println(max);
		
	}
}
