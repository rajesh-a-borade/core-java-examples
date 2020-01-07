package rajesh.lambda.examples;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MappersTest {

	private static Character convertIntToChar(int i) {
		char c = (char) i;
		return new Character(c);
	}
	
	private static List<String> expandToListOfStrings(String s) {
		return s.codePoints()
		.mapToObj(MappersTest::convertIntToChar)
		.map(e -> e.toString())
		.collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		
		
		String sample = "Maximilian John Miller";
		List<String> strList = expandToListOfStrings(sample);
		System.out.println(strList);
		
		Stream<String> alphabetStream =
	            Stream.of("alfa", "bravo", "charlie", "delta", "echo",
	                    "foxtrot", "golf", "hotel", "india", "juliet",
	                    "kilo", "lima", "mike", "november", "oscar",
	                    "papa", "quebec", "romeo", "sierra", "tango",
	                    "uniform", "victor", "whiskey", "x-ray", "yankee",
	                    "zulu");
		
		List<String> flatMappedList = alphabetStream
				.flatMap(word -> expandToListOfStrings(word).stream())
				.collect(Collectors.toList());
		System.out.println(flatMappedList);
		
		Stream<String> alphabetStream2 =
	            Stream.of("alfa", "bravo", "charlie", "delta", "echo",
	                    "foxtrot", "golf", "hotel", "india", "juliet",
	                    "kilo", "lima", "mike", "november", "oscar",
	                    "papa", "quebec", "romeo", "sierra", "tango",
	                    "uniform", "victor", "whiskey", "x-ray", "yankee",
	                    "zulu");
		
		Map<String, Integer> map = alphabetStream2.collect(Collectors.toMap(word -> word, word -> word.length()));
		System.out.println(map);
	}
}
