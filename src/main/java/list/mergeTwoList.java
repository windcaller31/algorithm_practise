package list;

import util.ListNode;

public class mergeTwoList {
	public static void main(String args[]){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		ListNode n11 = new ListNode(1);
		ListNode n12 = new ListNode(3);
		ListNode n13 = new ListNode(5);
		ListNode n14 = new ListNode(7);
		n11.next = n12;
		n12.next = n13;
		n13.next = n14;
		ListNode n  = merge( n1, n11);
		System.out.println(n);
	}
	
	public static ListNode merge(ListNode n1,ListNode n2){
		ListNode newNode = null;
		ListNode firstNode = null;
		if(n1.val>n2.val){
			newNode=n2;
			firstNode = newNode;	
			n2 = n2.next;
		}else{
			newNode=n1;
			firstNode = newNode;	
			n1 = n1.next;				
		}
		while(n1!=null&&n2!=null){			
			if(n1.val>n2.val){
				newNode.next=n2;
				n2 = n2.next;
				newNode = newNode.next;
			}else{
				newNode.next=n1;
				n1 = n1.next;
				newNode = newNode.next;				
			}
		}
		if(n1!=null){
			newNode.next = n1;
		}
		if(n2!=null){
			newNode.next = n2;
		}
		return firstNode;
	}
}
