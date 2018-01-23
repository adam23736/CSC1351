import java.util.*;
public class Expr {
	public static Stack<Double> nums = new Stack<>();
	public static Stack<String> operators = new Stack<>();
	
	public static void print(){
		System.out.println(nums);
		System.out.println(operators);
	}
	
	static void evaluateTop() {
		Double d1 = nums.pop();
		Double d2 = nums.pop();
		String op = operators.pop();
		if(op.equals("-")) nums.push(d1-d2);
	}
	
	public static void main(String [] args){
		LinkedList<String> input = new LinkedList<String>(Arrays.asList(args[0].split("((?<=[-+*/])|(?=[-+*/]))")));
		System.out.println(input);
		
		while(input.size() > 0){
			String next = input.remove();
			if (next.matches("[-+*/]")) {
				if(next.matches("[-+)") &&
						operators.size()> 0 &&
						operators.peek().matches("[*/]"));{
							evaluateTop();
						}
						operators.push(next);
			} else {
				nums.push(Double.parseDouble(next));
			}
		}
		while(operators.size() > 0) {
			evaluateTop();
		}
		print();
	}
}
