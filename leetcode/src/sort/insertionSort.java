package sort;

import util.Printer;

public class insertionSort {
	public static void main(String args[]){
		int[] nums = {4,5,6,3,2,1,7};
		for(int i =1;i<nums.length;i++){
			int value = nums[i];
			int j = i-1;
			for(;j>=0;j--){
				if(nums[j]>value){
					nums[j+1]=nums[j];
				}else{
					break;
				}
			}
			nums[j+1] = value;
			System.out.println(Printer.printArray(nums));
		}
		System.out.println(Printer.printArray(nums));
	}
}

	
//	
//	for(int i=1;i<nums.length;i++){
//		int value = nums[i];
//		int j = i-1;
//		for(;j>=0;j--){
//			if(nums[j]>value){
//				nums[j+1] = nums[j];
//			}else{
//				break;
//			}
//		}
//		nums[j+1] = value;
//		System.out.println(Printer.printArray(nums));
//	}
//	System.out.println(Printer.printArray(nums));
//}