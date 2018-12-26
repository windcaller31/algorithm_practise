/**
 * @param {number[]} nums
 * @return {number}
 */
var findLengthOfLCIS = function(nums) {
  if(nums==null||nums.length==0){
    return 0;
  }
  if(nums.length==1){
    return 1;
  }
  var k = 1;
  var r = 0;
  for(var i =1;i<nums.length;i++){
    var one = nums[i-1];
    var two = nums[i];
    if(two<=one){
      r = Math.max(k,r);
      k=1;
    }else {
      k++;
    }
    one = two;
    two = nums[i];
  }
  return Math.max(r,k);
};

console.log(findLengthOfLCIS([-151,-136,143,147,]));
