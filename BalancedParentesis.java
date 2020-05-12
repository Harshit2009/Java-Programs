import java.util.Stack;
 
public class BalancedParentesis 
{
 
 public static void main(String[] args) 
 {
 	String BalancedExpr1= BalancedParentesis("[()]{}{[()()]()]");
 	System.out.println("[()]{}{[()()]()] : "+BalancedExpr1);
 	String BalancedExpr2= BalancedParentesis("[(])");
 	System.out.println("[(]) : "+BalancedExpr2);
 }
 public static String BalancedParentesis(String exp)
 {
 	if (exp.isEmpty())
 		return "Balanced";
 
 	Stack<Character> stack = new Stack<Character>();
 	for (int i = 0; i < exp.length(); i++)
 	{
 		char current = exp.charAt(i);
 		if (current == '{' || current == '(' || current == '[')
 		{
 			stack.push(current);
 		}
 		if (current == '}' || current == ')' || current == ']')
 		{
 			if (stack.isEmpty())
 				return "Not Balanced";
 			char last = stack.peek();
 			if (current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[')
 			stack.pop();
 			else 
 				return "Not Balanced";
 			}
 		}
 		return stack.isEmpty()?"Balanced":"Not Balanced";
 	}
}
 