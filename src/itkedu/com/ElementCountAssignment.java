package itkedu.com;

import java.util.HashMap;
import java.util.Map;

public class ElementCountAssignment {

    // Generic method to count occurrences
    public static <T> Map<T, Integer> countElements(T[] array) {

        Map<T, Integer> map = new HashMap<>();

        for (T element : array) {
            map.put(element, map.getOrDefault(element, 0) + 1);
        }

        return map;
    }

    // Main method
    public static void main(String[] args) {

        // Example 1: String array
        String[] fruits = {"apple", "banana", "apple", "orange", "banana", "apple"};

        Map<String, Integer> fruitCount = countElements(fruits);
        System.out.println("Fruit Count: " + fruitCount);


        // Example 2: Integer array
        Integer[] numbers = {1, 2, 3, 2, 1, 4, 2, 1};

        Map<Integer, Integer> numberCount = countElements(numbers);
        System.out.println("Number Count: " + numberCount);
    }
}
