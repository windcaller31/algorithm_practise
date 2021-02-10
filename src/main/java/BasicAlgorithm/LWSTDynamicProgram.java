package BasicAlgorithm;

//莱文斯坦距离，一个串改几位变成另一个
public class LWSTDynamicProgram {
	public static void main(String args[]) {
		char[] a = {'m','t','a','c','n','u'};
		char[] b = {'m','i','t','c','m','u'};
		System.out.print(lwstDp(a, 6, b, 6));
	}
	
	// ij=min(i-1j,ij-1,i-1j-1)
	public static int lwstDp(char[] a, int n, char b[], int m) {
		int[][] minDist = new int[n][m];
		for (int j = 0; j < m; j++) {// 初始化第零行
			if (a[0] == b[j]) {
				minDist[0][j] = j;
			} else if (j != 0) {
				minDist[0][j] = minDist[0][j - 1] + 1;
			} else {
				minDist[0][j] = 1;
			}
		}
		for (int i = 0; i < n; i++) {// 初始化0列
			if (a[i] == b[0]) {
				minDist[i][0] = 1;
			} else if (i != 0) {
				minDist[i][0] = minDist[i - 1][0] + 1;
			} else {
				minDist[i][0] = 1;
			}
		}
		//按照递归公式来
		for(int i=1;i<n;i++) {
			for(int j=1;j<m;j++) {
				if(a[i]==b[j]) {
//					minDist[i][j]=min3(minDist[i-1][j]+1,minDist[i][j-1]+1,minDist[i-1][j-1]);
					minDist[i][j]=minDist[i-1][j-1];
				}else {
					minDist[i][j]=min3(minDist[i-1][j]+1,minDist[i][j-1]+1,minDist[i-1][j-1]+1);					
				}
			}
		}
		return minDist[n-1][m-1];
	}

	public static int min3(int a, int b, int c) {
		int min = a;
		if (b < min) {
			min = b;
		}
		if (c < min) {
			min = c;
		}
		return min;
	}
}
