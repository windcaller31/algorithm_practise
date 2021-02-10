package sort;

import util.Printer;

public class shellSort {	
	public static void main(String args[]){
		int nums[] = {3,9,8,2,1,5,7,6,4};
		int len = nums.length;
		int gap = len/2;
		while(gap>0){
			for(int j=gap;j<len;j++){
				int i=j;
				while(i>=gap){
					//i yu i-gap 比较如果不需要换位置  i+1 与 i+1-gap比较
					if(nums[i-gap]>nums[i]){
						int temp = nums[i-gap];
						nums[i-gap] = nums[i]; 
						nums[i] = temp;
						i = i-gap;	
					}else{
						break;
					}
				}
			}
			System.out.println(Printer.printArray(nums));
			gap = gap/2;
		}
		System.out.println(Printer.printArray(nums));
	}
}
