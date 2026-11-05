package assignment;

public class ExpressionEvaluator implements ExpressionEvaluatorInterface {

	@Override
	public String infixToPostfix(String infix) {
		String[] arr = infix.split(" ");
		int startp;
		int stopp;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == "(" && i != 0) {
				arr[i]="";
				startp = i+1;
				while(arr[i] != ")") {
					i++;
				}
				stopp = i-1;
				arr[i] = "";
			}
		}
		return null;
	}

	@Override
	public int evaluatePostfix(String postfix) {
		// TODO Auto-generated method stub
		return 0;
	}

}
