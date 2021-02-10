/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var middleNode = function(head) {
  var half_node = head;
  var final_node = head;
  while(final_node.next!=null){
    if(final_node.next.next==null){
      half_node = half_node.next;
      final_node = final_node.next;
    }else{
      half_node = half_node.next;
      final_node = final_node.next.next
    }
  }
  return half_node
};

function ListNode(val) {
  this.val = val;
  this.next = null;
}
