package BasicAlgorithm;

public class LongestSubSequence {
	public static void main(String args[]) {
		int a[]= {3,4,1,5,2,6,2,3,8,1};
		System.out.print(dp(a));
	}
	
	public static int dp(int[] a) {
		if(a.length==0) {
			return 0;
		}
		int maxCount=0;
		int dp[]=new int[a.length];
		for(int i=0;i<a.length;i++) {
			dp[i]=1;
			for(int j=0;j<i;j++) {
				if(a[i]>a[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		maxCount=dp[0];
		for(int i=0;i<dp.length;i++) {
			if(maxCount<dp[i]) {
				maxCount=dp[i];
			}
		}
		return maxCount;
	}
}
