package leetcode;

import java.util.Stack;

public class leetcode20 {
	public static void main(String args[]){
		String r = "{{)}";
		System.out.print(isValid(r));
	}
	
	public static boolean isValid(String s) {
		boolean flag = false;
		if(s.equals("")){
			return true;
		}
		String[] array = s.split("");
		Stack<String> stack = new Stack<String>();
		for(int i =0;i<array.length;i++){
			String a =array[i];
			if(a.equals("]")){
				if(stack.isEmpty()){
					return false;
				}else if(!stack.pop().equals("[")){
					return false;
				}else{
					flag = true;
				}
			}else if(a.equals("}")){
				if(stack.isEmpty()){
					return false;
				}else if(!stack.pop().equals("{")){
					return false;
				}else{
					flag = true;
				}
			}else if(a.equals(")")){
				if(stack.isEmpty()){
					return false;
				}else if(!stack.pop().equals("(")){
					return false;
				}else{
					flag = true;
				}
			}else{
				stack.push(a);	
			}
		}
		if(!stack.isEmpty()){
			return  false;
		}
		return flag;
	}
}
