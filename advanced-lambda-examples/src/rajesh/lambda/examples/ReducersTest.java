package rajesh.lambda.examples;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class ReducersTest {

	public static void main(String[] args) {
		
		BigInteger answer = LongStream.rangeClosed(1, 21)
									.mapToObj(BigInteger::valueOf)
									.reduce(BigInteger.ONE, BigInteger::multiply);
		System.out.println(answer);
		
	}
}
