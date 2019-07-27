package BasicAlgorithm;

public class MaxSubSum {
	public static void main(String args[]) {
//		int a[]= {7,1,5,3,6,4};
		int a[]= {0,-6,4,-2,3,-2};
//		int a[]= {4,-3,5,-2,-1,2,6,-2};
		int j= a.length-1;
		int i = 0;
		int sum = a[i];
		int maxSum = a[i];
		for (int m = i + 1; m <= j; ++m) {
			if (sum < 0) {
				sum = 0;
			} else {
				sum += a[m];
			}
			if (maxSum < sum) {
				maxSum = sum;
			}
		}
		System.out.print(maxSum);
	}
}
