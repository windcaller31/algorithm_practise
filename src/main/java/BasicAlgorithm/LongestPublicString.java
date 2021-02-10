package BasicAlgorithm;

public class LongestPublicString {
	public static void main(String args[]) {
		char[] a = {'m','t','a','c','n','u'};
		char[] b = {'m','i','t','c','m','u'};
		System.out.print(lcs(a, 6, b, 6));
	}
	
	public static int lcs(char[] a, int n, char[] b, int m) {
		int[][] maxlcs = new int[n][m];
		for (int j = 0; j < m; j++) {
			if (a[0] == b[j]) {
				maxlcs[0][j] = 1;
			} else if (j != 0) {
				maxlcs[0][j] = maxlcs[0][j - 1];
			} else {
				maxlcs[0][j] = 0;
			}
		}
		for (int i = 0; i < n; i++) {
			if (a[i] == b[0]) {
				maxlcs[i][0] = 1;
			} else if (i != 0) {
				maxlcs[i][0] = maxlcs[i - 1][0];
			} else {
				maxlcs[i][0] = 0;
			}
		}
		for(int i=1;i<n;i++) {
			for(int j=1;j<m;j++) {
				if(a[i]==b[j]) {
					maxlcs[i][j] = maxlcs[i-1][j-1]+1;
				}
				if(a[i]!=b[j]) {
					maxlcs[i][j] = max3(maxlcs[i-1][j-1],maxlcs[i-1][j],maxlcs[i][j-1]);
				}
			}
		}
		return maxlcs[n-1][m-1];
	}
	
	public static int max3(int a,int b,int c) {
		int max = a;
		if(b>max) {
			max=b;
		}
		if(c>max) {
			max=c;
		}
		return max;
	}
}
