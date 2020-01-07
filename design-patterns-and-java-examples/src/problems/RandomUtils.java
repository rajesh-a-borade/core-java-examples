package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomUtils {

	public static Integer generateRandom(int low, int high) {
		Random r = new Random();
		int result = r.nextInt(high - low) + low;
		return result;
	}
	
	public static List<Integer> getRandomNumbersList(int total, int low, int high) {
		
		List<Integer> list = new ArrayList<Integer>();
		for(int index=0; index < total; index++) {
			list.add(generateRandom(low, high));
		}
		return list;
	}
	
	// TEST
	public static void main(String[] args) {
		System.out.println(getRandomNumbersList(10, 1, 100));
	}
}

