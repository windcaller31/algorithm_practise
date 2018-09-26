/**
 * Initialize your data structure here.
 */
var node = function (){
  this.val;
  this.next;
}

var MyLinkedList = function() {
  this.head = new node();
  this.len = 0;
  this.createNew = function(){
    return new MyLinkedList();
  };
};

/**
 * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
 * @param {number} index
 * @return {number}
 */
MyLinkedList.prototype.get = function(index) {
  var iterator = this.head;
  if(index>=this.len){
    return -1;
  }
  var i =-1
  for(;i<index-1;i++){
    iterator = iterator.next;
  }
  if(iterator==null||i>index-1){
    return -1;
  }
  return iterator.next.val;
};

/**
 * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
 * @param {number} val
 * @return {void}
 */
MyLinkedList.prototype.addAtHead = function(val) {
  var newNode = new node();
  newNode.val = val;
  newNode.next = this.head.next;
  this.head.next = newNode;
  this.len++;
};

/**
 * Append a node of value val to the last element of the linked list.
 * @param {number} val
 * @return {void}
 */
MyLinkedList.prototype.addAtTail = function(val) {
  var newNode = new node();
  newNode.val = val;
  var iterator = this.head;
  while(iterator.next!=null){
    iterator=iterator.next;
  }
  iterator.next = newNode;
  this.len++;
};

/**
 * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
 * @param {number} index
 * @param {number} val
 * @return {void}
 */
MyLinkedList.prototype.addAtIndex = function(index, val) {
  if(index==this.len){
    this.addAtTail(val);
  }else{
    var iterator = this.head;
    var i = -1
    for(;i<index-1;i++){
      iterator=iterator.next;
    }
    if(iterator==null||i>index-1){
      return;
    }else{
      var newNode = new node();
      newNode.val = val;
      newNode.next = iterator.next;
      iterator.next = newNode;
      this.len++;
    }
  }
};

/**
 * Delete the index-th node in the linked list, if the index is valid.
 * @param {number} index
 * @return {void}
 */
MyLinkedList.prototype.deleteAtIndex = function(index) {
  if(index>=this.len){
    return;
  }
  var iterator = this.head;
  var i = -1;
  for(;i<index-1;i++){
    iterator=iterator.next;
  }
  if(iterator==null||i>index-1){
    return;
  }else{
    iterator.next = iterator.next.next;
    this.len--;
  }
};

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * var obj = Object.create(MyLinkedList).createNew()
 * var param_1 = obj.get(index)
 * obj.addAtHead(val)
 * obj.addAtTail(val)
 * obj.addAtIndex(index,val)
 * obj.deleteAtIndex(index)
 */

 var ml = new MyLinkedList();
 ml.addAtHead(1);
 ml.addAtHead(2);
 ml.deleteAtIndex(2);
 console.log(ml.get(1))
 console.log(ml.get(0))
 console.log(ml.get(2))
