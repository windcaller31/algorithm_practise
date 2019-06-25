package Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import util.Printer;

public class MaxTopK {
	private static int count = 0;
	private static int[] dui;

	public static void main(String args[]) {
		List<Integer> l = new ArrayList<Integer>();
		for (int j = 0; j < 10; j++) {
			l.add(j);
		}
		Collections.shuffle(l);
		int s[] = new int[10];
		for (int j = 0; j < l.size(); j++) {
			s[j] = l.get(j);
		}
		getMaxTopk(s, 3);
	}

	// 找出k个最小 生成一个小顶堆，新加入的数字都比堆顶点小则入堆。
	// 满了删除堆顶
	public static void getMaxTopk(int a[], int k) {
		dui = new int[k];
		for (int i = 0; i < a.length; i++) {
			insert(a[i]);
		}
		System.out.print(Printer.printArray(dui));
	}
	
	public static void insert(int data) {
		if(count>=dui.length&&dui[0]>data) {
			return;
		}
		if(count>=dui.length) {
			remove();
		}
		dui[count] = data;
		int i = count;
		while((i-1)/2>=0&&dui[i]<dui[(i-1)/2]) {
			swap(dui,i,(i-1)/2);
		}
		count++;
	}
	
	public static void remove() {
		if(count==0) {
			return;
		}
		dui[0] = dui[count-1];
		count--;
		heapify(dui,0,count-1);
	}
	
	public static void heapify(int a[],int i,int n) {
		while(true) {
			int maxPos = i;
			if(i*2+1<=n&&a[i*2+1]<a[i]) {
				maxPos = i*2+1;
			}
			if(i*2+2<=n&&a[i*2+2]<a[maxPos]) {
				maxPos = i*2+2;
			}
			if(maxPos == i) {
				break;
			}
			swap(dui,i,maxPos);
			i = maxPos;
		}
	}
	
	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}

