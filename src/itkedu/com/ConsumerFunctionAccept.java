package itkedu.com;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerFunctionAccept {
	public static void main(String[] args) {
		
		//consumer to display the number 
		Consumer<Integer> display= a -> System.out.println(a);
		
		//implement display using accept() method
		display.accept(15);
		
		
		//Consumer to multiply 2 to every integer of a list
		Consumer<List<Integer>> modify= list -> {
			for(int i=0; i<list.size(); i++) {
				list.set(i, 2*list.get(i));
			}
		};
		//consumer to display list of integers
		Consumer<List<Integer>> disList= list ->
		list.stream().forEach(a -> System.out.print(a + " "));
		
		List<Integer> list=new ArrayList<>();
	    list.add(2);
	    list.add(3);
	    list.add(4);
	    
	    //Implement modify using accept() method
	    modify.accept(list);
	    // Implement dispList using accept()
	    disList.accept(list);
	    
	    //using andthen() method
	    modify.andThen(disList).accept(list);
	}

}
