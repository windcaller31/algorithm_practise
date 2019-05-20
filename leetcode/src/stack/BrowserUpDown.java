package stack;

import java.util.Stack;

public class BrowserUpDown {
	private static Stack<String> stack = new Stack<String>();
	private static Stack<String> stackBak = new Stack<String>(); 
	public static void main(String args[]){
		
	}
	
	public static void into(String s){
		stack.push(s);
	}
	
	public static String forward(){
		if(!stackBak.isEmpty()){
			String s = stackBak.pop();
			stack.push(s);
			return stack.peek();
		}
		return null;
	}
	
	public static String back(){
		if(!stack.isEmpty()){
			String s = stack.pop();
			stackBak.push(s);
			return stackBak.peek();
		}
		return null;
	}
}
