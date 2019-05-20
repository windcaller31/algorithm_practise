package list;

import util.ListNode;

public class reverseList {
	public static void main(String args[]){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		reverse(n1);
		System.out.println(n4);
	}
	public static void reverse(ListNode node){
		ListNode prev = node;
		ListNode current = node.next;
		ListNode k = node.next;
		while(current!=null){
			k = current.next;
			current.next = prev;
			prev = current;
			current = k;
		}
	}
}
