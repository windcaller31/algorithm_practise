package leetcode;

public class leetcode64 {
	public static void main(String[] args) {
//		int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		int[][] grid = { { 1, 3, 1 }};
		System.out.print(minPathSum(grid));
	}

	public static int minPathSum(int[][] grid) {
		if(grid.length==1) {
			int sum=0;
			for(int i=0;i<grid[0].length;i++) {
				sum+=grid[0][i];
			}
			return sum;
		}
		int m = grid.length;
		int n = grid[0].length;
		int[][] states = new int[m][n];
		int sum = 0;
		for (int i = 0; i < m; i++) {
			sum += grid[i][0];
			states[i][0] = sum;
		}
		sum = 0;
		for (int i = 0; i < n; i++) {
			sum += grid[0][i];
			states[0][i] = sum;
		}
		int i = 1;
		int j = 1;
		for (; i < m; i++) {
			j=1;
			for (; j < n; j++) {
				states[i][j] = grid[i][j] + Math.min(states[i][j - 1], states[i - 1][j]);
			}
		}
		return states[i - 1][j - 1];
	}
}
