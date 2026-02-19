package itkedu.com;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TypesOfStream {

	public static void main(String[] args) {
		
		List<String> names= Arrays.asList("E","D","C","A","C","B");
		//Sequential stream
		names.stream().forEach(System.out::println);
		
		//Paralle stream
		names.parallelStream().forEach(n -> System.out.println(n + " "+ Thread.currentThread().getName()));
		
		// Infine stream
		Stream.iterate(1, n-> n+1).limit(6).forEach(System.out::println);
		
		//Primitive Streams
		IntStream.range(1, 5).forEach(System.out::println);
		}
}
