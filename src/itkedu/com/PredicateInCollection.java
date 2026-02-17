package itkedu.com;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class User{
	String name, role;

	public User(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", role=" + role + "]";
	}

	public String getName() {
		return name;
	}
	
}
public class PredicateInCollection {

	public static void main(String[] args) {
		
		List<User> users= new ArrayList<>();
		users.add(new User("John", "Admin"));
		users.add(new User("Peter", "member"));
		
		List admins = process(users, (User u) -> u.getRole().equals("admin"));
        System.out.println(admins);
    }
	public static List<User> process(List<User> users, Predicate<User> predicate) {
		List<User> result = new ArrayList<User>();
		for (User user : users)
			if (predicate.test(user))
				result.add(user);
		return result;
   }
	
}
