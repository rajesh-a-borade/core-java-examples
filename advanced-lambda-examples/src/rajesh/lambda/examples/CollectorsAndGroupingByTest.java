package rajesh.lambda.examples;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsAndGroupingByTest {

	public static void main(String[] args) {
		Map<String, Long> map = Stream.of("alfa", "bravo", "charlie", "delta", "echo",
		                "foxtrot", "golf", "hotel", "india", "juliet",
		                "kilo", "lima", "mike", "november", "oscar",
		                "papa", "quebec", "romeo", "sierra", "tango",
		                "uniform", "victor", "whiskey", "x-ray", "yankee",
		                "zulu")
				.collect(Collectors.groupingBy(
						word -> word,
						Collectors.counting()));
		
		System.out.println(map);
		
		Map<Integer, List<String>> result = Stream.of("alfa", "bravo", "charlie", "delta", "echo",
                "foxtrot", "golf", "hotel", "india", "juliet",
                "kilo", "lima", "mike", "november", "oscar",
                "papa", "quebec", "romeo", "sierra", "tango",
                "uniform", "victor", "whiskey", "x-ray", "yankee",
                "zulu")
				.collect(Collectors.groupingBy(String::length));
		System.out.println(result);
	}
}
