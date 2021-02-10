package leetcode;

import java.util.*;

public class leetcode15 {
	
	public static void main(String args[]){
//		int[] nums = {-1, 0, 1, 2, -1, -4};
		int[] nums = {1,1,-2};
		threeSum(nums);
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums.length<=2){
			return result;
		}
		for(int i = 0;i<nums.length;i++){
			if(map.get(nums[i])==null){
				map.put(nums[i],1);	
			}else{
				int old = map.get(nums[i]);
				map.put(nums[i],old+1);
			}
		}
		System.out.println(map.get(0));
		if(map.get(0)!=null && map.get(0)>=3){
			List<Integer> l = new ArrayList<Integer>();
			l.add(0);
			l.add(0);
			l.add(0);
			result.add(l);
		}
		List _nums_list = new ArrayList<Integer>();
		for(Integer key : map.keySet()){
			_nums_list.add(key);
		}
		Collections.sort(_nums_list);
		Integer[] _nums = (Integer[]) _nums_list.toArray(new Integer[_nums_list.size()]);
		
		for(int i =0;i<_nums.length;i++){
			for(int j=i+1;j<_nums.length;j++){
				
				if((_nums[i]*2 + _nums[j] == 0)&&(map.get(_nums[i]) >= 2)){
					List<Integer> l = new ArrayList<Integer>();
					l.add(_nums[i]);
					l.add(_nums[i]);
					l.add(_nums[j]);
					result.add(l);	
				}
				if((_nums[i] + _nums[j]*2 == 0)&&(map.get(_nums[j]) >= 2)){
					List<Integer> l = new ArrayList<Integer>();
					l.add(_nums[i]);
					l.add(_nums[j]);
					l.add(_nums[j]);
					result.add(l);	
				}
				int dif = 0-_nums[i]-_nums[j];
				if(dif>_nums[j]&&map.containsKey(dif)){
					List<Integer> l = new ArrayList<Integer>();
					l.add(_nums[i]);
					l.add(_nums[j]);
					l.add(dif);
					result.add(l);
				}
			}
		}
		return result;
	}
}
