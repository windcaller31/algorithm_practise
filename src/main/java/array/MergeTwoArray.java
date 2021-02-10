package array;

public class MergeTwoArray {
	public static void main(String args[]){
		int[] nums1 = {1,2,3,4,5};
		int[] nums2 = {2,7,10};
		int[] new_nums = new int[nums1.length+nums2.length];
		int i =0;
		int j = 0;
		int k = 0;
		for(;i<nums1.length&&j<nums2.length;k++){
			if(nums1[i]>nums2[j]){
				new_nums[k] = nums2[j];
				j++;
			}else{
				new_nums[k] = nums1[i];
				i++;
			}
		}
		while(i<nums1.length){
			new_nums[k] = nums1[i];
			i++;
			k++;
		}
		while(j<nums2.length){
			new_nums[k] = nums2[j];
			j++;
			k++;
		}
		System.out.println(new_nums);
	}
}
