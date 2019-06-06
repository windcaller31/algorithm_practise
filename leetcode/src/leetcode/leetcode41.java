package leetcode;

public class leetcode41 {
	public static int firstMissingPositive(int[] nums) {
		if (nums.length == 0)
			return 1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				// nums[i] != nums[nums[i] - 1] 避免换到相同数字导致死循环
				// nums[i] 位置的数字换过来 比如 nums[1] = 4 那么 nums[1] 和 nums[3] 交换，
				// 继续比较直到换对位置, 4应该在nums[3]，而nums[3]这个数字是不是放到nums[1]，则继续下一次循环比较 
				while (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i] - 1]) {
					int temp = nums[nums[i] - 1];// 交换数据
					nums[nums[i] - 1] = nums[i];
					nums[i] = temp;
				}
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		// 假设都符合要求，则返回长度+1的值
		return nums.length + 1;
	}
}
