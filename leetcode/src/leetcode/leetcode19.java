package leetcode;

import util.ListNode;

public class leetcode19 {
	public static void main(String args[]){
		ListNode n11 = new ListNode(1);
		ListNode n12 = new ListNode(2);
		ListNode n13 = new ListNode(3);
		ListNode n14 = new ListNode(4);
		ListNode n15 = new ListNode(5);
		n11.next = n12;
		n12.next = n13;
		n13.next = n14;
		n14.next = n15;
		removeNthFromEnd(n11, 1);
	}
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if(n==1){
			if(head.next==null){
				return null;
			}
			ListNode n1 = head;
			ListNode n1Prev = null;
			while(n1.next!=null){
				n1Prev = n1;
				n1 = n1.next;
			}
			n1Prev.next = null;
			return head;
		}
		ListNode n1 = head;
		ListNode n1Prev = null;
		ListNode n2 = null;
		ListNode n2Prev = null;
		int position = 1;
		int len = 1;
		while(n1.next!=null){
			n1Prev = n1;
			n1 = n1.next;
			position += 1;
			if(position == n){
				n2 = head;
			} 
			if(n2!=null&&n1.next!=null){
				n2Prev = n2;
				n2 = n2.next;
			}
			len ++;
		}
		if(len == n){
			return head.next;
		}
		n2Prev.next = n2.next;
		return head;
    }
}
