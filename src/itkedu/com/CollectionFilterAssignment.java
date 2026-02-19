package itkedu.com;

import java.util.Arrays;

public class CollectionFilterAssignment {

    // 1️⃣ Generic Filter Interface
    interface Filter<T> {
        T apply(T o);
    }

    // 2️⃣ Generic filter method
    public static <T> T[] filter(T[] array, Filter<T> filter) {

        // Create new array of same type and size
        T[] result = Arrays.copyOf(array, array.length);

        for (int i = 0; i < array.length; i++) {
            result[i] = filter.apply(array[i]);
        }

        return result;
    }

    // 3️⃣ Main method (Test)
    public static void main(String[] args) {

        // Example 1: Integer array (Multiply by 2)
        Integer[] numbers = {1, 2, 3, 4, 5};

        Integer[] doubled = filter(numbers, new Filter<Integer>() {
            @Override
            public Integer apply(Integer o) {
                return o * 2;
            }
        });

        System.out.println("Original: " + Arrays.toString(numbers));
        System.out.println("Doubled : " + Arrays.toString(doubled));


        // Example 2: String array (Uppercase)
        String[] words = {"java", "spring", "boot"};

        String[] upper = filter(words, new Filter<String>() {
            @Override
            public String apply(String o) {
                return o.toUpperCase();
            }
        });

        System.out.println("Original: " + Arrays.toString(words));
        System.out.println("Uppercase: " + Arrays.toString(upper));
    }
}

