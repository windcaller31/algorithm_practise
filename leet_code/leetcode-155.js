/**
 * initialize your data structure here.
 */
var MinStack = function() {
  this.mainStack = [];
};

/**
 * @param {number} x
 * @return {void}
 */
MinStack.prototype.push = function(x) {
  this.mainStack.push(x);
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
  return this.mainStack.pop();
};

/**
 * @return {number}
 */
MinStack.prototype.top = function() {
  return this.mainStack[this.mainStack.length-1];
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function() {
  var min = this.mainStack[0];
  for(key in this.mainStack){
    min = Math.min(min,this.mainStack[key]);
  }
  return min;
};

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = Object.create(MinStack).createNew()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */
