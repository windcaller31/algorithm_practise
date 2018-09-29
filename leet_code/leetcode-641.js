 /**
  * Initialize your data structure here. Set the size of the deque to be k.
  * @param {number} k
  */
 var MyCircularDeque = function(k) {
   this.thisLen = k;
   this.que = [];
 };

 /**
  * Adds an item at the front of Deque. Return true if the operation is successful.
  * @param {number} value
  * @return {boolean}
  */
 MyCircularDeque.prototype.insertFront = function(value) {
   if(this.que.length<this.thisLen){
     this.que.unshift(value);
     return true;
   }
   return false;
 };

 /**
  * Adds an item at the rear of Deque. Return true if the operation is successful.
  * @param {number} value
  * @return {boolean}
  */
 MyCircularDeque.prototype.insertLast = function(value) {
   if(this.que.length<this.thisLen){
     this.que.push(value);
     return true;
   }
   return false;
 };

 /**
  * Deletes an item from the front of Deque. Return true if the operation is successful.
  * @return {boolean}
  */
 MyCircularDeque.prototype.deleteFront = function() {
   if(this.que.length>0){
     this.que.shift();
     return true;
   }
   return false;
 };

 /**
  * Deletes an item from the rear of Deque. Return true if the operation is successful.
  * @return {boolean}
  */
 MyCircularDeque.prototype.deleteLast = function() {
   if(this.que.length>0){
     this.que.pop();
     return true;
   }
   return false;
 };

 /**
  * Get the front item from the deque.
  * @return {number}
  */
 MyCircularDeque.prototype.getFront = function() {
   return typeof(this.que[0])=='undefined'? -1:this.que[0];
 };

 /**
  * Get the last item from the deque.
  * @return {number}
  */
 MyCircularDeque.prototype.getRear = function() {
   return typeof(this.que[this.que.length-1])=='undefined'? -1:this.que[this.que.length-1];
 };

 /**
  * Checks whether the circular deque is empty or not.
  * @return {boolean}
  */
 MyCircularDeque.prototype.isEmpty = function() {
   return this.que.length==0?true:false;
 };

 /**
  * Checks whether the circular deque is full or not.
  * @return {boolean}
  */
 MyCircularDeque.prototype.isFull = function() {
   return this.que.length==this.thisLen?true:false;
 };

 /**
  * Your MyCircularDeque object will be instantiated and called as such:
  * var obj = Object.create(MyCircularDeque).createNew(k)
  * var param_1 = obj.insertFront(value)
  * var param_2 = obj.insertLast(value)
  * var param_3 = obj.deleteFront()
  * var param_4 = obj.deleteLast()
  * var param_5 = obj.getFront()
  * var param_6 = obj.getRear()
  * var param_7 = obj.isEmpty()
  * var param_8 = obj.isFull()
  */
