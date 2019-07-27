package leetcode;

public class leetcode200 {
	public static void main(String args[]) {
		char[][] grid = {
//				{'1','1','1'},
				{'0','1','0'},
				{'1','1','1'}
		};
		System.out.print(numIslands(grid));
	}
	
	public static int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int row = grid.length;
		int column = grid[0].length;
		int count = 0;
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				if(grid[i][j]=='1') {
					count++;
					combineOne(grid,i,j);
				}
			}
		}
		return count;
	}
	
	public static void combineOne(char[][] grid,int i,int j) {				
		if((i>grid.length-1)&&(j>grid[0].length-1)) {
			return;
		}			
		System.out.println(i+" "+j);
		//2表示走过岛屿每一步
		grid[i][j]='2';
		if(i<grid.length-1&&grid[i+1][j]=='1') {
			combineOne(grid,i+1,j);
		}
		if(i>0&&grid[i-1][j]=='1') {
			combineOne(grid,i-1,j);
		}
		if(j<grid[0].length-1&&grid[i][j+1]=='1') {
			combineOne(grid,i,j+1);
		}
		if(j>0&&grid[i][j-1]=='1') {
			combineOne(grid,i,j-1);
		}
	}
}
