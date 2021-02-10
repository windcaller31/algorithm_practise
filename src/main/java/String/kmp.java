package String;

public class kmp {
	public static void main(String args[]) {
		char a[] = {'a','c','d','b','p','m','t','a','c','d','a','q','0'};
		char b[] = {'a','c','d','a'};
		System.out.print(kmp_compare(a, a.length, b, b.length));
	}

	public static int kmp_compare(char a[], int n, char b[], int m) {
		int[] next = getNexts(b, m);//获取next数组后缀匹配前缀字符数组
		int j = 0;
		for (int i = 0; i < n; i++) {
			while (j > 0 && a[i] != b[j]) { //主串ai与模式串bj不同,j移动至后缀匹配前缀位置的下一位
				j = next[j - 1] + 1;
			}
			if (a[i] == b[j]) { //如果ai==bj,j向后移动
				j++;
			}
			if (j == m) { //当j移动到m位置说明a中有b
				return i-m+1;
			}
		}
		return -1;
	}

	public static int[] getNexts(char b[], int m) {
		int[] next = new int[m];
		next[0] = -1;
		int k = -1;
		for (int i = 1; i < m; ++i) {
			while (k != -1 && b[k + 1] != b[i]) { // 如果之前前缀后缀已经匹配上了，但是前缀+1字符不等于后缀字符时
				k = next[k];// k跳到上一次前后缀匹配位置,后续比较k+1和i
			}
			if (b[k + 1] == b[i]) {// 后缀子串字符==前缀子串字符,前缀k++
				++k;
			}
			next[i] = k; // 记录next i即前后缀匹配位置
		}
		return next;
	}
}
