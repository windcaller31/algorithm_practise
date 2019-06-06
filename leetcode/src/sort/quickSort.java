package sort;

import util.Printer;

public class quickSort {
	public static void main(String args[]){
		int[] nums = {4,5,5,3,2,1,7}; 
		quicksort(nums,0,nums.length-1);
		System.out.println(nums);
	}
	
	public static void quicksort(int[] a,int left,int right){
		if(left>=right){
			return;
		}else{
			int q = partition(a,left,right);
			quicksort(a, left, q-1);
			quicksort(a, q+1, right);
		}
	}
	
	public static int partition(int[] a,int left,int right){
		int pivot = a[right];
		int i = left;
		for(int j=i;j<=right-1;j++){
			if(a[j]<pivot){
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
			}
		}
		int temp = a[i];
		a[i] = pivot;
		a[right] = temp;
		System.out.println(Printer.printArray(a));
		return i;
	}
	
//	public static int partition(int[] a,int left,int right){
//		int pivot = a[left]; //[4, 5, 7, 3, 2, 1, 9]
//		int i = left+1;
//		for(int j=i;j<=right;j++){
//			if(a[j]<pivot){
//				int temp = a[i];
//				a[i] = a[j];
//				a[j] = temp;
//				i++;
//			}
//		}
//		int temp = a[i-1];   //[4, 3, 2, 1, 7, 5, 9]
//		a[i-1] = pivot;
//		a[left] = temp;
//		return i-1;
//	}
	
}
