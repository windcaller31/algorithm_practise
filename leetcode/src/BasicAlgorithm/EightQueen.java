package BasicAlgorithm;

//把8皇后所有可能全部打印出来
//回朔法穷举
public class EightQueen {
	private static int result[];
	
	public static void main(String args[]) {
		result = new int[8];
		cal8queens(0);
	}

	public static void cal8queens(int row) {
		if(row==8) {//个棋子都已经放置好
			print(result);
			return;  
		}
		for(int column=0;column<8;column++) {
			if(isOk(row,column)) {
				result[row]=column;
				cal8queens(row+1);//继续下一行
			}
		}
	}
	
	public static boolean isOk(int row , int column) {
		int leftup = column-1;
		int rightup = column+1;
		for(int i=row-1;i>=0;i--) {//逐行向上找
			if(result[i]==column) { //i行column列是否有棋子
				return false;
			}
			if(leftup>=0) {	//考察左上对角线
				if(result[i]==leftup) { //在对角线位置已经放置过棋子
					return false;
				}
			}
			if(rightup<=8) {
				if(result[i]==rightup) {
					return false;
				}
			}
			--leftup;
			++rightup;
		}
		return true;
	}
	
	public static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(""+i+""+a[i]+" ");
		}
		System.out.println();
	}
}
