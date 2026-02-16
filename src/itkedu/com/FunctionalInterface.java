package itkedu.com;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalInterface {

	public static void main(String[] args) {
		//functional Example
		Function<String, Integer> stringLength= s -> s.length();
		System.out.print("Using Functional: ");
		System.out.println(stringLength.apply("hello"));
		
		//Consumer example
		Consumer<String> printString= s -> System.out.println(s);
		System.out.print("Using Consumer: ");
		printString.accept("world");
		
		//Supplier example
		Supplier<Double> randomValue = () -> Math.random();
		System.out.print("Using Supplier: ");
		System.out.println(randomValue.get());	
		
		//predicte example
		Predicate<Integer> isEvent = n -> n%2 == 0;
		System.out.print("Using predicte: ");
		System.out.println(isEvent.test(4));
		
		//UnaryOperator example
		UnaryOperator<Integer> square = n -> n*n;
		System.out.print("Using UnaryOperator: ");
		System.out.println(square.apply(5));
		
		//BinaryOperator example
		BinaryOperator<Integer> sum = (a, b) -> a+b;
		System.out.print("Using UnaryOperator: ");
		System.out.println(sum.apply(2, 4));
		
		//BiFunction
		BiFunction<Integer, Integer, String> concatNumber= (a, b) -> a + "" +b;
		System.out.print("Using BiFunction: ");
		System.out.println(concatNumber.apply(5, 6));
		
		//Biconsumer
		BiConsumer<String, String> pointConcat= (s1, s2) -> System.out.println(s1 + s2);
		System.out.print("Using BiConsumer: ");
		pointConcat.accept("hello", " world");
		
		//Bipredicate
		BiPredicate<Integer, Integer> areEqual = (a, b) ->a.equals(b);
		System.out.print("Using BiPredicate: ");
		System.out.print(areEqual.test(5, 6));
	}
}
