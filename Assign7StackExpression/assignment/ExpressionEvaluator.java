package assignment;

public class ExpressionEvaluator implements ExpressionEvaluatorInterface {

	@Override
	public String infixToPostfix(String infix) {
		Stack<String> s = new Stack<String>();
		String postfix = "";
		String[] holder = infix.split(" ");
		for (int i = 0; i < holder.length; i++) {
			switch (holder[i]) {
			case "*": 
				String tempA = s.peek();
				while (tempA != null && (tempA.equals("*") || tempA.equals("/"))) {
					postfix 	+= s.pop() + " ";
					tempA = s.peek();
				}
				s.push("*");
				break;
			case "/": 
				String tempB = s.peek();
				while (tempB != null && (tempB.equals("*") || tempB.equals("/"))) {
					postfix += s.pop() + " ";
					tempB = s.peek();
				}
				s.push("/");
				break;
			case "+": 
				String tempC = s.peek();
				while ((tempC != null) && (tempC.equals("*") || tempC.equals("/"))) {
					postfix += s.pop() + " ";
					tempC = s.peek();
				}
				s.push("+");
				break;
			case "-": 
				String tempD = s.peek();
				while (tempD != null && (tempD.equals("*") || tempD.equals("/"))) {
					postfix += s.pop() + " ";
					tempD = s.peek();
				}
				s.push("-");
				break;
			case "(":
				s.push("(");
				break;
			case ")":
				String tempE = s.peek();
				while (!(tempE.equals("("))) {
					postfix += s.pop() + " ";
					tempE = s.peek();
				}
				s.pop();
				break;
			default:
				postfix += holder[i] + " ";
			}
		}
		while (s.peek() != null) {
		    postfix += s.pop() + " ";
		}
		return postfix;
	}

	@Override
	public int evaluatePostfix(String postfix) {
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < postfix.length(); i++) {
			char ch = postfix.charAt(i);
			if (Character.isDigit(ch)) {
				s.push(Character.getNumericValue(ch));
			} else {
				if(ch == '+') {
					int num2 = s.pop();
					int num1 = s.pop();
					s.push(num1 + num2);
				}else if(ch == '-') {
					int num2 = s.pop();
					int num1 = s.pop();
					s.push(num1 - num2);
				}else if(ch == '*') {
					int num2 = s.pop();
					int num1 = s.pop();
					s.push(num1 * num2);
				}else if(ch == '/') {
					int num2 = s.pop();
					int num1 = s.pop();
					s.push(num1 / num2);
			}
		}
	}
		return s.pop();

}}