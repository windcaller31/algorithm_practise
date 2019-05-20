package Recursion;

import java.util.ArrayList;
import java.util.List;

public class FullPermutation2 {
	public static void main(String args[]){
		int[] nums = {1,2,3};
		List<List<Integer>> l = permute(nums);
		System.out.println(l);
	}
	
	private static List<List<Integer>> res;// 存放结果的对象
	 public static List<List<Integer>> permute(int[] nums) {
	        res = new ArrayList<List<Integer>>();
	        DFS(nums,initializeBooleanArray(nums.length),new ArrayList<Integer>());// 收集全排列的所有排列结果
	        return res;
	    }
	    
	    // 循环选择固定哪一个数字（选择哪一个作为起始数字）
	    public static void DFS(int[] nums,boolean[] visited,List<Integer> tmp){
	        // 如果tmp中存放的数字已经将所有nums中的数字都放入了，那么就将其输入到res中
	        if(tmp.size()==nums.length)
	            res.add(new ArrayList<Integer>(tmp));
	        else{
	            // 否则，开始循环遍历，按照0,1,2..的顺序依次选择起点，然后遍历
	            for(int i=0;i<nums.length;i++){
	                if(visited[i])// 若该点已经被访问过了，则跳过访问下一个点
	                    continue;
	                else{// 若没被访问过，那么先标记为访问了，然后将其加入tmp中，等待tmp长度足够时写入res中
	                    visited[i] = true;
	                    tmp.add(nums[i]);
	                    DFS(nums,visited,tmp);// 递归调用，通过形参维护的 逻辑栈的变量有：tmp，visited
	                    tmp.remove(tmp.size()-1);// 递归结束，还原该点的状态，使得获取下一个组合的遍历还能再经过此点
	                    visited[i]=false;// 访问标记还原
	                }
	            }
	        }
	    }
	    
	    // 获取一个与num相等大小的boolean数组
	    public static boolean[] initializeBooleanArray(int num){
	        boolean[] res = new boolean[num];
	        for(int i=0;i<num;i++){
	            res[i] = false;
	        }
	        return res;
	    }
}
