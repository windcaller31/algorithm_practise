package leetcode;

import util.ListNode;

public class leetcode206 {
	public static void main(String args[]){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		ListNode n = reverseList(n1);
		System.out.print(n.val);
	}
	
	public static ListNode reverseList(ListNode head) {
		ListNode prev =null ;
		ListNode next =null ;
        if(head==null){
        	return head;
        }
        while(head.next!=null){
           	if(prev==null){
        		prev = head;
        		next = head.next;
        		head = head.next;
        		prev.next = null;        		 
        	}else{
        		head = head.next;
        		next.next = prev; 
        		prev = next;
        		next = head;
        	}        	
        }
        head.next = prev;
        return head;
    }
}
