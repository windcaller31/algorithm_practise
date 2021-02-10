package array;

public class DynamicExpansionArray {
	public static void main(String args[]){
		int init = 4;
		int[] nums = new int[4];
		for(int i=0;i<=6;i++){
			if(i>=nums.length){
				int[] new_nums = new int[init*2];
				for(int j = 0;j<nums.length;j++){
					new_nums[j] = nums[j];
				}
				nums = new_nums;
			}
			nums[i] = i;
		}
		System.out.println(nums);
	}
}
