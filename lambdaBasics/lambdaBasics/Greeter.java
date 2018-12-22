package lambdaBasics;

public class Greeter {

	public void greet(Greeting greeting) {
		greeting.perform();
	}
	
	public static void main(String[] args) {
		Greeter greeter = new Greeter();
		Greeting greetingImp = new GreetingImp();
		Greeting lambdaGreeting = () -> System.out.println("Greeting!");	
		Greeting innerGreatingClass = new Greeting() {
			public void perform() {
				System.out.println("Inner Greeting!");
			}
		};
		
		greeter.greet(greetingImp);
		greeter.greet(lambdaGreeting);
		greeter.greet(innerGreatingClass);
		greetingImp.perform();
		lambdaGreeting.perform();
		innerGreatingClass.perform();
	}
}
