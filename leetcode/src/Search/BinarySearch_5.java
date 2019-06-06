package Search;

public class BinarySearch_5 {
	// 返回第一个等于或者大于目标数的下标
	public static void main(String args[]) {
		int nums[] = { 2, 4, 5, 6, 7, 8, 9, 11 };
		int target = 6;

		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] >= target) {
				end = mid - 1;
			}
			if (nums[mid] < target) {
				start = mid + 1;
			}
		}

		System.out.println(start);
	}
}
