/**
 * Initialize your data structure here. Set the size of the queue to be k.
 * @param {number} k
 */
var MyCircularQueue = function(k) {
  this.thisList = [];
  this.len = k;
};

/**
 * Insert an element into the circular queue. Return true if the operation is successful.
 * @param {number} value
 * @return {boolean}
 */
MyCircularQueue.prototype.enQueue = function(value) {
  if(this.thisList.length < this.len){
    this.thisList.push(value);
    return true;
  }else{
    return false;
  }
};

/**
 * Delete an element from the circular queue. Return true if the operation is successful.
 * @return {boolean}
 */
MyCircularQueue.prototype.deQueue = function() {
  if(this.thisList.length==0){
    return false;
  }
  this.thisList.shift();
  return true;
};

/**
 * Get the front item from the queue.
 * @return {number}
 */
MyCircularQueue.prototype.Front = function() {
  return typeof(this.thisList[0])=="undefined"?-1:this.thisList[0];
};

/**
 * Get the last item from the queue.
 * @return {number}
 */
MyCircularQueue.prototype.Rear = function() {
  return typeof(this.thisList[this.thisList.length-1])=="undefined"?-1:this.thisList[this.thisList.length-1];
};

/**
 * Checks whether the circular queue is empty or not.
 * @return {boolean}
 */
MyCircularQueue.prototype.isEmpty = function() {
  if(this.thisList.length==0){
    return true;
  }else{
    return false;
  }
};

/**
 * Checks whether the circular queue is full or not.
 * @return {boolean}
 */
MyCircularQueue.prototype.isFull = function() {
  if(this.thisList.length==this.len){
    return true;
  }else{
    return false;
  }
};

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * var obj = Object.create(MyCircularQueue).createNew(k)
 * var param_1 = obj.enQueue(value)
 * var param_2 = obj.deQueue()
 * var param_3 = obj.Front()
 * var param_4 = obj.Rear()
 * var param_5 = obj.isEmpty()
 * var param_6 = obj.isFull()
 */

var MyCircularQueue = new MyCircularQueue(8);
MyCircularQueue.enQueue(3);
MyCircularQueue.enQueue(9);
MyCircularQueue.enQueue(5);
MyCircularQueue.enQueue(0);
console.log(MyCircularQueue.deQueue());
console.log(MyCircularQueue.deQueue());
console.log(MyCircularQueue.isEmpty());
console.log(MyCircularQueue.isEmpty());
console.log(MyCircularQueue.Rear());
console.log(MyCircularQueue.Rear());
console.log(MyCircularQueue.thisList);
