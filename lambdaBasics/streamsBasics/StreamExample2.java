package streamsBasics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lambdaBasics.Person;

public class StreamExample2 {

	public static void main(String[] args) {
		List<Person> people = getPeopleList();
		people.stream()
		.filter(p -> p.getAge()>40)
		.forEach(p -> System.out.println(p.getFirstName()));
		
		System.out.println(IntStream.range(1, 5).sum());
		showList(people);
		List<Person> sortedPeople = people.stream().sorted((p1,p2) -> p1.getLastName().compareTo(p2.getLastName())).collect(Collectors.toList());
		showList(sortedPeople);
	}
	
	public static List<Person> getPeopleList(){
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60), 
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 53), 
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39));
		return people;
	}
	public static void showList(List<Person> list) {
		list.stream().forEach(p -> System.out.println(p.getLastName() + " | " + p.getAge()));
	}

}
