package leetcode;

public class leetcode121 {

	public static void main(String args[]) {
		int[] prices = {7,1,5,3,6,4};
		System.out.print(maxProfit(prices));
	}
	//模拟每天买第二天卖掉，则会发现相隔n天的收益值等于每天的差值累加：
	// 1 2 4 3 对应第二天卖掉第一天股票：0 1 2 -1  则 1 3 这相隔的两天正好是 0+1+2-1=2
	public static int maxProfit(int[] prices) {
		int max = 0;
		int profit = 0;
		for(int i=1;i<prices.length;i++) {
			int s = profit+prices[i]-prices[i-1]; //买入天到这天的收益
			profit=Math.max(0,s); //如果已经赔本，则从新买入
			max = Math.max(max, profit); //计算这整个数组中区间最大的
		}
		return max;
	}
}
