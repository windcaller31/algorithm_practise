package leetcode;

import java.util.Stack;

public class leetcode32 {
	public static void main(String args[]){
		longestValidParentheses("(()");
	}
	public static int longestValidParentheses(String s) {
		Stack<Integer> linshi = new Stack<Integer>();
		int start =0;
		int max = 0;
		String[] array = s.split("");
		for(int i =0;i<array.length;i++){
			String a = array[i];
			//左括号都入进去栈
			if(a.equals("(")){
				linshi.push(i+1);
			}
			//右括号
			if(a.equals(")")){
				//如果栈中为空，说明该右括号为非法，start走到i的下一位继续
				if(linshi.isEmpty()){
					start = i+1;
				}
				//如果栈中不为空，则出栈，由于是在")"的if判断中，所以出栈的一定是左括号
				else{
					linshi.pop();
					//如果栈为空，那么说明左右括号匹配上了，算一次max距离 i-start+1
					if(linshi.isEmpty()){
						max = Math.max(max, i-start+1);
					}
					//如果栈不为空，说明栈中内容均为(((((...属于被包含内容
					else{
						max = Math.max(max, i-linshi.peek()+1);
					}
				}
			}
		}
		return max;
    }
}
