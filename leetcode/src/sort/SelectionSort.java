package sort;

public class SelectionSort {
	public static void main(String args[]){
		int[] nums = {4,5,6,3,2,1,7};
		for(int i=0;i<=nums.length-1;i++){
			int min = i;
			for(int j = i+1;j<=nums.length-1;j++){
				if(nums[j]<nums[min]){
					min = j;
				}
			}
			if(min!=i){
				int temp = nums[min];
				nums[min] = nums[i];
				nums[i] = temp;
			}
		}
		System.out.println(nums);
	}
}
