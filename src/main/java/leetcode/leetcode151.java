package leetcode;

import java.util.Arrays;

public class leetcode151 {
	public static void main(String args[]) {
		System.out.println(reverseWords("a"));
		System.out.println(reverseWords("a good   example"));
		System.out.println(reverseWords("  hello   world "));
	}
	
	public static String reverseWords(String s) {
		if(s==null||s.equals("")) {
			return s;
		}
		char[] a = s.toCharArray();
		int start = 0;
		int end = a.length-1;
		for(int i=start,j=end;i<=j;i++,j--) {
			char temp =a[i]; 
			a[i] = a[j];
			a[j] = temp;
		}
		for(;start<a.length&&end>=0;) {
			if(a[start]==' ') {
				start++;
			}
			if(a[end]==' ') {
				end--;
			}
			if(start>end) {
				return "";
			}
			if(a[start]!=' '&&a[end]!=' ') {
				break;
			}
		}
		if(start>end) {
			return "";
		}
		int next = start+1;
		for(int i=start;i<=end&&next<=end;) {
			char a_next = a[next];
			char a_i = a[i];
			if(next==end) {
				if(a_i==' '&&a_next!=' ') {
					break;
				}
				reverseWord(a,i,next);
				break;
			}
			if(a_i==' ' && a_next==' ') {
				for(int k=next;k<end;k++) {
					char temp = a[k+1];
					a[k+1] = a[k];
					a[k]=temp;
				}
				end--;
				next--;
				if(next==i) {
					next = i+1;
				}
				continue;
			}
			if(a_i!=' ' && a_next==' '){
				reverseWord(a,i,next-1);	
				i=next;
				next = i+1;
				continue;
			}
			if(a[i]==' '&&a[next]!=' ') {
				i=next;
				next = i+1;
				continue;
			}
			if(a[i]!=' '&&a[next]!=' ') {
				next++;	
			}			
		}
		return new String(Arrays.copyOfRange(a,start,end+1));
	}
	
	public static void reverseWord(char[] s,int i,int j) {
		for(;i<=j;i++,j--) {
			char temp =s[i]; 
			s[i] = s[j];
			s[j] = temp;
		}
	}
}
