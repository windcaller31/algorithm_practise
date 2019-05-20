package sort;

public class BubbleSort {
	public static void main(String args[]){
		int[] nums = {4,5,6,3,2,1};
		for(int i =nums.length-1;i>=0;i--){
			boolean flag = false;
			for(int j=1;j<=i;j++){
				if(nums[j]<nums[j-1]){
					int temp = nums[j-1];
					nums[j-1] = nums[j];
					nums[j]=temp;
					flag = true;
				}
			}
			if(!flag){
				break;
			}
			System.out.println(nums);
		}
		System.out.println(nums);
	}
}
