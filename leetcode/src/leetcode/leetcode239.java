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
			//去掉上一个窗口的最后一个值
			if((!queue.isEmpty())&&(queue.peekFirst()==i-k)){
				queue.poll();//remove head
			}
			//value大于queue中右边的值，就把queue右边的值弹出，直到value不大于或者queue为空为止
			while((!queue.isEmpty())&&(value>nums[queue.peekLast()])){
				queue.removeLast();
			}
			//将value下标存入queue右侧。此时queue中最左侧数据为最大。记录到res
			queue.offerLast(i);
			if(i+1>=k){
				res[i+1-k] = nums[queue.getFirst()];
			}
		}
		return res;
	}
}
