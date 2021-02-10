package leetcode;

import util.ListNode;

import java.util.ArrayList;
import java.util.List;

public class leetcode141 {
	public static void main(String args[]){
		List<String> l = new ArrayList<String>();
		
	}
	
	public static boolean hasCycle(ListNode head) {
        if(head==null){
        	return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null){
        	slow = slow.next;
        	fast = fast.next;
        	if(fast.next!=null){
        		fast = fast.next;
        	}else{
        		return false;
        	}
        	if(slow==fast){
        		return true;
        	}
        }
        return false;
    }
}
