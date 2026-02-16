package itkedu.com;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringExample {

	public static void main(String[] args)  {
		
		String text = "Hello";
		IntStream charStram=text.chars();//create a stream of character code points
		charStram.forEach(ch -> System.out.println((char) ch));
		
		//Using methods from the files library
		try (Stream<String> stream = Files.lines(Paths.get("C:\\Users\\gadekal.obulesu\\Downloads"))){
			stream.forEach(System.out::println);
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
}
