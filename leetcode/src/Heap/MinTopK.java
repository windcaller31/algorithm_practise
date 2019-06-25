package Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import util.Printer;

public class MinTopK {

	public static void main(String args[]) {
		List<Integer> l = new ArrayList<Integer>();
		for (int j = 0; j < 200; j++) {
			l.add(j);
		}
		Collections.shuffle(l);
		int s[] = new int[200];
		for (int j = 0; j < l.size(); j++) {
			s[j] = l.get(j);
		}
		getMinTopk(s, 10);
	}

	private static int count = 0;
	private static int[] dui;

	// 找出k个最小 生成一个大顶堆，新加入的数字都比堆顶点大则入堆。
	// 满了删除堆顶
	public static void getMinTopk(int a[], int k) {
		dui = new int[k];
		for (int i = 0; i < a.length; i++) {
			insert(a[i]);
		}
		System.out.print(Printer.printArray(dui));
	}

	public static void insert(int data) {
		if(count >= dui.length && dui[0] < data) {
			return;
		}
		if (count >= dui.length && dui[0] > data) {
			remove();
		}
		dui[count] = data;
		int i = count;
		while ((i - 1) / 2 >= 0 && dui[i] > dui[(i - 1) / 2]) {
			swap(dui, i, (i - 1) / 2);
			i = (i - 1) / 2;
		}
		count++;
	}

	public static void remove() {
		if (count == 0) {
			return;
		}
		dui[0] = dui[count - 1];
		count--;
		heapify(dui, 0, count - 1);
	}

	public static void heapify(int a[], int i, int n) {
		while (true) {
			int maxPos = i;
			if (i * 2 + 1 <= n && a[i * 2 + 1] > a[i]) {
				maxPos = i * 2 + 1;
			}
			if (i * 2 + 2 <= n && a[i * 2 + 2] > a[maxPos]) {
				maxPos = i * 2 + 2;
			}
			if (maxPos == i) {
				break;
			}
			swap(a, maxPos, i);
			i = maxPos;
		}
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
