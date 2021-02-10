package util;

public class Printer {
	public static String printArray(int[] array) {
		StringBuffer sb = new StringBuffer();
		for(int i =0;i<array.length;i++){
			sb.append(array[i]);
		}
		return sb.toString();
	}
}
