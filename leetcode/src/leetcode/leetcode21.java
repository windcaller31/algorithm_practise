package leetcode;

import util.ListNode;

public class leetcode21 {
	public static void main(String args[]){
		ListNode n11 = new ListNode(1);
		ListNode n12 = new ListNode(2);
		ListNode n13 = new ListNode(4);
		n11.next = n12;
		n12.next = n13;
		
		ListNode n21 = new ListNode(1);
		ListNode n22 = new ListNode(3);
		ListNode n23 = new ListNode(4);
		n21.next = n22;
		n22.next = n23;
		mergeTwoLists(n11, n21);
	}
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null){
			return l2;
		}
		if(l2==null){
			return l1;
		}	
		ListNode newNode = null;
		if(l1.val>=l2.val){
			newNode = new ListNode(l2.val);
			l2 = l2.next;
		}else if(l1.val<l2.val){
			newNode = new ListNode(l1.val);
			l1 = l1.next;
		}
		
		ListNode start = newNode;
		while((l1!=null)&&(l2!=null)){
			if(l1.val>=l2.val){
				newNode.next = new ListNode(l2.val);
				l2 = l2.next;
				newNode = newNode.next;
			}else if(l1.val<l2.val){
				newNode.next = new ListNode(l1.val);
				l1 = l1.next;
				newNode = newNode.next;
			}
		}
		if(l1!=null){
			newNode.next = l1;
		}
		if(l2!=null){
			newNode.next = l2;
		}
		return start;
	}
}
