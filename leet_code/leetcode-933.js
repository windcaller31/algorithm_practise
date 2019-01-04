var RecentCounter = function() {
  this.recentList = [];
};

/**
 * @param {number} t
 * @return {number}
 */
RecentCounter.prototype.ping = function(t) {
  this.recentList.push(t);
  while(this.recentList[0]<t-3000){
    this.recentList.shift();
  }
  return this.recentList.length;
};

/**
 * Your RecentCounter object   will be instantiated and called as such:
 * var obj = Object.create(RecentCounter).createNew()
 * var param_1 = obj.ping(t)
 */

 var obj = new RecentCounter();
 // console.log(obj.ping(1));
 // console.log(obj.ping(300));
 // console.log(obj.ping(3001));
 // console.log(obj.ping(3002));
 console.log(obj.ping(642));
 console.log(obj.ping(1849));
 console.log(obj.ping(4921));
 console.log(obj.ping(5936));
 console.log(obj.ping(5957));
