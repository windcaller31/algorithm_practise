package stack;

import util.ListNode;

public class MinStackListStack {
	private ListNode bottom = null;
	private ListNode top = null;

    /** initialize your data structure here. */
    public MinStackListStack() {
        
    }
    
    public void push(int x) {
    	if(bottom==null){
    		bottom = new ListNode(x);
    		top = bottom;
    	}else{
    		ListNode newTop = new ListNode(x);
    		newTop.next = top;
    		top = newTop;
    	}    	
    }
    
    public void pop() {
    	top = top.next;
    }
    
    public int top() {
        return top.val;
    }
    
    public int getMin() {
    	ListNode cursor = top;
    	int min = cursor.val;
        while(cursor!=null){
        	min = Math.min(min, cursor.val);
        	cursor = cursor.next;
        }
        return min;
    }
}
