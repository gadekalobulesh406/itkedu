package itkedu.com;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorChar {
	public static void main(String[] args) {
		List<String> word = Arrays.asList("Hello","Java","World");
		//Using predefined collectpr
		List<String> uniqueWords = word.stream()
				.distinct()
				.collect(Collectors.toList());
		
		//Using custom collector
		Map<Integer, List<String>> wordByLength = word.stream()
				.collect(Collectors.groupingBy(String::length));
	}

}
