package Search;

public class BinarySearch_2 {
	// 返回最后一个和目标数相等的下标
	public static void main(String args[]) {
		int nums[] = { 2, 4, 6, 7, 7, 7, 7 ,7};
		int target = 7;

		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] > target) {
				end = mid - 1;
			}
			if (nums[mid] <= target) {
				start = mid + 1;
			}
		}
		if (end>=0&&nums[end]==target) {
			System.out.println(end);
		}
	}
}
