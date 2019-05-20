package leetcode;

import util.ListNode;

public class leetcode23 {
	public static void main(String args[]){
		ListNode l11 = new ListNode(1);
		ListNode l12 = new ListNode(4);
		ListNode l13 = new ListNode(5);
		l11.next = l12;
		l12.next = l13;
		
		ListNode l21 = new ListNode(1);
		ListNode l22 = new ListNode(3);
		ListNode l23 = new ListNode(4);
		l21.next = l22;
		l22.next = l23;
		
		ListNode l31 = new ListNode(2);
		ListNode l32 = new ListNode(6);
		l31.next = l32;
		
		ListNode[] lists = {null,l31,null,l21};
		mergeKLists(lists);
	}
	
	public static ListNode mergeKLists(ListNode[] lists) {
		boolean flag = false;
		for(int i =0;i<lists.length;i++){
			if(lists[i]!=null){
				flag = true;
				break;
			}
		}
		if(!flag){
			return null;
		}
		if(lists.length==0){
			return null;
		}
		ListNode first = null;
		ListNode result = null;
		int total = lists.length;
		int index = 0;
		while(total!=1){
			//找到最小的节点
			ListNode minNode = null;
			index = 0;
			for(int i = 0;i<lists.length;i++){
				ListNode node = lists[i];
				if(node!=null&&minNode==null){
					minNode = node;
					index = i;
				}				
				if(node!=null&&minNode!=null&&node.val<minNode.val){
					minNode = node;
					index = i;
				}
			}
			//该节点向后移动 加入新节点
			if(result==null){				
				result = minNode;
				first = result;
			}else{
				result.next = minNode;
				result = result.next;
			}
			if(lists[index]==null){
				break;
			}
			if(lists[index].next!=null){
				lists[index] = lists[index].next;	
			}else{
				lists[index] = null;
				total--;
			}	
		}
		//last for
		for(int i = 0;i<lists.length;i++){
			ListNode node = lists[i];
			if(node!=null){
				if(first==null){
					first = node;
				}else{
					if(result==null){
						result = node;
					}else{
						result.next = node;	
					}					
				}
				break;
			}
		}
		return first;
	}
}
