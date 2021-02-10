package leetcode;

public class leetcode70 {
	public int climbStairs(int n) {
		int _1 = 1;
		int _2 = 2;
		int total = 0;
		if(n==1){
			return 1;
		}
		if(n==2){
			return 2;
		}
		for(int i = 3;i<=n;i++){
			total = _1+_2;
			_1 = _2;
			_2 = total;
		}
		return total;
	}
}
