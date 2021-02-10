package leetcode;

public class leetcode152 {
	public static void main(String args[]) {	
		int[] a= {-4,-3,-2};
		System.out.print(maxProduct(a));
	}
	
	public static int maxProduct(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		// 负负得正的问题要保证有一个最小乘积，下一个数这个最小乘积可能就是最大乘积
		int maxAll = nums[0];// 全局最大
		int maxLast = nums[0]; // 上一个乘积最大
		int maxCur; // 包含当前的最大乘积
		int minLast = nums[0]; // 上一个乘积最小
		int minCur;// 包含当前乘积最小

		for (int i = 1; i < nums.length; i++) {
			//每次保留最大值
			maxCur = Math.max(nums[i], Math.max(nums[i] * maxLast, nums[i] * minLast));			
			//每次保留最小值
			minCur = Math.min(nums[i], Math.min(nums[i] * maxLast, nums[i] * minLast));
			//顺序不能乱上面判断的是上一轮
			maxLast = maxCur;
			minLast = minCur;
			maxAll=Math.max(maxAll, maxLast);
		}
		return maxAll;
	}
}
