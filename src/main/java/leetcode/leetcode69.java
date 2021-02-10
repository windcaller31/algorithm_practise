package leetcode;

public class leetcode69 {
	public static void main(String args[]){
		System.out.println(mySqrt(127));
	}
	
	public static int mySqrt(int x) {
		long low=0;
		long high=x;
		int ans = 0;
		while(low<=high){
			long mid = (low+high)/2;
			long s = mid*mid;
			if(s==x){
				ans = (int)mid;
				return ans;
			}else if(s<x){
				ans = (int)mid;
				low = mid+1;
			}else if(s>x){
				high = mid-1;
			}
		}
		return ans;
	}
}
