/**
 * Initialize your data structure here.
 */
var MyHashMap = function() {
  this.basic_array = [];
  this.createNew = function(){
    return new MyHashMap();
  };
};

/**
 * value will always be non-negative.
 * @param {number} key
 * @param {number} value
 * @return {void}
 */
MyHashMap.prototype.put = function(key, value) {
  this.basic_array[key] = value;
};

/**
 * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
 * @param {number} key
 * @return {number}
 */
MyHashMap.prototype.get = function(key) {
  return (typeof(this.basic_array[key])=="undefined"||this.basic_array[key]==null)?-1:this.basic_array[key];
};

/**
 * Removes the mapping of the specified value key if this map contains a mapping for the key
 * @param {number} key
 * @return {void}
 */
MyHashMap.prototype.remove = function(key) {
  this.basic_array[key] = null;
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = Object.create(MyHashMap).createNew()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */
var obj = Object.create(MyHashMap).createNew();
console.log(JSON.stringify(obj));
