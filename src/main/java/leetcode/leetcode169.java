package leetcode;

import java.util.HashMap;
import java.util.Map;

public class leetcode169 {
	public static void main(String args[]){
		int[] a = {2,2,1,1,1,2,2};
		majorityElement(a);
	}
	
	public static int majorityElement(int[] nums) {
		Map<Integer,Integer> m = new HashMap<Integer,Integer>();
		int result = -1;
		for(int i =0;i<nums.length;i++){
			if(m.get(nums[i])==null){
				m.put(nums[i], 1);
			}else{
				m.put(nums[i], m.get(nums[i])+1);	
			}
			if(m.get(nums[i])>nums.length/2){
				result = nums[i];
				break; 
			}
		}
		return result;
	}
}
