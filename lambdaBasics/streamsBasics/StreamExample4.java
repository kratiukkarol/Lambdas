package streamsBasics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamExample4 {

	public static void main(String[] args) throws FileNotFoundException {
		InputStream input = new FileInputStream(new File("C:\\Karol\\Eclipse\\workspace\\Playlists\\biblioteka.txt"));
		System.out.println(input);
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		System.out.println(reader);

		List<Book> books = reader.lines().map(mapToBook).collect(Collectors.toList());
		System.out.println(books);
		books.forEach(System.out::println);

		Map<Book, Long> countingMap = books.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(countingMap);

		Map<String, Long> countingMap2 = books.stream()
				.collect(Collectors.groupingBy(Book::getAuthor, Collectors.counting()));
		System.out.println(countingMap2);

		Map<String, List<String>> countingMap3 = books.stream().collect(
				Collectors.groupingBy(Book::getAuthor, Collectors.mapping(Book::getTitle, Collectors.toList())));
		System.out.println(countingMap3);

		Map<String, Map<String, Long>> countingMap4 = books.stream().collect(
				Collectors.groupingBy(Book::getAuthor, Collectors.groupingBy(Book::getTitle, Collectors.counting())));
		System.out.println(countingMap4);

		Map<String, Long> countingMap5 = books.stream()
				.collect(Collectors.groupingBy(Book::getTitle, Collectors.counting())).entrySet().stream()
				.sorted(Map.Entry.<String, Long>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> {
					throw new IllegalStateException();
				}, LinkedHashMap::new));
		System.out.println(countingMap5);
	}

	public static Function<String, Book> mapToBook = (line) -> {
		String[] s = line.split(";");
		return new Book(s[0], s[1]);
	};
}
