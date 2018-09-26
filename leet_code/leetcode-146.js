/**
 * @param {number} capacity
 */
var LRUCache = function(capacity) {
  this.dataMap = {};
  this.queue = [];
  this.len = capacity;
  //添加新的分区时候检查并淘汰
  this.checkLen = function(){
    if(this.queue.length>=this.len){
      //找最少访问
      var eliminateKey = this.queue.pop();
      //淘汰之
      delete this.dataMap[eliminateKey];
    }
  };

  //调整queue
  this.dealQueue = function(the_key){
    var newQueue = [];
    for(var i =0;i<this.queue.length;i++){
      if(the_key == this.queue[i]){
        // var p = this.queue[i];
        // this.queue[i] = this.queue[0];
        // this.queue[0] = p;
        newQueue.unshift(this.queue[i]);
      }else{
        newQueue.push(this.queue[i]);
      }
    }
    this.queue = newQueue;
  };
};

/**
 * @param {number} key
 * @return {number}
 */
LRUCache.prototype.get = function(key) {
  if(typeof(this.dataMap[key])!="undefined"){
    this.dealQueue(key);
    return this.dataMap[key];
  }else{
    return -1;
  }
};

/**
 * @param {number} key
 * @param {number} value
 * @return {void}
 */
LRUCache.prototype.put = function(key, value) {
  if(typeof(this.dataMap[key])!="undefined"){
    this.dataMap[key] = value;
    this.dealQueue(key);
  }else{
    this.checkLen();
    this.dataMap[key] = value;
    this.queue.unshift(key);
  }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = Object.create(LRUCache).createNew(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */


var lru = new LRUCache(3);
lru.put(1,1);
lru.put(2,2);
lru.put(3,3);
lru.put(4,4);
console.log(lru.queue,lru.dataMap);
console.log(lru.get(4));
console.log(lru.get(3));
// console.log(lru.queue,lru.dataMap);
console.log(lru.get(2));
// console.log(lru.queue,lru.dataMap);
console.log(lru.get(1));
// console.log(lru.queue,lru.dataMap);
lru.put(5,5);
// console.log(lru.queue,lru.dataMap);
console.log(lru.get(1));
console.log(lru.get(2));
console.log(lru.get(3));
console.log(lru.get(4));
console.log(lru.get(5));
