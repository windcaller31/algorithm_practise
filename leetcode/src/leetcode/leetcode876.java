package leetcode;

import util.ListNode;

public class leetcode876 {
	public ListNode middleNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next!=null){
			slow = slow.next;
			fast = fast.next;
			if(fast.next!=null){
				fast = fast.next;
			}else{
				break;
			}
		}
		return slow;
    }
}
