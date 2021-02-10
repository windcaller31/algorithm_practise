package Recursion;

public class Factorial {
	public static void main(String args[]){
		System.out.println(fac(4));
	}
	
	public static int fac(int a){
		if(a==1){
			return 1;
		}		
		return fac(a-1)*a;
	}
}
