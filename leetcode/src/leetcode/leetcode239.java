package leetcode;

import java.util.LinkedList;

public class leetcode239 {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums.length==0||nums==null){
			return new int[0];
		}
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int[] res = new int[nums.length+1-k]; 
		for(int i =0;i<nums.length;i++){
			int value = nums[i];
			if((!queue.isEmpty())&&(queue.peekFirst()==i-k)){
				queue.poll();
			}
			while((!queue.isEmpty())&&(value>nums[queue.peekLast()])){
				queue.removeLast();
			}
			queue.offerLast(i);
			if(i+1>=k){
				res[i+1-k] = nums[queue.getFirst()];
			}
		}
		return res;
	}
}
