package lambdaBasics;

import java.util.function.BiConsumer;

public class ExceptionHandlingExample {

	public static void main(String[] args) {
		int[] numbers = {1,2,3,4};
		int key = 0;
		
		process(numbers, key, lambdaWrapper((v, k) -> System.out.println(v / k)));

	}

	private static BiConsumer<Integer, Integer> lambdaWrapper(BiConsumer<Integer, Integer> consumer) {
		return (v, k) -> {
			try {
				System.out.println(v / k);
			}
			catch(ArithmeticException ex) {
				System.out.println("Exception caught in lambda wrapper");
			}
		};
	}

	private static void process(int[] numbers, int key, BiConsumer<Integer, Integer> consumer) {
		for(int n : numbers) {
			consumer.accept(n, key);
		}
		
	}

}
