package leetcode;

public class leetcode8 {
	public int myAtoi(String str) {
		if (str.isEmpty()) {
			return 0;
		}
		Boolean positive = true;
		char a[] = str.toCharArray();
		int base = 0;
		int n = str.length();
		int i = 0;
		while (i < n && a[i] == ' ') {
			i++;
		}
		if (i < n && (a[i] == '+' || a[i] == '-')) {
			positive = (a[i] == '+') ? true : false;
			i++;
		}
		/*
		 base==Integer.MAX_VALUE/10 &&str.charAt(i)-'0'>7
			最大的数是：4294967296
			最小的书是：-2147483648
		*/
		while (i < n && a[i] >= '0' && a[i] <= '9') {
			if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && a[i] - '0' > 7)) {
				return (positive == true) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			base = 10 * base + (a[i] - '0');
			i++;
		}
		return (positive == true) ? base : base * (-1);
	}
}
