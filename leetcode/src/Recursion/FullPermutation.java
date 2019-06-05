package Recursion;

import java.util.HashSet;
import java.util.Set;

public class FullPermutation {
	public static void main(String args[]){
		char[] chars = {'1','2','3'};
		per(chars,0);
	}

	static Set<String> s = new HashSet<String>();
	public static void per(char[] data,int begin){
		int length = data.length;
		if(begin==length){
			s.add(String.valueOf(data));
			System.out.println(data);
		}
		for(int i =begin;i<length;i++){
			// if(!isUnique(data,begin,i)){
			if(!isUnique(data.toString())){
				swap(data,begin,i);
				per(data, begin + 1);
				swap(data,begin,i);
			}
		}
	}

	private static boolean isUnique(String data){
		if(s.contains(String.valueOf(data))){
			return true;
		}
		return false;
	}

	//另类比较唯一性
//	private static boolean isUnique(char[] data, int begin, int end){
//        for(int i = begin; i < end; i++){
//        	if(data[i] == data[end]){
//            	return true;
//            }
//        }
//        return false;
//    }

	private static void swap(char[] nums,int i,int j){
		System.out.println(i+"  "+j);
		char temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
