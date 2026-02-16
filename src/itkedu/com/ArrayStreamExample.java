package itkedu.com;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ArrayStreamExample {

	public static void main(String[] args) {
		
		String[] words={"Hello", "Java"};
		List<String> str=Arrays.asList("Hello","world", "Java");
		//create a stream
		Stream<String> stream1=str.stream();
		stream1.forEach(System.out::println);
		
		//create a stream from an array
		Stream<String> stream=Arrays.stream(words);
		stream.forEach(System.out::println);
		
		//Using the static method Stream.of() to pass elements
		Stream<String> stream2= Stream.of("Hello","world","java");//create a stream from elements
		stream2.forEach(System.out::println);
	}

}
