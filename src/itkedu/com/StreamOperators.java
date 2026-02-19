package itkedu.com;

import java.util.Arrays;
import java.util.List;

public class StreamOperators {

	public static void main(String[] args) {
		//pipeline operations
		List<Integer> list= Arrays.asList(1,2,3,6,4,6);
		list.stream().filter(n -> n%2 == 0).forEach(System.out::println);
		
		//map function
		List<String> str = Arrays.asList("Java", "hello");
		str.stream().map(String:: toUpperCase)//transfer string to uppercase
		.forEach(System.out::println);//output the result
		
		//Flatmap function
		List<List<Integer>> numbers = Arrays.asList(
			  Arrays.asList(1,2), 
			  Arrays.asList(3, 4),
			  Arrays.asList(5, 6)
			  );  
		numbers.stream().flatMap(List::stream)//Flatten lists into a single stream
		.forEach(System.out::println);
		
		//Distinct()
		List<Integer> number = Arrays.asList(1,2,3,2,6,4,3);
		number.stream().distinct().sorted() // distinct is used for to remove the duplicates
		.forEach(System.out::println);
		
		System.out.println("To Sort the numbers: ");//sorted() to sort the numbers
		number.stream().sorted().forEach(System.out::print);
		
		//Consumer action (peek)
		List<Integer> num = Arrays.asList(1,2,3,4,5,6,7,8);
		num.stream().filter(n ->n%2 == 0).peek(n ->System.out.println("Filtered value:"+n))
		.map(n ->n*n)
		.forEach(System.out::println);
	}
}
