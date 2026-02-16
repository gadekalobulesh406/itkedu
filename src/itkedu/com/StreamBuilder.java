package itkedu.com;

import java.util.stream.Stream;

public class StreamBuilder {

	public static void main(String[] args) {
		
		Stream.Builder<String> builder = Stream.builder();
		builder.add("Hello");
		builder.add("World");
		builder.add("Java");
		
		Stream<String> stream = builder.build();
		stream.forEach(System.out::println);
		
		// creating an infinite stream based on a generator function
		Stream<Double> stream1 = Stream.generate(Math::random);
		stream1.limit(3) //limit the number of elements
		.forEach(System.out::println);
		
		//Using Stream.iterate()
		Stream<Integer> stream3= Stream.iterate(0, n->n+2);
		stream3.limit(5).forEach(System.out::println);
		
	}
	
}
