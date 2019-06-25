package Heap;

import util.Printer;

public class MaxHeap {
	public static void main(String args[]) {
		int[] s = {3,7,5,2,1,8,9};
		buildHeap(s,s.length-1);
		System.out.println("=="+Printer.printArray(s));
		//正序
		for(int k=s.length-1;k>=0;k--) {
			swap(s,0,k);
			heapify(s,k-1,0);
		}
		System.out.println(Printer.printArray(s));
	}
	
	public static void buildHeap(int[] a, int n) {
		for (int i = (n - 1) / 2; i >= 0; i--) {
			heapify(a,n,i);
		}
	}

	public static void heapify(int[] a, int n, int i) {
		while (true) {
			int maxPos = i;
			if (i * 2 + 1 <= n && a[i * 2 + 1] > a[i]) {
				maxPos = i * 2 + 1;
			}
			if (i * 2 + 2 <= n && a[i * 2 + 2] > a[maxPos]) {
				maxPos = i * 2 + 2;
			}
			if (i == maxPos) {
				break;
			}
			swap(a, i, maxPos);
			i = maxPos;
		}
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
