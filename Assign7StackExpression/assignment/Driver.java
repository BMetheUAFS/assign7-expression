package assignment;

public class Driver {
	public static void main(String[] args) {
		ExpressionEvaluator e = new ExpressionEvaluator();
		System.out.println(e.infixToPostfix("1 + 4 * 5"));
		System.out.println(e.evaluatePostfix(e.infixToPostfix("1 + 4 * 5")));
	}
}
