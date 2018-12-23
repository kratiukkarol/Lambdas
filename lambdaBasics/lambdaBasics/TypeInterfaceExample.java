package lambdaBasics;

public class TypeInterfaceExample {

	public static void main(String[] args) {
		printLambda(s->s.length());
	}
	
	public static void printLambda(StringLengthLambda str) {
		System.out.println(str.getLength("Hello Lambdas!"));
	}
	
	interface StringLengthLambda{
		int getLength(String s);
	}

}
