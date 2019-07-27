package BasicAlgorithm;

public class DynamicProgramPackage {
	public static void main(String args[]) {
		int[] items = {9,10,8,11,4};
		int w = 16;
		System.out.print(knapsack(items, items.length, w));
	}
	
	public static int knapsack(int[] weight,int n,int w) {
		//true表示存在该种可能,n可以理解为遍历到最后一个物品
		boolean[][] states = new boolean[n][w+1];
		states[0][0] = true;  //第一行处理
		if(weight[0]<=w) {
			states[0][weight[0]] = true;
		}
		for(int i=1;i<n;i++) {
			for(int j=0;j<=w;j++) {
				if(states[i-1][j]==true) {  //重量不增加，表示i没选
					states[i][j]=states[i-1][j];
				}
			}
			for(int j=0;j<=w-weight[i];j++) {//第i个物品放入背包
				if(states[i-1][j]==true) {
					states[i][j+weight[i]]=true;
				}
			}			
		}
		for(int k=w;k>=0;k--) { //从最后一行可允许的最大重量向上扫描
			if(states[n-1][k]==true) {
				return k;
			}
		}
		return 0;
	}
}
