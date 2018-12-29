package streamsBasics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample3 {

	public static void main(String[] args) throws IOException {
		
		// 1. Integer stream
		IntStream
		.range(1, 11)
		.forEach(System.out::print);
		System.out.println(); // blank line
		
		// 2. Integer Stream with skip
		IntStream
		.range(1, 11)
		.skip(4)
		.forEach(System.out::println);
		System.out.println(); // blank line
		
		// 3. Integer Stream with sum
		System.out.println(
		IntStream
			.range(1, 5)
			.sum());
		System.out.println(); // blank line
		
		// 4. Stream.of, sorted and findFirst
		Stream.of("Ava", "Aneri", "Alberto")
		.sorted()
		.findFirst()
		.ifPresent(System.out::println);
		System.out.println(); // blank line
		
		// 5. Stream from Array, sort, filter and print
		String[] names = {"Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah"};
		Stream.of(names)
		.filter(n -> n.startsWith("S"))
		.sorted()
		.forEach(System.out::println);
		System.out.println(); // blank line
		
		// 6. average of squares of an int array
		IntStream.of(new int[] {2, 4, 6, 8, 10})
		.map(x -> x*x)
		.average()
		.ifPresent(System.out::println);
		System.out.println(); // blank line
		
		// 7A. Stream from List, filter and print
		List<String> people = Arrays.asList("Al", "Ankit", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah");
			people.stream()
			.map(String::toLowerCase)
			.filter(n -> n.startsWith("a"))
			.forEach(System.out::println);
			System.out.println(); // blank line
			
		// 7B. Stream from List, first letter of String to upper case
		List<String> people2 = Arrays.asList("Al", "Ankit", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah");
			people2.stream()
			.map(word -> word.substring(0, 1).toUpperCase() + word.substring(1))
			.filter(n -> n.startsWith("A"))
			.forEach(System.out::println);
			System.out.println(); // blank line
			
		// 8. Stream rows from text file, sort, filter, and print
		Stream<String> bands = Files.lines(Paths.get("C:\\Karol\\Eclipse\\workspace\\Lambdas\\lambdaBasics\\streamsBasics\\Bands.txt"));
			bands
			.sorted()
			.filter(x -> x.length()>11)
			.forEach(System.out::println);
			bands.close();
			System.out.println(); // blank line
			
		// 9. Stream rows from text file and save to List
		List<String> bands2 = Files.lines(Paths.get("C:\\Karol\\Eclipse\\workspace\\Lambdas\\lambdaBasics\\streamsBasics\\Bands.txt"))
			.filter(x -> x.contains("jit"))
			.collect(Collectors.toList());
		bands2.forEach(System.out::println);
		System.out.println(); // blank line
		
		// 10. Stream rows from CSV file and count
		Stream<String> rows = Files.lines(Paths.get("C:\\Karol\\Eclipse\\workspace\\Lambdas\\lambdaBasics\\streamsBasics\\data.txt"));
		int rowCount = (int) rows
				.map(x -> x.split(","))
				.filter(x -> x.length==3)
				.count();
		System.out.println(rowCount + " rows.");
		rows.close();
		System.out.println(); // blank line
		
		// 11. Stream rows from CSV file, parse data from rows
		Stream<String> rows2 = Files.lines(Paths.get("C:\\Karol\\Eclipse\\workspace\\Lambdas\\lambdaBasics\\streamsBasics\\data.txt"));
			rows2
				.map(x -> x.split(","))
				.filter(x -> x.length==3)
				.filter(x -> Integer.parseInt(x[1])>15)
				.forEach(x -> System.out.println(x[0] + " " + x[1] +" " + x[2]));
			rows2.close();
			System.out.println(); // blank line
		
		// 12. Stream rows from CSV file, store fields in HashMap
		Stream<String> rows3 = Files.lines(Paths.get("C:\\Karol\\Eclipse\\workspace\\Lambdas\\lambdaBasics\\streamsBasics\\data.txt"));
		Map<String, Integer> map = new HashMap<>();
		map = rows3
				.map(x -> x.split(","))
				.filter(x -> x.length==3)
				.filter(x-> Integer.parseInt(x[1]) > 15)
				.collect(Collectors.toMap(x -> x[0], x -> Integer.parseInt(x[1])));
		rows3.close();
		for(String key : map.keySet()) {
			System.out.println(key + " " + map.get(key));
		}
		System.out.println(); // blank line
		
		// 13. Reduction - sum
		double sum = Stream.of(3.2, 5.72, 11.23, 3.62)
				.reduce(0.0, (a, b) -> a + b);
		System.out.println("Total: " + sum);
		System.out.println(); // blank line
		
		// 14. Reduction - summary statistics
		IntSummaryStatistics summary = IntStream.of(4,6,123,25,74,85)
				.summaryStatistics();
		System.out.println("Statistics: " + summary);
	}

}
