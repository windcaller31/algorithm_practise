package Heap;

import util.Printer;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKArrays {
	public static void main(String args[]) {
		Queue<Integer> q = new PriorityQueue<Integer>();
		Integer a[]= new Integer[]{1,2,3,5,9};
		Integer b[]= new Integer[]{4,7,8};
		Integer c[]= new Integer[]{0,6,11};
		q.addAll(Arrays.asList(a));
		q.addAll(Arrays.asList(b));
		q.addAll(Arrays.asList(c));
		int d [] = new int[a.length+b.length+c.length];
		int i =0;
		while(!q.isEmpty()) {
			d[i] = q.poll();
			i++;
		}
		System.out.print(Printer.printArray(d));
	}
}
