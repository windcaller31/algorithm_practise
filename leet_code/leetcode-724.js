/**
 * @param {number[]} nums
 * @return {number}
 */
var pivotIndex = function(nums) {
  var back = 0;
  var front = 0;
  if(nums.length==0){
    return -1;
  }
  for(var i =0;i<nums.length;i++){
    back+=nums[i];
  }
  if(back == nums[0]){
    return 0;
  }
  for(var j=0;j<nums.length;j++){
    front+=nums[j];
    if(back==front){
      return j;
    }
    back-=nums[j];
  }
  return -1;
};

console.log(pivotIndex([1,7,3,6,5,6]));
