package itkedu.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MethodReference {
public static void main(String[] args) {
	ArrayList<String> list = new ArrayList<>();
	list.add("Hello");
	list.add("java");
	list.add("program");
	
	// creating new hashmap and using method reference
    // with necessary classes for the conversion
	HashMap<String, Integer> res = list.stream().collect(Collectors.toMap(
            Function.identity(), String::length,
            (e1, e2) -> e1, HashMap::new));
	System.out.println("Elements in HashMap are : "
            + res);
 }
}
