package lambdaBasics;

@FunctionalInterface
public interface Condition {
	boolean test(Person p);
}
