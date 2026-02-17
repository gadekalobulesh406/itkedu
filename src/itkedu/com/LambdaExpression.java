package itkedu.com;

import java.util.ArrayList;

public class LambdaExpression {

	public static void main(String[] args) {
		
		ZeroParameter zeroParameter= ()->System.out.println("This is zero paramter: ");
		zeroParameter.display();
		
		//single parameter
		ArrayList<Integer> list=new ArrayList<>();
		list.add(1);//Unboxing
		list.add(2);
		list.add(3);
		System.out.println("All elements");
		list.forEach(n->System.out.println(n));
	}
	interface ZeroParameter{
		void display() ;
	}
}
