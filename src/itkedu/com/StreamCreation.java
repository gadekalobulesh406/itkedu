package itkedu.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamCreation {
public static void main(String[] args) {
	//from collection
	List<String> list = new ArrayList<>();
	list.add("Hello");
	list.add("java");
	list.add("java 8");

	Stream<String> stream=list.stream();
	
	//from a arrray
	String[] arr= {"a","b","c"};
	Stream<String> stream2 = Arrays.stream(arr);
	
	//Using stream.of()
	 Stream<Integer> stream3 = Stream.of(1,2,3,6,4);
	 
	 //Infinite stream  [limit to avoid  infinite loop]
	 Stream<Integer> stream4 = Stream.iterate(1, n -> n+1).limit(4);
	 stream4.forEach(System.out::println);
}
}
