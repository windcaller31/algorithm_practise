package Recursion;

import java.util.HashSet;
import java.util.Set;


// f(1,2,...n) = {最后一位是 1, f(n-1)...

public class FullPermutation {
	public static void main(String args[]){
		char[] chars = {'1','2','3'};
		per(chars,3,3);
	}
	public static void per(char[] data,int n,int k){
		if(k==1){
			for(int i =0;i<n;i++){
				System.out.print(data[i]);
			}
			System.out.println(" ");
		}
		for(int i =0;i<k;i++){
			swap(data,i,k-1);
			per(data,n,k-1);
			swap(data,i,k-1);
		}
	}

	private static void swap(char[] nums,int i,int j){
//		System.out.println(i+"  "+j);
		char temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
