package Hash;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRU {
	static class Node {
		public String realKey;
		public String realData;
		// 整体双链表
		public Node next;
		public Node prev;
		// 哈希表中的链表
		public Node hNext;
	}

	private static Node[] dataList = new Node[10];
	private static Node tailNode = null;
	private static Node headNode = null;
	private static int len = 0;
	private static int total = 50;

	public static void main(String[] args) {
		System.out.println(visit("1"));
		System.out.println(visit("1111"));
		System.out.println(visit("222"));
		System.out.println(visit("1"));
		System.out.println(visit("111"));
	}

	public static int hashValue(String s) {
		return Integer.valueOf(s) % 10;
	}

	public static String visit(String data) {
		int index = hashValue(data);
		Node n = dataList[index];
		while (n != null) {
			if (n.realKey == data) {
				break;
			}
			n = n.hNext;
		}
		if (n != null) {
			if (headNode == n) {
				headNode = headNode.next;
			}else {
				Node prevNode = n.prev;
				prevNode.next = n.next;				
			}
			n.next = tailNode.next;
			n.prev = tailNode;
			tailNode.next = n;
			tailNode = n;
			return n.realData;
		} else {
			Node result = add(data);
			return result.realData;
		}
	}

	public static Node add(String data) {
		int index = hashValue(data);
		Node n = dataList[index];
		Node target = new Node();
		target.realKey = data;
		target.realData = data + "a";
		if (n == null) {
			dataList[index] = target;
		} else {
			while (n.hNext != null) {
				n = n.hNext;
			}
			n.hNext = target;
		}
		if (len == total) {
			headNode = headNode.next;
			tailNode.next = target;
			target.prev = tailNode;
			tailNode = tailNode.next;
			return target;
		} else {
			len++;
			if (headNode == null) {
				headNode = target;
			}
			if (tailNode == null) {
				tailNode = target;
			} else {
				tailNode.next = target;
				target.prev = tailNode;
				tailNode = tailNode.next;
			}
			return target;
		}
	}
}
