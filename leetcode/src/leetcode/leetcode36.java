package leetcode;

import java.util.HashMap;
import java.util.Map;

public class leetcode36 {
	public static void main(String args[]) {
		System.out.print(3/3*3+0/3);
	}
	/*
	观察行号规律：
	第0个九宫格：000111222; 第1个九宫格：000111222; 第2个九宫格：000111222;
	第3个九宫格：333444555; 第4个九宫格：333444555; 第5个九宫格：333444555;
	第6个九宫格：666777888; 第7个九宫格：666777888; 第8个九宫格：666777888;
	可见对于每三个九宫格行号增3；对于单个九宫格，每三个格点行号增1。
	因此第i个九宫格的第j个格点的行号可表示为i/3*3+j/3

	观察列号规律：
	第0个九宫格：012012012; 第1个九宫格：345345345; 第2个九宫格：678678678;
	第3个九宫格：012012012; 第4个九宫格：345345345; 第5个九宫格：678678678;
	第6个九宫格：012012012; 第7个九宫格：345345345; 第8个九宫格：678678678;
	可见对于下个九宫格列号增3，循环周期为3；对于单个九宫格，每个格点行号增1，周期也为3。
	周期的数学表示就是取模运算mod。
	因此第i个九宫格的第j个格点的列号可表示为i%3*3+j%3
	*/
	public boolean isValidSudoku(char[][] board) {
		for(int i=0;i<9;i++) {//i表示遍历9个9宫格(左到右)
			Map<Character, Boolean> row = new HashMap<Character, Boolean>();
			Map<Character, Boolean> column = new HashMap<Character, Boolean>();
			Map<Character, Boolean> nine = new HashMap<Character, Boolean>();
			for(int j=0;j<9;j++) {//j表示遍历每个九宫格里面的小格子
				if(board[i][j]!='.') {
					if(row.containsKey(board[i][j])&&row.get(board[i][j])==true) {
						return false;
					}else {
						row.put(board[i][j], true);
					}
				}
				if(board[j][i] != '.')
                {
                    if(column.containsKey(board[j][i])&&column.get(board[j][i]) == true)
                        return false;
                    column.put(board[j][i],true);
                }
                if(board[i/3*3+j/3][i%3*3+j%3] != '.')
                {
                    if(nine.containsKey(board[i/3*3+j/3][i%3*3+j%3])&&nine.get(board[i/3*3+j/3][i%3*3+j%3]))
                        return false;
                    nine.put(board[i/3*3+j/3][i%3*3+j%3],true);
                }
			}		
		}
		return true;
	}
}
