package leetcode;

public class leetcode322 {
	private static int[][] result;

	private static int maxValue = 100000000;

	public int search(int index, int amount, int[] coins) {
		if (index >= coins.length) {
			return maxValue;
		}

		if (amount == 0) {
			return 0;
		}

		if (amount < 0) {
			return maxValue;
		}

		if (result[index][amount] >= 0) {
			return result[index][amount];
		}
		//选中当前硬币，仍然要考察是否继续选当前硬币所以是  dp[index,amount-coins[index],coins]+1
		//没选当前硬币 那么看下一个硬币是否选 dp[index+1,amount,coins]
		result[index][amount] = Math.min(search(index, amount - coins[index], coins) + 1,
				search(index + 1, amount, coins));
		return result[index][amount];
	}

	public int coinChange(int[] coins, int amount) {
		result = new int[20][10000];
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10000; j++) {
				result[i][j] = -1;
			}
		}

		int val = search(0, amount, coins);
		if (val < maxValue) {
			return val;
		} else {
			return -1;
		}
	}
}
