import java.util.Arrays;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList; //need it in order to use Queue

@SuppressWarnings("unused")
public class Palindrome {
	public static void main(String [] args){
		String pal = "RaCeCar";
		Queue<String> queue = new LinkedList<>();
		Stack<String> stack = new Stack<>();
		
		/*System.out.println(Arrays.toString(pal.split(""))); //how you print an array in linked lists
		// pal.split(""); prints mem location*/
		String[] chars = pal.split("");
		for (int i = 0; i<chars.length; i++){
			if(chars[i].equals(" "))
				continue;
			queue.add(chars[i]);
			stack.push(chars[i]);
		}
		System.out.println(queue);
		System.out.println(stack);
		while(queue.size() > 0){
			String st = stack.pop();
			String qu = queue.remove();
			System.out.println(st + " " +qu);
			if(!(st.equalsIgnoreCase(qu))){
				System.out.println("No Palindrome");
				break;
			}
		}
	}
}
