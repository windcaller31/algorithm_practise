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
			if(a.equals("(")){
				linshi.push(i+1);
			}
			if(a.equals(")")){
				if(linshi.isEmpty()){
					start = i+1;
				}else{
					linshi.pop();
					if(linshi.isEmpty()){
						max = Math.max(max, i-start+1);
					}else{
						max = Math.max(max, i-linshi.peek()+1);
					}
				}
			}
		}
		return max;
    }
}
