/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findErrorNums = function(nums) {
    var result = [];
    var mid = {};
    var correctSum = (1+nums.length)*nums.length/2;    
    var wrongSum = 0;
    for(var i =0;i<nums.length;i++){
      var n = nums[i];
      if(!mid[n]){
        mid[n] = 1;
      }else{
        mid[n]++;
      }
    }
    for(key in mid){
      if(mid[key]>1){
        result.push(Number(key));
      }
      wrongSum+=Number(key);
    }
    correctSum-=wrongSum;
    result.push(correctSum);
    return result;
};

console.log(findErrorNums([1,1]));
