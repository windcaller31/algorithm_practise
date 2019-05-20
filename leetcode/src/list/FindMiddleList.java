package list;

import java.util.ArrayList;
import java.util.List;

import util.ListNode;

public class FindMiddleList {
	public static void main(String args[]){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
//		ListNode n5 = new ListNode(5);
//		ListNode n6 = new ListNode(6);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
//		n4.next = n5;
//		n5.next = n6;
		List<ListNode> r = find(n1);
		System.out.println(r);
	}
	
	public static List<ListNode> find(ListNode n){
		ListNode slow = n;
		ListNode fast = n;
		ListNode lastSlow = null;
		List<ListNode> result = new ArrayList<ListNode>();
		while(fast!=null){		
			lastSlow = slow;
			fast=fast.next;
			if(fast==null){
				result.add(slow);
				return result;
			}
			fast = fast.next;
			slow = slow.next;
		}
		result.add(slow);
		result.add(lastSlow);
		return result;
	}
}
