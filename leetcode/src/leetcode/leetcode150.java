package leetcode;

import java.util.Stack;

public class leetcode150 {
	public static void main(String args[]) {
//		String[] ts = { "3", "11", "+", "5", "-" };
		 String[] ts = { "-78", "-33", "196", "+", "-19", "-", "115", "+",
		 "-", "-99", "/", "-18", "8", "*", "-86", "-",
		 "-", "16", "/", "26", "-14", "-", "-", "47", "-", "101", "-", "163",
		 "*", "143", "-", "0", "-", "171",
		 "+", "120", "*", "-60", "+", "156", "/", "173", "/", "-24", "11",
		 "+", "21", "/", "*", "44", "*", "180",
		 "70", "-40", "-", "*", "86", "132", "-84", "+", "*", "-", "38", "/",
		 "/", "21", "28", "/", "+", "83",
		 "/", "-31", "156", "-", "+", "28", "/", "95", "-", "120", "+", "8",
		 "*", "90", "-", "-94", "*", "-73",
		 "/", "-62", "/", "93", "*", "196", "-", "-59", "+", "187", "-",
		 "143", "/", "-79", "-89", "+", "-" };
		System.out.print(evalRPN(ts));
	}

	public static int evalRPN(String[] tokens) {
		Stack<Integer> number = new Stack<Integer>();
		for (int i = 0; i < tokens.length; i++) {
			String t = tokens[i];
			if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {
				Integer total = null;
				int n1 = number.pop();
				int n2 = number.pop();
				if (t.equals("+")) {
					total = n2 + n1;
				}
				if (t.equals("-")) {
					total = n2 - n1;
				}
				if (t.equals("*")) {
					total = n2 * n1;
				}
				if (t.equals("/")) {
					if (n1 == 0) {
						total = 0;
					} else {
						total = n2 / n1;
					}
				}
				number.push(total);
			} else {
				number.push(Integer.valueOf(t));
			}
		}
		return number.pop();
	}
}
