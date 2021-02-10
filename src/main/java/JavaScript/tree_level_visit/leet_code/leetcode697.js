/**
 * @param {number[]} nums
 * @return {number}
 */
var findShortestSubArray = function(nums) {
  var times = {};
  var first = {};
  var last = {};
  var max = 0;
  for(var i=0;i<nums.length;i++){
    var n = nums[i]
    if('undefined' == typeof(times[n])){
      times[n] = 1;
    }else{
      times[n] = times[n]+1;
    }
    if('undefined' == typeof(first[n])){
      first[n] = i;
    }
    if('undefined' == typeof(last[n])){
      last[n] = i;
    }else{
      last[n] = Math.max(last[n],i);
    }
  }

  for(key in times){
    max = Math.max(max,times[key]);
  }

  var len = nums.length;
  for(key in last){
    if(max == times[key]){
      len = Math.min(last[key] - first[key] +1, len );
    }
  }
  return len;
};

console.log(findShortestSubArray([1,2,2,3,1,4,2]));
