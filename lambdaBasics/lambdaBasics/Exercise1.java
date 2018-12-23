package lambdaBasics;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Exercise1 {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60), new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 53), new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39));

		// Sort list by last name
		Collections.sort(people, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}

		});
		
		// java 8 way
		Collections.sort(people, (o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));

		// Prints all elements in the list
		for (Person p : people) {
			System.out.println(p);
		}
		
		// java 8 way
		people.forEach(System.out::println);

		// Prints all last names beginning with C
		for (Person p : people) {
			if (p.getLastName().startsWith("C")) {
				System.out.println(p);
			}
		}
		
		// java 8 way
		printConditionally(people, p -> p.getLastName().startsWith("C"));
	}
	
	public static void printConditionally(List<Person> people, Predicate<Person> predicate) {
		for (Person p : people) {
			if (predicate.test(p)) {
				System.out.println(p);
			}
		}
	}

}
