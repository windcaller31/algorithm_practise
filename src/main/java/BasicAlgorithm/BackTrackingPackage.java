package BasicAlgorithm;

public class BackTrackingPackage {
	public static void main(String args[]) {
		int[] items = {9,10,8,11,4};
		int w = 16;
//		int[] items = {9,8,3};
//		int w = 13;
		f(0,0,items,items.length,w);
		System.out.print(maxW);
	}
	
	private static int maxW = Integer.MIN_VALUE;//背包中总重量的最大值
	//cw表示当前已经装进去的物品重量,i表示考察到哪个物品
	//w背包重量 items表示每个物品的重量;n表示物品个数
	//背包重量100，物品个数10，物品重量存储在a中 f(0,0,a,10,100)
	public static void f(int i,int cw,int[] items,int n,int w) {
		if(cw==w||i==n) {//重量已经满了,i==n表示考察完所有物品
			if(cw>maxW) {
				maxW = cw;
			}
			return;
		}
		f(i+1,cw,items,n,w);//不装i而是装i+1
		if(cw+items[i]<=w) {
			f(i+1,cw+items[i],items,n,w);//装入i
		}
	}
}
